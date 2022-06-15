package com.example.linky.main.model.review;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/review")
public class ReviewController {

    /** 팝업 **/
    @GetMapping
    public String review() {

        return "main/review/review";
    }
}
