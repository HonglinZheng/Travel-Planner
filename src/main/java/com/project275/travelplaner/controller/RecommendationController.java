package com.project275.travelplaner.controller;

import com.project275.travelplaner.service.ItineraryService;
import com.project275.travelplaner.service.RecommendationService;
import com.project275.travelplaner.service.TripService;
import com.project275.travelplaner.service.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/itinerary")
public class RecommendationController {
    @Autowired
    UserService userService;
    @Autowired
    TripService tripService;
    @Autowired
    ItineraryService itineraryService;
    @Autowired
    RecommendationService recommendationService;
    @GetMapping("/search/{tripId}")
    public String search(@PathVariable int tripId, ModelMap model, HttpSession session){
        return recommendationService.search(tripId, model, session);
    }


    @GetMapping("/recommendation/{tripId}")
    public String getRecommendation(@PathVariable int tripId, @RequestParam String city, ModelMap model, HttpSession session){
        return recommendationService.getRecommendation(tripId, city, model, session);
    }
}
