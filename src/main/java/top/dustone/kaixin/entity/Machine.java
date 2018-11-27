package top.dustone.kaixin.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.sql.Timestamp;
@Entity
@Table(name="bean_machine")
@JsonIgnoreProperties({ "handler","hibernateLazyInitializer" })
public class Machine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tid")
    private MachineType machineType;
    private String nameplete;
    private String code;
    private String owner;
    private String payway;
    private int price;
    private int mPay;
    private String status;
    private float worktime;
    private String xyz;
    private Resource resource;
    private String detail;
    private Timestamp createTime;
    private Timestamp editTime;
    private Timestamp birth;
    private Timestamp deadLine;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public MachineType getMachineType() {
        return machineType;
    }

    public void setMachineType(MachineType machineType) {
        this.machineType = machineType;
    }

    public String getNameplete() {
        return nameplete;
    }

    public void setNameplete(String nameplete) {
        this.nameplete = nameplete;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getPayway() {
        return payway;
    }

    public void setPayway(String payway) {
        this.payway = payway;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getmPay() {
        return mPay;
    }

    public void setmPay(int mPay) {
        this.mPay = mPay;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public float getWorktime() {
        return worktime;
    }

    public void setWorktime(float worktime) {
        this.worktime = worktime;
    }

    public String getXyz() {
        return xyz;
    }

    public void setXyz(String xyz) {
        this.xyz = xyz;
    }

    public Resource getResource() {
        return resource;
    }

    public void setResource(Resource resource) {
        this.resource = resource;
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

    public Timestamp getBirth() {
        return birth;
    }

    public void setBirth(Timestamp birth) {
        this.birth = birth;
    }

    public Timestamp getDeadLine() {
        return deadLine;
    }

    public void setDeadLine(Timestamp deadLine) {
        this.deadLine = deadLine;
    }

    @Override
    public String toString() {
        return "Machine{" +
                "id=" + id +
                ", machineType=" + machineType +
                ", nameplete='" + nameplete + '\'' +
                ", code='" + code + '\'' +
                ", owner='" + owner + '\'' +
                ", payway='" + payway + '\'' +
                ", price=" + price +
                ", mPay=" + mPay +
                ", status='" + status + '\'' +
                ", worktime=" + worktime +
                ", xyz='" + xyz + '\'' +
                ", resource=" + resource +
                ", detail='" + detail + '\'' +
                ", createTime=" + createTime +
                ", editTime=" + editTime +
                ", birth=" + birth +
                ", deadLine=" + deadLine +
                '}';
    }
}
