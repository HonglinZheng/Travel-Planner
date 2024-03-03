package com.project275.travelplaner.controller;

import com.project275.travelplaner.entity.Trip;
import com.project275.travelplaner.service.TripService;
import com.project275.travelplaner.service.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/trip")
public class TripController {

    @Autowired
    UserService userService;

    @Autowired
    TripService tripService;

    @GetMapping("/addTrip")
    public String gotoSignup() {
        return "Signup";
    }

    @PostMapping("/addTrip")
    public String gotoSignup(Trip trip, ModelMap model, HttpSession session) {
        return tripService.addTrip(trip, model, session);
    }
}
