package top.dustone.kaixin.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MachineStatusServiceTest {
    @Autowired
    MachineStatusService machineStatusService;
    @Test
    public void startMaintain() {
        Boolean result=machineStatusService.startMaintain(1,1);
        System.out.println(result);
    }

    @Test
    public void endMaintain() {
    }

    @Test
    public void startWork() {
    }

    @Test
    public void endWork() {
    }

    @Test
    public void startTransport() {
        Boolean result=machineStatusService.startTransport(1,1);
        System.out.println(result);
    }

    @Test
    public void endTransport() {
    }
}