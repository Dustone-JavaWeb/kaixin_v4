package top.dustone.kaixin.entity.log;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import top.dustone.kaixin.entity.Machine;
import top.dustone.kaixin.entity.Resource;
import top.dustone.kaixin.entity.Support;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "log_oil")
@JsonIgnoreProperties({"handler", "hibernateLazyInitializer"})
public class LogOil {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne(targetEntity = Support.class)
    @JoinColumn(name = "support_id", referencedColumnName = "id", nullable = false)
    private Support support;
    @ManyToOne(targetEntity = Machine.class)
    @JoinColumn(name = "machine_id", referencedColumnName = "id", nullable = false)
    private Machine machine;
    private Double litre;
    private Double money;
    private String details;
    @OneToOne
    @Cascade(value = {CascadeType.ALL})
    private Resource resource;
    private String logMode;
    @Column(name = "create_time")
    private Timestamp createTime;
    @Column(name = "edit_time")
    private Timestamp editTime;
    @Transient
    private Timestamp fromTime;
    @Transient
    private Timestamp toTime;

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

    public Double getLitre() {
        return litre;
    }

    public void setLitre(Double litre) {
        this.litre = litre;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
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

    public String getLogMode() {
        return logMode;
    }

    public void setLogMode(String logMode) {
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

    @Override
    public String toString() {
        return "LogOil{" +
                "id=" + id +
                ", support=" + support +
                ", machine=" + machine +
                ", litre=" + litre +
                ", money=" + money +
                ", details='" + details + '\'' +
                ", resource=" + resource +
                ", logMode=" + logMode +
                ", createTime=" + createTime +
                ", editTime=" + editTime +
                '}';
    }

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
}
