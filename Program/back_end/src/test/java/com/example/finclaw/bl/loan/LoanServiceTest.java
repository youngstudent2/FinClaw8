package com.example.finclaw.bl.loan;

import com.example.finclaw.vo.ResponseVO;
import com.example.finclaw.vo.loan.LoanApplicationForm;
import com.example.finclaw.vo.loan.LoanApplicationVO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LoanServiceTest {
    @Autowired
    private LoanService loanService;

    @Test
    public void addLoanApplicationTest(){
        LoanApplicationForm loanApplicationForm = new LoanApplicationForm(){{
            setAmount(10000);
            setCertificationCode("100");
            setCompanyName("test");
            setPhoneNumber("test");
            setRegistrationCode("100");
            setUserID(1234);
            setUserName("test");
        }};
        ResponseVO responseVO = loanService.addLoanApplication(loanApplicationForm);
        assertTrue(responseVO.getSuccess());
    }

    @Test
    public void deleteLoanApplicationTest(){

    }

    @Test
    public void getUserLoanApplicationTest(){
        ResponseVO responseVO = loanService.getUserLoanApplication(7);
        List<LoanApplicationVO> loanApplicationVOS = (List<LoanApplicationVO>) responseVO.getContent();
        assertTrue(responseVO.getSuccess());
        assertEquals(1,loanApplicationVOS.size());

    }

    @Test
    public void getAllLoanApplicationTest(){
        ResponseVO responseVO = loanService.getAllLoanApplication();
        assertTrue(responseVO.getSuccess());
    }

    @Test
    public void getLoanApplicationTest(){
        ResponseVO responseVO = loanService.getLoanApplication(1);
        LoanApplicationVO loanApplicationVO = (LoanApplicationVO) responseVO.getContent();
        assertTrue(responseVO.getSuccess());
        assertEquals(new Integer(1),loanApplicationVO.getLoanApplicationID());
    }

    @Test
    public void getUserLoanHistoryTest(){
        ResponseVO responseVO = loanService.getUserLoanHistory(7);
        List<LoanApplicationVO> loanApplicationVOS = (List<LoanApplicationVO>) responseVO.getContent();
        assertTrue(responseVO.getSuccess());
        assertEquals(1,loanApplicationVOS.size());
    }

    @Test
    public void setDealtTest(){
        ResponseVO responseVO = loanService.setDealt(1);
        LoanApplicationVO loanApplicationVO = (LoanApplicationVO) (loanService.getLoanApplication(1).getContent());
        assertTrue(responseVO.getSuccess());
        assertTrue(loanApplicationVO.isHasDealt());
    }
}
