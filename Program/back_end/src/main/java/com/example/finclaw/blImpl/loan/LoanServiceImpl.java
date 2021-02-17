package com.example.finclaw.blImpl.loan;

import com.example.finclaw.bl.loan.LoanService;
import com.example.finclaw.data.loan.LoanMapper;
import com.example.finclaw.po.LoanApplication;
import com.example.finclaw.vo.ResponseVO;
import com.example.finclaw.vo.loan.LoanApplicationForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class LoanServiceImpl implements LoanService {

    @Autowired
    private LoanMapper loanMapper;

    /**
     * @param loanApplicationForm
     * @return
     *
     * 提交贷款申请
     */
    @Override
    public ResponseVO addLoanApplication(LoanApplicationForm loanApplicationForm){
        LoanApplication loanApplication = new LoanApplication(){{
           setUserID(loanApplicationForm.getUserID());
           setAmount(loanApplicationForm.getAmount());
           setPhoneNumber(loanApplicationForm.getPhoneNumber());
           setCertificationCode(loanApplicationForm.getCertificationCode());
           setRegistrationCode(loanApplicationForm.getRegistrationCode());
           setCompanyName(loanApplicationForm.getCompanyName());
        }};
        try {
            //todo 调用花旗API
            loanMapper.createNewLoanApplication(loanApplication);
        }catch (Exception e){
            return ResponseVO.buildFailure("Error 101 : Can't create new loanApplication! Exam your information and try again.\n");
        }
        return ResponseVO.buildSuccess();
    }


    /**
     * @param loanApplicationID
     * @return
     *
     * 取消贷款申请
     */

    @Override
    public ResponseVO deleteLoanApplication(Integer loanApplicationID){
        try{
            //todo 调用花旗API
            loanMapper.deleteLoanApplication(loanApplicationID);
        }catch (Exception e){
            return ResponseVO.buildFailure("Error 102 : Can't delete this loanApplication! Please input correct loanApplication ID and try again.\n");
        }
        return ResponseVO.buildSuccess();
    }



    /**
     * @param userID
     * @return
     *
     * 查看所有贷款申请记录
     */
    @Override
    public ResponseVO getUserLoanApplication(Integer userID){
        List<LoanApplication> loanApplications;
        try{
            //todo 调用花旗API
            loanApplications = loanMapper.getUserLoanApplication(userID);
        }catch (Exception e){
            return ResponseVO.buildFailure("Error 103 : Can't get the loan information. Please input correct user ID and try again.\n");
        }
        return ResponseVO.buildSuccess(loanApplications);
    }


    @Override
    public ResponseVO getAllLoanApplication(){
        List<LoanApplication> loanApplications;
        try {
            loanApplications = loanMapper.getAllLoanApplication();
        }catch (Exception e){
            return ResponseVO.buildFailure("Error 104 : Can't get the loan information. Please try again.\n");
        }
        return ResponseVO.buildSuccess(loanApplications);
    }

    /**
     * @param loanApplicationID
     * @return
     *
     * 查看某条贷款申请记录
     */
    @Override
    public ResponseVO getLoanApplication(Integer loanApplicationID){
        LoanApplication loanApplication;
        try{
            //todo 调用花旗API
            loanApplication = loanMapper.getLoanApplication(loanApplicationID);
        }catch (Exception e){
            return ResponseVO.buildFailure("Error 105 : Can't get the loan information by this ID. Please input correct loanApplication ID and try again.\n");
        }
        return ResponseVO.buildSuccess(loanApplication);
    }


    /**
     * @param loanApplicationID
     * @return
     *
     * 设置某贷款申请为已处理
     */

    @Override
    public ResponseVO setDealt(Integer loanApplicationID){
        try {
            //todo 调用花旗API
            loanMapper.setDealt(loanApplicationID);
        }catch (Exception e){
            return ResponseVO.buildFailure("Error 106 : Can't set this loanApplication DEALT! Please input correct loanApplication ID and try again.\n");
        }
        return ResponseVO.buildSuccess();
    }


    /**
     * @param userID
     * @return
     *
     * 查看某小微企业获得的所有贷款记录,只有hasDealt为true才是完成贷款的记录
     */
    @Override
    public ResponseVO getUserLoanHistory(Integer userID){
        List<LoanApplication> loanApplications;
        try{
            //todo 调用花旗API
            loanApplications = loanMapper.getUserLoanHistory(userID);
        }catch (Exception e){
            return ResponseVO.buildFailure("Error 107 : Can't get the loan history! Please input correct user ID and try again.\n");
        }
        return ResponseVO.buildSuccess(loanApplications);
    }
}
