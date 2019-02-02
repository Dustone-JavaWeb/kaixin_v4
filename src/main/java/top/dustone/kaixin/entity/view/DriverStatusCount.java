package top.dustone.kaixin.entity.view;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name = "view_driver_status_count")
@JsonIgnoreProperties({ "handler","hibernateLazyInitializer"})
public class DriverStatusCount {
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
        return "DriverStatusCount{" +
                "status='" + status + '\'' +
                ", number='" + number + '\'' +
                '}';
    }
}
