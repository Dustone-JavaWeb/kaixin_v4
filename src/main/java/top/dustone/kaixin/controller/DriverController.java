package top.dustone.kaixin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import top.dustone.kaixin.entity.Driver;
import top.dustone.kaixin.service.DriverService;
import top.dustone.kaixin.util.CommonResponseModel;
import top.dustone.kaixin.util.Page4Navigator;
import top.dustone.kaixin.util.RequestModel;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

@CrossOrigin
@RestController
public class DriverController {
    @Autowired
    DriverService driverService;
    @GetMapping("/admin_drivers")
    public Page4Navigator<Driver> list(
            @RequestParam(value = "start", defaultValue = "0") int start,
            @RequestParam(value = "size", defaultValue = "9") int size){
        start = start<0?0:start;
        Page4Navigator<Driver> page =driverService.list(start, size, 5);
        return page;
    }
    @PostMapping("/admin_drivers_query")
    public Page4Navigator<Driver> list(@RequestBody RequestModel<Driver> requestModel){
        Page4Navigator<Driver> page=driverService.listByExapmle(requestModel.getExample(),requestModel.getStart(),requestModel.getPageSize(),5);
        page.setExample(requestModel);
        //System.out.println(page);
        return page;
    }
    @PostMapping("/admin_drivers_update")
    public Page4Navigator<Driver> update(@RequestBody RequestModel<Driver> requestModel){
        Page4Navigator<Driver> page=driverService.update(requestModel.getExample());
        page.setResponseMessage("保存成功！");
        return page;
    }
    @GetMapping("/admin_driver_info")
    public Driver findById(@RequestParam(value = "id") int id){
        return driverService.findById(id);
    }
    @PostMapping("/admin_driver_export")
    public CommonResponseModel<Driver> export(@RequestBody RequestModel<Driver> requestModel, HttpServletRequest request){
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String fileName="机手信息导出_"+df.format(new Date())+".xls";
        String targetURL="resource/cacheFiles";
        String targetPath=request.getServletContext().getRealPath(targetURL);
        File targetFolder=new File(targetPath);
        File targetFile=new File(targetFolder,fileName);
        if(!targetFile.getParentFile().exists()){
            targetFile.getParentFile().mkdirs();
        }
        targetURL=targetURL+"/"+fileName;
        driverService.exportByExample(requestModel.getExample(),targetFile.getPath());
        CommonResponseModel<Driver> responseModel=new CommonResponseModel<Driver>();
        responseModel.setCode("200");
        responseModel.setMsg(targetURL);
        return responseModel;
    }
}
