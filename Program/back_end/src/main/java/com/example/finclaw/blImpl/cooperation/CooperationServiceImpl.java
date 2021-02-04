package com.example.finclaw.blImpl.cooperation;

import com.example.finclaw.bl.cooperation.AttendService;
import com.example.finclaw.bl.cooperation.CooperationService;
import com.example.finclaw.bl.project.ProjectService;
import com.example.finclaw.data.cooperation.CooperationMapper;
import com.example.finclaw.po.Cooperation;
import com.example.finclaw.vo.cooperation.CooperationVO;
import com.example.finclaw.vo.project.ProjectVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: GLH
 * @Date:   2020-10-11
 */
@Service
public class CooperationServiceImpl implements CooperationService {

    @Autowired
    private CooperationMapper cooperationMapper;
    @Autowired
    private AttendService attendService;
    @Autowired
    private ProjectService projectService;

    @Override
    public void addCooperationToProject(Integer cooperationID, Integer projectID) {
        attendService.attendProject(cooperationID, projectID);
    }


    @Override
    public void deleteCooperationFromProject(Integer cooperationID, Integer projectID) {
        attendService.quitProject(cooperationID, projectID);
    }

    @Override
    public void uploadServiceInfo(CooperationServiceForm cooperationServiceForm) {
        Integer projectID = cooperationServiceForm.getProjectID();
        Integer cooperationID = cooperationServiceForm.getCooperationID();
        String filepath = cooperationServiceForm.getFilepath();
        this.uploadProjectFilepath(cooperationID, projectID, filepath);
        Cooperation cooperation = new Cooperation();
        BeanUtils.copyProperties(cooperationServiceForm, cooperation);
        cooperationMapper.uploadServiceInfo(cooperation);
    }

    @Override
    public void uploadProjectFilepath(Integer cooperationID, Integer projectID, String filepath) {
        attendService.uploadProjectFilepath(cooperationID, projectID, filepath);
    }

    @Override
    public void setCooperationReady(Integer cooperationID, Integer projectID) {
        attendService.setReadyForProject(cooperationID, projectID);
    }

    @Override
    public List<ProjectVO> getCooperationProjects(Integer cooperationID) {
        return attendService.getCooperationProjects(cooperationID);
    }

    @Override
    public List<CooperationVO> getAllCooperations() {
        List<Cooperation> cooperationList = cooperationMapper.getAllCooperation();
        ArrayList<CooperationVO> cooperationVOS = new ArrayList<>();
        for (Cooperation cooperation : cooperationList) {
            CooperationVO cooperationVO = new CooperationVO();
            BeanUtils.copyProperties(cooperation, cooperationVO);
            cooperationVOS.add(cooperationVO);
        }
        return cooperationVOS;
    }

    @Override
    public List<ProjectVO> getCooperationUnAttendedProjects(Integer cooperationID) {
        List<ProjectVO> allProject = projectService.getAllProject();
        List<ProjectVO> attendedProjects = attendService.getCooperationProjects(cooperationID);
        List<ProjectVO> res = new ArrayList<>();
        for(ProjectVO projectVO :allProject){
            boolean hasFound = false;
            for(ProjectVO attendedProject: attendedProjects){
                if(projectVO.getProjectID()==attendedProject.getProjectID()){
                    hasFound = true;
                    break;
                }
            }
            if(!hasFound){
                res.add(projectVO);
            }
        }
        return res;
    }

    @Override
    public CooperationVO getCooperationById(Integer cooperationID) {
        Cooperation cooperation = cooperationMapper.getCooperationByCooperationID(cooperationID);
        CooperationVO cooperationVO = new CooperationVO();
        BeanUtils.copyProperties(cooperation, cooperationVO);
        return cooperationVO;
    }

}
