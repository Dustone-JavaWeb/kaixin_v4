package top.dustone.kaixin.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;
import top.dustone.kaixin.dao.SupportDAO;
import top.dustone.kaixin.entity.Support;
import top.dustone.kaixin.util.Page4Navigator;

import java.util.ArrayList;
import java.util.List;

@Service
public class SupportService {
    @Autowired
    private SupportDAO supportDAO;
    public Page4Navigator<Support> listByExapmle(Support support, int start, int size, int page){
        Sort sort=new Sort(Sort.Direction.DESC,"id");
        Pageable pageable= PageRequest.of(start,size,sort);
        ExampleMatcher exampleMatcher=ExampleMatcher.matching()
                .withMatcher("name",ExampleMatcher.GenericPropertyMatchers.contains())
                .withMatcher("tel",ExampleMatcher.GenericPropertyMatchers.startsWith());
        Example<Support> example=Example.of(support,exampleMatcher);
        Page pageJPA=supportDAO.findAll(example,pageable);
        return new Page4Navigator<Support>(pageJPA,page);
    }
    public Page4Navigator<Support> update(Support support){
        System.out.println(support);
        supportDAO.save(support);
        Page4Navigator<Support> result=new Page4Navigator<Support>();
        List<Support> content=new ArrayList<Support>(1);
        content.add(support);
        result.setContent(content);
        return result;
    }
}
