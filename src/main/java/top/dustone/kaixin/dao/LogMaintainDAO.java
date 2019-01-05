package top.dustone.kaixin.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import top.dustone.kaixin.entity.log.LogMaintain;

public interface LogMaintainDAO extends JpaRepository<LogMaintain,Integer>,JpaSpecificationExecutor<LogMaintain> {
}
