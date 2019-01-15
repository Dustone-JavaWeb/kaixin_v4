package top.dustone.kaixin.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "service_machine_status")
@JsonIgnoreProperties({ "handler","hibernateLazyInitializer"})
public class MachineStatus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer machineId;
    private String status;
    private Integer compactId;
    private Integer workId;
    private Integer transportId;
    private Integer maintainId;
    @Column(name="wgs_x")
    private Double wgsX;
    @Column(name="wgs_y")
    private Double wgsY;
    @Column(name="gcj_x")
    private Double gcjX;
    @Column(name="gcj_y")
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

    public Integer getCompactId() {
        return compactId;
    }

    public void setCompactId(Integer compactId) {
        this.compactId = compactId;
    }

    public Integer getWorkId() {
        return workId;
    }

    public void setWorkId(Integer workId) {
        this.workId = workId;
    }

    public Integer getTransportId() {
        return transportId;
    }

    public void setTransportId(Integer transportId) {
        this.transportId = transportId;
    }

    public Integer getMaintainId() {
        return maintainId;
    }

    public void setMaintainId(Integer maintainId) {
        this.maintainId = maintainId;
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
        return "MachineStatus{" +
                "id=" + id +
                ", machineId=" + machineId +
                ", compactId=" + compactId +
                ", workId=" + workId +
                ", transportId=" + transportId +
                ", maintainId=" + maintainId +
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
