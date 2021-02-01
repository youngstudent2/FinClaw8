package com.example.finclaw.bl.authority;

import com.example.finclaw.vo.ResponseVO;

/**
 * @Author: GLH
 * @Date:   2020-10-12
 */
public interface AuthorityService {
    public void openAuthority(Integer projectID, Integer cooperationID);

    public void closeAuthority(Integer projectID, Integer cooperationID);

    ResponseVO getAuthority(Integer projectID, Integer cooperationID);
}
