package top.dustone.kaixin.service.view;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;
import top.dustone.kaixin.dao.view.MachineMapViewDAO;
import top.dustone.kaixin.entity.view.MachineMapView;
import top.dustone.kaixin.util.Page4Navigator;

import java.util.ArrayList;
import java.util.List;

@Service
public class MachineMapViewService {
    @Autowired
    MachineMapViewDAO machineMapViewDAO;
    public List<MachineMapView> listAll(){
        Sort sort=new Sort(Sort.Direction.DESC,"id");
        return machineMapViewDAO.findAll(sort);
    }
    public Page4Navigator<MachineMapView> listByExample(MachineMapView machineMapView, int start, int size, int page){
        Sort sort=new Sort(Sort.Direction.DESC,"id");
        Pageable pageable= PageRequest.of(start,size,sort);
        ExampleMatcher exampleMatcher=ExampleMatcher.matching()
                .withMatcher("driverName",ExampleMatcher.GenericPropertyMatchers.contains());
        Example<MachineMapView> example=Example.of(machineMapView,exampleMatcher);
        Page pageJPA=machineMapViewDAO.findAll(example,pageable);
        return new Page4Navigator<MachineMapView>(pageJPA,page);
    }
    public Page4Navigator<MachineMapView> update(MachineMapView machineMapView){
        machineMapViewDAO.save(machineMapView);
        Page4Navigator<MachineMapView> result=new Page4Navigator<MachineMapView>();
        List<MachineMapView> content=new ArrayList<MachineMapView>(1);
        content.add(machineMapView);
        result.setContent(content);
        return result;
    }
}
