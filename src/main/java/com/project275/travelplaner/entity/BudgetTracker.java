package com.project275.travelplaner.entity;


import jakarta.persistence.*;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.stereotype.Component;

@Component
@Entity
@Data

public class BudgetTracker {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    double totalBudget;
    double transportationBudget;
    double accommodationBudget;
    double mealsBudget;
    double activitiesBudget;

    @OneToOne(mappedBy = "budgetTrack", fetch = FetchType.EAGER)
    Trip trip;
    
    public double sum(){
        return transportationBudget + accommodationBudget + mealsBudget + activitiesBudget;
    }



}
