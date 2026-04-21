package model;

import java.util.ArrayList;

public class Account {

    private double balance;
    private String name;

    private ArrayList<Transaction> statement = new ArrayList<>();

    public Account(){}

    public Account(double balance, String name){
        this.balance = balance;
        this.name = name;
    }

    public double getBalance(){
        return balance;
    }

    public void setBalance(double newBalance){
        this.balance = newBalance;
    }

    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }

    public void addTransaction(Transaction t){
        statement.add(t);
    }

    public ArrayList<Transaction> getStatement(){
        return new ArrayList<>(statement);
    }

    public void setStatement(ArrayList<Transaction> statement){
        this.statement = statement;
    }
}
