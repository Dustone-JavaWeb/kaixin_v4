package top.dustone.kaixin.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "com_machine_map")
@JsonIgnoreProperties({ "handler","hibernateLazyInitializer"})
public class MachineMap {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @OneToOne
    private Machine machine;
    @OneToOne
    private Driver driver;
    private double wgsX;
    private double wgsY;
    private double gcjX;
    private double gcjY;
    @Column(name = "update_time")
    private Timestamp updateTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Machine getMachine() {
        return machine;
    }

    public void setMachine(Machine machine) {
        this.machine = machine;
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public double getWgsX() {
        return wgsX;
    }

    public void setWgsX(double wgsX) {
        this.wgsX = wgsX;
    }

    public double getWgsY() {
        return wgsY;
    }

    public void setWgsY(double wgsY) {
        this.wgsY = wgsY;
    }

    public double getGcjX() {
        return gcjX;
    }

    public void setGcjX(double gcjX) {
        this.gcjX = gcjX;
    }

    public double getGcjY() {
        return gcjY;
    }

    public void setGcjY(double gcjY) {
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
        return "MachineMap{" +
                "id=" + id +
                ", machine=" + machine +
                ", driver=" + driver +
                ", wgsX=" + wgsX +
                ", wgsY=" + wgsY +
                ", gcjX=" + gcjX +
                ", gcjY=" + gcjY +
                ", updateTime=" + updateTime +
                '}';
    }
}
