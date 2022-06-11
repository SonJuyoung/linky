package com.example.linky.main.model.schedule;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.stream.Stream;

@Setter
@Entity
@Table(name = "t_schedule")
@DynamicUpdate
@ToString
public class ScheduleEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "INT UNSIGNED")
    private int id;

    @Column(nullable = false)
    private String time;

    @Column(nullable = false, columnDefinition = "INT UNSIGNED")
    private int man;

    @Column(nullable = false, columnDefinition = "INT UNSIGNED")
    private int woman;

    @Column(nullable = false)
    private boolean status;

    @Column(insertable = false)
    private LocalDate rdt;

    @Transient
    @Column(insertable = false, updatable = false)
    private String day;

    public int getId() {
        return id;
    }

    public String getTime() {
        return time;
    }

    public int getMan() {
        return man;
    }

    public int getWoman() {
        return woman;
    }

    public String getStatus() {
        String status = this.status ? "모집중" : "마감";
        return status;
    }

    public LocalDate getRdt() {
        return rdt;
    }

    public String getDay() {
        String[] arr = this.rdt.toString().split("-");
        Integer[] arr2 = Stream.of(arr).mapToInt(Integer::parseInt).boxed().toArray(Integer[]::new);
        LocalDate date = LocalDate.of(arr2[0], arr2[1], arr2[2]);
        DayOfWeek dayOfWeek = date.getDayOfWeek();
        String day = dayOfWeek.getDisplayName(TextStyle.NARROW, Locale.KOREAN);

        return day;
    }
}