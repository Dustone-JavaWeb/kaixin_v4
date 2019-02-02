package top.dustone.kaixin.entity.view;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "view_work_count")
@JsonIgnoreProperties({ "handler","hibernateLazyInitializer"})
public class WorkCount {
    @Id
    private String time;
    private String number;

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "WorkCount{" +
                "time='" + time + '\'' +
                ", number='" + number + '\'' +
                '}';
    }
}
