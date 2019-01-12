package top.dustone.kaixin.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import top.dustone.kaixin.entity.log.LogTransport;
import top.dustone.kaixin.entity.log.LogWork;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="service_compact")
@JsonIgnoreProperties({ "handler","hibernateLazyInitializer" })
public class Compact {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String number;
    @ManyToOne(targetEntity = Customer.class)
    @JoinColumn(name="customer_id")
    private Customer customer;
    @ManyToOne(targetEntity = Contact.class)
    @JoinColumn(name="contact_id")
    private Contact contact;
    private String type;
    private String status;
    private int bucket;
    private int hammer;
    private Double limitHour;
    private Double totalHour;
    private Double extraHour;
    private Double moneyPromise;
    private Double moneyRent;
    private Double moneyTotal;
    private Double moneyDelay;
    private Double moneyFact;
    private Double moneyFree;
    private String dest;
    @OneToOne
    @Cascade(value = {CascadeType.ALL})
    private Resource resource;
    @Column(name = "create_time")
    private Timestamp createTime;
    @Column(name = "edit_time")
    private Timestamp editTime;
    @Column(name="enter_time")
    private Timestamp enterTime;
    @Column(name="start_time")
    private Timestamp startTime;
    @OneToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name="com_compact_machine",
            joinColumns = @JoinColumn(name="compact_id",referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name="machine_id",referencedColumnName = "id",unique = true)
    )
    @OrderBy("id desc")
    private Set<Machine> machines=new HashSet<Machine>();
    @OneToMany(fetch =FetchType.EAGER)
    @JoinTable(
            name="com_compact_work",
            joinColumns = @JoinColumn(name="compact_id",referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name="work_id",referencedColumnName = "id",unique = true)
    )
    @OrderBy("id desc")
    private Set<LogWork> logWorks=new HashSet<LogWork>();
    @OneToMany(fetch =FetchType.EAGER)
    @JoinTable(
            name="com_compact_transport",
            joinColumns = @JoinColumn(name="compact_id",referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name="transport_id",referencedColumnName = "id",unique = true)
    )
    @OrderBy("id desc")
    private Set<LogTransport> logTransports=new HashSet<LogTransport>();

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

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getBucket() {
        return bucket;
    }

    public void setBucket(int bucket) {
        this.bucket = bucket;
    }

    public int getHammer() {
        return hammer;
    }

    public void setHammer(int hammer) {
        this.hammer = hammer;
    }

    public Double getLimitHour() {
        return limitHour;
    }

    public void setLimitHour(Double limitHour) {
        this.limitHour = limitHour;
    }

    public Double getTotalHour() {
        return totalHour;
    }

    public void setTotalHour(Double totalHour) {
        this.totalHour = totalHour;
    }

    public Double getExtraHour() {
        return extraHour;
    }

    public void setExtraHour(Double extraHour) {
        this.extraHour = extraHour;
    }

    public Double getMoneyPromise() {
        return moneyPromise;
    }

    public void setMoneyPromise(Double moneyPromise) {
        this.moneyPromise = moneyPromise;
    }

    public Double getMoneyRent() {
        return moneyRent;
    }

    public void setMoneyRent(Double moneyRent) {
        this.moneyRent = moneyRent;
    }

    public Double getMoneyTotal() {
        return moneyTotal;
    }

    public void setMoneyTotal(Double moneyTotal) {
        this.moneyTotal = moneyTotal;
    }

    public Double getMoneyDelay() {
        return moneyDelay;
    }

    public void setMoneyDelay(Double moneyDelay) {
        this.moneyDelay = moneyDelay;
    }

    public Double getMoneyFact() {
        return moneyFact;
    }

    public void setMoneyFact(Double moneyFact) {
        this.moneyFact = moneyFact;
    }

    public Double getMoneyFree() {
        return moneyFree;
    }

    public void setMoneyFree(Double moneyFree) {
        this.moneyFree = moneyFree;
    }

    public String getDest() {
        return dest;
    }

    public void setDest(String dest) {
        this.dest = dest;
    }

    public Resource getResource() {
        return resource;
    }

    public void setResource(Resource resource) {
        this.resource = resource;
    }

    public Timestamp getEditTime() {
        return editTime;
    }

    public void setEditTime(Timestamp editTime) {
        this.editTime = editTime;
    }

    public Timestamp getEnterTime() {
        return enterTime;
    }

    public void setEnterTime(Timestamp enterTime) {
        this.enterTime = enterTime;
    }

    public Timestamp getStartTime() {
        return startTime;
    }

    public void setStartTime(Timestamp startTime) {
        this.startTime = startTime;
    }

    public Set<Machine> getMachines() {
        return machines;
    }

    public void setMachines(Set<Machine> machines) {
        this.machines = machines;
    }

    public Set<LogWork> getLogWorks() {
        return logWorks;
    }

    public void setLogWorks(Set<LogWork> logWorks) {
        this.logWorks = logWorks;
    }

    public Set<LogTransport> getLogTransports() {
        return logTransports;
    }

    public void setLogTransports(Set<LogTransport> logTransports) {
        this.logTransports = logTransports;
    }

    @Override
    public String toString() {
        return "Compact{" +
                "id=" + id +
                ", number='" + number + '\'' +
                ", customer=" + customer +
                ", contact=" + contact +
                ", type='" + type + '\'' +
                ", status='" + status + '\'' +
                ", bucket=" + bucket +
                ", hammer=" + hammer +
                ", limitHour=" + limitHour +
                ", totalHour=" + totalHour +
                ", extraHour=" + extraHour +
                ", moneyPromise=" + moneyPromise +
                ", moneyRent=" + moneyRent +
                ", moneyTotal=" + moneyTotal +
                ", moneyDelay=" + moneyDelay +
                ", moneyFact=" + moneyFact +
                ", moneyFree=" + moneyFree +
                ", dest='" + dest + '\'' +
                ", resource=" + resource +
                ", editTime=" + editTime +
                ", enterTime=" + enterTime +
                ", startTime=" + startTime +
                ", machines=" + machines +
                ", logWorks=" + logWorks +
                ", logTransports=" + logTransports +
                '}';
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
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
