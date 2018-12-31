//package top.dustone.kaixin.entity.log;
//
//import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
//import org.hibernate.annotations.Cascade;
//import org.hibernate.annotations.CascadeType;
//import top.dustone.kaixin.entity.Machine;
//import top.dustone.kaixin.entity.Resource;
//import top.dustone.kaixin.entity.Support;
//
//import javax.persistence.*;
//import java.sql.Timestamp;
//
//@Entity
//@Table(name = "log_oil")
//@JsonIgnoreProperties({"handler", "hibernateLazyInitializer"})
//public class LogOil {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Integer id;
//    @ManyToOne(targetEntity = Support.class)
//    @JoinColumn(name = "support_id", referencedColumnName = "id", nullable = false)
//    private Support support;
//    @ManyToOne(targetEntity = Machine.class)
//    @JoinColumn(name = "machine_id", referencedColumnName = "id", nullable = false)
//    private Machine machine;
//    private Double litre;
//    private Double money;
//    private String details;
//    @OneToOne
//    @Cascade(value = {CascadeType.ALL})
//    private Resource resource;
//    private int logMode;
//    private Timestamp createTime;
//    private Timestamp editTime;
//}
