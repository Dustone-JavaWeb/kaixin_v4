package top.dustone.kaixin.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import top.dustone.kaixin.entity.Compact;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CompactServiceTest {
    @Autowired
    CompactService compactService;
    @Test
    public void listByExapmle() {
        Compact compact=new Compact();
        System.out.println(compactService.listByExample(compact,0,5,1));
    }

    @Test
    public void update() {
    }
}