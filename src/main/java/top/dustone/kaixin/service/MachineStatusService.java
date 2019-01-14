package top.dustone.kaixin.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import top.dustone.kaixin.dao.MachineDAO;
import top.dustone.kaixin.dao.MachineStatusDAO;
import top.dustone.kaixin.entity.MachineStatus;

@Service
@Transactional
public class MachineStatusService {
    @Autowired
    MachineStatusDAO machineStatusDAO;
    @Autowired
    MachineDAO machineDAO;
    @Transactional
    public boolean startMaintain(Integer machineId,Integer logMaintainId){
        MachineStatus machineStatus=machineStatusDAO.findFirstByMachineIdEquals(machineId);
        if(machineStatus!=null) {
            if(machineStatus.getTransportId()==null&&machineStatus.getWorkId()==null) {
                machineStatus.setMaintainId(logMaintainId);
                return true;
            }
        }
        return false;
    }
    @Transactional
    public boolean endMaintain(Integer machineId){
        MachineStatus machineStatus=machineStatusDAO.findFirstByMachineIdEquals(machineId);
        if(machineStatus!=null) {
            machineStatus.setMaintainId(null);
            return true;
        }else{
            return false;
        }
    }
    @Transactional
    public boolean startWork(Integer machineId,Integer logWorkId){
        MachineStatus machineStatus=machineStatusDAO.findFirstByMachineIdEquals(machineId);
        if(machineStatus!=null) {
            if(machineStatus.getTransportId()==null&&machineStatus.getMaintainId()==null) {
                machineStatus.setWorkId(logWorkId);
                return true;
            }
        }
        return false;

    }
    @Transactional
    public boolean endWork(Integer machineId){
        MachineStatus machineStatus=machineStatusDAO.findFirstByMachineIdEquals(machineId);
        if(machineStatus!=null) {
            machineStatus.setWorkId(null);
            return true;
        }else{
            return false;
        }
    }
    @Transactional
    public boolean startTransport(Integer machineId,Integer logTransportId){
        MachineStatus machineStatus=machineStatusDAO.findFirstByMachineIdEquals(machineId);
        if(machineStatus!=null) {
            if(machineStatus.getWorkId()==null&&machineStatus.getMaintainId()==null) {
                machineStatus.setTransportId(logTransportId);
                return true;
            }
        }
        return false;
    }
    @Transactional
    public boolean endTransport(Integer machineId){
        MachineStatus machineStatus=machineStatusDAO.findFirstByMachineIdEquals(machineId);
        if(machineStatus!=null) {
            machineStatus.setTransportId(null);
            return true;
        }else{
            return false;
        }
    }
}
