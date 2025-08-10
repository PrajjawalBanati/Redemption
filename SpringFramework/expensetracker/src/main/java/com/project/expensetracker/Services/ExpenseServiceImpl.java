package com.project.expensetracker.Services;

import com.project.expensetracker.DTOs.ExpenseDTO;
import com.project.expensetracker.Models.Expense;
import com.project.expensetracker.Repositories.ExpenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExpenseServiceImpl implements ExpenseService{
    @Autowired
    private ExpenseRepository expenseRepository;

    @Override
    public int addExpense(ExpenseDTO expenseDTO) {
        return 0;
    }

    @Override
    public List<Expense> getAllExpenses() {
        return List.of();
    }

    @Override
    public boolean deleteExpense(int id) {
        return false;
    }
}
