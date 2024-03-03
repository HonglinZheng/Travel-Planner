package com.project275.travelplaner.controller;

import com.project275.travelplaner.entity.Trip;
import com.project275.travelplaner.service.TripService;
import com.project275.travelplaner.service.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/trip")
public class TripController {

    @Autowired
    UserService userService;

    @Autowired
    TripService tripService;

    @GetMapping("/addTrip")
    public String gotoAddTrip() {
        return "AddTrip";
    }

    @PostMapping("/addTrip")
    public String addTrip(Trip trip, @RequestParam String start_date, @RequestParam String end_date, ModelMap model, HttpSession session) {
        return tripService.addTrip(trip, start_date, end_date, model, session);
    }

    @GetMapping("/shareTrip/{id}")
    public String gotoShareTrip(@PathVariable int id, ModelMap model) {
        model.put("id", id);
        return "ShareTrip";
    }

    @PostMapping("/shareTrip/{id}")
    public String shareTrip(@PathVariable int id, @RequestParam String email, ModelMap model, HttpSession session) {
        return tripService.shareTrip(id, email, model, session);
    }
}
