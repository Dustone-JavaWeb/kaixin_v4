package top.dustone.kaixin.service.log;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import top.dustone.kaixin.dao.LogTransportDAO;
import top.dustone.kaixin.entity.log.LogTransport;
import top.dustone.kaixin.util.Page4Navigator;

import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.List;

@Service
public class LogTransportService {
    @Autowired
    private LogTransportDAO logTransportDAO;
    public Page4Navigator<LogTransport> listByExapmle(LogTransport logTransport, int start, int size, int page){
        Sort sort=new Sort(Sort.Direction.DESC,"id");
        Pageable pageable=PageRequest.of(start,size,sort);
        Specification<LogTransport> specification=new Specification<LogTransport>() {
            @Override
            public Predicate toPredicate(Root<LogTransport> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder cb) {
                List<Predicate> ps = new ArrayList<Predicate>();
                if(logTransport.getSupport()!=null){
                    if(logTransport.getSupport().getName()!=null&&logTransport.getSupport().getName().trim().length()>0){
                        ps.add(cb.like(root.join("support", JoinType.INNER).get("name"),"%"+logTransport.getSupport().getName()+"%"));
                    }
                }
                if(logTransport.getMachine()!=null){
                    if(logTransport.getMachine().getNameplate()!=null&&logTransport.getMachine().getNameplate().trim().length()>0){
                        ps.add(cb.like(root.join("machine",JoinType.INNER).get("nameplate"),"%"+logTransport.getMachine().getNameplate()+"%"));
                    }
                }
                if(logTransport.getFromTime()!=null&&logTransport.getToTime()!=null){
                    ps.add(cb.between(root.get("createTime"),logTransport.getFromTime(),logTransport.getToTime()));
                }
                if(logTransport.getLogMode()!=null&&logTransport.getLogMode().trim().length()>0){
                    ps.add(cb.equal(root.get("logMode"),logTransport.getLogMode()));
                }
                if(logTransport.getType()!=null&&logTransport.getType().trim().length()>0){
                    ps.add(cb.equal(root.get("type"),logTransport.getType()));
                }
                Predicate p[]=new Predicate[ps.size()];
                criteriaQuery.where(cb.and(ps.toArray(p)));
                return criteriaQuery.getRestriction();
            }
        };
        Page pageJPA=logTransportDAO.findAll(specification,pageable);
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
