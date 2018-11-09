package top.dustone.kaixin.dao;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import top.dustone.kaixin.entity.SysDrawer;

import java.util.List;

public interface SysDrawerDAO extends JpaRepository<SysDrawer,Integer> {
    public List<SysDrawer> findByParentIdIsNull(Sort sort);
}
