package com.example.finclaw.blImpl.data;

import com.example.finclaw.bl.data.DataService;
import com.example.finclaw.data.cooperation.AttendMapper;
import com.example.finclaw.data.file.FileMapper;
import com.example.finclaw.data.project.ProjectMapper;
import com.example.finclaw.po.FileInfo;
import com.example.finclaw.po.Project;
import com.example.finclaw.vo.data.ProjectDataVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.List;

@Service
public class DataServiceImpl implements DataService {

    @Autowired
    FileMapper fileMapper;

    @Autowired
    ProjectMapper projectMapper;

    @Autowired
    AttendMapper attendMapper;

    @Override
    public String[] getFileMetadata(int fileID) {
        FileInfo fileInfo = fileMapper.getFileByID(fileID);
        String[] metadataList = null;
        try {
            File file = new File(fileInfo.getFilePath());
            BufferedReader reader = new BufferedReader(new FileReader(file));
            metadataList = reader.readLine().split(",");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return metadataList;
    }

    @Override
    public ProjectDataVO getProjectData(int projectID) {
        ProjectDataVO projectDataVO = new ProjectDataVO();
        Project project = projectMapper.getProjectByID(projectID);
        projectDataVO.setProjectID(project.getProjectID());
        projectDataVO.setName(project.getProjectName());
        projectDataVO.setStartTime(project.getStartTime());
        projectDataVO.setEndTime(project.getEndTime());
        projectDataVO.setDescription(project.getDescription());
        projectDataVO.setStatus(project.getStatus().toString());
        projectDataVO.setFileID(project.getFileID());
        List<Integer> cooperationIDs = attendMapper.getProjectCooperationIDs(projectID);
        projectDataVO.setCooperationNumber(cooperationIDs.size());
        return projectDataVO;
    }
}
