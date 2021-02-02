package com.example.finclaw.bl.cooperation;

import com.example.finclaw.vo.cooperation.CooperationServiceForm;
import com.example.finclaw.vo.cooperation.CooperationVO;
import com.example.finclaw.vo.project.ProjectVO;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.hamcrest.core.Is.is;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CooperationServiceTest {

    @Autowired
    CooperationService cooperationService;
    @Autowired
    AttendService attendService;

    Integer cooperationID = 2;
    Integer projectID = 1;

    @Test
    public void addCooperationToProject() {
        cooperationService.addCooperationToProject(cooperationID,projectID);
        List<CooperationVO> cooperations =  attendService.getProjectCooperations(projectID);
        Assert.assertThat(cooperations.get(1).getIpAddress(),is(cooperationService.getCooperationById(2).getIpAddress()));
    }

    @Test
    public void deleteCooperationFromProject() {
        cooperationService.addCooperationToProject(cooperationID,projectID);
        List<CooperationVO> cooperations =  attendService.getProjectCooperations(projectID);
        int l = cooperations.size();
        //System.out.println(l);
        cooperationService.deleteCooperationFromProject(cooperationID,projectID);
        cooperations = attendService.getProjectCooperations(projectID);
        l = l - cooperations.size();
        //System.out.println(cooperations.size());
        Assert.assertThat(l, is(1));
    }

    @Test
    public void uploadServiceInfo() {
        CooperationServiceForm cooperationServiceForm = new CooperationServiceForm(){{
            setCooperationID(1);
            setProjectID(1);
            setIpAddress("127.0.0.1");
            setServiceName("root");
            setServicePassword("123456");
           setFilepath("D:/user/test.csv");
        }};
        cooperationService.uploadServiceInfo(cooperationServiceForm);
        CooperationVO cooperation = cooperationService.getCooperationById(1);
        Assert.assertThat(cooperation.getIpAddress(), is("127.0.0.1"));
        Assert.assertThat(cooperation.getServiceName(), is("root"));
    }

    @Test
    public void setCooperationReady() {
        cooperationService.setCooperationReady(cooperationID,projectID);
    }

    @Test
    public void getCooperationProjects() {
        List<ProjectVO> projects =  cooperationService.getCooperationProjects(1);
        Assert.assertThat(projects.size(), is(1));
    }

    @Test
    public void getCooperationUnAttendedProjects() {
        List<ProjectVO> projects =  cooperationService.getCooperationUnAttendedProjects(1);
        Assert.assertThat(projects.size(), is(0));
    }

    @Test
    public void getCooperationById() {
        CooperationVO cooperationVO = cooperationService.getCooperationById(1);
        Assert.assertThat(cooperationVO.getCooperationName(), is("阿里巴巴"));
    }

    @Test
    public void getAllCooperations() {
        List<CooperationVO> cooperationVOS = cooperationService.getAllCooperations();
        Assert.assertThat(cooperationVOS.size(), is(2));
    }
}