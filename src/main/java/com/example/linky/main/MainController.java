package com.example.linky.main;

import com.example.linky.main.model.schedule.ScheduleEntity;
import com.example.linky.main.model.schedule.ScheduleRepository;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/")
@Controller
public class MainController {

    @Autowired private ScheduleRepository scheduleRepository;

    @GetMapping("")
    public String main(Model model) {

        System.out.println(scheduleRepository.findById(1));

        model.addAttribute("schedule", scheduleRepository.findAllOrderByRdtDesc());
        return "main/main";
    }

    @PostMapping("schedule/mod")
    @ResponseBody
    public int modProc(@RequestBody ScheduleEntity entity) {
        int result = scheduleRepository.save(entity) != null ? 1 : 0;

        return result;
    }
}
