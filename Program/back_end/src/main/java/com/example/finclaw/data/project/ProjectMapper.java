package com.example.finclaw.data.project;

import com.example.finclaw.po.Project;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author: cgc
 */
@Mapper
@Repository
public interface ProjectMapper {

    /**
     * 创建新项目
     * @param project 项目PO
     */
    void createNewProject(Project project);

    /**
     * 删除某个项目
     * @param projectID 待删除项目的ID
     */
    void deleteProject(Integer projectID);

    /**
     * 修改项目的信息
     * @param project 待修改的项目PO
     */
    void modifyProject(Project project);

    /**
     * 获取所有项目的信息
     * @return 所有项目的List
     */
    List<Project> getAllProjects();

    /**
     * 根据项目ID获取项目
     * @param projectID 项目ID
     * @return 一个项目PO
     */
    Project getProjectByID(Integer projectID);

}
