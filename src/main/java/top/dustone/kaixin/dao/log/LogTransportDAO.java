package top.dustone.kaixin.dao.log;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import top.dustone.kaixin.entity.log.LogTransport;

public interface LogTransportDAO extends JpaRepository<LogTransport,Integer> ,JpaSpecificationExecutor<LogTransport> {
}
