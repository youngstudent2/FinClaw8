package com.example.finclaw.bl.authority;

import com.example.finclaw.data.cooperation.AttendMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AuthorityServiceTest {

    @Autowired
    AuthorityService authorityService;
    @Autowired
    AttendMapper attendMapper;

    int projectID = 1;
    int cooperationID = 1;

    @Test
    public void openAuthority() {
        authorityService.openAuthority(1,1);

    }

    @Test
    public void closeAuthority() {
        authorityService.closeAuthority(1,1);
    }
}