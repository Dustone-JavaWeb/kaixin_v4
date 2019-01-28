package top.dustone.kaixin.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.dustone.kaixin.dao.ContactDAO;
import top.dustone.kaixin.dao.CustomerDAO;
import top.dustone.kaixin.entity.Contact;
import top.dustone.kaixin.entity.Customer;
import top.dustone.kaixin.util.CommonResponseModel;
import top.dustone.kaixin.util.Page4Navigator;

import java.util.List;

@Service
public class ContactService {
    @Autowired
    ContactDAO contactDAO;
    @Autowired
    CustomerDAO customerDAO;
    public Page4Navigator<Contact> listByCustomerId(Integer customerId){
        Page4Navigator<Contact> page=new Page4Navigator<Contact>();
        List<Contact> result=contactDAO.findAllByCustomerId(customerId);
        page.setContent(result);
        return page;
    }
    public CommonResponseModel<Contact> update(Contact contact){
        System.out.println(contact);
        CommonResponseModel<Contact> result=new CommonResponseModel<Contact>();
        if(contact.getCustomer()!=null&&contact.getCustomer().getId()!=null){
            Customer customer=customerDAO.findById(contact.getCustomer().getId()).get();
            if(customer!=null){
                contact.setCustomer(customer);
                contactDAO.save(contact);
                result.setT(contact);
                result.setCode("200");
                result.setMsg("保存成功！");
                return result;
            }
        }
        result.setCode("500");
        result.setMsg("数据异常！ 保存失败");
        return result;
    }
    public Contact findContactById(Integer id){
        return contactDAO.findById(id).get();
    }

}
