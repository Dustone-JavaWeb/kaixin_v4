package top.dustone.kaixin.service.view;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;
import top.dustone.kaixin.dao.view.MachineStatusViewDAO;
import top.dustone.kaixin.entity.view.MachineStatusView;
import top.dustone.kaixin.util.Page4Navigator;

import java.util.List;

@Service
public class MachineStatusViewService {
    @Autowired
    MachineStatusViewDAO machineStatusViewDAO;

    public List<MachineStatusView> listAll(){
        Sort sort=new Sort(Sort.Direction.DESC,"id");
        return machineStatusViewDAO.findAll(sort);
    }
    public Page4Navigator<MachineStatusView> listByExample(MachineStatusView machineStatusView, int start, int size, int page){
        Sort sort=new Sort(Sort.Direction.DESC,"id");
        Pageable pageable= PageRequest.of(start,size,sort);
        ExampleMatcher exampleMatcher=ExampleMatcher.matching()
                .withMatcher("driverName",ExampleMatcher.GenericPropertyMatchers.contains());
        Example<MachineStatusView> example=Example.of(machineStatusView,exampleMatcher);
        Page pageJPA=machineStatusViewDAO.findAll(example,pageable);
        return new Page4Navigator<MachineStatusView>(pageJPA,page);
    }
}
