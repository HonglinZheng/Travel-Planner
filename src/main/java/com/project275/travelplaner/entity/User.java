package com.project275.travelplaner.entity;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.*;

import lombok.Data;
@Entity
@Data
@Component
@EqualsAndHashCode(exclude="trips")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String email;
    private String mobile;
    private String password;
    private LocalDate dob;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "user_trip",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "trip_id"))
    Set<Trip> trips = new HashSet<>();
}
