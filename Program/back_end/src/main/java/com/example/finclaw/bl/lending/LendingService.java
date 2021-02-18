package com.example.finclaw.bl.lending;

import com.example.finclaw.vo.ResponseVO;
import com.example.finclaw.vo.lending.LendingForm;


/**
 * @Author HX
 * @Date 2021/2/7
 */

public interface LendingService {
    ResponseVO addLendingForm(LendingForm lendingForm);

    ResponseVO getBankLendingHistory(Integer bankID);

    ResponseVO getLendingHistory(Integer lendingHistoryID);

    ResponseVO getLendingHistoryByLoanApplicationID(Integer loanApplicationID);

    ResponseVO setDealt(Integer lendingHistoryID);

}
