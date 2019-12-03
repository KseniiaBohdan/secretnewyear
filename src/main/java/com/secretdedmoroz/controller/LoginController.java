package com.secretdedmoroz.controller;

import static java.util.Objects.nonNull;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

import com.secretdedmoroz.model.User;
import com.secretdedmoroz.service.UserService;

@Controller
public class LoginController {

    @Resource
    private UserService userService;

    @PostMapping("/login")
    public RedirectView login(@ModelAttribute("user") User user, HttpServletResponse response) {
        User newUser = userService.createNewUser(user.getName(), user.getEmail());
        response.addCookie(new Cookie("currentUser", user.getEmail()));
        if (nonNull(newUser)) {
            return new RedirectView("/create-room");
        } else {
            return new RedirectView("error");
        }
    }

}