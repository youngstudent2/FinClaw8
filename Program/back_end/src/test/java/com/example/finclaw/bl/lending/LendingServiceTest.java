package com.example.finclaw.bl.lending;

import com.example.finclaw.vo.ResponseVO;
import com.example.finclaw.vo.lending.LendingForm;
import com.example.finclaw.vo.lending.LendingHistoryVO;
import okhttp3.Response;
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
public class LendingServiceTest {
    @Autowired
    private LendingService lendingService;

    @Test
    public void addLendingFormTest(){
        LendingForm lendingForm = new LendingForm(){{
            setAmount(10000);
            setBankID(2);
            setBankName("CMB");
            setLenderID(2);
            setLenderName("lihua");
            setInterestRate(7);
            setPhoneNumber("12345678910");
            setLoanApplicationID(2);
        }};
        ResponseVO responseVO = lendingService.addLendingForm(lendingForm);
        assertEquals(true,responseVO.getSuccess());
    }

    @Test
    public void getBankLendingHistoryTest(){
        List<LendingHistoryVO> res = (List<LendingHistoryVO>) lendingService.getBankLendingHistory(3).getContent();
        assertEquals(1,res.size());

    }

    @Test
    public void getLendingHistoryTest(){
        ResponseVO responseVO = lendingService.getLendingHistory(1);
        LendingHistoryVO lendingHistoryVO = (LendingHistoryVO) (responseVO.getContent());
        assertTrue(responseVO.getSuccess());
        assertEquals(new Integer(3),lendingHistoryVO.getBankID());
    }

    @Test
    public void getLendingHistoryByLoanApplicationIDTest(){
        ResponseVO responseVO = lendingService.getLendingHistoryByLoanApplicationID(1);
        List<LendingHistoryVO> lendingHistoryVOS = (List<LendingHistoryVO>) (responseVO.getContent());
        assertTrue(responseVO.getSuccess());
        assertEquals(1,lendingHistoryVOS.size());
    }

    @Test
    public void setDealtTest(){
        ResponseVO responseVO = lendingService.setDealt(1);
        assertTrue(responseVO.getSuccess());
    }
}
