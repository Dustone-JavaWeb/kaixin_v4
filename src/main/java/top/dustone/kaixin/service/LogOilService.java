package top.dustone.kaixin.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;
import top.dustone.kaixin.dao.LogOilDAO;
import top.dustone.kaixin.entity.log.LogOil;
import top.dustone.kaixin.util.Page4Navigator;

import java.util.ArrayList;
import java.util.List;

@Service
public class LogOilService {
    @Autowired
    private LogOilDAO logOilDAO;
    public Page4Navigator<LogOil> listByExapmle(LogOil logOil,int start,int size,int page){
        Sort sort=new Sort(Sort.Direction.DESC,"id");
        Pageable pageable=PageRequest.of(start,size,sort);
        ExampleMatcher exampleMatcher=ExampleMatcher.matching()
                .withMatcher("support.name",ExampleMatcher.GenericPropertyMatchers.contains())
                .withMatcher("machine.nameplate",ExampleMatcher.GenericPropertyMatchers.startsWith());
        Example<LogOil> example=Example.of(logOil,exampleMatcher);
        Page pageJPA=logOilDAO.findAll(example,pageable);
        return new Page4Navigator<LogOil>(pageJPA,page);
    }
    public Page4Navigator<LogOil> update(LogOil logOil){
        logOilDAO.save(logOil);
        Page4Navigator<LogOil> result=new Page4Navigator<LogOil>();
        List<LogOil> content=new ArrayList<LogOil>(1);
        content.add(logOil);
        result.setContent(content);
        return result;
    }
}
