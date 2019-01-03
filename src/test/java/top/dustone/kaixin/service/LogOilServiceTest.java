package top.dustone.kaixin.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import top.dustone.kaixin.entity.Support;
import top.dustone.kaixin.entity.log.LogOil;

import java.sql.Timestamp;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LogOilServiceTest {
    @Autowired
    LogOilService logOilService;
    @Test
    public void listByExapmle() {
        LogOil logOil=new LogOil();
        Support support=new Support();
        support.setName("黄");
        logOil.setSupport(support);
        Timestamp toTimestamp=new Timestamp(1546494461000L);
        Timestamp fromTimestamp=new Timestamp(1545790560000L);

//        logOil.setFromTime(fromTimestamp);
//        logOil.setToTime(toTimestamp);
        System.out.println(logOilService.listByExapmle(logOil,0,5,1));
    }

    @Test
    public void update() {
    }
}