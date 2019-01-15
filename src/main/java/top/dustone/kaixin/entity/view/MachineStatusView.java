package top.dustone.kaixin.entity.view;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.sql.Timestamp;
@Entity
@Table(name = "view_machine_status")
@JsonIgnoreProperties({ "handler","hibernateLazyInitializer"})
public class MachineStatusView {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer machineId;
    private String status;
    private String machineNameplate;
    private String machineCode;
    private Integer compactId;
    private String compactNumber;
    private Integer customerId;
    private String customerName;
    private Integer workId;
    private Integer driverId;
    private String driverName;
    private String driverTel;
    private Integer transportId;
    private Integer transportSupportId;
    private String transportSupportName;
    private String transportSupportTel;
    private Integer maintainId;
    private Integer maintainSupportId;
    private String maintainSupportName;
    private String maintainSupportTel;
    @Column(name = "wgs_x")
    private Double wgsX;
    @Column(name = "wgs_y")
    private Double wgsY;
    @Column(name = "gcj_x")
    private Double gcjX;
    @Column(name = "gcj_y")
    private Double gcjY;
    @Column(name = "update_time")
    private Timestamp updateTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getMachineId() {
        return machineId;
    }

    public void setMachineId(Integer machineId) {
        this.machineId = machineId;
    }

    public String getMachineNameplate() {
        return machineNameplate;
    }

    public void setMachineNameplate(String machineNameplate) {
        this.machineNameplate = machineNameplate;
    }

    public String getMachineCode() {
        return machineCode;
    }

    public void setMachineCode(String machineCode) {
        this.machineCode = machineCode;
    }

    public Integer getCompactId() {
        return compactId;
    }

    public void setCompactId(Integer compactId) {
        this.compactId = compactId;
    }

    public String getCompactNumber() {
        return compactNumber;
    }

    public void setCompactNumber(String compactNumber) {
        this.compactNumber = compactNumber;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public Integer getWorkId() {
        return workId;
    }

    public void setWorkId(Integer workId) {
        this.workId = workId;
    }

    public Integer getDriverId() {
        return driverId;
    }

    public void setDriverId(Integer driverId) {
        this.driverId = driverId;
    }

    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    public String getDriverTel() {
        return driverTel;
    }

    public void setDriverTel(String driverTel) {
        this.driverTel = driverTel;
    }

    public Integer getTransportId() {
        return transportId;
    }

    public void setTransportId(Integer transportId) {
        this.transportId = transportId;
    }

    public Integer getTransportSupportId() {
        return transportSupportId;
    }

    public void setTransportSupportId(Integer transportSupportId) {
        this.transportSupportId = transportSupportId;
    }

    public String getTransportSupportName() {
        return transportSupportName;
    }

    public void setTransportSupportName(String transportSupportName) {
        this.transportSupportName = transportSupportName;
    }

    public String getTransportSupportTel() {
        return transportSupportTel;
    }

    public void setTransportSupportTel(String transportSupportTel) {
        this.transportSupportTel = transportSupportTel;
    }

    public Integer getMaintainId() {
        return maintainId;
    }

    public void setMaintainId(Integer maintainId) {
        this.maintainId = maintainId;
    }

    public Integer getMaintainSupportId() {
        return maintainSupportId;
    }

    public void setMaintainSupportId(Integer maintainSupportId) {
        this.maintainSupportId = maintainSupportId;
    }

    public String getMaintainSupportName() {
        return maintainSupportName;
    }

    public void setMaintainSupportName(String maintainSupportName) {
        this.maintainSupportName = maintainSupportName;
    }

    public String getMaintainSupportTel() {
        return maintainSupportTel;
    }

    public void setMaintainSupportTel(String maintainSupportTel) {
        this.maintainSupportTel = maintainSupportTel;
    }

    public Double getWgsX() {
        return wgsX;
    }

    public void setWgsX(Double wgsX) {
        this.wgsX = wgsX;
    }

    public Double getWgsY() {
        return wgsY;
    }

    public void setWgsY(Double wgsY) {
        this.wgsY = wgsY;
    }

    public Double getGcjX() {
        return gcjX;
    }

    public void setGcjX(Double gcjX) {
        this.gcjX = gcjX;
    }

    public Double getGcjY() {
        return gcjY;
    }

    public void setGcjY(Double gcjY) {
        this.gcjY = gcjY;
    }

    public Timestamp getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Timestamp updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        return "MachineStatusView{" +
                "id=" + id +
                ", machineId=" + machineId +
                ", machineNameplate='" + machineNameplate + '\'' +
                ", machineCode='" + machineCode + '\'' +
                ", compactId=" + compactId +
                ", compactNumber='" + compactNumber + '\'' +
                ", customerId=" + customerId +
                ", customerName='" + customerName + '\'' +
                ", workId=" + workId +
                ", driverId=" + driverId +
                ", driverName='" + driverName + '\'' +
                ", driverTel='" + driverTel + '\'' +
                ", transportId=" + transportId +
                ", transportSupportId=" + transportSupportId +
                ", transportSupportName='" + transportSupportName + '\'' +
                ", transportSupportTel='" + transportSupportTel + '\'' +
                ", maintainId=" + maintainId +
                ", maintainSupportId=" + maintainSupportId +
                ", maintainSupportName='" + maintainSupportName + '\'' +
                ", maintainSupportTel='" + maintainSupportTel + '\'' +
                ", wgsX=" + wgsX +
                ", wgsY=" + wgsY +
                ", gcjX=" + gcjX +
                ", gcjY=" + gcjY +
                ", updateTime=" + updateTime +
                '}';
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
