package org.expensetracker.Modules;

import java.time.LocalDate;

public class Expense {
    private int expense_id;
    private int expense_amount;
    private LocalDate date_of_expense;
    private String expense_description;

    public int getExpense_amount() {
        return expense_amount;
    }

    public int getExpense_id() {
        return expense_id;
    }

    public LocalDate getDate_of_expense() {
        return date_of_expense;
    }

    public String getExpense_description() {
        return expense_description;
    }
    private Expense(ExpenseBuilder expenseBuilder)
    {
        this.expense_id = expenseBuilder.expense_id;
        this.expense_amount = expenseBuilder.expense_amount;
        this.date_of_expense = expenseBuilder.date_of_expense;
        this.expense_description = expenseBuilder.expense_description;
    }
    public static class ExpenseBuilder{
        int expense_id;
        int expense_amount;
        LocalDate date_of_expense;
        String expense_description;
        private ExpenseBuilder(){}
        public ExpenseBuilder setExpense_id(int expense_id) {
            this.expense_id = expense_id;
            return this;
        }

        public ExpenseBuilder setExpense_amount(int expense_amount) {
            this.expense_amount = expense_amount;
            return this;
        }

        public ExpenseBuilder setDate_of_expense(LocalDate date_of_expense) {
            this.date_of_expense = date_of_expense;
            return this;
        }

        public ExpenseBuilder setExpense_description(String expense_description) {
            this.expense_description = expense_description;
            return this;
        }

        public Expense build()
        {
            return new Expense(this);
        }
    }

    public static ExpenseBuilder getBuilder(){
        return new ExpenseBuilder();
    }
}
