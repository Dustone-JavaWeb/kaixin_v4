package top.dustone.kaixin.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import top.dustone.kaixin.dao.SysDrawerDAO;
import top.dustone.kaixin.entity.SysDrawer;

import java.util.List;

@Service
public class PageInfoService {
    @Autowired
    SysDrawerDAO sysDrawerDAO;
    public List<SysDrawer> list(){
        Sort sort=new Sort(Sort.Direction.DESC,"id");
        return sysDrawerDAO.findAll(sort);
    }
}
