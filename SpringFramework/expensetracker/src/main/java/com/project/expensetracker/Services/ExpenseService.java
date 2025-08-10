package com.project.expensetracker.Services;

import com.project.expensetracker.DTOs.ExpenseDTO;
import com.project.expensetracker.Models.Expense;
import org.springframework.stereotype.Service;

import java.util.List;


public interface ExpenseService {
   public int addExpense(ExpenseDTO expenseDTO);
   public List<Expense> getAllExpenses();
   public boolean deleteExpense(int id);
}
