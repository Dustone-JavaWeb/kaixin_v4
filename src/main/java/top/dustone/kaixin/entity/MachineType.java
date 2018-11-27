package top.dustone.kaixin.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name = "bean_machine_type")
@JsonIgnoreProperties({ "handler","hibernateLazyInitializer"})
public class MachineType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "brand_id")
    private MachineBrand machineBrand;
    private String model;
    private String name;
    private String picture;
    private String detail;
    @OneToOne
    private Resource resource;
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public MachineBrand getMachineBrand() {
        return machineBrand;
    }

    public void setMachineBrand(MachineBrand machineBrand) {
        this.machineBrand = machineBrand;
    }

    public Resource getResource() {
        return resource;
    }

    public void setResource(Resource resource) {
        this.resource = resource;
    }

    @Override
    public String toString() {
        return "MachineType{" +
                "id=" + id +
                ", model='" + model + '\'' +
                ", name='" + name + '\'' +
                ", picture='" + picture + '\'' +
                ", detail='" + detail + '\'' +
                ", resource=" + resource +
                '}';
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
