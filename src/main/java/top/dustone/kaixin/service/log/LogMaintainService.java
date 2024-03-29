package top.dustone.kaixin.service.log;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import top.dustone.kaixin.dao.log.LogMaintainDAO;
import top.dustone.kaixin.entity.log.LogMaintain;
import top.dustone.kaixin.service.MachineStatusService;
import top.dustone.kaixin.util.Page4Navigator;

import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class LogMaintainService {
    @Autowired
    private LogMaintainDAO logMaintainDAO;
    @Autowired
    private MachineStatusService machineStatusService;

    public Page4Navigator<LogMaintain> listByExapmle(LogMaintain logMaintain, int start, int size, int page){
        Sort sort=new Sort(Sort.Direction.DESC,"id");
        Pageable pageable=PageRequest.of(start,size,sort);
        Specification<LogMaintain> specification=new Specification<LogMaintain>() {
            @Override
            public Predicate toPredicate(Root<LogMaintain> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder cb) {
                List<Predicate> ps = new ArrayList<Predicate>();
                if(logMaintain.getSupport()!=null){
                    if(logMaintain.getSupport().getName()!=null&&logMaintain.getSupport().getName().trim().length()>0){
                        ps.add(cb.like(root.join("support", JoinType.INNER).get("name"),"%"+logMaintain.getSupport().getName()+"%"));
                    }
                }
                if(logMaintain.getMachine()!=null){
                    if(logMaintain.getMachine().getNameplate()!=null&&logMaintain.getMachine().getNameplate().trim().length()>0){
                        ps.add(cb.like(root.join("machine",JoinType.INNER).get("nameplate"),"%"+logMaintain.getMachine().getNameplate()+"%"));
                    }
                }
                if(logMaintain.getFromTime()!=null&&logMaintain.getToTime()!=null){
                    ps.add(cb.between(root.get("createTime"),logMaintain.getFromTime(),logMaintain.getToTime()));
                }
                if(logMaintain.getLogMode()!=null&&logMaintain.getLogMode().trim().length()>0){
                    ps.add(cb.equal(root.get("logMode"),logMaintain.getLogMode()));
                }
                if(logMaintain.getType()!=null&&logMaintain.getType().trim().length()>0){
                    ps.add(cb.equal(root.get("type"),logMaintain.getType()));
                }
                Predicate p[]=new Predicate[ps.size()];
                criteriaQuery.where(cb.and(ps.toArray(p)));
                return criteriaQuery.getRestriction();
            }
        };
        Page pageJPA=logMaintainDAO.findAll(specification,pageable);
        return new Page4Navigator<LogMaintain>(pageJPA,page);
    }
    public Page4Navigator<LogMaintain> update(LogMaintain logMaintain){
        Page4Navigator<LogMaintain> result=new Page4Navigator<LogMaintain>();
        List<LogMaintain> content=new ArrayList<LogMaintain>(1);

        if(logMaintain.getId()==null){
            if(machineStatusService.inMaintain(logMaintain.getMachine().getId())){
                result.setResponseMessage("保存失败！ 当前挖机还有其他维修单未结束！");
            }else{
                logMaintain.setLogMode("未审核");
                logMaintain.setWorking("进行中");
                logMaintainDAO.save(logMaintain);
                machineStatusService.startMaintain(logMaintain.getMachine().getId(),logMaintain.getId());
                result.setResponseMessage("保存成功！ 挖机#"+logMaintain.getMachine().getCode()+"状态已修改");
            }
        }else{
            Optional<LogMaintain> optional=logMaintainDAO.findById(logMaintain.getId());
            LogMaintain old=optional.get();
            if(old!=null){
                if(old.getLogMode().equals("未审核")){
                    if(logMaintain.getLogMode().equals("已作废")){
                        logMaintain.setWorking(null);
                        logMaintainDAO.save(logMaintain);
                        machineStatusService.endMaintain(logMaintain.getMachine().getId());
                        result.setResponseMessage("已作废！ 挖机#"+logMaintain.getMachine().getCode()+"状态已修改");
                    }else{
                        logMaintainDAO.save(logMaintain);
                        result.setResponseMessage("保存成功！ 挖机#"+logMaintain.getMachine().getCode()+"状态已修改");
                    }
                }else if(old.getLogMode().equals("已审核")){
                    if(logMaintain.getLogMode().equals("已作废")){
                        old.setLogMode("已作废");
                        old.setWorking(null);
                        logMaintain.setWorking(null);
                        logMaintainDAO.save(old);
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
        content.add(logMaintain);
        result.setContent(content);
        return result;
    }
}
