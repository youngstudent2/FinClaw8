package com.example.finclaw.bl.data;

import com.example.finclaw.vo.data.ProjectDataVO;

public interface DataService {

    /**
     * 获取文件元数据
     * @param fileID
     */
    String[] getFileMetadata(int fileID);

    ProjectDataVO getProjectData(int projectID);
}
