package com.example.linky.payment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("")
public class paymentController {

    @Autowired PaymentService paymentService;

    @GetMapping("/payment")
    public String payment(Model model) {
        model.addAttribute("result", paymentService.getAnswerListVoFromSession());

        return "payment/payment";
    }
}
