package top.dustone.kaixin.dao.view;

import org.springframework.data.jpa.repository.JpaRepository;
import top.dustone.kaixin.entity.view.MachineStatusCount;

public interface MachineStatusCountDAO extends JpaRepository<MachineStatusCount,String> {
}
