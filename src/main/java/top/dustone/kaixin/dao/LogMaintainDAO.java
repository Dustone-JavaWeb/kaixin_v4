package top.dustone.kaixin.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import top.dustone.kaixin.entity.log.LogMaintain;

public interface LogMaintainDAO extends JpaRepository<LogMaintain,Integer> {
}
