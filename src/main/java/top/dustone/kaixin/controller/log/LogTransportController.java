package top.dustone.kaixin.controller.log;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import top.dustone.kaixin.entity.log.LogTransport;
import top.dustone.kaixin.service.log.LogTransportService;
import top.dustone.kaixin.util.Page4Navigator;
import top.dustone.kaixin.util.RequestModel;

@CrossOrigin
@RestController
public class LogTransportController {
    @Autowired
    private LogTransportService logTransportService;
    @PostMapping("/admin_logTransport_query")
    public Page4Navigator<LogTransport> list(@RequestBody RequestModel<LogTransport> requestModel){
        Page4Navigator<LogTransport> page=logTransportService.listByExapmle(requestModel.getExample(),requestModel.getStart(),requestModel.getPageSize(),5);
        page.setExample(requestModel);
        //System.out.println(page);
        return page;
    }
    @PostMapping("/admin_logTransport_update")
    public Page4Navigator<LogTransport> update(@RequestBody RequestModel<LogTransport> requestModel){
        Page4Navigator<LogTransport> page=logTransportService.update(requestModel.getExample());
        return page;
    }
}
