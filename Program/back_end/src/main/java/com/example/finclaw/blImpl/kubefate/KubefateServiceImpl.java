package com.example.finclaw.blImpl.kubefate;

import com.example.finclaw.bl.kubefate.KubefateService;
import com.example.finclaw.data.project.ProjectMapper;
import com.example.finclaw.po.Project;
import com.example.finclaw.po.ServerInfo;
import com.example.finclaw.vo.ResponseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.util.List;

/**
 * @Author: LLY
 * @Date:   2021-2-3
 */

@Service
public class KubefateServiceImpl implements KubefateService {
    private static String DEPLOY_ERROR = "部署失败";
    private static String DEPLOY_SUCCESS = "部署成功";
    private static String TRAIN_ERROR = "启动训练失败";
    private static String TRAIN_SUCCESS = "成功开始训练";

    @Autowired
    ProjectMapper projectMapper;

    private static String cmdPrefix = "python3 /finclaw/kubefate/docker-deploy/script.py -f";
    @Override
    public ResponseVO deploy(Integer projectID) {
        //todo 获取serverInfoList
        List<ServerInfo> serverInfoList = null;
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
        //todo 结果判断

    }

    @Override
    public ResponseVO upload(Integer projectID) {
        //todo 获取serverInfoList
        List<ServerInfo> serverInfoList = null;
        ServerInfo guestServerInfo = null;
        for (ServerInfo serverInfo : serverInfoList) {
            if (serverInfo.getUserID() ==) {
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
        sb.append(" "+guestServerInfo.getFilePath());
        sb.append(" -hp ");
        for (ServerInfo temp : serverInfoList) {
            if ((temp.getServerInfoID()) != (guestServerInfo.getServerInfoID())) {
                sb.append(temp.getServerInfoID());
                sb.append(" ");
                sb.append(temp.getFilePath());
                sb.append(" ");
            }
        }
        String cmd = sb.toString();
        String res = execCommand(cmd);
        //todo 结果判断
        return null;
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
        //todo 结果判断 设置projectStatus 获取mid，mname，mversion等

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
