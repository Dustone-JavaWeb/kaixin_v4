package top.dustone.kaixin.service.log;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import top.dustone.kaixin.dao.log.LogWorkDAO;
import top.dustone.kaixin.entity.log.LogWork;
import top.dustone.kaixin.service.MachineStatusService;
import top.dustone.kaixin.util.Page4Navigator;

import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class LogWorkService {
    @Autowired
    private LogWorkDAO logWorkDAO;
    @Autowired
    private MachineStatusService machineStatusService;
    public Page4Navigator<LogWork> listByExapmle(LogWork logWork, int start, int size, int page){
        Sort sort=new Sort(Sort.Direction.DESC,"id");
        Pageable pageable=PageRequest.of(start,size,sort);
        Specification<LogWork> specification=new Specification<LogWork>() {
            @Override
            public Predicate toPredicate(Root<LogWork> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder cb) {
                List<Predicate> ps = new ArrayList<Predicate>();
                if(logWork.getCompact()!=null){
                    if(logWork.getCompact().getNumber()!=null&&logWork.getCompact().getNumber().trim().length()>0){
                        ps.add(cb.like(root.join("compact",JoinType.INNER).get("number"),logWork.getCompact().getNumber()+"%"));
                    }
                }
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
                if(logWork.getType()!=null&&logWork.getType().trim().length()>0){
                    ps.add(cb.equal(root.get("type"),logWork.getType()));
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
        Page4Navigator<LogWork> result=new Page4Navigator<LogWork>();
        List<LogWork> content=new ArrayList<LogWork>(1);

        if(logWork.getId()==null){
            if(machineStatusService.inWork(logWork.getMachine().getId())){
                result.setResponseMessage("保存失败！ 当前挖机还有其他工单未结束！");
            }else{
                logWork.setLogMode("未审核");
                logWork.setWorking("进行中");
                logWorkDAO.save(logWork);
                machineStatusService.startWork(logWork.getMachine().getId(),logWork.getId());
                result.setResponseMessage("保存成功！ 挖机#"+logWork.getMachine().getCode()+"状态已修改");
            }
        }else{
            Optional<LogWork> optional=logWorkDAO.findById(logWork.getId());
            LogWork old=optional.get();
            if(old!=null){
                if(old.getLogMode().equals("未审核")){
                    if(logWork.getLogMode().equals("已作废")){
                        logWork.setWorking(null);
                        logWorkDAO.save(logWork);
                        machineStatusService.endWork(logWork.getMachine().getId());
                        result.setResponseMessage("已作废！ 挖机#"+logWork.getMachine().getCode()+"状态已修改");
                    }else{
                        logWorkDAO.save(logWork);
                        result.setResponseMessage("保存成功！ 挖机#"+logWork.getMachine().getCode()+"状态已修改");
                    }
                }else if(old.getLogMode().equals("已审核")){
                    if(logWork.getLogMode().equals("已作废")){
                        old.setLogMode("已作废");
                        old.setWorking(null);
                        logWork.setWorking(null);
                        logWorkDAO.save(old);
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
        content.add(logWork);
        result.setContent(content);
        return result;
    }
}
