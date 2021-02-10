package com.example.finclaw.data.lending;

import com.example.finclaw.po.LendingHistory;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;


@Mapper
@Repository
public interface LendingMapper {
    void createLendingHistory(LendingHistory lendingHistory);

    List<LendingHistory> getBankLendingHistory(Integer bankID);

    LendingHistory getLendingHistory(Integer lendingHistoryID);

    void setDealt(Integer lendingHistoryID);
}
