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

    public String gotoEditExpense(int tripId, int itineraryId, ModelMap model){
        Itinerary itinerary = itineraryRepo.findById(itineraryId).orElse(null);
        Trip trip = tripRepo.findById(tripId).orElse(null);
        if (itinerary == null) {
            model.put("itineraries", trip.getItineraries());
            model.put("tripId", tripId);
            model.put("trip", trip);
            model.put("budget", trip.getBudget());
            return "ViewItineraries";
        }
        model.put("name", itinerary.getName());
        model.put("itinerary", itinerary);
        model.put("expenseLog", itinerary.getExpenseLog());
        return "AddExpense";
    }

    public String updateExpense(int tripId, int itineraryId, Expense expenseLog_o, ModelMap model, HttpSession session){
        if (session.getAttribute("user") == null) {
            model.put("neg", "Invalid Session");
            return "Home";
        }
        Trip trip = tripRepo.findById(tripId).orElse(null);
        Itinerary itinerary = itineraryRepo.findById(itineraryId).orElse(null);
        itinerary.setExpenseSum(expenseLog_o.getSum());
        Expense expense = itinerary.getExpenseLog();
        expense.copy(expenseLog_o);
        expenseRepo.save(expense);
        model.put("pos", "Expenses are Logged Successfully");
        model.put("itineraries", trip.getItineraries());
        model.put("trip", trip);
        model.put("budget", trip.getBudget());
        return "ViewItineraries";
    }
}
