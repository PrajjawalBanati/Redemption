package org.expensetracker.Repository;

import org.expensetracker.DTOs.ExpenseDTO;
import org.expensetracker.Modules.Expense;

import java.util.List;

public interface ExpenseRepository {
    public void addExpense(Expense expense);
    public List<Expense> getExpenses();
}
