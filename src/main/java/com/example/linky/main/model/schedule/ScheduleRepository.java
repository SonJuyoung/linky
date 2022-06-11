package com.example.linky.main.model.schedule;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ScheduleRepository extends JpaRepository<ScheduleEntity, Integer> {

    @Query(value = "SELECT s FROM ScheduleEntity s ORDER BY s.rdt ASC")
    List<ScheduleEntity> findAllOrderByRdtDesc();

    @Query(value = "select s from ScheduleEntity s where s.status = true order by s.rdt")
    List<ScheduleEntity> findAvailable();
}
