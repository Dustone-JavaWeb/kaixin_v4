package top.dustone.kaixin.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="bean_driver")
@JsonIgnoreProperties({ "handler","hibernateLazyInitializer" })
public class SysDrawer {

}
