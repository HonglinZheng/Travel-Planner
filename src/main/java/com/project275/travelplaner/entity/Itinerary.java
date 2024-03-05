package com.project275.travelplaner.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
@Entity
@Data
@EqualsAndHashCode(exclude = {"expenseLog", "trip"})
public class Itinerary {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    String name;
    String location;
    LocalDate date;
    String attraction;
    String detail;
    String weatherForecast;
    String safetyTips;
    @OneToOne
    Expense expenseLog;

    @ManyToOne
    Trip trip;
}
