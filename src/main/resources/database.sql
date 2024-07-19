
# ---------------------------------------------------------------------- #
# Target DBMS:           MySQL                                           #
# Project name:          AccountingLedger                                #
# ---------------------------------------------------------------------- #
DROP DATABASE IF EXISTS accountingledger;

CREATE DATABASE IF NOT EXISTS accountingledger;

USE accountingledger;

# ---------------------------------------------------------------------- #
# Tables                                                                 #
# ---------------------------------------------------------------------- #




-- Create the Transactions table
CREATE TABLE Transactions (
    transaction_id INT PRIMARY KEY AUTO_INCREMENT,
    date DATE,
    time TIME,
    description VARCHAR(255),
    type_of_transaction VARCHAR(50),
    vendor VARCHAR(255),
    amount DECIMAL(10, 2)
);
 
-- Insert the transaction data
INSERT INTO Transactions (date, time, description, type_of_transaction, vendor, amount) VALUES
('2023-04-15', '11:15:00', 'Invoice', 'Deposit', 'Joe', 1500.00),
('2023-04-20', '19:30:00', 'Gasoline', 'Withdrawal', 'Gas Station XYZ', -40.00),
('2023-04-18', '08:45:00', 'Electric bill', 'Withdrawal', 'Utility Company', -75.00),
('2023-01-10', '10:05:20', 'Investment Dividend', 'Deposit', 'Bank', 200.00),
('2023-02-01', '09:10:00', 'Groceries', 'Withdrawal', 'Supermarket ABC', -120.50),
('2023-02-03', '14:00:00', 'Salary', 'Deposit', 'Employer', 2500.00),
('2023-02-05', '16:20:00', 'Dining Out', 'Withdrawal', 'Restaurant XYZ', -45.75),
('2023-02-07', '11:45:00', 'Investment Return', 'Deposit', 'Brokerage Firm', 350.00),
('2023-02-09', '13:10:00', 'Insurance', 'Withdrawal', 'Insurance Company', -200.00),
('2023-02-11', '15:25:00', 'Refund', 'Deposit', 'Store', 30.00),
('2023-02-13', '17:50:00', 'Fuel', 'Withdrawal', 'Gas Station ABC', -50.00),
('2023-02-15', '12:30:00', 'Utilities', 'Withdrawal', 'Utility Company', -100.00),
('2023-02-17', '08:15:00', 'Freelance Payment', 'Deposit', 'Client', 500.00),
('2023-02-19', '09:45:00', 'Rent', 'Withdrawal', 'Landlord', -800.00),
('2023-02-21', '11:00:00', 'Gift', 'Deposit', 'Friend', 100.00),
('2023-02-23', '16:35:00', 'Car Repair', 'Withdrawal', 'Auto Shop', -300.00),
('2023-02-25', '13:25:00', 'Interest Income', 'Deposit', 'Bank', 15.00),
('2023-02-27', '14:55:00', 'Medical Bill', 'Withdrawal', 'Hospital', -150.00),
('2023-02-28', '18:20:00', 'Online Purchase', 'Withdrawal', 'E-commerce Website', -70.00),
('2023-03-02', '08:35:00', 'Commission', 'Deposit', 'Affiliate Program', 75.00),
('2023-03-04', '12:10:00', 'Utilities', 'Withdrawal', 'Utility Company', -90.00),
('2023-03-06', '15:45:00', 'Dining Out', 'Withdrawal', 'Restaurant XYZ', -60.00),
('2023-03-08', '10:00:00', 'Salary', 'Deposit', 'Employer', 2500.00),
('2023-03-10', '13:30:00', 'Gasoline', 'Withdrawal', 'Gas Station XYZ', -40.00),
('2023-03-12', '16:15:00', 'Investment Return', 'Deposit', 'Brokerage Firm', 200.00),
('2023-03-14', '11:25:00', 'Groceries', 'Withdrawal', 'Supermarket ABC', -130.00),
('2023-03-16', '14:05:00', 'Utilities', 'Withdrawal', 'Utility Company', -85.00),
('2023-03-18', '17:30:00', 'Refund', 'Deposit', 'Store', 25.00),
('2023-03-20', '09:15:00', 'Rent', 'Withdrawal', 'Landlord', -800.00),
('2023-03-22', '10:45:00', 'Freelance Payment', 'Deposit', 'Client', 600.00),
('2023-03-24', '13:50:00', 'Dining Out', 'Withdrawal', 'Restaurant XYZ', -55.00),
('2023-03-26', '15:35:00', 'Car Insurance', 'Withdrawal', 'Insurance Company', -150.00),
('2023-03-28', '18:10:00', 'Online Purchase', 'Withdrawal', 'E-commerce Website', -80.00),
('2023-03-30', '08:25:00', 'Commission', 'Deposit', 'Affiliate Program', 65.00),
('2023-04-01', '11:10:00', 'Electric Bill', 'Withdrawal', 'Utility Company', -70.00),
('2023-04-03', '13:40:00', 'Salary', 'Deposit', 'Employer', 2500.00),
('2023-04-05', '15:20:00', 'Gasoline', 'Withdrawal', 'Gas Station XYZ', -50.00),
('2023-04-07', '17:00:00', 'Investment Return', 'Deposit', 'Brokerage Firm', 300.00),
('2023-04-09', '09:05:00', 'Groceries', 'Withdrawal', 'Supermarket ABC', -110.00),
('2023-04-11', '11:35:00', 'Utilities', 'Withdrawal', 'Utility Company', -95.00),
('2023-04-13', '13:55:00', 'Refund', 'Deposit', 'Store', 40.00),
('2023-04-17', '15:25:00', 'Rent', 'Withdrawal', 'Landlord', -800.00),
('2023-04-19', '08:40:00', 'Freelance Payment', 'Deposit', 'Client', 700.00),
('2023-04-21', '10:20:00', 'Dining Out', 'Withdrawal', 'Restaurant XYZ', -65.00),
('2023-04-23', '12:45:00', 'Car Insurance', 'Withdrawal', 'Insurance Company', -180.00),
('2023-04-25', '14:55:00', 'Online Purchase', 'Withdrawal', 'E-commerce Website', -90.00),
('2023-04-27', '16:30:00', 'Commission', 'Deposit', 'Affiliate Program', 85.00),
('2023-04-29', '09:15:00', 'Electric Bill', 'Withdrawal', 'Utility Company', -80.00),
('2023-05-01', '11:50:00', 'Salary', 'Deposit', 'Employer', 2500.00),
('2023-05-03', '13:35:00', 'Gasoline', 'Withdrawal', 'Gas Station XYZ', -60.00),
('2023-05-05', '15:20:00', 'Investment Return', 'Deposit', 'Brokerage Firm', 400.00),
('2023-05-07', '08:55:00', 'Groceries', 'Withdrawal', 'Supermarket ABC', -140.00),
('2023-05-09', '10:45:00', 'Utilities', 'Withdrawal', 'Utility Company', -105.00),
('2023-05-11', '12:35:00', 'Refund', 'Deposit', 'Store', 35.00),
('2023-05-13', '14:25:00', 'Rent', 'Withdrawal', 'Landlord', -800.00),
('2023-05-15', '09:55:00', 'Freelance Payment', 'Deposit', 'Client', 800.00),
('2023-05-17', '11:15:00', 'Dining Out', 'Withdrawal', 'Restaurant XYZ', -75.00),
('2023-05-19', '13:10:00', 'Car Insurance', 'Withdrawal', 'Insurance Company', -170.00),
('2023-05-21', '15:00:00', 'Online Purchase', 'Withdrawal', 'E-commerce Website', -100.00),
('2023-05-23', '16:45:00', 'Commission', 'Deposit', 'Affiliate Program', 90.00),
('2023-05-25', '09:30:00', 'Electric Bill', 'Withdrawal', 'Utility Company', -85.00),
('2023-05-27', '11:25:00', 'Salary', 'Deposit', 'Employer', 2500.00),
('2023-05-29', '13:50:00', 'Gasoline', 'Withdrawal', 'Gas Station XYZ', -70.00),
('2023-05-31', '15:40:00', 'Investment Return', 'Deposit', 'Brokerage Firm', 500.00),
('2023-06-02', '08:45:00', 'Groceries', 'Withdrawal', 'Supermarket ABC', -150.00),
('2023-06-04', '10:35:00', 'Utilities', 'Withdrawal', 'Utility Company', -115.00),
('2023-06-06', '12:25:00', 'Refund', 'Deposit', 'Store', 20.00),
('2023-06-08', '14:15:00', 'Rent', 'Withdrawal', 'Landlord', -800.00),
('2023-06-10', '09:05:00', 'Freelance Payment', 'Deposit', 'Client', 900.00),
('2023-06-12', '11:00:00', 'Dining Out', 'Withdrawal', 'Restaurant XYZ', -85.00),
('2023-06-14', '13:25:00', 'Car Insurance', 'Withdrawal', 'Insurance Company', -160.00),
('2023-06-16', '15:10:00', 'Online Purchase', 'Withdrawal', 'E-commerce Website', -110.00),
('2023-06-18', '16:55:00', 'Commission', 'Deposit', 'Affiliate Program', 95.00),
('2023-06-20', '09:45:00', 'Electric Bill', 'Withdrawal', 'Utility Company', -90.00),
('2023-06-22', '11:35:00', 'Salary', 'Deposit', 'Employer', 2500.00),
('2023-06-24', '13:30:00', 'Gasoline', 'Withdrawal', 'Gas Station XYZ', -80.00),
('2023-06-26', '15:20:00', 'Investment Return', 'Deposit', 'Brokerage Firm', 600.00),
('2023-06-28', '08:55:00', 'Groceries', 'Withdrawal', 'Supermarket ABC', -160.00),
('2023-06-30', '10:45:00', 'Utilities', 'Withdrawal', 'Utility Company', -125.00),
('2023-07-02', '12:35:00', 'Refund', 'Deposit', 'Store', 50.00),
('2023-07-04', '14:25:00', 'Rent', 'Withdrawal', 'Landlord', -800.00),
('2023-07-06', '09:55:00', 'Freelance Payment', 'Deposit', 'Client', 1000.00),
('2023-07-08', '11:15:00', 'Dining Out', 'Withdrawal', 'Restaurant XYZ', -95.00),
('2023-07-10', '13:10:00', 'Car Insurance', 'Withdrawal', 'Insurance Company', -150.00),
('2023-07-12', '15:00:00', 'Online Purchase', 'Withdrawal', 'E-commerce Website', -120.00),
('2023-07-14', '16:45:00', 'Commission', 'Deposit', 'Affiliate Program', 105.00),
('2023-07-16', '09:30:00', 'Electric Bill', 'Withdrawal', 'Utility Company', -100.00),
('2023-07-18', '11:25:00', 'Salary', 'Deposit', 'Employer', 2500.00),
('2023-07-20', '13:50:00', 'Gasoline', 'Withdrawal', 'Gas Station XYZ', -90.00),
('2023-07-22', '15:40:00', 'Investment Return', 'Deposit', 'Brokerage Firm', 700.00),
('2023-07-24', '08:45:00', 'Groceries', 'Withdrawal', 'Supermarket ABC', -170.00),
('2023-07-26', '10:35:00', 'Utilities', 'Withdrawal', 'Utility Company', -135.00),
('2023-07-28', '12:25:00', 'Refund', 'Deposit', 'Store', 45.00),
('2023-07-30', '14:15:00', 'Rent', 'Withdrawal', 'Landlord', -800.00),
('2023-08-01', '09:05:00', 'Freelance Payment', 'Deposit', 'Client', 1100.00),
('2023-08-03', '11:00:00', 'Dining Out', 'Withdrawal', 'Restaurant XYZ', -105.00),
('2023-08-05', '13:25:00', 'Car Insurance', 'Withdrawal', 'Insurance Company', -170.00),
('2023-08-07', '15:10:00', 'Online Purchase', 'Withdrawal', 'E-commerce Website', -130.00),
('2023-08-09', '16:55:00', 'Commission', 'Deposit', 'Affiliate Program', 115.00),
('2023-08-11', '09:45:00', 'Electric Bill', 'Withdrawal', 'Utility Company', -110.00);
