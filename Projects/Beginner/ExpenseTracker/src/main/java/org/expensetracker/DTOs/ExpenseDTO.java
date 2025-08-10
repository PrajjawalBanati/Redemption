package org.expensetracker.DTOs;

public class ExpenseDTO {
    private final String description;
    private final int amount;

    private ExpenseDTO(ExpenseDTOBuilder expenseDTOBuilder)
    {
        this.description = expenseDTOBuilder.description;
        this.amount = expenseDTOBuilder.amount;
    }

    public String getDescription() {
        return description;
    }

    public int getAmount() {
        return amount;
    }

    public static class ExpenseDTOBuilder{
        private String description;
        private int amount;
        private ExpenseDTOBuilder() {}
        public ExpenseDTOBuilder setDescription(String description) {
            this.description = description;
            return this;
        }

        public ExpenseDTOBuilder setAmount(int amount) {
            this.amount = amount;
            return this;
        }

        public ExpenseDTO build()
        {
            return new ExpenseDTO(this);
        }

    }
    public static ExpenseDTOBuilder getBuilder()
    {
        return new ExpenseDTOBuilder();
    }
}
