package com.example.linky.visitor.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;

public interface VisitorRepository extends JpaRepository<VisitorEntity, VisitorId> {

    VisitorEntity findByIp(String encodedIp);
    List<VisitorEntity> findAllByRdt(LocalDate rdt);
}
