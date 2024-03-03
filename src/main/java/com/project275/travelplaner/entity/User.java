package com.project275.travelplaner.entity;

import jakarta.persistence.*;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

import lombok.Data;
@Entity
@Data
@Component
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String email;
    private long mobile;
    private String password;
    private LocalDate dob;

    @OneToMany(fetch = FetchType.EAGER)
    List<Trip> planer;
}
