package com.project275.travelplaner.service;

import com.project275.travelplaner.entity.Trip;
import com.project275.travelplaner.repository.TripRepository;
import com.project275.travelplaner.repository.UserRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

@Service
public class TripService {
    @Autowired
    private UserRepository userRepo;

    @Autowired
    private TripRepository tripRepo;

    public String addTrip(Trip trip, ModelMap model, HttpSession session){
        if (session.getAttribute("user") == null) {
            model.put("neg", "Invalid Session");
            return "Home";
        } else{
            tripRepo.save(trip);
            model.put("pos", "Trip Added Successfully");
            return "UserHome";
        }
    }
}
