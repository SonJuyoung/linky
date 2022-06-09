package com.example.linky.admin.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "t_admin")
public class AdminEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false, length = 30, unique = true)
    private String uid;

    @Column(nullable = false, length = 200)
    private String upw;

    @Column(nullable = false)
    private String role;
}
