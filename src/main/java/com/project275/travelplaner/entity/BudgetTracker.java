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

	public int getId() {
		return id;
	}

	public double getTotalBudget() {
		return totalBudget;
	}

	public double getTransportationBudget() {
		return transportationBudget;
	}

	public double getAccommodationBudget() {
		return accommodationBudget;
	}

	public double getMealsBudget() {
		return mealsBudget;
	}

	public double getActivitiesBudget() {
		return activitiesBudget;
	}

	public Trip getTrip() {
		return trip;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setTotalBudget(double totalBudget) {
		this.totalBudget = totalBudget;
	}

	public void setTransportationBudget(double transportationBudget) {
		this.transportationBudget = transportationBudget;
	}

	public void setAccommodationBudget(double accommodationBudget) {
		this.accommodationBudget = accommodationBudget;
	}

	public void setMealsBudget(double mealsBudget) {
		this.mealsBudget = mealsBudget;
	}

	public void setActivitiesBudget(double activitiesBudget) {
		this.activitiesBudget = activitiesBudget;
	}

	public void setTrip(Trip trip) {
		this.trip = trip;
	}



}
