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
import java.util.HashSet;
import java.util.*;

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
        }
        int curId = (int) session.getAttribute("user");
        User curUser = userRepo.findById(curId).get();
        LocalDate startDate = LocalDate.parse(start_date);
        LocalDate endDate = LocalDate.parse(end_date);
        if (startDate.isAfter(endDate)){
            model.put("neg", "Start Date Cannot Be After End Date");
            model.put("trips", curUser.getTrips());
            model.put("userName", curUser.getName());
            return "UserHome";
        }
        trip.setStartDate(startDate);
        trip.setEndDate(endDate);
        trip.getUsers().add(curUser);
        curUser.getTrips().add(trip);
        tripRepo.save(trip);
        userRepo.save(curUser);
        model.put("pos", "Trip Added Successfully");
        model.put("trips", curUser.getTrips());
        model.put("userName", curUser.getName());
        return "UserHome";
    }

    public String shareTrip(int id, String email, ModelMap model, HttpSession session){
        if (session.getAttribute("user") == null) {
            model.put("neg", "Invalid Session");
            return "Home";
        }
        int curId = (int) session.getAttribute("user");;
        User curUser = userRepo.findById(curId).get();
        User user = userRepo.findByEmail(email);
        if (user == null) {
            model.put("neg", "The User Doesn't Exist");
            model.put("trips", curUser.getTrips());
            model.put("userName", curUser.getName());
            return "UserHome";
        }
        Trip trip = tripRepo.findById(id).get();
        trip.getUsers().add(user);
        user.getTrips().add(trip);
        tripRepo.save(trip);
        userRepo.save(user);
        model.put("pos", "Trip Shared Successfully");
        model.put("trips", curUser.getTrips());
        model.put("userName", curUser.getName());
        return "UserHome";
    }

    public String deleteTrip(int id, ModelMap model, HttpSession session){
        if (session.getAttribute("user") == null) {
            model.put("neg", "Invalid Session");
            return "Home";
        }
        int curUserId = (int) session.getAttribute("user");;
        User curUser = userRepo.findById(curUserId).get();
        Trip trip = tripRepo.findById(id).orElse(null);
        if (trip == null){
            model.put("neg", "Trip Not Found");
            model.put("trips", curUser.getTrips());
            model.put("userName", curUser.getName());
            return "UserHome";
        }
        Set<Trip> nTrips = new HashSet<>();
        for(Trip t : curUser.getTrips()){
            if(t.getId() != id) nTrips.add(t);
        }
        curUser.setTrips(nTrips);
        userRepo.save(curUser);
//      tripRepo.deleteById(id);
        model.put("pos", "Trip Deleted Successfully");
        curUser = userRepo.findById(curUserId).get();
        model.put("trips", curUser.getTrips());
        model.put("userName", curUser.getName());
        return "UserHome";
    }

    public String gotoEditTrip(int id, ModelMap model, HttpSession session){
        if (session.getAttribute("user") == null) {
            model.put("neg", "Invalid Session");
            return "Home";
        }
        int curUserId = (int) session.getAttribute("user");;
        User curUser = userRepo.findById(curUserId).get();
        Trip trip = tripRepo.findById(id).orElse(null);
        if (trip == null){
            model.put("neg", "Trip Not Found");
            model.put("trips", curUser.getTrips());
            model.put("userName", curUser.getName());
            return "UserHome";
        } else{
            model.put("trip", trip);
            return "EditTrip";
        }
    }

    public String updateTrip(Trip trip, String start_date, String end_date, ModelMap model, HttpSession session){
        if (session.getAttribute("user") == null) {
            model.put("neg", "Invalid Session");
            return "Home";
        }
        int curUserId = (int) session.getAttribute("user");;
        User curUser = userRepo.findById(curUserId).get();
        LocalDate startDate = LocalDate.parse(start_date);
        LocalDate endDate = LocalDate.parse(end_date);
        if (startDate.isAfter(endDate)){
            model.put("neg", "Start Date Cannot Be After End Date");
            model.put("trips", curUser.getTrips());
            model.put("userName", curUser.getName());
            return "UserHome";
        }
        Trip oTrip = tripRepo.findById(trip.getId()).orElse(null);
        oTrip.setName(trip.getName());
        oTrip.setBudget(trip.getBudget());
        oTrip.setStartDate(LocalDate.parse(start_date));
        oTrip.setEndDate(LocalDate.parse(end_date));
        tripRepo.save(oTrip);
        model.put("pos", "Book Updated Successfully");
        curUser = userRepo.findById(curUserId).get();
        model.put("trips", curUser.getTrips());
        model.put("userName", curUser.getName());
        return "UserHome";
    }

    public String gotoUserHome(ModelMap model, HttpSession session){
        if (session.getAttribute("user") == null) {
            model.put("neg", "Invalid Session");
            return "Home";
        }
        int curUserId = (int) session.getAttribute("user");
        User curUser = userRepo.findById(curUserId).get();
        model.put("trips", curUser.getTrips());
        model.put("userName", curUser.getName());
        return "UserHome";
    }

    public String viewItinerary(int id, ModelMap model, HttpSession session){
        if (session.getAttribute("user") == null) {
            model.put("neg", "Invalid Session");
            return "Home";
        }
        Trip trip = tripRepo.findById(id).orElse(null);
        model.put("itineraries", trip.getItineraries());
        model.put("tripId", trip.getId());
        model.put("trip",trip);
        model.put("budget", trip.getBudget());
        return "ViewItineraries";
    }

    public String gotoShareTrip(int id, ModelMap model) {
        model.put("id", id);
        Trip trip = tripRepo.findById(id).get();
        Set<User> users = trip.getUsers();
        List<String> names = new ArrayList<>();
        for (User user: users){
            names.add(user.getName());
        }
        model.put("names", names);
        return "ShareTrip";
    }
}
