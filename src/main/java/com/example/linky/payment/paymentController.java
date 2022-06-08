package com.example.linky.payment;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("")
public class paymentController {

    @GetMapping("/payment")
    public String payment() {

        return "payment/payment";
    }
}
