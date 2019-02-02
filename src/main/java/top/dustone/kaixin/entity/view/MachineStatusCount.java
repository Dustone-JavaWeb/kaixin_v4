package top.dustone.kaixin.entity.view;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "view_machine_status_count")
@JsonIgnoreProperties({ "handler","hibernateLazyInitializer"})
public class MachineStatusCount {
    @Id
    private String status;
    private String number;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "MachineStatusCount{" +
                "status='" + status + '\'' +
                ", number='" + number + '\'' +
                '}';
    }
}
