package top.dustone.kaixin.dao.sys;

import org.springframework.data.jpa.repository.JpaRepository;
import top.dustone.kaixin.entity.sys.SysUser;

public interface SysUserDAO extends JpaRepository<SysUser,Integer>{
    public SysUser findByUsername(String username);
    public SysUser findByUsernameAndPassword(String username,String password);
}
