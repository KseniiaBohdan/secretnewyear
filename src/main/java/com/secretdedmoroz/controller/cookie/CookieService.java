package com.secretdedmoroz.controller.cookie;

import static java.util.Objects.nonNull;

import java.util.Arrays;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

@Service
public class CookieService {

    public String getCookieValue(HttpServletRequest request, String cookieName) {
        Cookie cookie = Arrays.stream(request.getCookies()).filter(c -> c.getName().equals(cookieName)).findFirst().orElse(null);
        if (nonNull(cookie)) {
            return cookie.getValue();
        } else {
            return null;
        }
    }
}
