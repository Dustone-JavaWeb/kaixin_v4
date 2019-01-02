package top.dustone.kaixin.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import top.dustone.kaixin.dao.LogOilDAO;
import top.dustone.kaixin.entity.Machine;
import top.dustone.kaixin.entity.Support;
import top.dustone.kaixin.entity.log.LogOil;
import top.dustone.kaixin.util.Page4Navigator;

import javax.persistence.criteria.*;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Service
public class LogOilService {
    @Autowired
    private LogOilDAO logOilDAO;
    public Page4Navigator<LogOil> listByExapmle(LogOil logOil,int start,int size,int page){
        Sort sort=new Sort(Sort.Direction.DESC,"id");
        Pageable pageable=PageRequest.of(start,size,sort);
        Specification<LogOil> specification=new Specification<LogOil>() {
            @Override
            public Predicate toPredicate(Root<LogOil> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder cb) {
                Join<LogOil,Support> join1=root.join("support",JoinType.INNER);
                Path<String> exp1=join1.get("name");
                Join<LogOil,Machine> join2=root.join("machine",JoinType.INNER);
                Path<String> exp2=join2.get("nameplate");
                Path<Timestamp> exp3=root.get("createTime");
                Predicate predicate=cb.and(
                        cb.like(exp1,"%name%"),
                        cb.like(exp2,"%nameplate%"),
                        cb.lessThanOrEqualTo(exp3,new Timestamp(1546499794000L))
                );
                return predicate;
            }
        };
        Page pageJPA=logOilDAO.findAll(specification,pageable);
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
    private class MySpec implements Specification<LogOil>{
        @Override
        public Predicate toPredicate(Root<LogOil> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder cb) {
            Join<LogOil,Support> join1=root.join("support",JoinType.INNER);
            Path<String> exp1=join1.get("name");
            Join<LogOil,Machine> join2=root.join("machine",JoinType.INNER);
            Path<String> exp2=join2.get("nameplate");
            Path<Timestamp> exp3=root.get("createTime");
            Predicate predicate=cb.and(
                    cb.like(exp1,"%name%"),
                    cb.like(exp2,"%nameplate%"),
                    cb.lessThanOrEqualTo(exp3,new Timestamp(1546499794000L))
                    );
            return predicate;
        }
    }
}
