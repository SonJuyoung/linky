package com.example.linky.main;

import com.example.linky.main.model.schedule.ScheduleEntity;
import com.example.linky.main.model.schedule.ScheduleRepository;
import com.example.linky.visitor.VisitorService;
import com.example.linky.visitor.model.VisitorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/")
@Controller
public class MainController {

    @Autowired private ScheduleRepository scheduleRepository;
    @Autowired private VisitorRepository visitorRepository;
    @Autowired private MainService mainService;
    @Autowired private VisitorService visitorService;


    @GetMapping("")
    public String main(Model model) throws Exception {
        visitorService.doSave();

        model.addAttribute("visitor", visitorService.getVisitorCount());
        model.addAttribute("schedule", mainService.scheduleInit());
        return "main/main";
    }

    @PostMapping("schedule/mod")
    @ResponseBody
    public int modProc(@RequestBody ScheduleEntity entity) {
        int result = scheduleRepository.save(entity) != null ? 1 : 0;

        return result;
    }
}
