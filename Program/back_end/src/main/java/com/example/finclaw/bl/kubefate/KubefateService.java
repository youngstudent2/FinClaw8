package com.example.finclaw.bl.kubefate;

import com.example.finclaw.vo.ResponseVO;

/**
 * @Author: LLY
 * @Date:   2021-2-3
 */
public interface KubefateService {
    public ResponseVO deploy(Integer projectID);
}
