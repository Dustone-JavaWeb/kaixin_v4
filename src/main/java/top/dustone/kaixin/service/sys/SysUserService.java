package top.dustone.kaixin.service.sys;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.dustone.kaixin.dao.sys.SysUserDAO;
import top.dustone.kaixin.entity.sys.SysUser;

@Service
public class SysUserService {
    @Autowired
    private SysUserDAO sysUserDAO;
    public boolean isExist(String username){
        SysUser sysUser=findByUsername(username);
        return sysUser!=null;
    }
    public SysUser findByUsername(String username){
        return sysUserDAO.findByUsername(username);
    }
    public SysUser get(String username,String password){
        return sysUserDAO.findByUsernameAndPassword(username,password);
    }
}
