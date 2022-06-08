package com.example.linky.apply;

import com.example.linky.apply.model.AnswerListVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/apply")
public class ApplyController {

    @GetMapping
    public String apply() {

        return "apply/apply";
    }

    @PostMapping
    public String applyProc(AnswerListVo listVo, HttpSession hs) {
        hs.setAttribute("test", listVo);
        return "redirect:/apply";
    }
}
