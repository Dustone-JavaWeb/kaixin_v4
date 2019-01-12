package top.dustone.kaixin.entity.view;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "view_machine_map")
@JsonIgnoreProperties({ "handler","hibernateLazyInitializer"})
public class MachineMapView {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer driverId;
    private String driverName;
    private Integer machineId;
    private Integer compactId;
    private String machineNameplate;
    private String machineCode;
    private String machineStatus;
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
        return "MachineMapView{" +
                "id=" + id +
                ", driverId=" + driverId +
                ", driverName='" + driverName + '\'' +
                ", machineId=" + machineId +
                ", machineNameplate='" + machineNameplate + '\'' +
                ", machineCode='" + machineCode + '\'' +
                ", wgsX=" + wgsX +
                ", wgsY=" + wgsY +
                ", gcjX=" + gcjX +
                ", gcjY=" + gcjY +
                ", updateTime=" + updateTime +
                '}';
    }

    public String getMachineStatus() {
        return machineStatus;
    }

    public void setMachineStatus(String machineStatus) {
        this.machineStatus = machineStatus;
    }

    public Integer getCompactId() {
        return compactId;
    }

    public void setCompactId(Integer compactId) {
        this.compactId = compactId;
    }
}
