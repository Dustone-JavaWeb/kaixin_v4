package top.dustone.kaixin.service;

import com.xuxueli.poi.excel.ExcelExportUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import top.dustone.kaixin.entity.Driver;
import top.dustone.kaixin.util.Page4Navigator;
import top.dustone.kaixin.util.export.DrvierExcel;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DriverServiceTest {
    @Autowired
    private DriverService driverService;
    @Test
    public void list() {
        //System.out.println(driverService.list());
    }

    @Test
    public void list1() {
    }
    @Test
    public void listByExapmle(){
        Driver driver=new Driver();
        Page4Navigator<Driver> result=driverService.listByExapmle(driver,0,100,1);
        List<DrvierExcel> list=new ArrayList<DrvierExcel>(5);
        for(Driver driver1:result.getContent()){
            DrvierExcel drvierExcel=new DrvierExcel(driver1);
            list.add(drvierExcel);
        }
        ExcelExportUtil.exportToFile("D:\\\\Project\\IDEA Project\\kaixin_v4\\src\\main\\webapp\\resource\\cacheFiles\\driver_2019-01-21-19:02:37.xlsx",list);
    }
}