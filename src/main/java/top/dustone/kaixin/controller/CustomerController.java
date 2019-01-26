package top.dustone.kaixin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import top.dustone.kaixin.entity.Contact;
import top.dustone.kaixin.entity.Customer;
import top.dustone.kaixin.service.CustomerService;
import top.dustone.kaixin.util.Page4Navigator;
import top.dustone.kaixin.util.RequestModel;

@CrossOrigin
@RestController
public class CustomerController {
    @Autowired
    CustomerService customerService;
    @PostMapping("/admin_customer_query")
    public Page4Navigator<Customer> list(@RequestBody RequestModel<Customer> requestModel){
        Page4Navigator<Customer> page=customerService.listByExample(requestModel.getExample(),requestModel.getStart(),requestModel.getPageSize(),5);
        page.setExample(requestModel);
        //System.out.println(page);
        return page;
    }
    @PostMapping("/admin_customer_update")
    public Page4Navigator<Customer> update(@RequestBody RequestModel<Customer> requestModel){
        System.out.println(requestModel.getExample());
        Page4Navigator<Customer> page=customerService.update(requestModel.getExample());
        page.setResponseMessage("保存成功！");
        return page;
    }
    @PostMapping("/admin_customer_query_by_contact")
    public Page4Navigator<Customer> listByContact(@RequestBody RequestModel<Contact> requestModel){
        Page4Navigator<Customer> page=customerService.listByContact(requestModel.getExample());
        return page;
    }
}
