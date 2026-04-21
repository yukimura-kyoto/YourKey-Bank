package repository;

import model.Account;
import model.Transaction;

import java.io.*;

public class AccountRepository {

    public static void saveAccount(Account acc){
        try{
            File file = new File("Data");
            if (!file.exists()) {
                file.mkdirs();
            }

            FileWriter fw = new FileWriter("Data/"+acc.getName()+".txt");
            fw.write(acc.getName()+"\n");
            fw.write(String.valueOf(acc.getBalance()+"\n"));

            for (Transaction transaction : acc.getStatement()){
                String line = transaction.getType()+";"+ transaction.getData()+";"+ transaction.getTransactionValue();
                fw.write(line +"\n");
            }
            fw.close();
        }catch (IOException e) {
            System.out.println("Erro ao salvar: " + e.getMessage());
        }
    }

    public static Account loadAccount(String name){
        try{
            BufferedReader br = new BufferedReader(new FileReader("Data/"+ name +".txt"));
            String accountName = br.readLine();
            double balance = Double.parseDouble(br.readLine());

            Account acc = new Account(balance, accountName);

            String line;

            while ((line = br.readLine())!=null){
                String[] parts = line.split(";");
                Transaction.TransactionType type = Transaction.TransactionType.valueOf(parts[0]);
                String date = (parts[1]);
                double value = Double.parseDouble(parts[2]);

                Transaction t = new Transaction(value, date,type);
                acc.addTransaction(t);
            }
            return acc;
        }catch (IOException e) {
            System.out.println("Nenhum save encontrado.");
            return new Account(0,"user");
        }
    }
}
