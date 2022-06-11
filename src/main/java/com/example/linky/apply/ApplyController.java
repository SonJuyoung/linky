package com.example.linky.apply;

import com.example.linky.apply.model.AnswerListVo;
import com.example.linky.main.model.schedule.ScheduleEntity;
import com.example.linky.main.model.schedule.ScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/apply")
public class ApplyController {
    @Autowired
    ScheduleRepository scheduleRepository;

    @GetMapping
    public String apply(Model model) {
        List list = new ArrayList();
        String rdtDay;

        for(ScheduleEntity entity : scheduleRepository.findAvailable()) {
            String rdt = String.valueOf(entity.getRdt());
            String day = entity.getDay();
            rdtDay = rdt + " " + day;
            list.add(rdtDay);
        }

        model.addAttribute("data", list);
        System.out.println(list);

        return "apply/apply";
    }

    @PostMapping
    public String applyProc(AnswerListVo listVo, HttpSession hs) {
        hs.setAttribute("test", listVo);
        return "redirect:/payment";
    }
}