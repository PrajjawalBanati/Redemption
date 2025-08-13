package com.project.expensetracker.Models;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "expense")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
public class Expense {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer expense_id;
    @Column(name = "description", nullable = false)
    private String description;
    @Column(name = "amount", nullable = false)
    private Integer amount;
    @Column(name = "date_of_expenditure", nullable = false)
    private LocalDate localDate;
    @Column(name = "expense_type", nullable = false)
    @Enumerated(value = EnumType.STRING)
    private ExpenseType expenseType;
}
