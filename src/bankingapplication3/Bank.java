package bankingapplication3;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class Bank {
    private String name;
    
    
    public Bank(String name){
        this.name = name;
    }
    
    public void listAccount(Account account) {
        Connection con = BankConnection.connect();
        try{
            Statement statement = con.createStatement();
            String sql = "Select * from account";
            ResultSet results = statement.executeQuery(sql);
        
            while(results.next()){
                System.out.println(results.getString(1)+" "+results.getString(2)+" "+results.getString(3));
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Bank.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    public void openAccount(Account account) {
        Connection con = BankConnection.connect();
        String sql = "insert into account(accID,accName,accBalance) values(?,?,?)";
        try{
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setInt(1, account.getNumber());
            preparedStatement.setString(2, account.getName());
            preparedStatement.setDouble(3, account,getBalance());
            preparedStatement.executeUpdate();
            
        
        } catch (SQLException ex) {
            Logger.getLogger(Bank.class.getName()).log(Level.SEVERE, null, ex);
        }   
    }
   
    
    public void closeAccount(int number) {
        Connection con = BankConnection.connect();
        String sql = "Delete account from where accID = ?";
        
        try{
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setInt(1,number);
            preparedStatement.executeUpdate();
        
        } catch (SQLException ex) {
            Logger.getLogger(Bank.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    public void depositMoney(Account account, double amount) {
        account.deposit(amount);    
        Connection con = BankConnection.connect();
        String sql = "UPDATE student set accBalance = ? where accID = ? ";
        
        try{
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setDouble(1, account.getBalance());
            preparedStatement.setInt(2, account.getNumber());
            preparedStatement.executeUpdate();
        
        } catch (SQLException ex) {
            Logger.getLogger(Bank.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    public void withdrawMoney(Account account, double amount) {
        account.deposit(amount);
        Connection con = BankConnection.connect();
        String sql = "UPDATE student set accBalance = ? where accID = ? ";
        
        try{
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setDouble(1, account.getBalance());
            preparedStatement.setInt(2, account.getNumber());
            preparedStatement.executeUpdate();
        
        } catch (SQLException ex) {
            Logger.getLogger(Bank.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public Account getAccount(int number){
        Connection con = BankConnection.connect();
        Account account = null;
        String sql = "select * from account where accID ="+number+"'";
        Statement statement;
        String accountName;
        double balance;
            
        try {
            statement = con.createStatement();
            ResultSet result = statement.executeQuery(sql);
            while (result.next()) {
                accountName = result.getString(2);
                balance = result.getDouble(3);
                
            }
            account = new Account(number, accountName, balance);
            
        } catch (SQLException ex) {
            Logger.getLogger(Bank.class.getName()).log(Level.SEVERE, null, ex);
        }
        return account;
        
        
    }

}
