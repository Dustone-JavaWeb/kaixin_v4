package top.dustone.kaixin.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;
import top.dustone.kaixin.dao.ContactDAO;
import top.dustone.kaixin.dao.CustomerDAO;
import top.dustone.kaixin.entity.Contact;
import top.dustone.kaixin.entity.Customer;
import top.dustone.kaixin.util.Page4Navigator;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerService {
    @Autowired
    CustomerDAO customerDAO;
    @Autowired
    ContactDAO contactDAO;
    public Page4Navigator<Customer> listByExample(Customer customer,int start,int size,int page){
        Sort sort=new Sort(Sort.Direction.DESC,"id");
        Pageable pageable= PageRequest.of(start,size,sort);
        ExampleMatcher exampleMatcher=ExampleMatcher.matching()
                .withMatcher("name",ExampleMatcher.GenericPropertyMatchers.contains())
                .withMatcher("bankAccount.name",ExampleMatcher.GenericPropertyMatchers.startsWith())
                .withMatcher("bankAccount.number",ExampleMatcher.GenericPropertyMatchers.startsWith());
        Example<Customer> example=Example.of(customer,exampleMatcher);
        Page pageJPA=customerDAO.findAll(example,pageable);
        return new Page4Navigator<Customer>(pageJPA,page);
    }
    public Page4Navigator<Customer> update(Customer customer){
        customerDAO.save(customer);
        Page4Navigator<Customer> result=new Page4Navigator<Customer>();
        List<Customer> content=new ArrayList<Customer>(1);
        content.add(customer);
        result.setContent(content);
        return result;
    }
    public Page4Navigator<Customer> listByContact(Contact contact){
        Page4Navigator<Customer> result=new Page4Navigator<Customer>();

        Sort sort=new Sort(Sort.Direction.DESC,"id");
        ExampleMatcher exampleMatcher=ExampleMatcher.matching()
                .withMatcher("name",ExampleMatcher.GenericPropertyMatchers.contains())
                .withMatcher("bankAccount.name",ExampleMatcher.GenericPropertyMatchers.startsWith())
                .withMatcher("bankAccount.number",ExampleMatcher.GenericPropertyMatchers.startsWith());
        Example<Contact> example=Example.of(contact,exampleMatcher);
        List<Contact> contacts=contactDAO.findAll(example);
        List<Customer> customers=new ArrayList<Customer>(5);
        for(Contact c:contacts){
            customers.add(c.getCustomer());
        }
        result.setContent(customers);
        return result;
    }
}
