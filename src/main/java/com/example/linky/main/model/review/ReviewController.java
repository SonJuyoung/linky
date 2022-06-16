package com.example.linky.main.model.review;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Controller
@RequestMapping("/review")
public class ReviewController {

    @Autowired private ReviewService reviewService;

    /** 팝업 **/
    @GetMapping
    public String review() {

        return "main/review/review";
    }

    @PostMapping
    public String saveReview(ReviewVo review) {
        reviewService.insFileInFolder(review);

        return "redirect:/review/proc";
    }

    @GetMapping("/proc")
    public String saveProc() {

        return "main/review/proc";
    }
}
