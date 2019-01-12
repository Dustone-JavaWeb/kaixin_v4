package top.dustone.kaixin.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;
import top.dustone.kaixin.dao.DriverDAO;
import top.dustone.kaixin.entity.Driver;
import top.dustone.kaixin.util.Page4Navigator;

import java.util.ArrayList;
import java.util.List;

@Service
public class DriverService {
    @Autowired
    private DriverDAO driverDAO;
    public List<Driver> list(){
        Sort sort=new Sort(Sort.Direction.DESC,"id");
        return driverDAO.findAll(sort);
    }
    public  Page4Navigator<Driver> list(int start,int size,int page){
        Sort sort=new Sort(Sort.Direction.DESC,"id");
        Pageable pageable=PageRequest.of(start,size,sort);
        Page pageJPA=driverDAO.findAll(pageable);
        return new Page4Navigator<Driver>(pageJPA,page);
    }
    public Page4Navigator<Driver> listByExapmle(Driver driver,int start,int size,int page){
        Sort sort=new Sort(Sort.Direction.DESC,"id");
        Pageable pageable=PageRequest.of(start,size,sort);
        ExampleMatcher exampleMatcher=ExampleMatcher.matching()
                .withMatcher("name",ExampleMatcher.GenericPropertyMatchers.contains())
                .withMatcher("paperId",ExampleMatcher.GenericPropertyMatchers.startsWith())
                .withMatcher("tel",ExampleMatcher.GenericPropertyMatchers.startsWith());
        Example<Driver> example=Example.of(driver,exampleMatcher);
        Page pageJPA=driverDAO.findAll(example,pageable);
        return new Page4Navigator<Driver>(pageJPA,page);
    }
    public Page4Navigator<Driver> update(Driver driver){
        driverDAO.save(driver);
        Page4Navigator<Driver> result=new Page4Navigator<Driver>();
        List<Driver> content=new ArrayList<Driver>(1);
        content.add(driver);
        result.setContent(content);
        return result;
    }
    public Driver findById(Integer id){
        return driverDAO.findFirstByIdEquals(id);
    }
}
