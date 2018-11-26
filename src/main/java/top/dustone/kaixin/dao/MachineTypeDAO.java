package top.dustone.kaixin.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import top.dustone.kaixin.entity.MachineType;

public interface MachineTypeDAO extends JpaRepository<MachineType,Integer> {
}
