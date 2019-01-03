package top.dustone.kaixin.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import top.dustone.kaixin.dao.LogOilDAO;
import top.dustone.kaixin.entity.log.LogOil;
import top.dustone.kaixin.util.Page4Navigator;

import javax.persistence.criteria.*;
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
                List<Predicate> ps = new ArrayList<Predicate>();
                if(logOil.getSupport()!=null){
                    if(logOil.getSupport().getName()!=null&&logOil.getSupport().getName().trim().length()>0){
                        ps.add(cb.like(root.join("support",JoinType.INNER).get("name"),"%"+logOil.getSupport().getName()+"%"));
                    }
                }
                if(logOil.getMachine()!=null){
                    if(logOil.getMachine().getNameplate()!=null&&logOil.getMachine().getNameplate().trim().length()>0){
                        ps.add(cb.like(root.join("support",JoinType.INNER).get("name"),"%"+logOil.getMachine().getNameplate()+"%"));
                    }
                }
                if(logOil.getFromTime()!=null&&logOil.getToTime()!=null){
                    ps.add(cb.between(root.get("createTime"),logOil.getFromTime(),logOil.getToTime()));
                }
                if(logOil.getLogMode()!=null&&logOil.getLogMode().trim().length()>0){
                    ps.add(cb.equal(root.get("logMode"),logOil.getLogMode()));
                }
                Predicate p[]=new Predicate[ps.size()];
                criteriaQuery.where(cb.and(ps.toArray(p)));
                return criteriaQuery.getRestriction();
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
}
