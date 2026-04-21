package repository;

import model.Account;
import model.Transaction;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.type.TypeReference;
import java.io.*;

public class AccountRepository {

    static ObjectMapper om = new ObjectMapper();

    public static void saveAccount(Account acc){
        try{
            // isso só cria o banco de dados
            File file = new File("Data");
            if (!file.exists()) {
                file.mkdirs();
            }
            File data = new File("Data/"+acc.getName()+".json");

            om.writerWithDefaultPrettyPrinter().writeValue(data, acc);

        }catch (IOException e) {
            System.out.println("Erro ao salvar: " + e.getMessage());
        }
    }

    public static Account loadAccount(String name){
        try{
            System.out.println("LOAD FOI CHAMADO");
            File file = new File("Data/"+name+".json");

            System.out.println(file.getAbsolutePath());
            System.out.println(file.exists());

            if (!file.exists()) {
                return new Account(0, name);
            }
            Account acc = om.readValue(file,Account.class);

            return acc;
        }catch (IOException e) {
            System.out.println("ENTROU NO CATCH");
            e.printStackTrace();
            return new Account(0,"user");
        }
    }
}
