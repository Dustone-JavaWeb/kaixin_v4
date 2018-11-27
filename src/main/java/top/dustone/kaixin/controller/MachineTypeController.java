package top.dustone.kaixin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import top.dustone.kaixin.entity.MachineBrand;
import top.dustone.kaixin.entity.MachineType;
import top.dustone.kaixin.service.MachineBrandService;
import top.dustone.kaixin.service.MachineTypeService;
import top.dustone.kaixin.util.Page4Navigator;
import top.dustone.kaixin.util.RequestModel;

@CrossOrigin
@RestController
public class MachineTypeController {
    @Autowired
    MachineTypeService machineTypeService;
    @Autowired
    MachineBrandService machineBrandService;
    @PostMapping("/machineType_query")
    public Page4Navigator<MachineType> list(@RequestBody RequestModel<MachineType> requestModel){
        Page4Navigator<MachineType> page=machineTypeService.listByExample(requestModel.getExample());
        return page;
    }
    @PostMapping("/machineBrand_query")
    public Page4Navigator<MachineBrand> listBrand(@RequestBody RequestModel<MachineBrand> requestModel){
        Page4Navigator<MachineBrand> page=machineBrandService.list();
        return page;
    }
}
