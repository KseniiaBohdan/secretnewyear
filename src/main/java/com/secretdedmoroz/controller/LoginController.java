package com.secretdedmoroz.controller;

import static com.secretdedmoroz.controller.cookie.CookieName.CURRENT_PARTY_URL;
import static com.secretdedmoroz.controller.cookie.CookieName.CURRENT_USER;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

import com.secretdedmoroz.controller.data.LoginData;
import com.secretdedmoroz.service.PartyService;
import com.secretdedmoroz.service.UserService;


@Controller
public class LoginController {

    @Resource
    private UserService userService;
    @Resource
    private PartyService partyService;

    @PostMapping("/createPartyAndAddPlayers")
    public RedirectView createPartyAndAddPlayers(@ModelAttribute("loginData") LoginData loginData, HttpServletResponse response) {
        userService.createNewUser(loginData.getUserName(), loginData.getEmail());
        String partyUrl = partyService.createParty(loginData.getEmail(), loginData.getPartyName());

        response.addCookie(new Cookie(CURRENT_USER, loginData.getEmail()));
        response.addCookie(new Cookie(CURRENT_PARTY_URL, partyUrl));

        return new RedirectView("/addPlayers.html");
    }

}