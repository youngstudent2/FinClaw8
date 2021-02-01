package com.example.finclaw.blImpl.monitor;

import com.example.finclaw.bl.account.AccountService;
import com.example.finclaw.bl.cooperation.CooperationService;
import com.example.finclaw.bl.monitor.MonitorService;
import com.example.finclaw.data.monitor.MonitorMapper;
import com.example.finclaw.enums.Operation;
import com.example.finclaw.po.MonitorForm;
import com.example.finclaw.vo.account.UserVO;
import com.example.finclaw.vo.monitor.MonitorFormVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author  hx
 *
 * @Date 2020/10/15
 */

@Service
public class MonitorServiceImpl implements MonitorService {

    @Autowired
    private MonitorMapper monitorMapper;
    @Autowired
    private AccountService accountService;
    @Autowired
    private CooperationService cooperationService;

    @Override
    public void recordInfo(int userID, int projectID, int operatorID) {
        MonitorForm monitorForm = new MonitorForm(userID, projectID, operatorID);
        monitorMapper.createNewRecord(monitorForm);
    }


    @Override
    public List<MonitorFormVO> getMonitorInfo(int projectID) {
        List<MonitorForm> monitorForms = monitorMapper.getProjectMonitorForms(projectID);
        return convert2FormVO(monitorForms);
    }


    @Override
    public List<MonitorFormVO> getMonitorInfo(int projectID, int operatorID) {
        List<MonitorForm> monitorForms = monitorMapper.getProjectMonitorForms(projectID);
        List<MonitorFormVO> monitorFormVOS = new ArrayList<>();
        for (MonitorForm form : monitorForms) {
            if (form.getOperation().equals(Operation.getOperation(operatorID).toString())) {
                monitorFormVOS.add(new MonitorFormVO(form));
            }
        }
        return monitorFormVOS;
    }

    @Override
    public List<MonitorFormVO> getMonitorInfo(int projectID, int cooperationID, int operatorID) {
        List<MonitorForm> monitorForms = monitorMapper.getProjectMonitorForms(projectID);
        List<MonitorFormVO> monitorFormVOS = new ArrayList<>();
        for (MonitorForm form :
                monitorForms) {
            if (form.getOperation().equals(
                    Operation.toString(Operation.getOperation(operatorID)))) {
                int userID = form.getUserID();
                UserVO userVO = accountService.getUserInfo(userID);
                if (userVO.getCooperation().equals(
                        cooperationService.getCooperationById(cooperationID).getCooperationName()))
                    monitorFormVOS.add(new MonitorFormVO(form));
            }
        }
        return monitorFormVOS;
    }


        @Override
        public List<MonitorFormVO> getCooperationMonitorInfo(int projectID, int cooperationID) {
            List<MonitorForm> monitorForms = monitorMapper.getCooperationMonitorInfo(projectID, cooperationID);
            return convert2FormVO(monitorForms);
        }

        private List<MonitorFormVO> convert2FormVO (List<MonitorForm> forms){
            List<MonitorFormVO> formVOs = new ArrayList<>();
            for (MonitorForm form : forms) {
                formVOs.add(new MonitorFormVO(form));
            }
            return formVOs;
        }
    }


