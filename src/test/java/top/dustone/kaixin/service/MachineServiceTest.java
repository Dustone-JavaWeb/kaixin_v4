package top.dustone.kaixin.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import top.dustone.kaixin.entity.MachineBrand;
import top.dustone.kaixin.entity.MachineType;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MachineServiceTest {
    @Autowired
    MachineTypeService machineTypeService;
    @Test
    public void listByExample() {
        MachineBrand machineBrand=new MachineBrand();
        machineBrand.setId(2);
        MachineType machineType=new MachineType();
        System.out.println(machineTypeService.listByExample(machineType));
    }
}