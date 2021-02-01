package com.example.finclaw.blImpl.authority;

import com.example.finclaw.bl.authority.AuthorityService;
import com.example.finclaw.data.cooperation.AttendMapper;
import com.example.finclaw.vo.ResponseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthorityServiceImpl implements AuthorityService {
    @Autowired
    private AttendMapper attendMapper;

    @Override
    public void openAuthority(Integer projectID, Integer cooperationID) {
        attendMapper.openAuthority(cooperationID, projectID);
    }

    @Override
    public void closeAuthority(Integer projectID, Integer cooperationID) {
        attendMapper.closeAuthority(cooperationID, projectID);
    }

    @Override
    public ResponseVO getAuthority(Integer projectID, Integer cooperationID){
        int authority = attendMapper.getAuthority(cooperationID, projectID);
        return ResponseVO.buildSuccess(authority);
    }
}
