package top.dustone.kaixin.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DriverServiceTest {
    @Autowired
    private DriverService driverService;
    @Test
    public void list() {
        System.out.println(driverService.list());
    }

    @Test
    public void list1() {
    }
    @Test
    public void listByExapmle(){

    }
}