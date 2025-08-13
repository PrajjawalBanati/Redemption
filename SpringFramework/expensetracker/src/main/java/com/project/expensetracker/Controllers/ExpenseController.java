package com.project.expensetracker.Controllers;

import com.project.expensetracker.DTOs.ExpenseDTO;
import com.project.expensetracker.Models.Expense;
import com.project.expensetracker.Services.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ExpenseController {
    @Autowired
    private ExpenseService expenseService;

    @GetMapping("/expenses")
    public List<Expense> getAllExpenses()
    {
        return expenseService.getAllExpenses();
    }

    @PostMapping("/expenses")
    public @ResponseBody Expense addExpense(@RequestBody ExpenseDTO expenseDTO)
    {
        return expenseService.addExpense(expenseDTO);
    }
}
