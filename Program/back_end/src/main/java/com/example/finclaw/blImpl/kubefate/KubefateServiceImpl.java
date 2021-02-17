package com.example.finclaw.blImpl.kubefate;

import com.example.finclaw.bl.kubefate.KubefateService;
import com.example.finclaw.data.model.ModelMapper;
import com.example.finclaw.data.attendance.ServerInfoMapper;
import com.example.finclaw.data.project.ProjectMapper;
import com.example.finclaw.enums.ProjectStatus;
import com.example.finclaw.po.Model;
import com.example.finclaw.po.Project;
import com.example.finclaw.po.ServerInfo;
import com.example.finclaw.vo.ResponseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.util.List;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

/**
 * @Author: LLY
 * @Date:   2021-2-3
 */

@Service
public class KubefateServiceImpl implements KubefateService {

    private static String DEPLOY_ERROR = "deploy failure.\n";
    private static String DEPLOY_SUCCESS = "deploy success\n.";
    private static String UPLOADERROR = "upload failure.\n";
    private static String UPLOAD_SUCCESS = "upload success.\n";
    private static String SUBMIT_ERROR = "submit failure.\n";
    private static String SUBMIT_SUCCESS = "submit success.\n";
    private static String LOAD_BIND_ERROR = "load_bind failure.\n";
    private static String LOAD_BIND_SUCCESS = "load_bind success.\n";

    @Autowired
    ProjectMapper projectMapper;
    @Autowired
    ServerInfoMapper serverInfoMapper;
    @Autowired
    ModelMapper modelMapper;

    private static String cmdPrefix = "python3 /finclaw/kubefate/docker-deploy/script.py -f";
    @Override
    public ResponseVO deploy(Integer projectID) {
        List<ServerInfo> serverInfoList = serverInfoMapper.getProjectServerInfo(projectID);
        //拼接命令 python3 script.py -f deploy -pw 123456 123456 -id 1 2 -ip 1.1.1.1 2.2.2.2
        StringBuilder sb = new StringBuilder(cmdPrefix);
        sb.append(" deploy -pw ");
        for (ServerInfo serverInfo : serverInfoList) {
            sb.append(serverInfo.getServerPassword());
            sb.append(" ");
        }
        sb.append("-id ");
        for (ServerInfo serverInfo : serverInfoList) {
            sb.append(serverInfo.getServerInfoID());
            sb.append(" ");
        }
        sb.append("-ip ");
        for (ServerInfo serverInfo : serverInfoList) {
            sb.append(serverInfo.getIpAddress());
            sb.append(" ");
        }
        String cmd = sb.toString();
        String res = execCommand(cmd);
        if(res.equals(DEPLOY_SUCCESS)){
            return ResponseVO.buildSuccess(DEPLOY_SUCCESS);
        }else{
            return ResponseVO.buildFailure(DEPLOY_ERROR);
        }
    }

    @Override
    public ResponseVO upload(Integer projectID) {
        Project project = projectMapper.getProjectByID(projectID);
        List<ServerInfo> serverInfoList = serverInfoMapper.getProjectServerInfo(projectID);
        ServerInfo guestServerInfo = null;
        for (ServerInfo serverInfo : serverInfoList) {
            if (serverInfo.getUserID().equals(project.getProjectID())) {
                guestServerInfo = serverInfo;
                break;
            }
        }
        //当任务指明为upload时，必须明确给出参数-gp,-hp, -proj
        //-gp和-hp参数都是合作方id与其主机上数据集路径的二元组，前者只传一个二元组，后者可接受一个二元组序列。
        //python3 script.py -f upload -gp 1 /root/data.csv -hp 1 /root/data1.csv 2 /root/data2.csv -proj example
        StringBuilder sb = new StringBuilder(cmdPrefix);
        sb.append(" upload -gp ");
        sb.append(guestServerInfo.getServerInfoID());
        sb.append(" ");
        sb.append(guestServerInfo.getFilePath());
        sb.append(" -hp ");
        for (ServerInfo temp : serverInfoList) {
            if (!temp.getServerInfoID().equals(guestServerInfo.getServerInfoID())) {
                sb.append(temp.getServerInfoID());
                sb.append(" ");
                sb.append(temp.getFilePath());
                sb.append(" ");
            }
        }
        String cmd = sb.toString();
        String res = execCommand(cmd);
        if(res.equals(UPLOAD_SUCCESS)){
            return ResponseVO.buildSuccess(UPLOAD_SUCCESS);
        }else{
            return ResponseVO.buildFailure(UPLOADERROR);
        }
    }

