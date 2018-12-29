package top.dustone.kaixin.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import top.dustone.kaixin.dao.MachineTypeDAO;
import top.dustone.kaixin.entity.MachineType;
import top.dustone.kaixin.util.Page4Navigator;

import java.util.List;

@Service
public class MachineTypeService {
    @Autowired
    MachineTypeDAO machineTypeDAO;
    public Page4Navigator<MachineType> listByExample(MachineType machineType){
        Page4Navigator<MachineType> page4Navigator=new Page4Navigator<MachineType>();
        ExampleMatcher exampleMatcher=ExampleMatcher.matching()
                .withMatcher("model",ExampleMatcher.GenericPropertyMatchers.contains());
        Example<MachineType> example=Example.of(machineType,exampleMatcher);
        page4Navigator.setContent(machineTypeDAO.findAll(example));
        return page4Navigator;
    }
    public List<MachineType> listAll(){
        Sort sort=new Sort(Sort.Direction.ASC,"model");
        return machineTypeDAO.findAll(sort);
    }
}
