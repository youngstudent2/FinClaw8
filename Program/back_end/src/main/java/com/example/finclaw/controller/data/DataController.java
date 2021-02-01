package com.example.finclaw.controller.data;


import com.example.finclaw.bl.data.DataService;
import com.example.finclaw.vo.ResponseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/data")
public class DataController {

    @Autowired
    private DataService dataService;

    @GetMapping("/getFileMetadata/{operatorID}")
    public ResponseVO getFileMetadata(@RequestParam int fileID, @PathVariable int operatorID){
        return ResponseVO.buildSuccess(dataService.getFileMetadata(fileID));
    }

    @GetMapping("/getProjectData/{operatorID}")
    public ResponseVO getProjectData(@RequestParam int projectID, @PathVariable int operatorID){
        return ResponseVO.buildSuccess(dataService.getProjectData(projectID));
    }
}
