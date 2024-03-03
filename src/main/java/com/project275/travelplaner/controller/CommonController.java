package com.project275.travelplaner.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CommonController {
    @GetMapping("/")
    public String gotoHome()
    {
        return "Home";
    }

    @GetMapping("/logout")
    public String logout(HttpSession httpSession, ModelMap map)
    {
        httpSession.invalidate();
        map.put("pos", "Logged out Successfully");
        return "Home";
    }
}
