package HW5CommandandBuild;
/*************************************************
File: CustomerDriver.java
By: Kalise G. Shields
Date: April 22th, 2023
Compile: Tester class for the BankCustomer class
Usage: 
System: Using VSCode on MacOs
Description: This file is used as a tester class for the BankCustomer class with the build() method
*************************************************/
//Also used the sample code provided to us by the teachers while implementing
public class CustomerDriver {
    public static void main(String[] args) {
        BankCustomer customer1 = new BankCustomerBuilder()
                .buildWithName("Kalise Shields")
                .buildWithAccountNumber("123456789")
                .build();

        BankCustomer customer2 = new BankCustomerBuilder()
                .buildWithName("Jane Doe")
                .buildWithAccountNumber("789123456")
                .build();

        System.out.println(customer1.getName() + " " + customer1.getAccountNumber());
        System.out.println(customer2.getName() + " " + customer2.getAccountNumber());
    }
}
