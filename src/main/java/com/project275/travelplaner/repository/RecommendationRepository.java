package com.project275.travelplaner.repository;
import java.util.List;
import com.project275.travelplaner.entity.Recommend;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface RecommendationRepository extends JpaRepository<Recommend, Integer> {
    List<Recommend> findByCity(String city);

    @Query("SELECT DISTINCT city FROM Recommend")
    List<String> findDistinctCities();
}
