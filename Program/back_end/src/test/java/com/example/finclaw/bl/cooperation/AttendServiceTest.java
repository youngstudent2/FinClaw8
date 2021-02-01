package com.example.finclaw.bl.cooperation;

import com.example.finclaw.bl.project.ProjectService;
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
public class AttendServiceTest {

    @Autowired
    AttendService attendService;
    @Autowired
    ProjectService projectService;

    private Integer cooperationID = 2;
    private Integer projectID = 2;

    @Test
    public void attendProject() {
        attendService.attendProject(cooperationID,projectID);
    }

    @Test
    public void quitProject() {
        attendService.attendProject(cooperationID,projectID);
        attendService.quitProject(cooperationID,projectID);
    }

    @Test
    public void setReadyForProject() {
        attendService.setReadyForProject(cooperationID,projectID);
    }

    @Test
    public void getCooperationProjects() {
        List<ProjectVO> projectForms = attendService.getCooperationProjects(1);
        int num = projectForms.size();
        Assert.assertThat(num,is(1));
    }

    @Test
    public void getProjectCooperations() {
        List<CooperationVO> cooperations = attendService.getProjectCooperations(1);
        Assert.assertThat(cooperations.size(), is(1));
    }
}