package com.secretdedmoroz.controller;

import static com.secretdedmoroz.controller.cookie.CookieName.CURRENT_PARTY_URL;
import static com.secretdedmoroz.controller.cookie.CookieName.CURRENT_USER;
import static java.util.Objects.nonNull;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.secretdedmoroz.controller.cookie.CookieService;
import com.secretdedmoroz.model.Room;
import com.secretdedmoroz.service.RoomService;
import com.secretdedmoroz.service.UserService;

@Controller
public class CreateRoomController {

    @Resource
    private RoomService roomService;
    @Resource
    private UserService userService;
    @Resource
    private CookieService cookieService;

    @GetMapping("/create-room")
    public ModelAndView createRoom(HttpServletRequest request) {
        String currentUserEmail = cookieService.getCookieValue(request, CURRENT_USER);
        if (nonNull(currentUserEmail)) {
            return new ModelAndView("/createRoom.html");
        } else {
            return new ModelAndView("/error");
        }
    }

    @PostMapping("/room-creation")
    public RedirectView createRoom(HttpServletRequest request, HttpServletResponse response, @ModelAttribute("room") Room room) {
        String currentUserEmail = cookieService.getCookieValue(request, CURRENT_USER);
        if (nonNull(currentUserEmail)) {
            String roomUrl = roomService.createRoom(currentUserEmail, room.getRoomName());
            response.addCookie(new Cookie(CURRENT_PARTY_URL, roomUrl));
            return new RedirectView("/in-room");
        } else {
            return new RedirectView("/error");
        }
    }
}
