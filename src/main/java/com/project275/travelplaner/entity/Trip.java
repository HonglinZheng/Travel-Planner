package com.project275.travelplaner.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.*;

@Component
@Entity
@Data
@EqualsAndHashCode(exclude = {"users", "itineraries","budgetTrack"})
public class Trip {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    String name;
    LocalDate startDate;
    LocalDate endDate;
    double budget;

    @OneToOne
    BudgetTracker budgetTrack;

    @ManyToMany(mappedBy = "trips", fetch = FetchType.EAGER)
    Set<User> users = new HashSet<>();

    @OneToMany(fetch = FetchType.EAGER)
    List<Itinerary> itineraries = new ArrayList<>();

}