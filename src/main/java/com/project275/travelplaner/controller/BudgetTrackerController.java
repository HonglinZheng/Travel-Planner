package com.project275.travelplaner.controller;

import com.project275.travelplaner.repository.BudgetTrackerRepository;
import com.project275.travelplaner.repository.TripRepository;
import com.project275.travelplaner.service.BudgetTrackerService;
import com.project275.travelplaner.service.TripService;
import com.project275.travelplaner.entity.BudgetTracker;
import com.project275.travelplaner.entity.Trip;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.PathVariable;



@Controller
@RequestMapping("/trip")
public class BudgetTrackerController {
    @Autowired
    TripService tripService;
    @Autowired
    BudgetTrackerService budgetTrackerService;
    @Autowired
    private TripRepository tripRepo;

    @GetMapping("/editBudget/{tripId}")
    public String getBudget(@PathVariable int tripId, ModelMap model) {
        return budgetTrackerService.editBudget(tripId, model);
    }

    @PostMapping("/editBudget/{tripId}")
    public String editBudget(@PathVariable int tripId, BudgetTracker budgetTracker, ModelMap model, HttpSession session){
        return budgetTrackerService.addBudget(tripId, budgetTracker, model, session);
    }
}
