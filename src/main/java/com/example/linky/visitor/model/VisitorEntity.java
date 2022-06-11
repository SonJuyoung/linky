package com.example.linky.visitor.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
@Table(name="t_visitor")
@IdClass(VisitorId.class)
public class VisitorEntity {
    @Id
    @Column(name="ip", nullable = false, length = 255)
    private String ip;

    @Id
    @Column(name = "rdt", columnDefinition = "DATE DEFAULT NOW()")
    private LocalDate rdt;
}
