package top.dustone.kaixin.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import top.dustone.kaixin.entity.Resource;

public interface ResourceDAO extends JpaRepository<Resource,Integer>{
    public Resource findFirstByIdEquals(Integer id);
}
