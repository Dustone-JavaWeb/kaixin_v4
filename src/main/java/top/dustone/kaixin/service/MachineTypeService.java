package top.dustone.kaixin.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;
import top.dustone.kaixin.dao.MachineTypeDAO;
import top.dustone.kaixin.entity.MachineType;
import top.dustone.kaixin.util.CommonResponseModel;
import top.dustone.kaixin.util.Page4Navigator;

import java.util.List;

@Service
public class MachineTypeService {
    @Autowired
    MachineTypeDAO machineTypeDAO;
    public Page4Navigator<MachineType> listByExample(MachineType machineType,int start,int size,int page){
        Sort sort=new Sort(Sort.Direction.DESC,"id");
        Pageable pageable=PageRequest.of(start,size,sort);
        Page4Navigator<MachineType> page4Navigator=new Page4Navigator<MachineType>();
        ExampleMatcher exampleMatcher=ExampleMatcher.matching()
                .withMatcher("model",ExampleMatcher.GenericPropertyMatchers.contains())
                .withMatcher("name",ExampleMatcher.GenericPropertyMatchers.contains())
                .withMatcher("brandName",ExampleMatcher.GenericPropertyMatchers.contains());
        Example<MachineType> example=Example.of(machineType,exampleMatcher);
        Page pageJPA=machineTypeDAO.findAll(example,pageable);
        return new Page4Navigator<MachineType>(pageJPA,page);
    }
    public List<MachineType> listAll(){
        Sort sort=new Sort(Sort.Direction.ASC,"model");
        return machineTypeDAO.findAll(sort);
    }
    public CommonResponseModel<MachineType> update(MachineType machineType){
        CommonResponseModel<MachineType> result=new CommonResponseModel<MachineType>();
        machineTypeDAO.save(machineType);
        result.setT(machineType);
        result.setMsg("保存成功!");
        result.setCode("200");
        return result;
    }
}
