package top.dustone.kaixin.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import top.dustone.kaixin.dao.DriverDAO;
import top.dustone.kaixin.entity.Driver;

import java.util.List;

@Service
public class DriverService {
    @Autowired
    private DriverDAO driverDAO;
    public List<Driver> list(){
        Sort sort=new Sort(Sort.Direction.DESC,"id");
        return driverDAO.findAll(sort);
    }
}
