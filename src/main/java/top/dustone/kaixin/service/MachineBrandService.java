package top.dustone.kaixin.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import top.dustone.kaixin.dao.MachineBrandDAO;
import top.dustone.kaixin.entity.MachineBrand;
import top.dustone.kaixin.util.Page4Navigator;

import java.util.ArrayList;
import java.util.List;
@Service
public class MachineBrandService {
    @Autowired
    MachineBrandDAO machineBrandDAO;
    public List<MachineBrand> list(){
        Sort sort=new Sort(Sort.Direction.DESC,"id");
        return machineBrandDAO.findAll(sort);
    }
    public Page4Navigator<MachineBrand> update(MachineBrand machineBrand){
        machineBrandDAO.save(machineBrand);
        Page4Navigator<MachineBrand> page4Navigator=new Page4Navigator<MachineBrand>();
        List<MachineBrand> content=new ArrayList<MachineBrand>(1);
        content.add(machineBrand);
        page4Navigator.setContent(content);
        return page4Navigator;
    }
}
