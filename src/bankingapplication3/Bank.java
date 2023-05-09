package bankingapplication3;

public class Bank {
    private String name;
    
    
    public Bank(String name){
        this.name = name;
    }
    
    public void listAccount(Account account) {
        
    }
    
    public void openAccount(Account account) {
        
    }
    
    public void closeAccount(int number) {
        
    }
    
    public void depositMoney(Account account, double amount) {
        account.deposit(amount);
    }
    
    public void withdrawMoney(Account account, double amount) {
        account.deposit(amount);
    }
    
    public Account getAccount(int number){
        String accountName = "aaaa";
        double balance = 500;
        Account account = new Account(number, accountName, number);
        return account;
        
    }

}
