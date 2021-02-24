package com.example.finclaw.data.lending;

import com.example.finclaw.po.LendingHistory;
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
public class LendingMapperTest {
    @Autowired
    private LendingMapper lendingMapper;

    @Test
    public void createLendingHistoryTest(){
        LendingHistory lendingHistory = new LendingHistory(){{
            setAmount(10000);
            setBankID(150);
            setBankName("TEST");
            setLenderID(3);
            setLenderName("lihua");
            setInterestRate(7);
            setPhoneNumber("12345678910");
            setLoanApplicationID(4);
        }};
        lendingMapper.createLendingHistory(lendingHistory);
        List<LendingHistory> lendingHistories = lendingMapper.getBankLendingHistory(150);
        assertTrue(lendingHistories.size()>0);
    }

    @Test
    public void getBankLendingHistoryTest(){
        List<LendingHistory> lendingHistories = lendingMapper.getBankLendingHistory(3);
        assertEquals(1,lendingHistories.size());
    }

    @Test
    public void getLendingHistoryTest(){
        LendingHistory lendingHistory = lendingMapper.getLendingHistory(1);
        assertEquals(new Integer(1),lendingHistory.getLendingHistoryID());
    }

    @Test
    public void getLendingHistoryByLoanApplicationID(){
        List<LendingHistory> lendingHistories = lendingMapper.getBankLendingHistory(3);
        assertEquals(1,lendingHistories.size());
    }

    @Test
    public void setDealtTest(){
        lendingMapper.setDealt(1);
        assertTrue(lendingMapper.getLendingHistory(1).isHasDealt());
    }

}
