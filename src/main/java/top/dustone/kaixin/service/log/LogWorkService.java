package top.dustone.kaixin.service.log;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import top.dustone.kaixin.dao.LogWorkDAO;
import top.dustone.kaixin.entity.log.LogWork;
import top.dustone.kaixin.util.Page4Navigator;

import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.List;

@Service
public class LogWorkService {
    @Autowired
    private LogWorkDAO logWorkDAO;
    public Page4Navigator<LogWork> listByExapmle(LogWork logWork, int start, int size, int page){
        Sort sort=new Sort(Sort.Direction.DESC,"id");
        Pageable pageable=PageRequest.of(start,size,sort);
        Specification<LogWork> specification=new Specification<LogWork>() {
            @Override
            public Predicate toPredicate(Root<LogWork> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder cb) {
                List<Predicate> ps = new ArrayList<Predicate>();
                if(logWork.getMachine()!=null){
                    if(logWork.getMachine().getNameplate()!=null&&logWork.getMachine().getNameplate().trim().length()>0){
                        ps.add(cb.like(root.join("machine",JoinType.INNER).get("nameplate"),"%"+logWork.getMachine().getNameplate()+"%"));
                    }
                }
                if(logWork.getDriver()!=null){
                    if(logWork.getDriver().getName()!=null&&logWork.getDriver().getName().trim().length()>0){
                        ps.add(cb.like(root.join("driver",JoinType.INNER).get("name"),"%"+logWork.getDriver().getName()+"%"));
                    }
                }
                if(logWork.getFromTime()!=null&&logWork.getToTime()!=null){
                    ps.add(cb.between(root.get("createTime"),logWork.getFromTime(),logWork.getToTime()));
                }
                if(logWork.getLogMode()!=null&&logWork.getLogMode().trim().length()>0){
                    ps.add(cb.equal(root.get("logMode"),logWork.getLogMode()));
                }
                Predicate p[]=new Predicate[ps.size()];
                criteriaQuery.where(cb.and(ps.toArray(p)));
                return criteriaQuery.getRestriction();
            }
        };
        Page pageJPA=logWorkDAO.findAll(specification,pageable);
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
