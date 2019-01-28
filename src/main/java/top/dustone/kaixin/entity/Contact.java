package top.dustone.kaixin.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import javax.persistence.*;

@Entity
@Table(name="bean_contact")
@JsonIgnoreProperties({ "handler","hibernateLazyInitializer"})
public class Contact {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne(fetch =FetchType.EAGER,targetEntity = Customer.class)
    @JoinTable(name="com_customer_contact",
                joinColumns = @JoinColumn(name="contact_id",referencedColumnName = "id"),
                inverseJoinColumns = @JoinColumn(name="customer_id",referencedColumnName = "id")
    )
    private Customer customer;
    private String name;
    private String role;
    private String tel;
    private String personId;
    private String detail;
    @OneToOne
    @Cascade(value = {CascadeType.ALL})
    private Resource resource;
    @OneToOne
    @Cascade(value = {CascadeType.ALL})
    private BankAccount bankAccount;

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
    public Customer getCustomer() {
        return customer;
    }
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getPersonId() {
        return personId;
    }

    public void setPersonId(String personId) {
        this.personId = personId;
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

    @Override
    public String toString() {
        return "Contact{" +
                "id=" + id +
                ", customer=" + customer +
                ", name='" + name + '\'' +
                ", role='" + role + '\'' +
                ", tel='" + tel + '\'' +
                ", personId='" + personId + '\'' +
                ", detail='" + detail + '\'' +
                ", resource=" + resource +
                ", bankAccount=" + bankAccount +
                '}';
    }
}
