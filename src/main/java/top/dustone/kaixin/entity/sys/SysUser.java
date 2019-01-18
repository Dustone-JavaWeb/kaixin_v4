package top.dustone.kaixin.entity.sys;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.sql.Timestamp;
@Entity
@Table(name="sys_user")
@JsonIgnoreProperties({ "handler","hibernateLazyInitializer","sysRole"})
public class SysUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String username;
    private String password;
    private String salt;
    private String nickName;
    private boolean isEnabled;
    private boolean isLocked;
    private int loginFailureCount;
    private Timestamp lockedTime;
    private Timestamp loginTime;
    private String loginIp;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "role_id")
    private SysRole sysRole;
    private String linkType;
    private String linkId;
    private String avatar;
    private Timestamp editTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public boolean isEnabled() {
        return isEnabled;
    }

    public void setEnabled(boolean enabled) {
        isEnabled = enabled;
    }

    public boolean isLocked() {
        return isLocked;
    }

    public void setLocked(boolean locked) {
        isLocked = locked;
    }

    public int getLoginFailureCount() {
        return loginFailureCount;
    }

    public void setLoginFailureCount(int loginFailureCount) {
        this.loginFailureCount = loginFailureCount;
    }

    public Timestamp getLockedTime() {
        return lockedTime;
    }

    public void setLockedTime(Timestamp lockedTime) {
        this.lockedTime = lockedTime;
    }

    public Timestamp getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(Timestamp loginTime) {
        this.loginTime = loginTime;
    }

    public String getLoginIp() {
        return loginIp;
    }

    public void setLoginIp(String loginIp) {
        this.loginIp = loginIp;
    }

    public SysRole getSysRole() {
        return sysRole;
    }

    public void setSysRole(SysRole sysRole) {
        this.sysRole = sysRole;
    }

    public String getLinkType() {
        return linkType;
    }

    public void setLinkType(String linkType) {
        this.linkType = linkType;
    }

    public String getLinkId() {
        return linkId;
    }

    public void setLinkId(String linkId) {
        this.linkId = linkId;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public Timestamp getEditTime() {
        return editTime;
    }

    public void setEditTime(Timestamp editTime) {
        this.editTime = editTime;
    }

    @Override
    public String toString() {
        return "SysUser{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", salt='" + salt + '\'' +
                ", nickName='" + nickName + '\'' +
                ", isEnabled=" + isEnabled +
                ", isLocked=" + isLocked +
                ", loginFailureCount=" + loginFailureCount +
                ", lockedTime=" + lockedTime +
                ", loginTime=" + loginTime +
                ", loginIp='" + loginIp + '\'' +
                ", sysRole=" + sysRole +
                ", linkType='" + linkType + '\'' +
                ", linkId='" + linkId + '\'' +
                ", avatar='" + avatar + '\'' +
                ", editTime=" + editTime +
                '}';
    }
}
