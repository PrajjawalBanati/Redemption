package com.project.expensetracker.Services;

import com.project.expensetracker.DTOs.ExpenseDTO;
import com.project.expensetracker.Models.Expense;
import com.project.expensetracker.Models.ExpenseType;
import com.project.expensetracker.Repositories.ExpenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ExpenseServiceImpl implements ExpenseService{
    @Autowired
    private ExpenseRepository expenseRepository;

    @Override
    public Expense addExpense(ExpenseDTO expenseDTO) {
        expenseDTO.setExpenseTime(LocalDate.now());
        if (expenseDTO.getExpenseType() == null){ expenseDTO.setExpenseType(ExpenseType.Other); }
        return expenseRepository.saveAndFlush(ExpenseDTO.toExpense(expenseDTO));
    }

    @Override
    public List<Expense> getAllExpenses() {
        return expenseRepository.findAll();
    }

    @Override
    public void deleteExpense(int id) {
        expenseRepository.deleteById(id);
    }
}
