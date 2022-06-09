package com.example.linky.main;

import com.example.linky.main.model.schedule.ScheduleEntity;
import com.example.linky.main.model.schedule.ScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/")
@Controller
public class MainController {

    @Autowired private ScheduleRepository scheduleRepository;

    @GetMapping("")
    public String main(Model model) {

        System.out.println(scheduleRepository.findById(1));

        model.addAttribute("schedule", scheduleRepository.findAll());
        return "main/main";
    }
}
