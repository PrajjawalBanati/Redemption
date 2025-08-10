package com.project.expensetracker.Repositories;

import com.project.expensetracker.Models.Expense;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@Repository
@Configuration
@EnableJpaRepositories
public interface ExpenseRepository extends JpaRepository<Expense, Integer> {
}
