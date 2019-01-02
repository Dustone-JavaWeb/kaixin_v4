package top.dustone.kaixin.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;
import top.dustone.kaixin.dao.LogTransportDAO;
import top.dustone.kaixin.entity.log.LogTransport;
import top.dustone.kaixin.util.Page4Navigator;

import java.util.ArrayList;
import java.util.List;

@Service
public class LogTransportService {
    @Autowired
    private LogTransportDAO logTransportDAO;
    public Page4Navigator<LogTransport> listByExapmle(LogTransport logTransport, int start, int size, int page){
        Sort sort=new Sort(Sort.Direction.DESC,"id");
        Pageable pageable= PageRequest.of(start,size,sort);
        ExampleMatcher exampleMatcher=ExampleMatcher.matching()
                .withMatcher("support.name",ExampleMatcher.GenericPropertyMatchers.contains())
                .withMatcher("machine.nameplate",ExampleMatcher.GenericPropertyMatchers.startsWith());
        Example<LogTransport> example=Example.of(logTransport,exampleMatcher);
        Page pageJPA=logTransportDAO.findAll(example,pageable);
        return new Page4Navigator<LogTransport>(pageJPA,page);
    }
    public Page4Navigator<LogTransport> update(LogTransport logTransport){
        logTransportDAO.save(logTransport);
        Page4Navigator<LogTransport> result=new Page4Navigator<LogTransport>();
        List<LogTransport> content=new ArrayList<LogTransport>(1);
        content.add(logTransport);
        result.setContent(content);
        return result;
    }
}
