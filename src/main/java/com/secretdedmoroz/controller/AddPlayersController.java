package com.secretdedmoroz.controller;

import com.secretdedmoroz.controller.cookie.CookieService;
import com.secretdedmoroz.model.User;
import com.secretdedmoroz.service.PartyService;
import com.secretdedmoroz.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static com.secretdedmoroz.controller.cookie.CookieName.CURRENT_PARTY_URL;

@Controller
public class AddPlayersController {

    @Resource
    private PartyService partyService;
    @Resource
    private UserService userService;
    @Resource
    private CookieService cookieService;

    @GetMapping("/addPlayers")
    public String addPlayers(HttpServletRequest request, @RequestParam String players) {
        Set<User> users = parsePlayers(players);
        partyService.addPlayersToParty(cookieService.getCookieValue(request, CURRENT_PARTY_URL), users);
        return "party";
    }

    private Set<User> parsePlayers(final String players) {
        String[] pares = players.split(";");
        Set<User> users = new HashSet<>();
        Arrays.stream(pares).forEach(p -> users.add(new User(p.split("=")[0], p.split("=")[1])));
        return users;
    }

}
