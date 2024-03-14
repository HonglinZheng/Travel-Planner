package com.project275.travelplaner.repository;

import com.project275.travelplaner.entity.Administrator;
import com.project275.travelplaner.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdministratorRepository extends JpaRepository<Administrator, Integer> {
    User findByEmail(String email);
}
