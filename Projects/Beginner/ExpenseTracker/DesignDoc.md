### Design Document

Here I will be mentioning the requirements which are required to clear in the System design interview.  

Requirements

- Users can add an expense with a description and amount.
- Users can update an expense.
- Users can delete an expense.
- Users can view all expenses.
- Users can view a summary of all expenses.
- Users can view a summary of expenses for a specific month (of current year).

```py
class Expense:
    expense_id
    expense_amount
    date_of_expense
    expense_description

class ExpenseDTO:
    expense_description
    expense_amount
    
class JsonFileWriter:
    file_obj
    
class ExpenseRepository
    json_fileWriterObj
        
class ExpenseService:
    expenseRepositoryObj

class ExpenseController:
    expenseServiceObj
```

