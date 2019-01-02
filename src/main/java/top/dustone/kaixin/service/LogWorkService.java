package top.dustone.kaixin.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;
import top.dustone.kaixin.dao.LogWorkDAO;
import top.dustone.kaixin.entity.log.LogWork;
import top.dustone.kaixin.util.Page4Navigator;

import java.util.ArrayList;
import java.util.List;

@Service
public class LogWorkService {
    @Autowired
    private LogWorkDAO logWorkDAO;
    public Page4Navigator<LogWork> listByExapmle(LogWork logWork, int start, int size, int page){
        Sort sort=new Sort(Sort.Direction.DESC,"id");
        Pageable pageable= PageRequest.of(start,size,sort);
        ExampleMatcher exampleMatcher=ExampleMatcher.matching()
                .withMatcher("support.name",ExampleMatcher.GenericPropertyMatchers.contains())
                .withMatcher("machine.nameplate",ExampleMatcher.GenericPropertyMatchers.startsWith());
        Example<LogWork> example=Example.of(logWork,exampleMatcher);
        Page pageJPA=logWorkDAO.findAll(example,pageable);
        return new Page4Navigator<LogWork>(pageJPA,page);
    }
    public Page4Navigator<LogWork> update(LogWork logWork){
        logWorkDAO.save(logWork);
        Page4Navigator<LogWork> result=new Page4Navigator<LogWork>();
        List<LogWork> content=new ArrayList<LogWork>(1);
        content.add(logWork);
        result.setContent(content);
        return result;
    }
}
