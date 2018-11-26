package top.dustone.kaixin.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "bean_machine_brand")
@JsonIgnoreProperties({ "handler","hibernateLazyInitializer"})
public class MachineBrand {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;
    private String name;
    private String logo;
    private String detail;
    @OneToOne
    private Resource resource;
    @OneToMany(mappedBy = "machineBrand",fetch = FetchType.EAGER)
    private List<MachineType> machineTypes;
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public Resource getResource() {
        return resource;
    }

    public void setResource(Resource resource) {
        this.resource = resource;
    }

    @Override
    public String toString() {
        return "MachineBrand{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", logo='" + logo + '\'' +
                ", detail='" + detail + '\'' +
                ", resource=" + resource +
                ", machineTypes=" + machineTypes +
                '}';
    }
}
