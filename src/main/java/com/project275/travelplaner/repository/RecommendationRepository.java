package com.project275.travelplaner.repository;
import java.util.List;
import com.project275.travelplaner.entity.Recommendation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecommendationRepository extends JpaRepository<Recommendation, Integer> {
    List<Recommendation> findByCity(String city);
}
