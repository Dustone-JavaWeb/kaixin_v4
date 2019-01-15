package top.dustone.kaixin.service.view;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import top.dustone.kaixin.entity.view.MachineStatusView;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MachineStatusViewServiceTest {
    @Autowired
    MachineStatusViewService machineStatusViewService;
    @Test
    public void listByExample() {
        MachineStatusView machineStatusView=new MachineStatusView();
        System.out.println(machineStatusViewService.listByExample(machineStatusView,0,100,1));
    }
}