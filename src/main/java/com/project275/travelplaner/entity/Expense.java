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

	public double getSum(){
		return transportationExpense + accommodationExpense
				+ mealsExpense + activitiesExpense;
	}

	public void copy(Expense other){
		this.activitiesExpense = other.getActivitiesExpense();
		this.mealsExpense = other.getMealsExpense();
		this.accommodationExpense = other.getAccommodationExpense();
		this.transportationExpense = other.getTransportationExpense();
	}

	public int getId() {
		return id;
	}

	public double getTransportationExpense() {
		return transportationExpense;
	}

	public double getAccommodationExpense() {
		return accommodationExpense;
	}

	public double getMealsExpense() {
		return mealsExpense;
	}

	public double getActivitiesExpense() {
		return activitiesExpense;
	}

	public Itinerary getItinerary() {
		return itinerary;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setTransportationExpense(double transportationExpense) {
		this.transportationExpense = transportationExpense;
	}

	public void setAccommodationExpense(double accommodationExpense) {
		this.accommodationExpense = accommodationExpense;
	}

	public void setMealsExpense(double mealsExpense) {
		this.mealsExpense = mealsExpense;
	}

	public void setActivitiesExpense(double activitiesExpense) {
		this.activitiesExpense = activitiesExpense;
	}

	public void setItinerary(Itinerary itinerary) {
		this.itinerary = itinerary;
	}
    
}