    @Override
    public ResponseVO submit(Integer projectID) {
        //python3 script.py -f submit -alg SecureBoost -proj example -m 1
        Project project = projectMapper.getProjectByID(projectID);
        StringBuilder sb = new StringBuilder(cmdPrefix);
        sb.append(" submit -alg hetero_lr proj ");
        sb.append(project.getProjectName());
        sb.append(" -m 1");
        String cmd = sb.toString();
        String res = execCommand(cmd);
        //结果判断 设置projectStatus 获取mid，jid，mversion等
        JsonParser jp = new JsonParser();
        JsonObject jo = jp.parse(res).getAsJsonObject();
        int retCode = jo.get("retcode").getAsInt();
        if(retCode==1){
            return ResponseVO.buildFailure(SUBMIT_ERROR);
        }else {
            String mid = jo.get("model_id").getAsString();
            String modelVersion = jo.get("model_version").getAsString();
            //modelName可以自定义，且只用设置一次，就在这里设置了
            String modelName = "model";
            String jid = jo.get("jobid").getAsString();
            Model model = new Model(mid,modelVersion,modelName,jid);
            int modelID = modelMapper.createNewModel(model);
            //设置modelID后项目可以根据modelID找到相应的model信息
            projectMapper.setModelID(projectID,modelID);
            //设置项目状态为Training
            projectMapper.setProjectStatus(projectID, ProjectStatus.Training);
            return ResponseVO.buildSuccess(SUBMIT_SUCCESS);
        }
    }

    @Override
    public ResponseVO query(Integer projectID) {
        Project project = projectMapper.getProjectByID(projectID);
        Model model = modelMapper.getModel(project.getModelID());
        String jid = model.getJid();
        //python3 script.py -f query -jid jobid
        StringBuilder sb = new StringBuilder(cmdPrefix);
        sb.append(" query -jid ");
        sb.append(jid);
        String cmd = sb.toString();
        String res = execCommand(cmd);
        String[] status = res.split("\n");
        boolean failedFlag = false;
        boolean runningFlag = false;
        for(int i=0;i<status.length;i++){
            if(status[i].equals("falied")){
                failedFlag= true;
                break;
            }
            if(status[i].equals("running")){
                runningFlag = true;
            }
        }
        if(failedFlag){
            projectMapper.setProjectStatus(projectID,ProjectStatus.Failed);
            return ResponseVO.buildSuccess(ProjectStatus.Failed);
        }else if(runningFlag){
            projectMapper.setProjectStatus(projectID,ProjectStatus.Training);
            return ResponseVO.buildSuccess(ProjectStatus.Training);
        }
        projectMapper.setProjectStatus(projectID,ProjectStatus.Finished);
        return ResponseVO.buildSuccess(ProjectStatus.Finished);
    }

    @Override
    public ResponseVO loadBind(Integer projectID) {
        Project project = projectMapper.getProjectByID(projectID);
        Model model = modelMapper.getModel(project.getModelID());
        String mid = model.getMid();
        String modelVersion = model.getModelVerion();
        String modelName = model.getModelName();
        //python3 script.py -f load_bind -mid model_id -mver model_version -mname toy_model
        StringBuilder sb = new StringBuilder(cmdPrefix);
        sb.append(" load_bind -mid ");
        sb.append(mid);
        sb.append(" -mver ");
        sb.append(modelVersion);
        sb.append(" -mname ");
        sb.append(modelName);
        String cmd = sb.toString();
        String res = execCommand(cmd);
        if(res.equals(LOAD_BIND_SUCCESS)){
            return ResponseVO.buildSuccess(LOAD_BIND_SUCCESS);
        }else{
            return ResponseVO.buildFailure(LOAD_BIND_ERROR);
        }
    }

    @Override
    public ResponseVO predict() {
        return null;
    }

    private String execCommand(String cmd) {
        //System.out.println("the cmd is: " + cmd);
        String res;
        int retCode = 0;
        try {
            Process process = Runtime.getRuntime().exec(cmd);
            retCode = process.waitFor();
            res = getOutput(process);
        } catch (IOException | InterruptedException e) {
            res = "failure";
            retCode = -1;
            e.printStackTrace();
        }
        return res;

    }

    private String getOutput(Process process) throws IOException {
        InputStreamReader ir = new InputStreamReader(process.getInputStream());
        LineNumberReader input = new LineNumberReader(ir);
        String line;
        StringBuilder output = new StringBuilder();
        while ((line = input.readLine()) != null) {
            output.append(line).append("\n");
        }
        //System.out.println(output.toString());
        input.close();
        ir.close();
        return output.toString();
    }

    private void appendArg(String[] args, StringBuilder s) {
        for (String arg : args) {
            s.append(arg);
            s.append(" ");
        }
    }
}
