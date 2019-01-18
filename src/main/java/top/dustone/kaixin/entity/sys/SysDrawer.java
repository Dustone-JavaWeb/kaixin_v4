package top.dustone.kaixin.entity.sys;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="sys_drawer")
@JsonIgnoreProperties({ "handler","hibernateLazyInitializer","parent"})
public class SysDrawer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;
    private String name;
    private String icon;
    private String url;
    @ManyToOne
    private SysDrawer parent;
    @OneToMany(mappedBy = "parent")
    private List<SysDrawer> sysDrawers;
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public SysDrawer getParent() {
        return parent;
    }

    public void setParent(SysDrawer parent) {
        this.parent = parent;
    }

    public List<SysDrawer> getSysDrawers() {
        return sysDrawers;
    }

    public void setSysDrawers(List<SysDrawer> sysDrawers) {
        this.sysDrawers = sysDrawers;
    }
}
