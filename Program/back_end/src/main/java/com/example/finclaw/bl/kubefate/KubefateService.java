package com.example.finclaw.bl.kubefate;

import com.example.finclaw.vo.ResponseVO;

/**
 * @Author: LLY
 * @Date:   2021-2-3
 */
public interface KubefateService {
    /**
     * 用于部署一个项目，调用算法组的deploy接口
     * @param projectID
     * @return 返回部署结果
     */
    public ResponseVO deploy(Integer projectID);

    /**
     * 必须在deploy完成后执行，功能：完成各参与方数据集上传
     * @param projectID
     * @return
     */
    public ResponseVO upload(Integer projectID);

    /**
     * 必须在upload完成后才能执行，且一般upload后紧跟submit操作，功能：在训练环境部署完成的前提下由监管方发起一次训练任务
     * @return
     */
    public ResponseVO submit(Integer projectID);

    /**
     * 根据jid可以查询模型训练状态
     * @param projectID
     * @return
     */
    public ResponseVO query(Integer projectID);

    /**
     * 必须先绑定才能进行predict
     * @param projectID
     * @return
     */
    public ResponseVO loadBind(Integer projectID);

    public ResponseVO predict();

}

