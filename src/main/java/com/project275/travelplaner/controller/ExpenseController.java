package com.project275.travelplaner.controller;

import com.project275.travelplaner.entity.Expense;
import com.project275.travelplaner.repository.TripRepository;
import com.project275.travelplaner.service.ExpenseService;
import com.project275.travelplaner.service.TripService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/itinerary")
public class ExpenseController {
    @Autowired
    TripService tripService;
    @Autowired
    ExpenseService expenseService;
    @Autowired
    private TripRepository tripRepo;

    @GetMapping("/expenseLog/{tripId}/{itineraryId}")
    public String getExpense(@PathVariable int tripId, @PathVariable int itineraryId, ModelMap model) {
        return expenseService.editExpense(tripId, itineraryId, model);
    }

    @PostMapping("/expenseLog/{tripId}/{itineraryId}")
    public String editExpense(@PathVariable int tripId, @PathVariable int itineraryId, Expense expenseLog, ModelMap model, HttpSession session){
        return expenseService.addExpense(tripId, itineraryId, expenseLog, model, session);
    }
}
