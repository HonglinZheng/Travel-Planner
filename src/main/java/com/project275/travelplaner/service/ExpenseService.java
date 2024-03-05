package com.project275.travelplaner.service;

import com.project275.travelplaner.entity.*;
import com.project275.travelplaner.repository.BudgetTrackerRepository;
import com.project275.travelplaner.repository.TripRepository;
import com.project275.travelplaner.repository.UserRepository;
import com.project275.travelplaner.repository.ExpenseRepository;
import com.project275.travelplaner.repository.ItineraryRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;

@Service
public class ExpenseService {
    @Autowired
    private TripRepository tripRepo;
    @Autowired
    private ItineraryRepository itineraryRepo;
    @Autowired
    private ExpenseRepository expenseRepo;
    @Autowired
    private UserRepository userRepo;

    public String editExpense(@PathVariable int tripId, @PathVariable int itineraryId, ModelMap model){
//        Trip trip = tripRepo.findById(tripId).orElse(null);
        Itinerary itinerary = itineraryRepo.findById(itineraryId).orElse(null);
        Expense expenseLog = new Expense();
        if (itinerary != null) {
            expenseLog = itinerary.getExpenseLog();
            if (expenseLog == null) {
                expenseLog = new Expense();
                expenseLog.setItinerary(itinerary);
                itinerary.setExpenseLog(expenseLog);
                expenseRepo.save(expenseLog);
            }
        }
        model.put("name", itinerary.getName());
        model.put("expenseLog", expenseLog);
        model.put("itinerary", itinerary);
        return "AddExpense";
    }

    public String addExpense(int tripId, int itineraryId, Expense expenseLog, ModelMap model, HttpSession session){
        if (session.getAttribute("user") == null) {
            model.put("neg", "Invalid Session");
            return "Home";
        }

        Trip trip = tripRepo.findById(tripId).orElse(null);
        expenseRepo.save(expenseLog);
        model.put("pos", "Expenses are Logged Successfully");
        model.put("itineraries", trip.getItineraries());
        return "ViewItineraries";
    }
}
