package top.dustone.kaixin.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import top.dustone.kaixin.dao.CompactDAO;
import top.dustone.kaixin.entity.Compact;
import top.dustone.kaixin.util.Page4Navigator;

import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.List;

@Service
public class CompactService {
    @Autowired
    CompactDAO compactDAO;
    public Page4Navigator<Compact> listByExample(Compact compact, int start, int size, int page){
        Sort sort=new Sort(Sort.Direction.DESC,"id");
        Pageable pageable= PageRequest.of(start,size,sort);
        Specification<Compact> specification=new Specification<Compact>() {
            @Override
            public Predicate toPredicate(Root<Compact> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder cb) {
                List<Predicate> ps = new ArrayList<Predicate>();
                if(compact.getCustomer()!=null){
                    if(compact.getCustomer().getName()!=null&&compact.getCustomer().getName().trim().length()>0){
                        ps.add(cb.like(root.join("customer", JoinType.INNER).get("name"),"%"+compact.getCustomer().getName()+"%"));
                    }
                }
                if(compact.getContact()!=null){
                    if(compact.getContact().getName()!=null&&compact.getContact().getName().trim().length()>0){
                        ps.add(cb.like(root.join("contact",JoinType.INNER).get("nameplate"),"%"+compact.getContact().getName()+"%"));
                    }
                }
                if(compact.getFromTime()!=null&&compact.getToTime()!=null){
                    ps.add(cb.between(root.get("createTime"),compact.getFromTime(),compact.getToTime()));
                }
                if(compact.getStatus()!=null&&compact.getStatus().trim().length()>0){
                    ps.add(cb.equal(root.get("status"),compact.getStatus()));
                }
                if(compact.getType()!=null&&compact.getType().trim().length()>0){
                    ps.add(cb.equal(root.get("type"),compact.getType()));
                }
                Predicate p[]=new Predicate[ps.size()];
                criteriaQuery.where(cb.and(ps.toArray(p)));
                return criteriaQuery.getRestriction();
            }
        };
        Page pageJPA=compactDAO.findAll(specification,pageable);
        return new Page4Navigator<Compact>(pageJPA,page);
    }
    public Page4Navigator<Compact> update(Compact compact){
        compactDAO.save(compact);
        Page4Navigator<Compact> result=new Page4Navigator<Compact>();
        List<Compact> content=new ArrayList<Compact>(1);
        content.add(compact);
        result.setContent(content);
        return result;
    }
    public Compact findById(Integer id){
        return compactDAO.findFirstByIdEquals(id);
    }
}
