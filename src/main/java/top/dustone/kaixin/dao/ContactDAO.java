package top.dustone.kaixin.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import top.dustone.kaixin.entity.Contact;

import java.util.List;

public interface ContactDAO extends JpaRepository<Contact,Integer>{
    public List<Contact> findAllByCustomerId(Integer id);
}
