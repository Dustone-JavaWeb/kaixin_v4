package top.dustone.kaixin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import top.dustone.kaixin.entity.Contact;
import top.dustone.kaixin.entity.Customer;
import top.dustone.kaixin.service.ContactService;
import top.dustone.kaixin.service.CustomerService;
import top.dustone.kaixin.util.CommonResponseModel;
import top.dustone.kaixin.util.Page4Navigator;
import top.dustone.kaixin.util.RequestModel;

@CrossOrigin
@RestController
public class CustomerController {
    @Autowired
    CustomerService customerService;
    @Autowired
    ContactService contactService;
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
    @PostMapping("/admin_contact_update")
    public CommonResponseModel<Contact> updateContact(@RequestBody RequestModel<Contact> requestModel){
        return contactService.update(requestModel.getExample());
    }
    @PostMapping("/admin_contact_query")
    public Page4Navigator<Contact> listContact(@RequestBody RequestModel<Customer> requestModel){
        return contactService.listByCustomerId(requestModel.getExample().getId());
    }
    @PostMapping("/admin_contact_get")
    public CommonResponseModel<Contact> getContact(@RequestBody RequestModel<Contact> requestModel){
        CommonResponseModel<Contact> result=new CommonResponseModel<Contact>();
        Contact contact=contactService.findContactById(requestModel.getExample().getId());
        if(contact!=null){
            result.setT(contact);
            result.setCode("200");
        }else{
            result.setCode("500");
            result.setMsg("参数错误！");
        }
        return result;
    }
}
