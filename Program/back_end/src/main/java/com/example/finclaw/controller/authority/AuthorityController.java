package com.example.finclaw.controller.authority;

import com.example.finclaw.bl.authority.AuthorityService;
import com.example.finclaw.vo.ResponseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Author: GLH
 * @Date:   2020-10-12
 */
@RestController
@RequestMapping("/api/authority")
public class AuthorityController {
    @Autowired
    private AuthorityService authorityService;

    @PostMapping("/closeAuthority/{operatorID}")
    public ResponseVO closeAuthority(@RequestParam Integer projectID, @RequestParam Integer cooperationID, @PathVariable Integer operatorID) {
        authorityService.closeAuthority(projectID, cooperationID);
        return ResponseVO.buildSuccess("success");
    }

    @PostMapping("/openAuthority/{operatorID}")
    public ResponseVO openAuthority(@RequestParam Integer projectID, @RequestParam Integer cooperationID, @PathVariable Integer operatorID) {
        authorityService.openAuthority(projectID, cooperationID);
        return ResponseVO.buildSuccess("success");
    }

    @GetMapping("/getAuthority")
    public ResponseVO getAuthority(@RequestParam Integer projectID, @RequestParam Integer cooperationID){
        return ResponseVO.buildSuccess(authorityService.getAuthority(projectID, cooperationID));
    }
}
