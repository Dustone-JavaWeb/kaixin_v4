package top.dustone.kaixin.controller.view;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import top.dustone.kaixin.entity.view.MachineMapView;
import top.dustone.kaixin.service.view.MachineMapViewService;
import top.dustone.kaixin.util.Page4Navigator;
import top.dustone.kaixin.util.RequestModel;

@CrossOrigin
@RestController
public class MachineMapViewController {
    @Autowired
    MachineMapViewService machineMapViewService;
    @PostMapping("/admin_machine_map_view_query")
    public Page4Navigator<MachineMapView> list(@RequestBody RequestModel<MachineMapView> requestModel){
        Page4Navigator<MachineMapView> page=machineMapViewService.listByExample(requestModel.getExample(),requestModel.getStart(),requestModel.getPageSize(),5);
        page.setExample(requestModel);
        return page;
    }
}
