package top.dustone.kaixin.service.log;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import top.dustone.kaixin.dao.log.LogErrorDAO;
import top.dustone.kaixin.entity.log.LogError;
import top.dustone.kaixin.util.Page4Navigator;

import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.List;

@Service
public class LogErrorService {
    @Autowired
    private LogErrorDAO logErrorDAO;
    public Page4Navigator<LogError> listByExapmle(LogError logError, int start, int size, int page){
        Sort sort=new Sort(Sort.Direction.DESC,"id");
        Pageable pageable=PageRequest.of(start,size,sort);
        Specification<LogError> specification=new Specification<LogError>() {
            @Override
            public Predicate toPredicate(Root<LogError> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder cb) {
                List<Predicate> ps = new ArrayList<Predicate>();
                if(logError.getSupport()!=null){
                    if(logError.getSupport().getName()!=null&&logError.getSupport().getName().trim().length()>0){
                        ps.add(cb.like(root.join("support", JoinType.INNER).get("name"),"%"+logError.getSupport().getName()+"%"));
                    }
                }
                if(logError.getMachine()!=null){
                    if(logError.getMachine().getNameplate()!=null&&logError.getMachine().getNameplate().trim().length()>0){
                        ps.add(cb.like(root.join("machine",JoinType.INNER).get("nameplate"),"%"+logError.getMachine().getNameplate()+"%"));
                    }
                }
                if(logError.getDriver()!=null){
                    if(logError.getDriver().getName()!=null&&logError.getDriver().getName().trim().length()>0){
                        ps.add(cb.like(root.join("driver",JoinType.INNER).get("name"),"%"+logError.getDriver().getName()+"%"));
                    }
                }
                if(logError.getFromTime()!=null&&logError.getToTime()!=null){
                    ps.add(cb.between(root.get("createTime"),logError.getFromTime(),logError.getToTime()));
                }
                if(logError.getLogMode()!=null&&logError.getLogMode().trim().length()>0){
                    ps.add(cb.equal(root.get("logMode"),logError.getLogMode()));
                }
                if(logError.getType()!=null&&logError.getType().trim().length()>0){
                    ps.add(cb.equal(root.get("type"),logError.getType()));
                }
                Predicate p[]=new Predicate[ps.size()];
                criteriaQuery.where(cb.and(ps.toArray(p)));
                return criteriaQuery.getRestriction();
            }
        };
        Page pageJPA=logErrorDAO.findAll(specification,pageable);
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
