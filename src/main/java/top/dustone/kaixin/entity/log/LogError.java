package top.dustone.kaixin.entity.log;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.Cascade;
import top.dustone.kaixin.entity.Driver;
import top.dustone.kaixin.entity.Machine;
import top.dustone.kaixin.entity.Resource;
import top.dustone.kaixin.entity.Support;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "log_error")
@JsonIgnoreProperties({"handler", "hibernateLazyInitializer"})
public class LogError {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne(targetEntity = Support.class)
    @JoinColumn(name = "support_id", referencedColumnName = "id", nullable = false)
    private Support support;
    @ManyToOne(targetEntity = Machine.class)
    @JoinColumn(name = "machine_id", referencedColumnName = "id", nullable = false)
    private Machine machine;
    @ManyToOne(targetEntity = Driver.class)
    @JoinColumn(name = "driver_id", referencedColumnName = "id", nullable = false)
    private Driver driver;
    private String type;
    private String logMode;
    private String title;
    private String details;
    @OneToOne
    @Cascade(value = {org.hibernate.annotations.CascadeType.ALL})
    private Resource resource;
    @Column(name = "create_time")
    private Timestamp createTime;
    @Column(name = "edit_time")
    private Timestamp editTime;
    @Transient
    private Timestamp fromTime;
    @Transient
    private Timestamp toTime;

    public Timestamp getFromTime() {
        return fromTime;
    }

    public void setFromTime(Timestamp fromTime) {
        this.fromTime = fromTime;
    }

    public Timestamp getToTime() {
        return toTime;
    }

    public void setToTime(Timestamp toTime) {
        this.toTime = toTime;
    }

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

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getLogMode() {
        return logMode;
    }

    public void setLogMode(String logMode) {
        this.logMode = logMode;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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
        return "LogError{" +
                "id=" + id +
                ", support=" + support +
                ", machine=" + machine +
                ", driver=" + driver +
                ", type='" + type + '\'' +
                ", logMode=" + logMode +
                ", title='" + title + '\'' +
                ", details='" + details + '\'' +
                ", resource=" + resource +
                ", createTime=" + createTime +
                ", editTime=" + editTime +
                '}';
    }
}
