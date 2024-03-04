package com.project275.travelplaner.controller;

import com.project275.travelplaner.entity.LoginInfo;
import com.project275.travelplaner.entity.User;
import com.project275.travelplaner.service.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/signup")
    public String gotoSignup() {
        return "Signup";
    }

    @GetMapping("/login")
    public String gotoLogin() {
        return "Login";
    }

    @PostMapping("/signup")
    public String signup(User user, ModelMap model)
            throws IOException {
        return userService.signup(user, model);
    }

    @PostMapping("/login")
    public String login(LoginInfo info, ModelMap model, HttpSession session) {
        return userService.login(info, model, session);
    }
}
