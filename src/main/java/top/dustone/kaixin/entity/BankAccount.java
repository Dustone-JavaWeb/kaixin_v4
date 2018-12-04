package top.dustone.kaixin.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name="bean_bank_account")
@JsonIgnoreProperties({ "handler","hibernateLazyInitializer" })
public class BankAccount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String type;
    private String name;
    private String number;
    private String bank;
    private String detail;
    private Timestamp createTime;
    private Timestamp editTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getBank() {
        return bank;
    }

    public void setBank(String bank) {
        this.bank = bank;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
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

    @Override
    public String toString() {
        return "BankAccount{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", name='" + name + '\'' +
                ", number='" + number + '\'' +
                ", bank='" + bank + '\'' +
                ", detail='" + detail + '\'' +
                ", createTime=" + createTime +
                ", editTime=" + editTime +
                '}';
    }
}
