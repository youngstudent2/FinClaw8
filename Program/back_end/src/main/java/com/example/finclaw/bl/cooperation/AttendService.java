package com.example.finclaw.bl.cooperation;

import com.example.finclaw.vo.ResponseVO;
import com.example.finclaw.vo.account.UserVO;
import com.example.finclaw.vo.project.ProjectVO;
import com.example.finclaw.vo.server.ServerInfoForm;
import com.example.finclaw.vo.server.ServerInfoVO;

import java.util.List;

public interface AttendService {

    ResponseVO attendProject(Integer projectID, Integer cooperationID);

    ResponseVO quitProject(Integer projectID, Integer cooperationID);

    ResponseVO updateServerInfo(ServerInfoForm serverInfoForm);

    ResponseVO setReadyForProject(Integer projectID, Integer cooperationID, boolean isReady);

    ResponseVO setChosen(Integer projectID, Integer cooperationID, boolean isChosen);

    List<ProjectVO> getCooperationProjects(Integer cooperationID);

    ServerInfoVO getServerInfo(Integer projectID, Integer cooperationID);

    List<UserVO> getProjectCooperations(Integer projectID);
}
