package top.dustone.kaixin.controller.view;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import top.dustone.kaixin.entity.view.MachineStatusView;
import top.dustone.kaixin.service.view.MachineStatusViewService;
import top.dustone.kaixin.util.Page4Navigator;
import top.dustone.kaixin.util.RequestModel;

@CrossOrigin
@RestController
public class MachineStatusViewController {
    @Autowired
    MachineStatusViewService machineStatusViewService;
    @PostMapping("/machine_status_view_query")
    public Page4Navigator<MachineStatusView> list(@RequestBody RequestModel<MachineStatusView> requestModel){
        Page4Navigator<MachineStatusView> page=machineStatusViewService.listByExample(requestModel.getExample(),requestModel.getStart(),requestModel.getPageSize(),5);
        page.setExample(requestModel);
        return page;
    }
}
