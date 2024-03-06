package com.project275.travelplaner.controller;

import com.project275.travelplaner.entity.Itinerary;
import com.project275.travelplaner.service.ItineraryService;
import com.project275.travelplaner.service.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/itinerary")
public class ItineraryController {

    @Autowired
    UserService userService;

    @Autowired
    ItineraryService itineraryService;

    @GetMapping("/add/{tripId}")
    public String gotoAddItinerary(@PathVariable int tripId, ModelMap model) {
        model.put("tripId", tripId);
        return "AddItinerary";
    }

    @PostMapping("/add/{tripId}")
    public String addItinerary(@PathVariable int tripId, @RequestParam String idate, Itinerary itinerary, ModelMap model, HttpSession session) {
        return itineraryService.addItinerary(tripId, idate, itinerary, model, session);
    }


    @GetMapping("/delete/{tripId}/{itineraryId}")
    public String deleteTrip(@PathVariable int tripId, @PathVariable int itineraryId, ModelMap model, HttpSession session){
        return itineraryService.deleteItinerary(tripId, itineraryId, model, session);
    }

    @GetMapping("/edit/{tripId}/{itineraryId}")
    public String gotoEditTrip(@PathVariable int tripId, @PathVariable int itineraryId, ModelMap model, HttpSession session){
        return itineraryService.gotoEditItinerary(tripId, itineraryId, model, session);
    }

    @PostMapping("/update/{tripId}")
    public String updateTrip(@PathVariable int tripId, @RequestParam String idate, Itinerary itinerary, ModelMap model, HttpSession session){
        return itineraryService.updateItinerary(tripId, idate, itinerary, model, session);
    }
    @GetMapping("/home/{tripId}")
    public String goToTripHome(@PathVariable int tripId, ModelMap model, HttpSession session){
        return itineraryService.goToTripHome(tripId, model, session);
    }

    @RequestMapping("/generate/{tripId}/{recommendationId}")
    public String generateItinerary(@PathVariable int tripId, @PathVariable int recommendationId, ModelMap model, HttpSession session){
        return itineraryService.generate(tripId, recommendationId, model, session);
    }
}
