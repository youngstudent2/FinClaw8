package com.example.finclaw.blImpl.cooperation;

import com.example.finclaw.bl.cooperation.AttendService;
import com.example.finclaw.data.cooperation.AttendMapper;
import com.example.finclaw.data.cooperation.CooperationMapper;
import com.example.finclaw.data.project.ProjectMapper;
import com.example.finclaw.po.Cooperation;
import com.example.finclaw.vo.cooperation.CooperationVO;
import com.example.finclaw.vo.project.ProjectVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AttendServiceImpl implements AttendService {
    @Autowired
    private AttendMapper attendMapper;
    @Autowired
    private ProjectMapper projectMapper;
    @Autowired
    private CooperationMapper cooperationMapper;

    @Override
    public void attendProject(Integer cooperationID, Integer projectID) {
        attendMapper.attendProject(cooperationID, projectID);
    }

    @Override
    public void quitProject(Integer cooperationID, Integer projectID) {
        attendMapper.quitProject(cooperationID, projectID);
    }

    @Override
    public void setReadyForProject(Integer cooperationID, Integer projectID) {
        attendMapper.setReadyForProject(cooperationID, projectID);
    }

    @Override
    public List<ProjectVO> getCooperationProjects(Integer cooperationID) {
        List<Integer> projectIDs = attendMapper.getCooperationProjectIDs(cooperationID);
        ArrayList<ProjectVO> projectVOS = new ArrayList<>();
        for (Integer projectID : projectIDs) {
            projectVOS.add(new ProjectVO(projectMapper.getProjectByID(projectID)));
    }
        return projectVOS;
    }

    @Override
    public List<CooperationVO> getProjectCooperations(Integer projectID) {
        List<Integer> cooperationIDs = attendMapper.getProjectCooperationIDs(projectID);
        ArrayList<CooperationVO> cooperationVOS = new ArrayList<>();
        for (Integer cooperationID : cooperationIDs) {
            CooperationVO cooperationVO = new CooperationVO();
            Cooperation cooperation = cooperationMapper.getCooperationByCooperationID(cooperationID);
            BeanUtils.copyProperties(cooperation, cooperationVO);
            int authority = attendMapper.getAuthority(cooperationID, projectID);
            cooperationVO.setAuthority(authority);
            cooperationVOS.add(cooperationVO);
        }
        return cooperationVOS;
    }

    @Override
    public void uploadProjectFilepath(Integer cooperationID, Integer projectID, String filepath) {
        attendMapper.uploadProjectFilepath(cooperationID, projectID, filepath);
    }
}
