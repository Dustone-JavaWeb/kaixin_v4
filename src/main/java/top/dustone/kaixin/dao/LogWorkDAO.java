package top.dustone.kaixin.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import top.dustone.kaixin.entity.log.LogWork;

public interface LogWorkDAO extends JpaRepository<LogWork,Integer> ,JpaSpecificationExecutor<LogWork> {
}
