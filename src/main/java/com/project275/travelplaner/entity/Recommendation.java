package com.project275.travelplaner.entity;
import jakarta.persistence.*;
import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Entity
@Data
@Table(name = "recommendations")
public class Recommendation {
    @Id
   // @GeneratedValue(strategy = GenerationType.IDENTITY)
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;
    @Column(unique = true)
    private String city;
    private String recommendation;
}
