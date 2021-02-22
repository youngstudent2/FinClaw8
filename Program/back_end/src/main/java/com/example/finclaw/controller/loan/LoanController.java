package com.example.finclaw.controller.loan;

import com.example.finclaw.bl.citiAPI.CitiAPIService;
import com.example.finclaw.bl.loan.LoanService;
import com.example.finclaw.vo.loan.LoanApplicationForm;
import com.example.finclaw.vo.ResponseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

/**
 * @Author: HX
 * @Date:   2021-2-2
 */
@RestController
@RequestMapping("/api/loan")
public class LoanController {

    @Autowired
    private LoanService loanService;

    @Autowired
    private CitiAPIService citiAPIService;

    @PostMapping("/addLoanApplication")
    public ResponseVO addLoanApplication(@RequestBody LoanApplicationForm loanApplicationForm){
        //提交贷款申请
        return loanService.addLoanApplication(loanApplicationForm);
    }

    @PostMapping("/deleteLoanApplication/{loanApplicationID}")
    public ResponseVO deleteLoanApplication(@PathVariable Integer loanApplicationID){
        //取消贷款申请
        return loanService.deleteLoanApplication(loanApplicationID);
    }

    @GetMapping("/getUserLoanApplication/{userID}")
    public ResponseVO getUserLoanApplication(@PathVariable Integer userID){
        //查看所有贷款申请记录   2.17修改
        return loanService.getUserLoanApplication(userID);
    }

    @GetMapping("/getAllLoanApplication")
    public ResponseVO getAllLoanApplication(){
        //查看全部的贷款申请    2.17新增
        return loanService.getAllLoanApplication();
    }

    @GetMapping("/getLoanApplication/{loanApplicationID}")
    public ResponseVO getLoanApplication(@PathVariable Integer loanApplicationID){
        //查看某条贷款申请记录
        return loanService.getLoanApplication(loanApplicationID);
    }

    @PostMapping("/setDealt/{loanApplicationID}")
    public ResponseVO setDealt(@PathVariable Integer loanApplicationID){
        //设置某贷款申请为已处理
        return loanService.setDealt(loanApplicationID);
    }

    @GetMapping("/getUserLoanHistory/{userID}")
    public ResponseVO getUserLoanHistory(@PathVariable Integer userID){
        //查看某小微企业获得的所有贷款记录,只有hasDealt为true才是完成贷款的记录
        return loanService.getUserLoanHistory(userID);
    }


}
