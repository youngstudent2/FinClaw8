package com.example.finclaw.data.project;

import com.example.finclaw.enums.ProjectStatus;
import com.example.finclaw.po.Project;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.Timestamp;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProjectMapperTest {
    @Autowired
    private ProjectMapper projectMapper;

    @Test
    public void createNewProjectTest() {
        Project project = new Project();
        project.setUserID(3);
        project.setProjectName("test");
        project.setDescription("this is a test project");
        project.setStatus(ProjectStatus.Running);
        project.setStartTime(new Timestamp(System.currentTimeMillis()));
        project.setEndTime(new Timestamp(System.currentTimeMillis()));
        projectMapper.createNewProject(project);
        for (Project p : projectMapper.getAllProjects()) {
            if (p.getUserID() == 3 && p.getProjectName().equals("test") && p.getDescription().equals("this is a test project"))
                return;
        }
        fail();
    }

    @Test
    public void deleteProjectTest() {
        int deleteID = 0;
        for (Project p : projectMapper.getAllProjects()) {
            if (p.getUserID() == 3 && p.getProjectName().equals("test") && p.getDescription().equals("this is a test project")) {
                deleteID = p.getProjectID();
                break;
            }
        }
        projectMapper.deleteProject(deleteID);
        for (Project p : projectMapper.getAllProjects()) {
            if (p.getUserID() == 3 && p.getProjectName().equals("test") && p.getDescription().equals("this is a test project")) {
                fail();
            }
        }
    }

    @Test
    public void modifyProjectTest() {
        Project project = projectMapper.getProjectByID(2);
        project.setDescription("test modify");
        projectMapper.modifyProject(project);
        assertEquals("test modify", projectMapper.getProjectByID(2).getDescription());
    }

    @Test
    public void getAllProjectsTest() {
        assertEquals(5,projectMapper.getAllProjects().size());
    }

    @Test
    public void getProjectByIDTest() {
        Project project = projectMapper.getProjectByID(2);
        assertEquals(3,project.getUserID().intValue());
    }

    @Test
    public void setModelIDTest() {
        projectMapper.setModelID(2,1);
        assertEquals(1, projectMapper.getProjectByID(2).getModelID().intValue());
    }

    @Test
    public void setProjectStatusTest() {
        projectMapper.setProjectStatus(2, ProjectStatus.Finished);
        assertEquals(ProjectStatus.Finished, projectMapper.getProjectByID(2).getStatus());
    }

    @Test
    public void getAllBankProjectInfoTest() {
        assertEquals(3, projectMapper.getAllBankProjectInfo(3).size());
    }

}
