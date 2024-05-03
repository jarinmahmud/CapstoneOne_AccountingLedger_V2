# Accounting Ledger CLI Application

This Java CLI application allows users to track financial transactions for personal or business use. 
It provides features to add deposits, make payments (debits), view transaction ledgers, and generate reports based on specified criteria.
The application manages these transactions by reading from and saving to a transaction file (transactions.txt) using a structured format.

## Features
- **Home Screen**
  - **Add Deposit:** Record a deposit transaction with details such as date, time, description, vendor, and amount.
  - **Make Payment (Debit):** Record a payment transaction with details similar to deposits but with a negative amount.
- **Ledger Screen**
  - **View Ledger:** Display transaction entries sorted by date (newest first) and filter by all entries, deposits only, or payments only.
- **Reports Screen**
  - **Generate Reports:**
      - Month to Date
      - Previous Month
      - Year to Date
      - Previous Year
      - Custom date range search
      - Search by Description
      - Search by Vendor
      - Custom amount range search

## Project Structure
- **Main.java**: Entry point of the application. Triggers the Display Screen.

- **Transaction.java**: Class representing a financial transaction.

- **TransactionHandler.java**: Handles transaction-related operations.

- **CustomSearch.java**: Implements custom search operations.

- **FileHandler.java**: Handles reading from and writing to transaction file.

## Future Improvements
- Implement graphical user interface (GUI) using JavaFX or Swing.
- Integrate database for persistent storage of transactions.
- Enhance error handling and input validation for user interactions.

## Interesting Code Snippets
### Sort Transactions by Date (Newest First)
```java
// Sort by date, newest entry first
transactions.sort(Comparator.comparing(Transaction::getDate).reversed());
```
### Error Handling with Null
```java
// Only write successfull transactions to file
if (transaction != null) {
    FileHandler.writeToFile(transaction);
}
```
### Filter Transactions by Date Range
```java
for (Transaction transaction : transactions){
    // Doing the logic this way ensures start date and end date are included
    if ((!transaction.getDate().isBefore(startDate)) && (!transaction.getDate().isAfter(endDate))) {
        dateRange.add(transaction);
    }
}
```

## Images