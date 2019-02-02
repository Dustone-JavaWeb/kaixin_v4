package top.dustone.kaixin.util;

import top.dustone.kaixin.entity.view.DriverStatusCount;
import top.dustone.kaixin.entity.view.MachineStatusCount;

import java.util.List;

public class BaseboardData {
    private List<MachineStatusCount> machineStatusCounts;
    private List<DriverStatusCount> driverStatusCounts;

    public List<MachineStatusCount> getMachineStatusCounts() {
        return machineStatusCounts;
    }

    public void setMachineStatusCounts(List<MachineStatusCount> machineStatusCounts) {
        this.machineStatusCounts = machineStatusCounts;
    }

    public List<DriverStatusCount> getDriverStatusCounts() {
        return driverStatusCounts;
    }

    public void setDriverStatusCounts(List<DriverStatusCount> driverStatusCounts) {
        this.driverStatusCounts = driverStatusCounts;
    }

    @Override
    public String toString() {
        return "BaseboardData{" +
                "machineStatusCounts=" + machineStatusCounts +
                ", driverStatusCounts=" + driverStatusCounts +
                '}';
    }
}
