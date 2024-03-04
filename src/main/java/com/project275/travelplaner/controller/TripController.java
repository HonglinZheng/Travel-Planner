package com.project275.travelplaner.controller;

import com.project275.travelplaner.entity.Trip;
import com.project275.travelplaner.entity.User;
import com.project275.travelplaner.service.TripService;
import com.project275.travelplaner.service.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@Controller
@RequestMapping("/trip")
public class TripController {

    @Autowired
    UserService userService;

    @Autowired
    TripService tripService;

    @GetMapping("/add")
    public String gotoAddTrip() {
        return "AddTrip";
    }

    @PostMapping("/add")
    public String addTrip(Trip trip, @RequestParam String start_date, @RequestParam String end_date, ModelMap model, HttpSession session) {
        return tripService.addTrip(trip, start_date, end_date, model, session);
    }

    @GetMapping("/share/{id}")
    public String gotoShareTrip(@PathVariable int id, ModelMap model) {
        model.put("id", id);
        return "ShareTrip";
    }

    @PostMapping("/share/{id}")
    public String shareTrip(@PathVariable int id, @RequestParam String email, ModelMap model, HttpSession session) {
        return tripService.shareTrip(id, email, model, session);
    }

    @GetMapping("/delete/{id}")
    public String deleteTrip(@PathVariable int id, ModelMap model, HttpSession session){
        return tripService.deleteTrip(id, model, session);
    }

    @GetMapping("/edit/{id}")
    public String gotoEditTrip(@PathVariable int id, ModelMap model, HttpSession session){
        return tripService.gotoEditTrip(id, model, session);
    }

    @PostMapping("/update")
    public String updateTrip(Trip trip, @RequestParam String start_date, @RequestParam String end_date, ModelMap model, HttpSession session) {
        return tripService.updateTrip(trip, start_date, end_date, model, session);
    }

    @GetMapping("/view/{id}")
    public String viewItinerary(@PathVariable int id, ModelMap model, HttpSession session){
        return tripService.viewItinerary(id, model, session);
    }

    @GetMapping("/home")
    public String gotoUserHome(ModelMap model, HttpSession session){
        return tripService.gotoUserHome(model, session);
    }
}
