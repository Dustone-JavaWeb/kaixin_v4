package top.dustone.kaixin.controller.log;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import top.dustone.kaixin.entity.log.LogOil;
import top.dustone.kaixin.service.log.LogOilService;
import top.dustone.kaixin.util.Page4Navigator;
import top.dustone.kaixin.util.RequestModel;

@CrossOrigin
@RestController
public class LogOilController {
    @Autowired
    private LogOilService logOilService;
    @PostMapping("/logOil_query")
    public Page4Navigator<LogOil> list(@RequestBody RequestModel<LogOil> requestModel){
        Page4Navigator<LogOil> page=logOilService.listByExapmle(requestModel.getExample(),requestModel.getStart(),10,5);
        page.setExample(requestModel);
        //System.out.println(page);
        return page;
    }
    @PostMapping("/logOil_update")
    public Page4Navigator<LogOil> update(@RequestBody RequestModel<LogOil> requestModel){
        Page4Navigator<LogOil> page=logOilService.update(requestModel.getExample());
        page.setResponseMessage("保存成功！");
        return page;
    }
}
