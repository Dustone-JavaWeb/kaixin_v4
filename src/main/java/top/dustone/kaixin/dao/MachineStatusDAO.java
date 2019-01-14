package top.dustone.kaixin.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import top.dustone.kaixin.entity.MachineStatus;

public interface MachineStatusDAO extends JpaRepository<MachineStatus,Integer> {
    public MachineStatus findFirstByMachineIdEquals(Integer id);
}
