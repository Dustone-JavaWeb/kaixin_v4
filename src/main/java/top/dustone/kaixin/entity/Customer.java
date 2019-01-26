package top.dustone.kaixin.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;
@Entity
@Table(name="bean_customer")
@JsonIgnoreProperties({ "handler","hibernateLazyInitializer" })
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String type;
    private String status;
    private String detail;
    @OneToOne
    @Cascade(value = {CascadeType.ALL})
    private Resource resource;
    @OneToOne
    @Cascade(value = {CascadeType.ALL})
    private BankAccount bankAccount;
    private Timestamp createTime;
    private Timestamp editTime;
    @OneToMany(fetch =FetchType.EAGER)
    @Cascade(value = {CascadeType.ALL})
    @JoinTable(name="com_customer_contact",
            joinColumns = @JoinColumn(name="customer_id",referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name="contact_id",referencedColumnName = "id")
    )
    private Set<Contact> contacts=new HashSet<Contact>();
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public Resource getResource() {
        return resource;
    }

    public void setResource(Resource resource) {
        this.resource = resource;
    }

    public BankAccount getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(BankAccount bankAccount) {
        this.bankAccount = bankAccount;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    public Timestamp getEditTime() {
        return editTime;
    }

    public void setEditTime(Timestamp editTime) {
        this.editTime = editTime;
    }

    public Set<Contact> getContacts() {
        return contacts;
    }

    public void setContacts(Set<Contact> contacts) {
        this.contacts = contacts;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", status='" + status + '\'' +
                ", detail='" + detail + '\'' +
                ", resource=" + resource +
                ", bankAccount=" + bankAccount +
                ", createTime=" + createTime +
                ", editTime=" + editTime +
                ", contacts=" + contacts +
                '}';
    }
}
