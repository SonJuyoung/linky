package com.example.linky.main.model.review;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "t_review")
public class ReviewEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String img;

    @Column(columnDefinition = "BOOLEAN DEFAULT FALSE")
    private boolean repre;

    @Column(insertable = false, updatable = false, columnDefinition = "DATE DEFAULT CURRENT_TIMESTAMP()")
    private LocalDate rdt;
}
