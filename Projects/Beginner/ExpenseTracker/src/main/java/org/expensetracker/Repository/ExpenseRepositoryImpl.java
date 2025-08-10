package org.expensetracker.Repository;

import org.expensetracker.DTOs.ExpenseDTO;
import org.expensetracker.Modules.Expense;

import java.util.List;

public class ExpenseRepositoryImpl implements ExpenseRepository{
    private JSONFileReaderWriter<List<Expense>> jsonFileReaderWriter;
    public ExpenseRepositoryImpl()
    {
        this.jsonFileReaderWriter = (JSONFileReaderWriter<List<Expense>>) JSONFileReaderWriter.getInstance();
    }
    @Override
    public void addExpense(Expense expense) throws RuntimeException{
        this.jsonFileReaderWriter.writeFile(List.of(expense));
    }

    @Override
    public List<Expense> getExpenses() throws RuntimeException {
        return this.jsonFileReaderWriter.readFile();
    }
}
