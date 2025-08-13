package com.project.expensetracker.DTOs;


import com.project.expensetracker.Models.Expense;
import com.project.expensetracker.Models.ExpenseType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@AllArgsConstructor
@Builder
@Setter
@Getter
public class ExpenseDTO {
    private String description;
    private int amount;
    private ExpenseType expenseType;
    private LocalDate expenseTime;
    public static Expense toExpense(ExpenseDTO expenseDTO){
        return Expense.builder().description(expenseDTO.description).amount(expenseDTO.amount).localDate(expenseDTO.expenseTime).expenseType(expenseDTO.expenseType).build();
    }
}
