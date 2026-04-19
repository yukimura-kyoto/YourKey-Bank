package System;

import java.io.*;

public class AccountManager {

    public static void salvarConta(Conta acc){
        try{
            File pasta= new File("Data");
            if (!pasta.exists()) {
                pasta.mkdirs();
            }

            FileWriter fw = new FileWriter("Data/"+acc.getNome()+".txt");
            fw.write(acc.getNome()+"\n");
            fw.write(String.valueOf(acc.getSaldo()+"\n"));

            for (Transacao transacao : acc.getExtrato()){
                String linha = transacao.getTipo()+";"+transacao.getData()+";"+transacao.getValorTransacao();
                fw.write(linha+"\n");
            }
            fw.close();
        }catch (IOException e) {
            System.out.println("Erro ao salvar: " + e.getMessage());
        }
    }

    public static Conta carregarConta(String nome){
        try{
            BufferedReader br = new BufferedReader(new FileReader("Data/"+nome+".txt"));
            String nomeConta = br.readLine();
            double saldo = Double.parseDouble(br.readLine());

            Conta conta = new Conta(saldo, nomeConta);

            String linha;

            while ((linha= br.readLine())!=null){
                String[] partes = linha.split(";");
                Transacao.TipoTransacao tipo = Transacao.TipoTransacao.valueOf(partes[0]);
                String data = (partes[1]);
                double valor = Double.parseDouble(partes[2]);

                Transacao t = new Transacao(valor,data,tipo);
                conta.addTransacao(t);
            }
            return conta;
        }catch (IOException e) {
            System.out.println("Nenhum save encontrado.");
            return new Conta(0,"user");
        }
    }
}
