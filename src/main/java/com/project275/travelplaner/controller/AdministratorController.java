package com.project275.travelplaner.controller;

import com.project275.travelplaner.entity.Recommend;
import com.project275.travelplaner.service.AdministratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/administrator")
public class AdministratorController {

    @Autowired
    AdministratorService administratorService;

    @GetMapping("/view")
    public String viewRec(ModelMap model) {
        return administratorService.showRecommendation(model);
    }

    @GetMapping("/add")
    public String gotoAddRec(ModelMap model) {
        return "AddRec";
    }

    @PostMapping("/add")
    public String addRec(Recommend recommendation, ModelMap model) {
        return administratorService.addRecommendation(recommendation, model);
    }
}
