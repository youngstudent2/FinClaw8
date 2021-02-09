package com.example.finclaw.controller.loan;

import com.example.finclaw.vo.Loan.LoanApplicationForm;
import com.example.finclaw.vo.ResponseVO;
import org.springframework.web.bind.annotation.*;

/**
 * @Author: HX
 * @Date:   2021-2-2
 */
@RestController
@RequestMapping("/api/loan")
public class LoanController {

    @PostMapping("/addLoanApplication")
    public ResponseVO addLoanApplication(@RequestBody LoanApplicationForm loanApplicationForm){
        //提交贷款申请
        return null;
    }

    @PostMapping("/deleteLoanApplication/{loanApplicationID}")
    public ResponseVO deleteLoanApplication(@PathVariable Integer loanApplicationID){
        //取消贷款申请
        return null;
    }

    @GetMapping("/getAllLoanApplication/{userID}")
    public ResponseVO getAllLoanApplication(@PathVariable Integer userID){
        //查看所有贷款申请记录
        return null;
    }

    @GetMapping("/getLoanApplication/{loanApplicationID}")
    public ResponseVO getLoanApplication(@PathVariable Integer loanApplicationID){
        //查看某条贷款申请记录
        return null;
    }

    @PostMapping("/setDealt/{loanApplicationID}")
    public ResponseVO setDealt(@PathVariable Integer loanApplicationID){
        //设置某贷款申请为已处理
        return null;
    }

    @GetMapping("/getUserLoanHistory/{userID}")
    public ResponseVO getUserLoanHistory(@PathVariable Integer userID){
        //查看某小微企业获得的所有贷款记录,只有hasDealt为true才是完成贷款的记录
        return null;
    }
}
