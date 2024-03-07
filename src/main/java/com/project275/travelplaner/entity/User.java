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

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getEmail() {
		return email;
	}

	public String getMobile() {
		return mobile;
	}

	public String getPassword() {
		return password;
	}

	public LocalDate getDob() {
		return dob;
	}

	public Set<Trip> getTrips() {
		return trips;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	public void setTrips(Set<Trip> trips) {
		this.trips = trips;
	}
    
    
}
