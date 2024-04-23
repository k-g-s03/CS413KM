package HW5CommandandBuild;
/*************************************************
File: BankAccountTransaction.java
By: Kalise G. Shields
Date: April 22th, 2023
Compile: Compiles the BankAccountTransaction class, DepositTransaction class, WithdrawTransaction class, and tester class
Usage: 
System: Using VSCode on MacOs
Description: This file is used to create a bank account transaction class that will allow the user to deposit or withdraw money from their account
*************************************************/

//Importing the necessary packages for this file
import java.time.LocalDateTime;
import java.util.Scanner;

//Creating the BankAccountTransaction class
public class BankAccountTransaction {
    //Declaring the instance variables that were instructed in the directions
    private String name;
    private long account;
    private String accountNumber;
    private double balance;
    protected double amount;
    protected String transactionType;
    private boolean status;
    private LocalDateTime transactionTime;

    //Constructor
    public BankAccountTransaction(String name, long account, String accountNumber, 
                                double balance, String transactionType, boolean status)
    {
        this.name = name;
        this.account = account;
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.transactionType = transactionType;
        this.status = status;
        this.transactionTime = LocalDateTime.now();
    }

    //Getters
    public String getName(){
        return name;
    }

    public double getAmount(){
        return amount;
    }

    public long getAccount(){
        return account;
    }

    public String getAccountNumber(){
        return accountNumber;
    }

    public double getBalance(){
        return balance;
    }

    public String getTransactionType(){
        return transactionType;
    }

    public boolean getStatus(){
        return status;
    }

    public LocalDateTime getTransactionTime(){
        return transactionTime;
    }

    //Setters
    public void setName(String name){
        this.name = name;
    }

    public void setAmount(double amount){
        this.amount = amount;
    }

    public void setAccount(long account){
        this.account = account;
    }

    public void setAccountNumber(String accountNumber){
        this.accountNumber = accountNumber;
    }

    public void setBalance(double balance){
        this.balance = balance;
    }

    public void setTransactionType(String transactionType){
        this.transactionType = transactionType;
    }

    public void setStatus(boolean status){
        this.status = status;
    }

    public void setTransactionTime(LocalDateTime transactionTime){
        this.transactionTime = transactionTime;
    }


    @Override
    //toString method to display the account information
    public String toString() {
        return "Name: " + name + "\n" +
                "Account: " + account + "\n" +
                "Account Number: " + accountNumber + "\n" +
                "Balance: " + balance + "\n" +
                "Transaction Type: " + transactionType + "\n" +
                "Status: " + status + "\n" +
                "Transaction Time: " + transactionTime + "\n";
    }

    //Interface that defines the execute method
    public interface TransactionInterface{
        public void execute();
    }

    //Concrete classes that implement the TransactionInterface
    public class DepositTransaction implements TransactionInterface{
        public void execute(){ //using the execute method to add the amount to the balance
            balance += amount;
            status = true;
            System.out.println("Deposit successful! Your total balance is: " + balance + "\n");
        }
    }
    //Concrete classes that implement the TransactionInterface
    public class WithdrawTransaction implements TransactionInterface{
        public void execute(){ //using the execute method to check if the balance is greater than the amount to be withdrawn

            if(balance >= amount){
                balance -= amount;
                status = true;
                System.out.println("Withdrawal successful! Your total balance is: " + balance + "\n");
                
            }else{
                    System.out.println("Insufficient funds! Your balance is: " + balance + "\n");
                    status = false;
                }
        }
    } 

// Main.java
// Subclass Main

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        //Creating the checking account object with using the BankAccountTransaction class
        BankAccountTransaction checkingAccount = new BankAccountTransaction("John Doe", 123456789, "123456789", 1000.00, "Deposit", true);
        System.out.println(checkingAccount.toString());

        //If statement to check if the transaction type is a deposit or withdrawal
        if(checkingAccount.getTransactionType().equals("Deposit")){
            System.out.println("Enter the amount you would like to deposit: ");
            checkingAccount.amount = input.nextDouble();
            System.out.println("You have chosen to deposit: " + checkingAccount.amount + "\n");
            BankAccountTransaction.DepositTransaction deposit = checkingAccount.new DepositTransaction();
            deposit.execute();
        }else if(checkingAccount.getTransactionType().equals("Withdraw")){
            System.out.println("Enter the amount you would like to withdraw: ");
            checkingAccount.amount = input.nextDouble();
            System.out.println("You have chosen to deposit: " + checkingAccount.amount + "\n");
            BankAccountTransaction.WithdrawTransaction withdraw = checkingAccount.new WithdrawTransaction();
            withdraw.execute();
        }

        //Same with checking account, this creates a savings account object using the BankAccountTransaction class
        BankAccountTransaction savingsAccount = new BankAccountTransaction("John Doe", 123456789, "987654321", 500.00, "Withdraw", true);
        System.out.println(savingsAccount.toString()); 

        //If statement to check if the transaction type is a deposit or withdrawal
        if(savingsAccount.getTransactionType().equals("Deposit")){
            System.out.println("Enter the amount you would like to deposit: ");
            savingsAccount.amount = input.nextDouble();
            System.out.println("You have chosen to deposit: " + savingsAccount.amount + "\n");
            BankAccountTransaction.DepositTransaction deposit = savingsAccount.new DepositTransaction();
            deposit.execute();
        }else if(savingsAccount.getTransactionType().equals("Withdraw")){
            System.out.println("Enter the amount you would like to withdraw: ");
            savingsAccount.amount = input.nextDouble();
            System.out.println("You have chosen to deposit: " + savingsAccount.amount + "\n");
            BankAccountTransaction.WithdrawTransaction withdraw = savingsAccount.new WithdrawTransaction();
            withdraw.execute();
        }

        // Close the scanner
    input.close();

    }
    
}


        



