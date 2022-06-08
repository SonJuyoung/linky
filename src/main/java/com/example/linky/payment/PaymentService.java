package com.example.linky.payment;

import com.example.linky.apply.model.AnswerListVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;

@Service
public class PaymentService {
    @Autowired
    private HttpSession hs;

    public AnswerListVo getAnswerListVoFromSession() {
        AnswerListVo result = null;
        try {
            result = (AnswerListVo) hs.getAttribute("test");
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }
}
