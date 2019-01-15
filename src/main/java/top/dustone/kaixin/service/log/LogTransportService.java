package top.dustone.kaixin.service.log;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import top.dustone.kaixin.dao.log.LogTransportDAO;
import top.dustone.kaixin.entity.log.LogTransport;
import top.dustone.kaixin.service.MachineStatusService;
import top.dustone.kaixin.util.Page4Navigator;

import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class LogTransportService {
    @Autowired
    private LogTransportDAO logTransportDAO;
    @Autowired
    private MachineStatusService machineStatusService;
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
        Page4Navigator<LogTransport> result=new Page4Navigator<LogTransport>();
        List<LogTransport> content=new ArrayList<LogTransport>(1);

        if(logTransport.getId()==null){
            if(machineStatusService.inTransport(logTransport.getMachine().getId())){
                result.setResponseMessage("保存失败！ 当前挖机还有其他转场单未结束！");
            }else{
                logTransport.setLogMode("未审核");
                logTransport.setWorking("进行中");
                logTransportDAO.save(logTransport);
                machineStatusService.startTransport(logTransport.getMachine().getId(),logTransport.getId());
                result.setResponseMessage("保存成功！ 挖机#"+logTransport.getMachine().getCode()+"状态已修改");
            }
        }else{
            Optional<LogTransport> optional=logTransportDAO.findById(logTransport.getId());
            LogTransport old=optional.get();
            if(old!=null){
                if(old.getLogMode().equals("未审核")){
                    if(logTransport.getLogMode().equals("已作废")){
                        logTransport.setWorking(null);
                        logTransportDAO.save(logTransport);
                        machineStatusService.endTransport(logTransport.getMachine().getId());
                        result.setResponseMessage("已作废！ 挖机#"+logTransport.getMachine().getCode()+"状态已修改");
                    }else{
                        logTransportDAO.save(logTransport);
                        result.setResponseMessage("保存成功！ 挖机#"+logTransport.getMachine().getCode()+"状态已修改");
                    }
                }else if(old.getLogMode().equals("已审核")){
                    if(logTransport.getLogMode().equals("已作废")){
                        old.setLogMode("已作废");
                        old.setWorking(null);
                        logTransport.setWorking(null);
                        logTransportDAO.save(old);
                        result.setResponseMessage("作废成功！");
                    }else{
                        result.setResponseMessage("已审核的单据无法修改，只能作废");
                    }
                }else{
                    result.setResponseMessage("已作废的单据无法修改。");
                }
            }else{
                result.setResponseMessage("非法数据！ 保存失败");
            }
        }
        content.add(logTransport);
        result.setContent(content);
        return result;
    }
}
