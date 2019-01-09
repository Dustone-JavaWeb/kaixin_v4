package top.dustone.kaixin.service.view;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import top.dustone.kaixin.entity.view.MachineMapView;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MachineMapViewServiceTest {
    @Autowired
    MachineMapViewService machineMapViewService;
    @Test
    public void listByExapmle() {
        MachineMapView machineMapView=new MachineMapView();
        //System.out.println(machineMapViewService.listAll());
        System.out.println(machineMapViewService.listByExample(machineMapView,0,5,1));
    }

    @Test
    public void update() {
    }
}