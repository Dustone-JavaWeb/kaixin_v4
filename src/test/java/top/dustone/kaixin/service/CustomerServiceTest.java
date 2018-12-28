package top.dustone.kaixin.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import top.dustone.kaixin.entity.Contact;
import top.dustone.kaixin.entity.Customer;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CustomerServiceTest {
    @Autowired
    CustomerService customerService;
    @Test
    public void listByExample() {
        Customer customer=new Customer();
        customer.setName("Dustone");
        System.out.println(customerService.listByExample(customer,0,5,5));
    }

    @Test
    public void update() {
        Customer customer=new Customer();
        customer.setName("Dustone科技");
        customer.setDetail("测试数据");
        customer.setStatus("正常");
        customer.setType("普通");
        Contact contact=new Contact();
        contact.setName("陈岩");
        contact.setPersonId("674462865");
        contact.setRole("老板");
        customer.getContacts().add(contact);
        customerService.update(customer);
        System.out.println(customer);
    }

    @Test
    public void listByContact() {
        Contact contact=new Contact();
        contact.setName("陈岩");
        contact.setPersonId("674462865");
        contact.setRole("老板");
        System.out.println(customerService.listByContact(contact).getContent());
    }
}