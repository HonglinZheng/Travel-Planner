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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    @Column(unique = true)
    String city;
    String recommendation;
	public int getId() {
		return id;
	}
	public String getCity() {
		return city;
	}
	public String getRecommendation() {
		return recommendation;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public void setRecommendation(String recommendation) {
		this.recommendation = recommendation;
	}
    
}
