package com.secretdedmoroz.controller;

import static com.secretdedmoroz.controller.cookie.CookieName.CURRENT_PARTY_URL;
import static java.util.Objects.nonNull;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.secretdedmoroz.controller.cookie.CookieService;
import com.secretdedmoroz.model.Room;
import com.secretdedmoroz.service.RoomService;

@Controller
public class InRoomController {

    @Resource
    private RoomService roomService;
    @Resource
    private CookieService cookieService;

    @GetMapping("/in-room")
    public ModelAndView inRoom(HttpServletRequest request, HttpServletResponse response) {
        Room room = roomService.getRoomByUrl(cookieService.getCookieValue(request, CURRENT_PARTY_URL));
        if (nonNull(room)) {
            return new ModelAndView("/inRoom.html");
        } else {
            return new ModelAndView("/error");
        }
    }
}
