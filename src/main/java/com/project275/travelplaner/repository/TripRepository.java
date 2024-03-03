package com.project275.travelplaner.repository;

import com.project275.travelplaner.entity.Trip;
import com.project275.travelplaner.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TripRepository extends JpaRepository<Trip, Integer> {
}
