package service;

import model.Account;
import model.Transaction;
import model.TransactionStatus;

public class AccountService {
    public TransactionStatus deposit(Account acc, double value){
        if (value <=0) return TransactionStatus.INVALID_VALUE;
        double newBalance = acc.getBalance()+value;
        acc.setBalance(newBalance);
        acc.addTransaction(new Transaction(value, Transaction.TransactionType.DEPOSITO));
        return TransactionStatus.SUCCESS;
    }

    public TransactionStatus withdraw(Account acc, double value){
        if (value <=0) return TransactionStatus.INVALID_VALUE;
        if (value > acc.getBalance()) return TransactionStatus.FAILED;
        double newBalance = acc.getBalance()-value;
        acc.setBalance(newBalance);
        acc.addTransaction(new Transaction(value, Transaction.TransactionType.SAQUE));
        return TransactionStatus.SUCCESS;
    }
}
