package model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Transaction {

    private double transactionValue;
    private String date;
    private TransactionType type;

    public enum TransactionType {
        DEPOSITO, SAQUE
    }

    public Transaction(){}

    public Transaction(double transactionValue, TransactionType type){
        this.transactionValue = transactionValue;
        date = getDateTime();
        this.type = type;
    }

    public Transaction(double transactionValue, String transactionDate, TransactionType type){
        this.transactionValue = transactionValue;
        this.date = transactionDate;
        this.type = type;
    }

    private String getDateTime() {
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date date = new Date();
        return dateFormat.format(date);
    }

    public TransactionType getType(){
        return type;
    }

    public String getDate(){
        return date;
    }

    public void setDate(String date){
        this.date = date;
    }

    public double getTransactionValue(){
        return transactionValue;
    }
}
