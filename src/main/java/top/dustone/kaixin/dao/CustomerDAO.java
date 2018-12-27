package top.dustone.kaixin.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import top.dustone.kaixin.entity.Customer;

public interface CustomerDAO extends JpaRepository<Customer,Integer>{
}
