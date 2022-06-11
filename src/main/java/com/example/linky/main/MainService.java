package com.example.linky.main;

import com.example.linky.main.model.schedule.ScheduleEntity;
import com.example.linky.main.model.schedule.ScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class MainService {

    @Autowired private ScheduleRepository scheduleRepository;

    public List<ScheduleEntity> scheduleInit() {
        List<ScheduleEntity> result = scheduleRepository.findAllOrderByRdtDesc();
        int size = result.size();

        if(size == 0) {
            result.clear();
            for(int i=0; i<4; i++) {
                ScheduleEntity entity = new ScheduleEntity();
                entity.setStatus(false);
                entity.setWoman(0);
                entity.setWoman(0);
                entity.setTime("00:00");
                entity.setRdt(LocalDate.now());
                result.add(entity);
                scheduleRepository.save(entity);
            }
        }

        return result;
    }
}
