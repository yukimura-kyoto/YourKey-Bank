package model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Transaction {

    private double transactionValue;
    private String transactionDate;
    private TransactionType type;

    public enum TransactionType {
        DEPOSITO, SAQUE
    }

    public Transaction(double transactionValue, TransactionType type){
        this.transactionValue = transactionValue;
        transactionDate = getDateTime();
        this.type = type;
    }

    public Transaction(double transactionValue, String transactionDate, TransactionType type){
        this.transactionValue = transactionValue;
        this.transactionDate = transactionDate;
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

    public String getData(){
        return transactionDate;
    }

    public double getTransactionValue(){
        return transactionValue;
    }
}
