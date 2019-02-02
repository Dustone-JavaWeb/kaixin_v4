package top.dustone.kaixin.dao.view;

import org.springframework.data.jpa.repository.JpaRepository;
import top.dustone.kaixin.entity.view.DriverStatusCount;

public interface DriverStatusCountDAO extends JpaRepository<DriverStatusCount,String> {
}
