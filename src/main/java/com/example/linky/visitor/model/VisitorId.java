package com.example.linky.visitor.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;

public class VisitorId implements Serializable {
    private String ip;
    private LocalDate rdt;

    public VisitorId() {}

    public VisitorId(String ip, LocalDate rdt) {
        super();
        this.ip = ip;
        this.rdt = rdt;
    }
}
