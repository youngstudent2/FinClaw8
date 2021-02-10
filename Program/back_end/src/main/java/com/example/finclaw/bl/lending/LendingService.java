package com.example.finclaw.bl.lending;

import com.example.finclaw.vo.ResponseVO;
import com.example.finclaw.vo.lending.LendingForm;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @Author HX
 * @Date 2021/2/7
 */

public interface LendingService {
    ResponseVO addLendingForm(LendingForm lendingForm);

    ResponseVO getBankLendingHistory(Integer bankID);

    ResponseVO getLendingHistory(Integer lendingHistoryID);

    ResponseVO setDealt(Integer lendingHistoryID);
}
