package top.dustone.kaixin.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import top.dustone.kaixin.entity.log.LogOil;

public interface LogOilDAO extends JpaRepository<LogOil,Integer>,JpaSpecificationExecutor<LogOil> {
}
