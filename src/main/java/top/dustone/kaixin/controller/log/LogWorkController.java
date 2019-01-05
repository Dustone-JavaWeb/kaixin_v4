package top.dustone.kaixin.controller.log;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import top.dustone.kaixin.entity.log.LogWork;
import top.dustone.kaixin.service.log.LogWorkService;
import top.dustone.kaixin.util.Page4Navigator;
import top.dustone.kaixin.util.RequestModel;

@CrossOrigin
@RestController
public class LogWorkController {
    @Autowired
    private LogWorkService logWorkService;
    @PostMapping("/logWork_query")
    public Page4Navigator<LogWork> list(@RequestBody RequestModel<LogWork> requestModel){
        Page4Navigator<LogWork> page=logWorkService.listByExapmle(requestModel.getExample(),requestModel.getStart(),10,5);
        page.setExample(requestModel);
        //System.out.println(page);
        return page;
    }
    @PostMapping("/logWork_update")
    public Page4Navigator<LogWork> update(@RequestBody RequestModel<LogWork> requestModel){
        Page4Navigator<LogWork> page=logWorkService.update(requestModel.getExample());
        page.setResponseMessage("保存成功！");
        return page;
    }
}
