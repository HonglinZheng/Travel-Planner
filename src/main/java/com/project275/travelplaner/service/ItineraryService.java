package com.project275.travelplaner.service;

import com.project275.travelplaner.entity.Itinerary;
import com.project275.travelplaner.entity.Trip;
import com.project275.travelplaner.entity.User;
import com.project275.travelplaner.repository.ItineraryRepository;
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
            return "ViewItineraries";
        }
        itinerary.setDate(date);
        itinerary.setTrip(trip);
        itineraryRepo.save(itinerary);

        trip.getItineraries().add(itinerary);
        tripRepo.save(trip);

        model.put("pos", "Itinerary Added Successfully");
        model.put("itineraries", trip.getItineraries());
        model.put("tripId", tripId);
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
        return "ViewItineraries";
    }

    public String gotoEditItinerary(int tripId, int itineraryId, ModelMap model, HttpSession session){
        if (session.getAttribute("user") == null) {
            model.put("neg", "Invalid Session");
            return "Home";
        }
        Itinerary itinerary = itineraryRepo.findById(itineraryId).orElse(null);
        model.put("tripId", tripId);
        model.put("itinerary", itinerary);
        return "EditItinerary";
    }

    public String updateItinerary(int tripId, String idate, Itinerary itinerary, ModelMap model, HttpSession session){
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
            return "ViewItineraries";
        }
        itinerary.setDate(date);
        itinerary.setTrip(trip);
        itineraryRepo.save(itinerary);

        model.put("pos", "Itinerary Updated Successfully");
        model.put("itineraries", trip.getItineraries());
        model.put("tripId", tripId);
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
        return "ViewItineraries";
    }
}
