package com.project275.travelplaner.service;

import com.project275.travelplaner.entity.Recommend;
import com.project275.travelplaner.repository.RecommendationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import java.util.List;

@Service
public class AdministratorService {

    @Autowired
    private RecommendationRepository RecommendationRepo;

    public String showRecommendation(ModelMap model) {
        List<Recommend> recommendations = RecommendationRepo.findAll();
        model.addAttribute("recommendations", recommendations);
        model.put("recommendations", recommendations);
        return "AdministratorPage";
    }

    public String addRecommendation(Recommend recommend, ModelMap model) {
        System.out.println(recommend.getCity());
        System.out.println(recommend.getRecommendation());
        RecommendationRepo.save(recommend);
        List<Recommend> recommendations = RecommendationRepo.findAll();
        model.addAttribute("recommendations", recommendations);
        model.put("recommend", recommend);
        model.put("recommendations", recommendations);
        return "AdministratorPage";
    }
}
