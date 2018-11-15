package top.dustone.kaixin.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import top.dustone.kaixin.entity.Driver;
import top.dustone.kaixin.util.Page4Navigator;

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
        driver.setName("陈岩");
        System.out.println("hello");
        Page4Navigator<Driver> result=driverService.listByExapmle(driver,0,5,1);
        System.out.println(result.getContent());
    }
}