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
<img width="889" alt="Screenshot 2024-05-02 at 9 40 04 PM" src="https://github.com/nuhiii/CapstoneOne_AccountingLedger/assets/143645213/0f35a2d6-b24d-47ed-92f6-d9534139e5c6">
<img width="889" alt="Screenshot 2024-05-02 at 9 40 20 PM" src="https://github.com/nuhiii/CapstoneOne_AccountingLedger/assets/143645213/89e84c22-fd14-4611-b9e8-23539eba4b98">
<img width="889" alt="Screenshot 2024-05-02 at 9 53 49 PM" src="https://github.com/nuhiii/CapstoneOne_AccountingLedger/assets/143645213/cea2dc98-c271-4526-8741-9de76cc72394">
<img width="889" alt="Screenshot 2024-05-02 at 9 55 27 PM" src="https://github.com/nuhiii/CapstoneOne_AccountingLedger/assets/143645213/99ab93e3-7471-4461-ad17-adeaf5e6be88">
<img width="889" alt="Screenshot 2024-05-02 at 9 56 45 PM" src="https://github.com/nuhiii/CapstoneOne_AccountingLedger/assets/143645213/aca3eba5-98bb-402c-ac8b-5feb72ef2228">
<img width="889" alt="Screenshot 2024-05-02 at 10 04 54 PM" src="https://github.com/nuhiii/CapstoneOne_AccountingLedger/assets/143645213/e7216bb9-8c0c-4ce6-ba0c-f206a6822e7e">
<img width="889" alt="Screenshot 2024-05-02 at 10 05 23 PM" src="https://github.com/nuhiii/CapstoneOne_AccountingLedger/assets/143645213/7b99673e-d30b-4839-aff6-3ca31b26b1a7">
<img width="889" alt="Screenshot 2024-05-02 at 10 06 51 PM" src="https://github.com/nuhiii/CapstoneOne_AccountingLedger/assets/143645213/4c24bbc8-3508-484f-adc7-d045438bedd3">
<img width="889" alt="Screenshot 2024-05-02 at 10 08 24 PM" src="https://github.com/nuhiii/CapstoneOne_AccountingLedger/assets/143645213/bd53b046-4af2-480e-a2f7-5c3ce1c0abfb">
<img width="889" alt="Screenshot 2024-05-02 at 10 09 03 PM" src="https://github.com/nuhiii/CapstoneOne_AccountingLedger/assets/143645213/76debb1b-70fc-4f37-9027-f8fc9ebee46c">
<img width="889" alt="Screenshot 2024-05-02 at 10 09 43 PM" src="https://github.com/nuhiii/CapstoneOne_AccountingLedger/assets/143645213/434ee154-67fc-4147-89c2-1a9e025fc035">
<img width="889" alt="Screenshot 2024-05-02 at 10 10 29 PM" src="https://github.com/nuhiii/CapstoneOne_AccountingLedger/assets/143645213/37508a3f-700d-47b0-87a4-f9fdafb68980">
<img width="889" alt="Screenshot 2024-05-02 at 10 11 26 PM" src="https://github.com/nuhiii/CapstoneOne_AccountingLedger/assets/143645213/3e689604-af09-4df4-9fd2-2de0ed08c582">
<img width="889" alt="Screenshot 2024-05-02 at 10 19 12 PM" src="https://github.com/nuhiii/CapstoneOne_AccountingLedger/assets/143645213/7312726d-e6e3-40b4-a1c2-71594ca3ac7d">

That's all! Thank you!
~ Nuhi








