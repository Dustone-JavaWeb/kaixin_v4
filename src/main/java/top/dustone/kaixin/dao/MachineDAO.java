package top.dustone.kaixin.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import top.dustone.kaixin.entity.Machine;

public interface MachineDAO extends JpaRepository<Machine,Integer>{
    public Machine findFirstByIdEquals(Integer id);
}
