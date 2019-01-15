package top.dustone.kaixin.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import top.dustone.kaixin.dao.MachineDAO;
import top.dustone.kaixin.dao.MachineStatusDAO;
import top.dustone.kaixin.entity.MachineStatus;
import top.dustone.kaixin.util.Page4Navigator;

@Service
@Transactional
public class MachineStatusService {
    @Autowired
    MachineStatusDAO machineStatusDAO;
    @Autowired
    MachineDAO machineDAO;

    public Page4Navigator<MachineStatus> listByExample(MachineStatus machineStatus, int start, int size, int page) {
        Sort sort = new Sort(Sort.Direction.DESC, "id");
        Pageable pageable = PageRequest.of(start, size, sort);
        Page pageJPA = null;
        if (machineStatus.getWorkId() != null) {
            pageJPA = machineStatusDAO.findByWorkIdIsNotNull(pageable);
        } else if (machineStatus.getMaintainId() != null) {
            pageJPA = machineStatusDAO.findByMaintainIdIsNotNull(pageable);
        } else if (machineStatus.getTransportId() != null) {
            pageJPA = machineStatusDAO.findByTransportIdIsNotNull(pageable);
        } else {
            pageJPA = machineStatusDAO.findAll(pageable);
        }
        return new Page4Navigator<MachineStatus>(pageJPA, page);
    }

    @Transactional
    public boolean startMaintain(Integer machineId, Integer logMaintainId) {
        MachineStatus machineStatus = machineStatusDAO.findFirstByMachineIdEquals(machineId);
        if (machineStatus != null) {
            machineStatus.setMaintainId(logMaintainId);
            machineStatus.setStatus("维修");
            return true;
        }
        return false;
    }

    public Boolean inMaintain(Integer machineId) {
        MachineStatus machineStatus = machineStatusDAO.findFirstByMachineIdEquals(machineId);
        if (machineStatus.getMaintainId() == null) {
            return false;
        } else {
            return true;
        }
    }

    @Transactional
    public boolean endMaintain(Integer machineId) {
        MachineStatus machineStatus = machineStatusDAO.findFirstByMachineIdEquals(machineId);
        if (machineStatus != null) {
            machineStatus.setMaintainId(null);
            machineStatus.setStatus("空闲");
            return true;
        } else {
            return false;
        }
    }

    @Transactional
    public boolean startWork(Integer machineId, Integer logWorkId) {
        MachineStatus machineStatus = machineStatusDAO.findFirstByMachineIdEquals(machineId);
        if (machineStatus != null) {
            machineStatus.setWorkId(logWorkId);
            machineStatus.setStatus("工作");
            return true;
        }
        return false;

    }

    public Boolean inWork(Integer machineId) {
        MachineStatus machineStatus = machineStatusDAO.findFirstByMachineIdEquals(machineId);
        if (machineStatus.getWorkId() == null) {
            return false;
        } else {
            return true;
        }
    }

    @Transactional
    public boolean endWork(Integer machineId) {
        MachineStatus machineStatus = machineStatusDAO.findFirstByMachineIdEquals(machineId);
        if (machineStatus != null) {
            machineStatus.setWorkId(null);
            machineStatus.setStatus("空闲");
            return true;
        } else {
            return false;
        }
    }

    @Transactional
    public boolean startTransport(Integer machineId, Integer logTransportId) {
        MachineStatus machineStatus = machineStatusDAO.findFirstByMachineIdEquals(machineId);
        if (machineStatus != null) {
            machineStatus.setTransportId(logTransportId);
            machineStatus.setStatus("转场");
            return true;
        }
        return false;
    }

    public Boolean inTransport(Integer machineId) {
        MachineStatus machineStatus = machineStatusDAO.findFirstByMachineIdEquals(machineId);
        if (machineStatus.getTransportId() == null) {
            return false;
        } else {
            return true;
        }
    }

    @Transactional
    public boolean endTransport(Integer machineId) {
        MachineStatus machineStatus = machineStatusDAO.findFirstByMachineIdEquals(machineId);
        if (machineStatus != null) {
            machineStatus.setTransportId(null);
            machineStatus.setStatus("空闲");
            return true;
        } else {
            return false;
        }
    }

    @Transactional
    public boolean setCompact(Integer machineId, Integer compactId) {
        MachineStatus machineStatus = machineStatusDAO.findFirstByMachineIdEquals(machineId);
        if (machineStatus.getCompactId() == null) {
            machineStatus.setCompactId(compactId);
            return true;
        } else {
            return false;
        }
    }

    @Transactional
    public boolean removeCompact(Integer machineId) {
        MachineStatus machineStatus = machineStatusDAO.findFirstByMachineIdEquals(machineId);
        if (machineStatus.getCompactId() != null) {
            machineStatus.setCompactId(null);
            return true;
        } else {
            return false;
        }
    }
}
