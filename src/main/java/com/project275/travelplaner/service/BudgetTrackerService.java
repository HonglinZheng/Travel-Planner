package com.project275.travelplaner.service;

import com.project275.travelplaner.entity.*;
import com.project275.travelplaner.repository.TripRepository;
import com.project275.travelplaner.repository.UserRepository;
import com.project275.travelplaner.repository.BudgetTrackerRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;

@Service
public class BudgetTrackerService {
    @Autowired
    private TripRepository tripRepo;
    @Autowired
    private BudgetTrackerRepository budgetTrackerRepo;
    @Autowired
    private UserRepository userRepo;

    public String editBudget(@PathVariable int tripId, ModelMap model){
        Trip trip = tripRepo.findById(tripId).orElse(null);
        BudgetTracker budgetTracker = new BudgetTracker();
        if (trip != null) {
            budgetTracker = trip.getBudgetTrack();
            if (budgetTracker == null) {
                budgetTracker = new BudgetTracker();
                budgetTracker.setTotalBudget(trip.getBudget());
                budgetTracker.setTrip(trip);
                trip.setBudgetTrack(budgetTracker);
                budgetTrackerRepo.save(budgetTracker);
            }
        }

        model.put("name", trip.getName());
        model.put("budget", trip.getBudget());
        model.put("budgetTracker", budgetTracker);
        return "addBudget";
    }

    public String addBudget(int tripId, BudgetTracker budgetTracker, ModelMap model, HttpSession session){
        if (session.getAttribute("user") == null) {
            model.put("neg", "Invalid Session");
            return "Home";
        }
        int curId = (int) session.getAttribute("user");
        User curUser = userRepo.findById(curId).get();

        Trip trip = tripRepo.findById(tripId).orElse(null);
        if (budgetTracker.sum() > trip.getBudget()){
            model.put("neg", "Sum of detailed budget should not be greater than the total budget");
            model.put("trips", curUser.getTrips());
            return "UserHome";
        }

        budgetTrackerRepo.save(budgetTracker);
        model.put("pos", "Budget Tracker Added Successfully");
        model.put("trips", curUser.getTrips());
        return "UserHome";
    }
}
