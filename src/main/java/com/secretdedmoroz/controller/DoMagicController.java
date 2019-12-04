package com.secretdedmoroz.controller;

import static com.secretdedmoroz.controller.cookie.CookieName.CURRENT_PARTY_URL;

import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.secretdedmoroz.controller.cookie.CookieService;
import com.secretdedmoroz.model.User;
import com.secretdedmoroz.service.EmailService;
import com.secretdedmoroz.service.MagicService;

@Controller
public class DoMagicController {

    @Resource
    private MagicService magicService;
    @Resource
    private CookieService cookieService;
    @Resource
    private EmailService emailService;

    @GetMapping("/doMagic")
    public String doMagic(HttpServletRequest request) {
        Map<User, User> pares = magicService.doMagic(cookieService.getCookieValue(request, CURRENT_PARTY_URL));
        emailService.sendEmails(pares);
        return "theEnd";
    }

}
