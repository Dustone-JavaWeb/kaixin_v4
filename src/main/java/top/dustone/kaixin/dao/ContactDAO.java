package top.dustone.kaixin.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import top.dustone.kaixin.entity.Contact;

public interface ContactDAO extends JpaRepository<Contact,Integer>{
}
