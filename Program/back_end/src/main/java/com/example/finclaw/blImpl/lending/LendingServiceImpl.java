package com.example.finclaw.blImpl.lending;

import com.example.finclaw.bl.lending.LendingService;
import com.example.finclaw.data.lending.LendingMapper;
import com.example.finclaw.po.LendingHistory;
import com.example.finclaw.vo.ResponseVO;
import com.example.finclaw.vo.lending.LendingForm;
import com.example.finclaw.vo.lending.LendingHistoryVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class LendingServiceImpl implements LendingService{

    @Autowired
    private LendingMapper lendingMapper;

    /**
     * @param lendingForm
     * @return
     *
     * 银行可以浏览到在平台上借款的小微企业的借款列表，然后为某个借款请求提交贷款意愿
     *
     */
    @Override
    public ResponseVO addLendingForm(LendingForm lendingForm){
        LendingHistory lendingHistory = new LendingHistory(){{
            setBankID(lendingForm.getBankID());
            setBankName(lendingForm.getBankName());
            setLenderID(lendingForm.getLenderID());
            setLenderName(lendingForm.getLenderName());
            setAmount(lendingForm.getAmount());
            setInterestRate(lendingForm.getInterestRate());
            setPhoneNumber(lendingForm.getPhoneNumber());
        }};
        try{
            lendingMapper.createLendingHistory(lendingHistory);
        }catch (Exception e){
            return ResponseVO.buildFailure("Error 201 :  Can't create new lendingHistory! Exam your information and try again.\n");
        }
        return ResponseVO.buildSuccess();
    }



    /**
     * @param bankID
     * @return
     *
     * 查看某银行在平台的所有贷款记录
     */
    @Override
    public ResponseVO getBankLendingHistory(Integer bankID){

        List<LendingHistoryVO> lendingHistoryVOS = new ArrayList<>();

        try{
            for (LendingHistory lendingHistory:
                    lendingMapper.getBankLendingHistory(bankID)) {

                lendingHistoryVOS.add(convert2vo(lendingHistory));
            }

        }catch (Exception e){
            return ResponseVO.buildFailure("Error 202 : Can't get the lending information. Please input correct bank ID and try again.\n");
        }
        return ResponseVO.buildSuccess(lendingHistoryVOS);
    }


    /**
     * @param lendingHistoryID
     * @return
     *
     * 查看某条贷款记录
     */
    @Override
    public ResponseVO getLendingHistory(Integer lendingHistoryID){

        LendingHistoryVO lendingHistoryVO;

        try{
            lendingHistoryVO = convert2vo(lendingMapper.getLendingHistory(lendingHistoryID));

        }catch (Exception e){
            return ResponseVO.buildFailure("Error 203 : Can't get the lending information by this ID. Please input correct lendingHistory ID and try again.\n");
        }
        return ResponseVO.buildSuccess(lendingHistoryVO);
    }


    /**
     * 根据所给的借贷申请编号（loanApplicationID）返回对应的银行借贷意愿表
     * @param loanApplicationID
     * @return
     */
    @Override
    public ResponseVO getLendingHistoryByLoanApplicationID(Integer loanApplicationID){
        List<LendingHistoryVO> lendingHistoryVOS = new ArrayList<>();

        try{
            for (LendingHistory lendingHistory :
                    lendingMapper.getLendingHistoryByLoanApplicationID(loanApplicationID)) {
                lendingHistoryVOS.add(convert2vo(lendingHistory));
            }
        }catch (Exception e){
            return ResponseVO.buildFailure("Error 204 : Can't get the lending history by this loanApplicationID. Please input correct ID and try again.\n");
        }

        return ResponseVO.buildSuccess(lendingHistoryVOS);
    }
    

    /**
     * @param lendingHistoryID
     * @return
     *
     * 银行发布的贷款意愿被用户采纳后置为将hasDealt置为true
     */

    @Override
    public ResponseVO setDealt(Integer lendingHistoryID){
        try{
            lendingMapper.setDealt(lendingHistoryID);
        }catch (Exception e){
            return ResponseVO.buildFailure("Error 205 : Can't set this lendingHistory DEALT! Please input correct lendingHistory ID and try again.\n");
        }
        return ResponseVO.buildSuccess();
    }


    /**
     * 将从数据库获取到的PO类转化为VO类
     * @param lendingHistory
     * @return
     */
    private LendingHistoryVO convert2vo(LendingHistory lendingHistory){

        return new LendingHistoryVO(){{
           setLendingHistoryID(lendingHistory.getLendingHistoryID());
           setLoanApplicationID(lendingHistory.getLoanApplicationID());
           setBankID(lendingHistory.getBankID());
           setBankName(lendingHistory.getBankName());
           setLenderID(lendingHistory.getLenderID());
           setLenderName(lendingHistory.getLenderName());
           setAmount(lendingHistory.getAmount());
           setInterestRate(lendingHistory.getInterestRate());
           setPhoneNumber(lendingHistory.getPhoneNumber());
           setHasDealt(lendingHistory.isHasDealt());
           setCreateTime(lendingHistory.getCreateTime());
        }};
    }
}
