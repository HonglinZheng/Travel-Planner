package com.project275.travelplaner.repository;

import com.project275.travelplaner.entity.Itinerary;
import com.project275.travelplaner.entity.Trip;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItineraryRepository extends JpaRepository<Itinerary, Integer> {
}
