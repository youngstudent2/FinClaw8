package com.example.finclaw.blImpl.lending;

import com.example.finclaw.bl.lending.LendingService;
import com.example.finclaw.data.lending.LendingMapper;
import com.example.finclaw.po.LendingHistory;
import com.example.finclaw.vo.ResponseVO;
import com.example.finclaw.vo.lending.LendingForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
            setLenderID(lendingForm.getLenderID());
            setBankName(lendingForm.getBankName());
            setAmount(lendingForm.getAmount());
            setInterestRate(lendingForm.getInterestRate());
            setPhoneNumber(lendingForm.getPhoneNumber());
        }};
        try{
            //todo 花旗API
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
        List<LendingHistory> lendingHistories;
        try{
            //todo 花旗API
            lendingHistories = lendingMapper.getBankLendingHistory(bankID);
        }catch (Exception e){
            return ResponseVO.buildFailure("Error 202 : Can't get the lending information. Please input correct bank ID and try again.\n");
        }
        return ResponseVO.buildSuccess(lendingHistories);
    }


    /**
     * @param lendingHistoryID
     * @return
     *
     * 查看某条贷款记录
     */
    @Override
    public ResponseVO getLendingHistory(Integer lendingHistoryID){
        LendingHistory lendingHistory;
        try{
            //todo 花旗API
            lendingHistory = lendingMapper.getLendingHistory(lendingHistoryID);
        }catch (Exception e){
            return ResponseVO.buildFailure("Error 203 : Can't get the lending information by this ID. Please input correct lendingHistory ID and try again.\n");
        }
        return ResponseVO.buildSuccess(lendingHistory);
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
            //todo 花旗API
            lendingMapper.setDealt(lendingHistoryID);
        }catch (Exception e){
            return ResponseVO.buildFailure("Error 204 : Can't set this lendingHistory DEALT! Please input correct lendingHistory ID and try again.\n");
        }
        return ResponseVO.buildSuccess();
    }
}
