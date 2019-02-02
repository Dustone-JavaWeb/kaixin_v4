package top.dustone.kaixin.dao.view;

import org.springframework.data.jpa.repository.JpaRepository;
import top.dustone.kaixin.entity.view.WorkCount;

public interface WorkCountDAO extends JpaRepository<WorkCount,String> {
}
