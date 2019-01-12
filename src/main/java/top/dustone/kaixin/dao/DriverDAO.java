package top.dustone.kaixin.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import top.dustone.kaixin.entity.Driver;

public interface DriverDAO extends JpaRepository<Driver,Integer>{
    public Driver findFirstByIdEquals(Integer id);
}
