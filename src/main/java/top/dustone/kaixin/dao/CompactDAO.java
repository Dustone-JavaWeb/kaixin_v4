package top.dustone.kaixin.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import top.dustone.kaixin.entity.Compact;

public interface CompactDAO extends JpaRepository<Compact,Integer>,JpaSpecificationExecutor<Compact>{
    public Compact findFirstByIdEquals(Integer id);
}

