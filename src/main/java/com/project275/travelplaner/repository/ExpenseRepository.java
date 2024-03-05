package com.project275.travelplaner.repository;

import com.project275.travelplaner.entity.Expense;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;


public interface ExpenseRepository extends JpaRepository<Expense, Integer> {
}
