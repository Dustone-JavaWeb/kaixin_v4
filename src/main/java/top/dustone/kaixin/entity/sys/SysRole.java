package top.dustone.kaixin.entity.sys;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="sys_role")
@JsonIgnoreProperties({ "handler","hibernateLazyInitializer" })
public class SysRole {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String roleName;
    private String detail;
    private int type;
    @OneToMany(fetch = FetchType.EAGER)
    @JoinTable(name="sys_role_drawer",
            joinColumns = @JoinColumn(name="role_id",referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name="drawer_id",referencedColumnName = "id",unique = true)
    )
    private Set<SysDrawer> sysDrawers=new HashSet<SysDrawer>();
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public Set<SysDrawer> getSysDrawers() {
        return sysDrawers;
    }

    public void setSysDrawers(Set<SysDrawer> sysDrawers) {
        this.sysDrawers = sysDrawers;
    }

    @Override
    public String toString() {
        return "SysRole{" +
                "id=" + id +
                ", roleName='" + roleName + '\'' +
                ", detail='" + detail + '\'' +
                ", type=" + type +
                ", sysDrawers=" + sysDrawers +
                '}';
    }
}
