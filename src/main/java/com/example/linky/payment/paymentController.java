package com.example.linky.payment;

import com.example.linky.main.model.schedule.ScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("")
public class paymentController {

    @Autowired PaymentService paymentService;
    @Autowired ScheduleRepository scheduleRepository;

    @GetMapping("/payment")
    public String payment(Model model) {
        model.addAttribute("result", paymentService.getAnswerListVoFromSession());
        String id = paymentService.getAnswerListVoFromSession().getAnswerVoList().get(0).getAnswer().split(" ")[2];
        System.out.println(id);
        model.addAttribute("place", scheduleRepository.findPlace(Integer.parseInt(id)));

        return "payment/payment";
    }
}
