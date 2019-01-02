package top.dustone.kaixin.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import top.dustone.kaixin.entity.log.LogTransport;

public interface LogTransportDAO extends JpaRepository<LogTransport,Integer> {
}
