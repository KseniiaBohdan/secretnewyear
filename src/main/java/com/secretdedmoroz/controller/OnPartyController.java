package com.secretdedmoroz.controller;

import static com.secretdedmoroz.controller.cookie.CookieName.CURRENT_PARTY_URL;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.secretdedmoroz.controller.cookie.CookieService;
import com.secretdedmoroz.model.Party;
import com.secretdedmoroz.service.PartyService;

@Controller
public class OnPartyController {

    @Resource
    private PartyService partyService;
    @Resource
    private CookieService cookieService;

    @GetMapping("/onParty")
    public ModelAndView onParty(ModelMap model, HttpServletRequest request, HttpServletResponse response) {
        Party party = partyService.getPartyByUrl(cookieService.getCookieValue(request, CURRENT_PARTY_URL));
        model.addAttribute("players", party.getPlayers());
        return new ModelAndView("/party.html", model);
    }

}
