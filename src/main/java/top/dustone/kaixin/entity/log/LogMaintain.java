package top.dustone.kaixin.entity.log;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.Cascade;
import top.dustone.kaixin.entity.Machine;
import top.dustone.kaixin.entity.Resource;
import top.dustone.kaixin.entity.Support;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "log_maintain")
@JsonIgnoreProperties({"handler", "hibernateLazyInitializer"})
public class LogMaintain {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne(targetEntity = Support.class)
    @JoinColumn(name = "support_id", referencedColumnName = "id", nullable = false)
    private Support support;
    @ManyToOne(targetEntity = Machine.class)
    @JoinColumn(name = "machine_id", referencedColumnName = "id", nullable = false)
    private Machine machine;
    private String type;
    private double money;
    private String details;
    @OneToOne
    @Cascade(value = {org.hibernate.annotations.CascadeType.ALL})
    private Resource resource;
    private int logMode;
    @Column(name = "create_time")
    private Timestamp createTime;
    @Column(name = "edit_time")
    private Timestamp editTime;
    @Column(name = "start_time")
    private Timestamp startTime;
    @Column(name = "end_time")
    private Timestamp endTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Support getSupport() {
        return support;
    }

    public void setSupport(Support support) {
        this.support = support;
    }

    public Machine getMachine() {
        return machine;
    }

    public void setMachine(Machine machine) {
        this.machine = machine;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public Resource getResource() {
        return resource;
    }

    public void setResource(Resource resource) {
        this.resource = resource;
    }

    public int getLogMode() {
        return logMode;
    }

    public void setLogMode(int logMode) {
        this.logMode = logMode;
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

    public Timestamp getStartTime() {
        return startTime;
    }

    public void setStartTime(Timestamp startTime) {
        this.startTime = startTime;
    }

    public Timestamp getEndTime() {
        return endTime;
    }

    public void setEndTime(Timestamp endTime) {
        this.endTime = endTime;
    }

    @Override
    public String toString() {
        return "LogMaintain{" +
                "id=" + id +
                ", support=" + support +
                ", machine=" + machine +
                ", type='" + type + '\'' +
                ", money=" + money +
                ", details='" + details + '\'' +
                ", resource=" + resource +
                ", logMode=" + logMode +
                ", createTime=" + createTime +
                ", editTime=" + editTime +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                '}';
    }
}
