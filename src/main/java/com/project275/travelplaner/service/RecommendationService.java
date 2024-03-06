package com.project275.travelplaner.service;
import java.util.*;

import com.project275.travelplaner.entity.Recommendation;
import com.project275.travelplaner.repository.RecommendationRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

@Service
public class RecommendationService {
    @Autowired
    private RecommendationRepository RecommendationRepo;

    public String search(int tripId, ModelMap model, HttpSession session){
        model.put("tripId", tripId);
        return "Search";
    }

    public String getRecommendation(int tripId, String city, ModelMap model, HttpSession session){
        List<Recommendation> recommendations = RecommendationRepo.findByCity(city);
        model.addAttribute("recommendations", recommendations);
//        model.put("recommendations", recommendations);
        model.put("tripId", tripId);
        model.put("city", city);
        return "Recommendations";
    }
}
