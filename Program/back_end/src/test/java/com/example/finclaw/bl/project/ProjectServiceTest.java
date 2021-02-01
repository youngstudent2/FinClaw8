package com.example.finclaw.bl.project;

import com.example.finclaw.vo.project.ProjectForm;
import com.example.finclaw.vo.project.ProjectVO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProjectServiceTest {

    @Autowired
    private ProjectService projectService;

    private final ProjectForm projectForm = new ProjectForm() {{
        setDescription("one test");
        setProjectName("test");
    }};

    private final ProjectVO normalProjectVO = new ProjectVO(){{
        setProjectID(1);
        setDescription("one test");
        setProjectName("test");
    }};

    private final ProjectVO wrongProjectVO = new ProjectVO(){{
        setProjectID(1);
        setDescription("one test");
        setProjectName("test");
    }};

    @Transactional
    @Test
    public void addProjectTest() {
        //获取现有项目数
        int currentProjectNum = projectService.getAllProject().size();
        projectService.addProject(projectForm);
        int newProjectNum = projectService.getAllProject().size();
        assertEquals(currentProjectNum + 1, newProjectNum);
    }

    @Transactional
    @Test
    public void deleteProjectTest() {
        int projectID;
        boolean res;
        //删除一个不存在的project
        projectID = -1;
        res = projectService.deleteProject(projectID);
        assertFalse(res);
        //删除一个存在的project
        projectID = 1;
        res = projectService.deleteProject(projectID);
        assertTrue(res);
    }

    @Transactional
    @Test
    public void modifyProjectTest(){
        boolean res;
        //修改一个不存在的project
        res = projectService.modifyProject(wrongProjectVO);
        assertFalse(res);
        //删除一个存在的project
        res = projectService.modifyProject(normalProjectVO);
        assertTrue(res);
    }

    @Transactional
    @Test
    public void getAllProjectTest(){
        int projectNum = projectService.getAllProject().size();
        //数据库里实践的项目数
        int actualNum = 1;
        assertEquals(actualNum,projectNum);
    }

    @Transactional
    @Test
    public void getProjectTest(){
        int projectID = projectService.getProject(normalProjectVO.getProjectID()).getProjectID();
        int expectedID = normalProjectVO.getProjectID();
        assertEquals(expectedID,projectID);
    }
}