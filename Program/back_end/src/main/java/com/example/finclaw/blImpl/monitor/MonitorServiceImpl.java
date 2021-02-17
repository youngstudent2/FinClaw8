package com.example.finclaw.blImpl.monitor;

import com.example.finclaw.bl.monitor.MonitorService;
import com.example.finclaw.data.monitor.MonitorMapper;
import com.example.finclaw.enums.Operation;
import com.example.finclaw.po.Monitor;
import com.example.finclaw.vo.monitor.MonitorVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author  hx
 *
 * @Date 2020/10/15
 */

@Service
public class MonitorServiceImpl implements MonitorService {

    @Autowired
    private MonitorMapper monitorMapper;


    @Override
    public void recordInfo(int userID, int projectID, int operatorID) {

        String operation = Objects.requireNonNull(Operation.getOperation(operatorID)).toString();

        monitorMapper.createNewRecord(userID, projectID,operation);
    }


    @Override
    public List<MonitorVO> getAllOperation(){

        return convert2VO(monitorMapper.getAllMonitor());

    }

    @Override
    public List<MonitorVO> getProjectMonitor(int projectID){

        return convert2VO(monitorMapper.getProjectMonitor(projectID));

    }


    @Override
    public List<MonitorVO> getUserMonitor(int userID){

        return convert2VO(monitorMapper.getUserMonitor(userID));

    }


    private List<MonitorVO> convert2VO (List<Monitor> monitors){

        List<MonitorVO> monitorVOS = new ArrayList<>();

        for (Monitor monitor : monitors) {

            monitorVOS.add(new MonitorVO(){{

                setMonitorID(monitor.getMonitorID());
                setUserID(monitor.getUserID());
                setProjectID(monitor.getProjectID());
                setOperation(monitor.getOperation());
                setOperateTime(monitor.getOperateTime());

            }});
        }

        return monitorVOS;
    }
}


