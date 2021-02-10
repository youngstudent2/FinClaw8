package com.example.finclaw.blImpl.lending;

import com.example.finclaw.bl.lending.LendingService;
import com.example.finclaw.vo.ResponseVO;
import com.example.finclaw.vo.lending.LendingForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class LendingServiceImpl implements LendingService{

    /**
     * @param lendingForm
     * @return
     *
     * 银行可以浏览到在平台上借款的小微企业的借款列表，然后为某个借款请求提交贷款意愿
     *
     */
    @Override
    public ResponseVO addLendingForm(LendingForm lendingForm){
        //todo 花旗API
        return null;
    }



    /**
     * @param bankID
     * @return
     *
     * 查看某银行在平台的所有贷款记录
     */
    @Override
    public ResponseVO getBankLendingHistory(Integer bankID){
        //todo 花旗API
        return null;
    }


    /**
     * @param lendingHistoryID
     * @return
     *
     * 查看某条贷款记录
     */
    @Override
    public ResponseVO getLendingHistory(Integer lendingHistoryID){
        //todo 花旗API
        return null;
    }


    /**
     * @param lendingHistoryID
     * @return
     *
     * 银行发布的贷款意愿被用户采纳后置为将hasDealt置为true
     */

    @Override
    public ResponseVO setDealt(Integer lendingHistoryID){
        //todo 花旗API
        return null;
    }
}
