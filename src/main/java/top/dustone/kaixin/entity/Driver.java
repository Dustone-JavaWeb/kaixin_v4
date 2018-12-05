package top.dustone.kaixin.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import javax.persistence.*;
import java.sql.Timestamp;
@Entity
@Table(name="bean_driver")
@JsonIgnoreProperties({ "handler","hibernateLazyInitializer" })
public class Driver {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String tel;
    private String personId;
    private String paperId;
    private String status;
    private String type;
    @OneToOne
    private Resource resource;
    @ManyToOne
    @Cascade(value = {CascadeType.ALL})
    private BankAccount bankAccount;
    @Column(name = "create_time")
    private Timestamp createTime;
    @Column(name = "edit_time")
    private Timestamp editTime;
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

    public String getPaperId() {
        return paperId;
    }

    public void setPaperId(String paperId) {
        this.paperId = paperId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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
        return "Driver{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", tel='" + tel + '\'' +
                ", personId='" + personId + '\'' +
                ", paperId='" + paperId + '\'' +
                ", status='" + status + '\'' +
                ", type='" + type + '\'' +
                ", resource=" + resource +
                ", bankAccount=" + bankAccount +
                ", createTime=" + createTime +
                ", editTime=" + editTime +
                '}';
    }
}
