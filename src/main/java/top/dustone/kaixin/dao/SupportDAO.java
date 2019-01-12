package top.dustone.kaixin.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import top.dustone.kaixin.entity.Support;

public interface SupportDAO extends JpaRepository<Support,Integer>{
    public Support findFirstByIdEquals(Integer id);
}
