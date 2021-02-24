package com.example.finclaw.data.loan;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import com.example.finclaw.po.LoanApplication;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LoanMapperTest {
    @Autowired
    private LoanMapper loanMapper;

    @Test
    public void createNewLoanApplicationTest(){
       LoanApplication loanApplication = new LoanApplication(){{
            setAmount(10000);
            setCertificationCode("100");
            setCompanyName("test");
            setPhoneNumber("test");
            setRegistrationCode("100");
            setUserID(123);
            setUserName("test");
            setHasDealt(true);
        }};
       loanMapper.createNewLoanApplication(loanApplication);
       assertTrue(loanMapper.getUserLoanApplication(123).size()>0);
    }

    @Test
    public void deleteLoanApplicationTest(){

    }

    @Test
    public void getUserLoanApplicationTest(){
        List<LoanApplication> loanApplications = loanMapper.getUserLoanApplication(7);
        assertEquals(1,loanApplications.size());
    }

    @Test
    public void getAllLoanApplicationTest(){
        List<LoanApplication> loanApplications = loanMapper.getAllLoanApplication();
        assertTrue(loanApplications.size()>0);
    }

    @Test
    public void getLoanApplicationTest(){
        LoanApplication loanApplication = loanMapper.getLoanApplication(1);
        assertEquals(new Integer(7),loanApplication.getUserID());
        assertEquals(new Integer(1),loanApplication.getLoanApplicationID());
    }

    @Test
    public void setDealtTest(){
        loanMapper.setDealt(1);
        assertTrue(loanMapper.getLoanApplication(1).isHasDealt());
    }

    @Test
    public void getUserLoanHistoryTest(){
        List<LoanApplication> loanApplications = loanMapper.getUserLoanHistory(7);
        assertTrue(loanApplications.size()>0);
    }

    @Test
    public void changeAmountTest(){
        loanMapper.changeAmount(1,12345);
        assertEquals(12345,loanMapper.getLoanApplication(1).getAmount(),0.1);
    }
}
