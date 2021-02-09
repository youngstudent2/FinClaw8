package com.example.finclaw.blImpl.cooperation;

import com.example.finclaw.bl.account.AccountService;
import com.example.finclaw.bl.cooperation.AttendService;
import com.example.finclaw.bl.project.ProjectService;
import com.example.finclaw.data.cooperation.AttendMapper;
import com.example.finclaw.data.cooperation.ServerInfoMapper;
import com.example.finclaw.data.project.ProjectMapper;
import com.example.finclaw.po.ServerInfo;
import com.example.finclaw.po.User;
import com.example.finclaw.vo.ResponseVO;
import com.example.finclaw.vo.account.UserVO;
import com.example.finclaw.vo.project.ProjectVO;
import com.example.finclaw.vo.server.ServerInfoForm;
import com.example.finclaw.vo.server.ServerInfoVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AttendServiceImpl implements AttendService {
    private final static String OTHER_ERROR = "其他错误";

    @Autowired
    private AttendMapper attendMapper;
    @Autowired
    private ServerInfoMapper serverInfoMapper;
    @Autowired
    private ProjectService projectService;
    @Autowired
    private AccountService accountService;

    @Override
    public ResponseVO attendProject(Integer projectID, Integer cooperationID) {
        try {
            attendMapper.attendProject(cooperationID, projectID);
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            return ResponseVO.buildFailure(OTHER_ERROR);
        }
        return ResponseVO.buildSuccess();
    }

    @Override
    public ResponseVO quitProject(Integer projectID, Integer cooperationID) {
        try{
            attendMapper.quitProject(cooperationID, projectID);
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            return ResponseVO.buildFailure(OTHER_ERROR);
        }
        return ResponseVO.buildSuccess();
    }

    @Override
    public ResponseVO updateServerInfo(ServerInfoForm serverInfoForm) {
        try {
            ServerInfo serverInfo=new ServerInfo();
            BeanUtils.copyProperties(serverInfoForm,serverInfo);
            serverInfoMapper.updateServerInfo(serverInfo);
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            return ResponseVO.buildFailure(OTHER_ERROR);
        }
        return ResponseVO.buildSuccess();
    }

    @Override
    public ResponseVO setReadyForProject(Integer projectID, Integer cooperationID, boolean isReady) {
        try{
            attendMapper.setReadyForProject(cooperationID, projectID, isReady);
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            return ResponseVO.buildFailure(OTHER_ERROR);
        }
        return ResponseVO.buildSuccess();
    }

    @Override
    public ResponseVO setChosen(Integer projectID, Integer cooperationID, boolean isChosen) {
        try {
            attendMapper.setChosen(cooperationID, projectID, isChosen);
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            return ResponseVO.buildFailure(OTHER_ERROR);
        }
        return ResponseVO.buildSuccess();
    }

    @Override
    public List<ProjectVO> getCooperationProjects(Integer cooperationID) {
        List<Integer> projectIDs = attendMapper.getCooperationProjectIDs(cooperationID);
        ArrayList<ProjectVO> projectVOS = new ArrayList<>();
        for (Integer projectID : projectIDs) {
            ProjectVO projectVO = projectService.getProject(projectID);
            projectVOS.add(projectVO);
    }
        return projectVOS;
    }

    @Override
    public ServerInfoVO getServerInfo(Integer projectID, Integer cooperationID) {
        ServerInfo serverInfo=serverInfoMapper.getServerInfo(projectID,cooperationID);
        ServerInfoVO serverInfoVO=new ServerInfoVO();
        BeanUtils.copyProperties(serverInfo,serverInfoVO);
        return serverInfoVO;
    }

    @Override
    public List<UserVO> getProjectDataProducers(Integer projectID) {
        List<Integer> userIDs = attendMapper.getProjectDataProducerIDs(projectID);
        ArrayList<UserVO> userVOS = new ArrayList<>();
        for (Integer userID : userIDs) {
            UserVO userVO = accountService.getUserInfo(userID);
            userVOS.add(userVO);
        }
        return userVOS;
    }
}
