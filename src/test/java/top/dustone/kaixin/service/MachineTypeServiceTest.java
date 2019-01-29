package top.dustone.kaixin.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import top.dustone.kaixin.entity.MachineType;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MachineTypeServiceTest {
    @Autowired
    MachineTypeService machineTypeService;
    @Test
    public void listByExample() {
        MachineType machineType=new MachineType();
        machineType.setModel("AAC");
//        System.out.println(machineTypeService.listByExample(machineType));;

    }
}