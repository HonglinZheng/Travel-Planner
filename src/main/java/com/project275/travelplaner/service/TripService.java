package com.project275.travelplaner.service;

import com.project275.travelplaner.entity.Trip;
import com.project275.travelplaner.entity.User;
import com.project275.travelplaner.repository.TripRepository;
import com.project275.travelplaner.repository.UserRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import java.time.LocalDate;

@Service
public class TripService {
    @Autowired
    private UserRepository userRepo;

    @Autowired
    private TripRepository tripRepo;

    public String addTrip(Trip trip, String start_date, String end_date, ModelMap model, HttpSession session){
        if (session.getAttribute("user") == null) {
            model.put("neg", "Invalid Session");
            return "Home";
        } else{
            User user = (User) session.getAttribute("user");
            User user1 = userRepo.findById(user.getId()).get();
            trip.setStartDate(LocalDate.parse(start_date));
            trip.setEndDate(LocalDate.parse(end_date));
            trip.getUsers().add(user1);
            user1.getTrips().add(trip);
            tripRepo.save(trip);
            userRepo.save(user1);
            model.put("pos", "Trip Added Successfully");
            model.put("trips", user1.getTrips());
            return "UserHome";
        }
    }

    public String shareTrip(int id, String email, ModelMap model, HttpSession session){
        if (session.getAttribute("user") == null) {
            model.put("neg", "Invalid Session");
            return "Home";
        } else{
            User user = userRepo.findByEmail(email);
            if (user == null) {
                model.put("neg", "Something Went Wrong");
                return "UserHome";
            }
            Trip trip = tripRepo.findById(id).get();
            trip.getUsers().add(user);
            user.getTrips().add(trip);
            tripRepo.save(trip);
            userRepo.save(user);
            model.put("pos", "Trip Shared Successfully");
            int curId = ((User) session.getAttribute("user")).getId();
            User curUser = userRepo.findById(curId).get();
            model.put("trips", curUser.getTrips());
            return "UserHome";
        }
    }
}
