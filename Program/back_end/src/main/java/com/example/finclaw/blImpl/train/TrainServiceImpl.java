package com.example.finclaw.blImpl.train;

import com.example.finclaw.bl.project.ProjectService;
import com.example.finclaw.bl.train.TrainService;
import com.example.finclaw.util.KubefateService;
import com.example.finclaw.vo.cooperation.CooperationVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrainServiceImpl implements TrainService {

    @Autowired
    private KubefateService kubefateService;

    @Autowired
    private ProjectService projectService;

    @Override
    public boolean startDeploy(int projectID) {
        //找到该项目的所以合作方，拿到其相应数据
        List<CooperationVO> cooperationVOS = projectService.getProjectCooperations(projectID);
        int size = cooperationVOS.size();
        String[] userID = new String[size];
        String[] ip = new String[size];
        String[] pw = new String[size];
        String[] filepath = new String[size];
        for (int i = 0; i < cooperationVOS.size(); i++) {
            CooperationVO temp = cooperationVOS.get(i);
            userID[i] = temp.getCooperationName();
            ip[i] = temp.getIpAddress();
            pw[i] = temp.getServicePassword();
            //filepath[i] = temp.getFilePath();
        }
        return kubefateService.deploy(userID, pw, ip, filepath, projectID + "");
    }

    @Override
    public boolean startTrain(int projectID) {
        return kubefateService.submit("SecureBoost", projectID + "");
    }
}
