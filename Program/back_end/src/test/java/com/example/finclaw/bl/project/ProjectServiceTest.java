package com.example.finclaw.bl.project;

import com.example.finclaw.vo.model.ModelVO;
import com.example.finclaw.vo.project.ProjectForm;
import com.example.finclaw.vo.project.ProjectVO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProjectServiceTest {
    @Autowired
    private ProjectService projectService;

    @Test
    public void addProjectTest() {
        ProjectForm projectForm = new ProjectForm();
        projectForm.setProjectName("test1");
        projectForm.setStartTime(new Timestamp(System.currentTimeMillis()));
        projectForm.setEndTime(new Timestamp(System.currentTimeMillis()));
        projectForm.setUserID(99);
        projectForm.setDescription("this is a test project");
        projectService.addProject(projectForm);
        List<ProjectVO> projectVOS = projectService.getAllProject();
        for (ProjectVO projectVO : projectVOS) {
            if (projectVO.getProjectName().equals("test1") && projectVO.getUserID() == 99 && projectVO.getDescription().equals("this is a test project"))
                return;
        }
        fail();
    }

    @Test
    public void deleteProjectTest() {
        projectService.deleteProject(1);
        List<ProjectVO> projectVOS = projectService.getAllProject();
        for (ProjectVO projectVO : projectVOS) {
            if (projectVO.getProjectID() == 1)
                fail();
        }
    }

    @Test
    public void modifyProjectTest() {
        ProjectForm projectForm = new ProjectForm();
        projectForm.setProjectName("test1");
        projectForm.setStartTime(new Timestamp(System.currentTimeMillis()));
        projectForm.setEndTime(new Timestamp(System.currentTimeMillis()));
        projectForm.setUserID(99);
        projectForm.setDescription("this is a test project");
        projectService.modifyProject(5, projectForm);
        ProjectVO projectVO = projectService.getProject(5);
        assertEquals("this is a test project", projectVO.getDescription());
    }

    @Test
    public void getAllBankProjectInfoTest() {
        try {
            List<ProjectVO> projectVOS = projectService.getAllBankProjectInfo(3);
            assertEquals(5, projectVOS.size());
        } catch (Exception e){
            fail();
        }
    }

    @Test
    public void getAllModelTest() {
        try {
            List<ModelVO> modelVOS = projectService.getAllModel();
            assertEquals(4, modelVOS.size());
        } catch (Exception e) {
            fail();
        }
    }
}
