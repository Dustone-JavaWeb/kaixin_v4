package top.dustone.kaixin.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import top.dustone.kaixin.dao.LogErrorDAO;
import top.dustone.kaixin.entity.log.LogError;

import top.dustone.kaixin.util.Page4Navigator;

import java.util.ArrayList;
import java.util.List;

@Service
public class LogErrorService {
    @Autowired
    private LogErrorDAO logErrorDAO;
    public Page4Navigator<LogError> listByExapmle(LogError logError, int start, int size, int page){
        Sort sort=new Sort(Sort.Direction.DESC,"id");
        Pageable pageable= PageRequest.of(start,size,sort);
        ExampleMatcher exampleMatcher=ExampleMatcher.matching()
                .withMatcher("support.name",ExampleMatcher.GenericPropertyMatchers.contains())
                .withMatcher("machine.nameplate",ExampleMatcher.GenericPropertyMatchers.startsWith());
        Example<LogError> example=Example.of(logError,exampleMatcher);
        Page pageJPA=logErrorDAO.findAll(example,pageable);
        return new Page4Navigator<LogError>(pageJPA,page);
    }
    public Page4Navigator<LogError> update(LogError logError){
        logErrorDAO.save(logError);
        Page4Navigator<LogError> result=new Page4Navigator<LogError>();
        List<LogError> content=new ArrayList<LogError>(1);
        content.add(logError);
        result.setContent(content);
        return result;
    }
}
