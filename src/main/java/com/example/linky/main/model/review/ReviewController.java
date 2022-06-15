package com.example.linky.main.model.review;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/review")
public class ReviewController {

    /** 팝업 **/
    @GetMapping
    public String review() {

        return "main/review/review";
    }

    @ResponseBody
    @PostMapping
    public String saveReview() {


        return null;
    }
}
