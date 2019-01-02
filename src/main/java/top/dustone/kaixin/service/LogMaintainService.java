package top.dustone.kaixin.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;
import top.dustone.kaixin.dao.LogMaintainDAO;
import top.dustone.kaixin.entity.log.LogMaintain;
import top.dustone.kaixin.util.Page4Navigator;

import java.util.ArrayList;
import java.util.List;

@Service
public class LogMaintainService {
    @Autowired
    private LogMaintainDAO logMaintainDAO;
    public Page4Navigator<LogMaintain> listByExapmle(LogMaintain logMaintain, int start, int size, int page){
        Sort sort=new Sort(Sort.Direction.DESC,"id");
        Pageable pageable= PageRequest.of(start,size,sort);
        ExampleMatcher exampleMatcher=ExampleMatcher.matching()
                .withMatcher("support.name",ExampleMatcher.GenericPropertyMatchers.contains())
                .withMatcher("machine.nameplate",ExampleMatcher.GenericPropertyMatchers.startsWith());
        Example<LogMaintain> example=Example.of(logMaintain,exampleMatcher);
        Page pageJPA=logMaintainDAO.findAll(example,pageable);
        return new Page4Navigator<LogMaintain>(pageJPA,page);
    }
    public Page4Navigator<LogMaintain> update(LogMaintain logMaintain){
        logMaintainDAO.save(logMaintain);
        Page4Navigator<LogMaintain> result=new Page4Navigator<LogMaintain>();
        List<LogMaintain> content=new ArrayList<LogMaintain>(1);
        content.add(logMaintain);
        result.setContent(content);
        return result;
    }
}
