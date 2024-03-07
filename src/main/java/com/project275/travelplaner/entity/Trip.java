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

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public LocalDate getStartDate() {
		return startDate;
	}

	public LocalDate getEndDate() {
		return endDate;
	}

	public double getBudget() {
		return budget;
	}

	public BudgetTracker getBudgetTrack() {
		return budgetTrack;
	}

	public Set<User> getUsers() {
		return users;
	}

	public List<Itinerary> getItineraries() {
		return itineraries;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}

	public void setBudget(double budget) {
		this.budget = budget;
	}

	public void setBudgetTrack(BudgetTracker budgetTrack) {
		this.budgetTrack = budgetTrack;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}

	public void setItineraries(List<Itinerary> itineraries) {
		this.itineraries = itineraries;
	}

}