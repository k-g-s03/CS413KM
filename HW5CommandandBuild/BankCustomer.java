package HW5CommandandBuild;
/*************************************************
File: BankCustomer.java
By: Kalise G. Shields
Date: April 22th, 2023
Compile: Compiles the BankCustomer class and BankCustomerBuilder class
Usage: 
System: Using VSCode on MacOs
Description: This file is used to create a bank customer class that will allow the user to create a bank customer object with a name and account number
*************************************************/

//Used the sample code provided to us by the teachers while implementin 
public class BankCustomer {
    private String name;
    private String accountNumber;

    public BankCustomer(String name, String accountNumber){
        this.name = name;
        this.accountNumber = accountNumber;
    }

    public String getName(){
        return name;
    }

    public String getAccountNumber(){
        return accountNumber;
    }

}

class BankCustomerBuilder{
    private String name;
    private String accountNumber;

    public BankCustomerBuilder(){
    }

    //Method to build name
    public BankCustomerBuilder buildWithName(String name){
        this.name = name;
        return this;
    }

    //Method to build account number
    public BankCustomerBuilder buildWithAccountNumber(String accountNumber){
        this.accountNumber = accountNumber;
        return this;
    }

    //Build method
    public BankCustomer build(){
        return new BankCustomer(name,accountNumber);
    }
}
