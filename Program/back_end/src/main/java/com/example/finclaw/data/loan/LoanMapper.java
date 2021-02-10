package com.example.finclaw.data.loan;

import com.example.finclaw.po.LoanApplication;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;


@Mapper
@Repository
public interface LoanMapper {
    void createNewLoanApplication(LoanApplication loanApplication);

    void deleteLoanApplication(Integer loanApplicationID);

    List<LoanApplication> getAllLoanApplication(Integer userID);

    LoanApplication getLoanApplication(Integer loanApplicationID);

    void setDealt(Integer loanApplicationID);

    List<LoanApplication> getUserLoanHistory(Integer userID);

    void changeAmount(Integer loanApplicationID, double amount);
}
