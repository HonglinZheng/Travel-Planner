package com.project275.travelplaner.service;

import com.project275.travelplaner.entity.*;
import com.project275.travelplaner.repository.ExpenseRepository;
import com.project275.travelplaner.repository.ItineraryRepository;
import com.project275.travelplaner.repository.RecommendationRepository;
import com.project275.travelplaner.repository.TripRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class ItineraryService {
    @Autowired
    private TripRepository tripRepo;

    @Autowired
    private ItineraryRepository itineraryRepo;

    @Autowired
    private ExpenseRepository expenseRepo;

    @Autowired
    private RecommendationRepository recommendationRepo;


    public String addItinerary(int tripId, String idate, Itinerary itinerary, ModelMap model, HttpSession session){
        if (session.getAttribute("user") == null) {
            model.put("neg", "Invalid Session");
            return "Home";
        }
        Trip trip = tripRepo.findById(tripId).orElse(null);
        LocalDate startDate = trip.getStartDate();
        LocalDate endDate = trip.getEndDate();
        LocalDate date = LocalDate.parse(idate);
        if(date.isBefore(startDate) || date.isAfter(endDate)){
            model.put("neg", "Itinerary Date Not In Trip Date Range");
            model.put("itineraries", trip.getItineraries());
            model.put("tripId", tripId);
            model.put("trip", trip);
            model.put("budget", trip.getBudget());
            return "ViewItineraries";
        }
        Expense expense = new Expense();
        expenseRepo.save(expense);
        itinerary.setDate(date);
        itinerary.setTrip(trip);
        itinerary.setExpenseSum(0);
        itinerary.setExpenseLog(expense);
        itineraryRepo.save(itinerary);

        trip.getItineraries().add(itinerary);
        tripRepo.save(trip);

        model.put("pos", "Itinerary Added Successfully");
        model.put("itineraries", trip.getItineraries());
        model.put("tripId", tripId);
        model.put("trip", trip);
        model.put("budget", trip.getBudget());
        return "ViewItineraries";
    }

    public String deleteItinerary(int tripId, int itineraryId, ModelMap model, HttpSession session){
        if (session.getAttribute("user") == null) {
            model.put("neg", "Invalid Session");
            return "Home";
        }
        Trip trip = tripRepo.findById(tripId).orElse(null);
        List<Itinerary> nItineraries = new ArrayList<>();
        for(Itinerary i : trip.getItineraries()){
            if(i.getId() != itineraryId){
                nItineraries.add(i);
            }
        }
        trip.setItineraries(nItineraries);
        tripRepo.save(trip);
        itineraryRepo.deleteById(itineraryId);
        model.put("pos", "Itinerary Deleted Successfully");
        model.put("itineraries", trip.getItineraries());
        model.put("tripId", tripId);
        model.put("trip", trip);
        model.put("budget", trip.getBudget());
        return "ViewItineraries";
    }

    public String gotoEditItinerary(int tripId, int itineraryId, ModelMap model, HttpSession session){
        if (session.getAttribute("user") == null) {
            model.put("neg", "Invalid Session");
            return "Home";
        }
        Trip trip = tripRepo.findById(tripId).orElse(null);
        Itinerary itinerary = itineraryRepo.findById(itineraryId).orElse(null);
        model.put("tripId", tripId);
        model.put("itinerary", itinerary);
        model.put("trip", trip);
        return "EditItinerary";
    }

    public String updateItinerary(int tripId, String idate, Itinerary itinerary, ModelMap model, HttpSession session){
        if (session.getAttribute("user") == null) {
            model.put("neg", "Invalid Session");
            return "Home";
        }
        Trip trip = tripRepo.findById(tripId).orElse(null);
        Itinerary oItinerary = itineraryRepo.findById(itinerary.getId()).orElse(null);
        LocalDate startDate = trip.getStartDate();
        LocalDate endDate = trip.getEndDate();
        LocalDate date = LocalDate.parse(idate);
        if(date.isBefore(startDate) || date.isAfter(endDate)){
            model.put("neg", "Itinerary Date Not In Trip Date Range");
            model.put("itineraries", trip.getItineraries());
            model.put("tripId", tripId);
            model.put("trip", trip);
            model.put("budget", trip.getBudget());
            return "ViewItineraries";
        }
        itinerary.setExpenseLog(oItinerary.getExpenseLog());
        itinerary.setDate(date);
        itinerary.setTrip(trip);
        itineraryRepo.save(itinerary);

        model.put("pos", "Itinerary Updated Successfully");
        model.put("itineraries", trip.getItineraries());
        model.put("tripId", tripId);
        model.put("trip", trip);
        model.put("budget", trip.getBudget());
        return "ViewItineraries";
    }

    public String goToTripHome(@PathVariable int tripId, ModelMap model, HttpSession session){
        if (session.getAttribute("user") == null) {
            model.put("neg", "Invalid Session");
            return "Home";
        }
        Trip trip = tripRepo.findById(tripId).orElse(null);
        model.put("itineraries", trip.getItineraries());
        model.put("tripId", tripId);
        model.put("trip", trip);
        model.put("budget", trip.getBudget());
        return "ViewItineraries";
    }

    public String generate(@PathVariable int tripId, @PathVariable int recommendationId, ModelMap model, HttpSession session){
        Recommendation recommendation = recommendationRepo.findById(recommendationId).orElse(null);
        Trip trip = tripRepo.findById(tripId).orElse(null);
        LocalDate startDate = trip.getStartDate();
        Itinerary itinerary = new Itinerary();
        Expense expense = new Expense();
        expenseRepo.save(expense);
        itinerary.setExpenseSum(0);
        itinerary.setExpenseLog(expense);
        itinerary.setTrip(trip);
        itinerary.setDate(startDate);
        trip.getItineraries().add(itinerary);
        itinerary.setLocation(recommendation.getCity());
        itinerary.setName(recommendation.getRecommendation());
        itineraryRepo.save(itinerary);
        //model.addAttribute("generatedItinerary", itinerary);
        model.put("itineraries", trip.getItineraries());
        model.put("tripId", tripId);
        model.put("trip", trip);
        model.put("budget", trip.getBudget());
        return "ViewItineraries";
    }

    public String gotoAddItinerary(int tripId, ModelMap model) {
        Trip trip = tripRepo.findById(tripId).orElse(null);
        model.put("tripId", tripId);
        model.put("trip",trip);
        return "AddItinerary";
    }
}
