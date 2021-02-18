package com.example.finclaw.blImpl.loan;

import com.example.finclaw.bl.loan.LoanService;
import com.example.finclaw.data.loan.LoanMapper;
import com.example.finclaw.po.LoanApplication;
import com.example.finclaw.vo.ResponseVO;
import com.example.finclaw.vo.loan.LoanApplicationForm;
import com.example.finclaw.vo.loan.LoanApplicationVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
           setUserName(loanApplicationForm.getUserName());
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

        List<LoanApplicationVO> loanApplicationsVOS = new ArrayList<>();

        try{

            for (LoanApplication loanApplication:
                    loanMapper.getUserLoanApplication(userID)) {

                loanApplicationsVOS.add(convert2vo(loanApplication));
            }

        }catch (Exception e){

            return ResponseVO.buildFailure("Error 103 : Can't get the loan information. Please input correct user ID and try again.\n");
        }

        return ResponseVO.buildSuccess(loanApplicationsVOS);
    }


    @Override
    public ResponseVO getAllLoanApplication(){
        List<LoanApplicationVO> loanApplicationsVOS = new ArrayList<>();

        try {

            for (LoanApplication loanApplication:
                    loanMapper.getAllLoanApplication()) {

                loanApplicationsVOS.add(convert2vo(loanApplication));
            }

        }catch (Exception e){

            return ResponseVO.buildFailure("Error 104 : Can't get the loan information. Please try again.\n");
        }

        return ResponseVO.buildSuccess(loanApplicationsVOS);
    }

    /**
     * @param loanApplicationID
     * @return
     *
     * 查看某条贷款申请记录
     */
    @Override
    public ResponseVO getLoanApplication(Integer loanApplicationID){

        LoanApplicationVO loanApplicationVO;

        try{

            loanApplicationVO = convert2vo(loanMapper.getLoanApplication(loanApplicationID));

        }catch (Exception e){

            return ResponseVO.buildFailure("Error 105 : Can't get the loan information by this ID. Please input correct loanApplication ID and try again.\n");
        }

        return ResponseVO.buildSuccess(loanApplicationVO);
    }


    /**
     * @param userID
     * @return
     *
     * 查看某小微企业获得的所有贷款记录,只有hasDealt为true才是完成贷款的记录
     */
    @Override
    public ResponseVO getUserLoanHistory(Integer userID){

        List<LoanApplicationVO> loanApplicationVOS = new ArrayList<>();

        try{
            //todo 调用花旗API
            for (LoanApplication loanApplication:
                    loanMapper.getUserLoanHistory(userID)) {

                loanApplicationVOS.add(convert2vo(loanApplication));
            }

        }catch (Exception e){

            return ResponseVO.buildFailure("Error 106 : Can't get the loan history! Please input correct user ID and try again.\n");
        }

        return ResponseVO.buildSuccess(loanApplicationVOS);
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

            return ResponseVO.buildFailure("Error 107 : Can't set this loanApplication DEALT! Please input correct loanApplication ID and try again.\n");
        }

        return ResponseVO.buildSuccess();
    }



    /**
     * 将从数据库获取到的PO类转化为VO类
     * @param loanApplication
     * @return
     */
    private LoanApplicationVO convert2vo(LoanApplication loanApplication){

        return new LoanApplicationVO(){{
            setLoanApplicationID(loanApplication.getLoanApplicationID());
            setUserID(loanApplication.getUserID());
            setUserName(loanApplication.getUserName());
            setAmount(loanApplication.getAmount());
            setCertificationCode(loanApplication.getCertificationCode());
            setRegistrationCode(loanApplication.getRegistrationCode());
            setCompanyName(loanApplication.getCompanyName());
            setPhoneNumber(loanApplication.getPhoneNumber());
            setHasDealt(loanApplication.isHasDealt());
            setCreateTime(loanApplication.getCreateTime());
        }};
    }
}
