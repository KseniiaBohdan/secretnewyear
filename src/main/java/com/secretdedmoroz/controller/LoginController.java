package com.secretdedmoroz.controller;

import com.secretdedmoroz.controller.data.LoginData;
import com.secretdedmoroz.service.PartyService;
import com.secretdedmoroz.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import static com.secretdedmoroz.controller.cookie.CookieName.CURRENT_PARTY_URL;
import static com.secretdedmoroz.controller.cookie.CookieName.CURRENT_USER;

@Controller
public class LoginController {

    @Resource
    private UserService userService;
    @Resource
    private PartyService partyService;

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @PostMapping("/addPlayers")
    public String createPartyAndAddPlayers(@ModelAttribute("loginData") LoginData loginData, HttpServletResponse response) {
        userService.createNewUser(loginData.getUserName(), loginData.getEmail());
        String partyUrl = partyService.createParty(loginData.getEmail(), loginData.getPartyName());

        response.addCookie(new Cookie(CURRENT_USER, loginData.getEmail()));
        response.addCookie(new Cookie(CURRENT_PARTY_URL, partyUrl));

        return "addPlayers";
    }

}