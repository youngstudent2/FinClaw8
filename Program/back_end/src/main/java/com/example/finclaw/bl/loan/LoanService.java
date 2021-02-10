package com.example.finclaw.bl.loan;

import com.example.finclaw.vo.ResponseVO;
import com.example.finclaw.vo.loan.LoanApplicationForm;

/**
 * @Author HX
 * @Date 2021.2.7
 */

public interface LoanService {
    ResponseVO addLoanApplication(LoanApplicationForm loanApplicationForm);

    ResponseVO deleteLoanApplication(Integer loanApplicationID);

    ResponseVO getAllLoanApplication(Integer userID);

    ResponseVO getLoanApplication(Integer loanApplicationID);

    ResponseVO setDealt(Integer loanApplicationID);

    ResponseVO getUserLoanHistory(Integer userID);
}
