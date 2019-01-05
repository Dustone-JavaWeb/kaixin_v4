package top.dustone.kaixin.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import top.dustone.kaixin.entity.log.LogError;

public interface LogErrorDAO extends JpaRepository<LogError,Integer>,JpaSpecificationExecutor<LogError> {
}
