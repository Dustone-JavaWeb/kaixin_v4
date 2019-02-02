package top.dustone.kaixin.service.view;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.dustone.kaixin.dao.view.DriverStatusCountDAO;
import top.dustone.kaixin.dao.view.MachineStatusCountDAO;
import top.dustone.kaixin.util.BaseboardData;

@Service
public class GlobalStatusService {
    @Autowired
    MachineStatusCountDAO machineStatusCountDAO;
    @Autowired
    DriverStatusCountDAO driverStatusCountDAO;
    public BaseboardData makeBaseboardData(){
        BaseboardData baseboardData=new BaseboardData();
        baseboardData.setDriverStatusCounts(driverStatusCountDAO.findAll());
        baseboardData.setMachineStatusCounts(machineStatusCountDAO.findAll());
        return baseboardData;
    }
}
