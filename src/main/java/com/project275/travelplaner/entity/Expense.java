package com.project275.travelplaner.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Entity
@Data
public class Expense {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    double transportationExpense;
    double accommodationExpense;
    double mealsExpense;
    double activitiesExpense;

    @OneToOne(mappedBy = "expenseLog", fetch = FetchType.EAGER)
    Itinerary itinerary;
}
