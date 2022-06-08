package com.example.linky.apply;

import com.example.linky.apply.model.AnswerListVo;
import com.example.linky.apply.model.AnswerVo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/apply")
public class ApplyController {

    @GetMapping
    public String apply() {

        return "apply/apply";
    }

    @PostMapping
    public String applyProc(AnswerListVo listVo) {
        for(AnswerVo item : listVo.getAnswerVoList()) {
            System.out.println(item.getAnswer());
        }
        return "redirect:/";
    }
}
