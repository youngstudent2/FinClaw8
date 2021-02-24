package com.example.finclaw.bl.lending;

import com.example.finclaw.vo.ResponseVO;
import com.example.finclaw.vo.lending.LendingForm;
import okhttp3.Response;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import static org.junit.Assert.assertEquals;

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
}
