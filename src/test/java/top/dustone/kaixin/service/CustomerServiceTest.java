package top.dustone.kaixin.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import top.dustone.kaixin.entity.Contact;
import top.dustone.kaixin.entity.Customer;

import java.util.HashSet;
import java.util.Set;

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
        Set<Contact> contacts=new HashSet<Contact>();
        contacts.add(contact);
        customer.setContacts(contacts);
        customerService.update(customer);
        System.out.println(customer);
    }

    @Test
    public void listByContact() {

    }
}