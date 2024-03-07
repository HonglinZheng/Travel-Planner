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
    double expenseSum;

    @OneToOne
    Expense expenseLog;

    @ManyToOne
    Trip trip;

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getLocation() {
		return location;
	}

	public LocalDate getDate() {
		return date;
	}

	public String getAttraction() {
		return attraction;
	}

	public String getDetail() {
		return detail;
	}

	public String getWeatherForecast() {
		return weatherForecast;
	}

	public String getSafetyTips() {
		return safetyTips;
	}

	public double getExpenseSum() {
		return expenseSum;
	}

	public Expense getExpenseLog() {
		return expenseLog;
	}

	public Trip getTrip() {
		return trip;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public void setAttraction(String attraction) {
		this.attraction = attraction;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public void setWeatherForecast(String weatherForecast) {
		this.weatherForecast = weatherForecast;
	}

	public void setSafetyTips(String safetyTips) {
		this.safetyTips = safetyTips;
	}

	public void setExpenseSum(double expenseSum) {
		this.expenseSum = expenseSum;
	}

	public void setExpenseLog(Expense expenseLog) {
		this.expenseLog = expenseLog;
	}

	public void setTrip(Trip trip) {
		this.trip = trip;
	}

    
}
