package bankingapplication3;

import java.util.Random;
import java.util.Scanner;


public class BankingApplication3 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int option = 0;
        Bank bank = new Bank("AAA");
        int number;
        String name;
        double balance;
        double amount;
        Account account;
        
        while(option !=6){
            System.out.println("Main menu");
            System.out.println("1. Display all accounts");
            System.out.println("2. Open new account");
            System.out.println("3. Close existing account");
            System.out.println("4. Deposit");
            System.out.println("5. Withdraw"); 
            System.out.println("6. Exit");
            
            System.out.println("Enter your choice: ");
            option = scan.nextInt();
            
            switch(option) {
                case 1:
                    bank.listAccount(account);
                    break;
                    
                case 2:
                    number = generateAccountNumber();
                    System.out.println("Enter Account Name: ");
                    name = scan.nextLine();
                    System.out.println("Enter Initial Balance");
                    balance = scan.nextDouble();
                    account = new Account(number, name, balance);
                    bank.openAccount(account);
                    break;
                    
                case 3:
                    System.out.println("Enter Account Number");
                    number = scan.nextInt();
                    bank.closeAccount(number);
                    System.out.println("Account is Deleted");
                    System.out.println();
                    break;
                    
                case 4:
                    System.out.println("Enter Account Number: ");
                    number = scan.nextInt();
                    account = bank.getAccount(number);
                    System.out.println("Enter Amount: ");
                    amount = scan.nextDouble();
                    bank.depositMoney(account, amount);
                    System.out.println("Balance: "+ account.getBalance());
                    break;
                    
                case 5:
                    System.out.println("Enter Account Number: ");
                    number = scan.nextInt();
                    account = bank.getAccount(number);
                    System.out.println("Enter Amount: ");
                    amount = scan.nextDouble();
                    bank.withdrawMoney(account, amount);
                    break;
                    
            }
            
        }
        
    }
    
    public static int generateAccountNumber(){
        Random random = new Random();
        int accNumber = 100000 + random.nextInt(900000);
        return accNumber;
    }
}
