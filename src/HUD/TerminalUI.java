package HUD;

import java.util.ArrayList;
import java.util.Scanner;
import model.Account;
import model.Transaction;

public class TerminalUI {

    static Scanner sc = new Scanner(System.in);


    public int getInt(){
        while(true){
            try {
                return Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                printOpcaoInvalid();
            }
        }
    }

    public double getDouble(){
        while(true){
            try {
                return Double.parseDouble(sc.nextLine());
            } catch (NumberFormatException e) {
                printValorInvalid();
            }
        }
    }

    public static void contaMenu(){
        System.out.println("===== MENU =====");
        System.out.println("1 - Checar Saldo");
        System.out.println("2 - Depósito");
        System.out.println("3 - Sacar");
        System.out.println("4 - Extrato");
        System.out.println("0 - Sair");
        System.out.print("Escolha uma opção: ");
    }

    public static void printDepositoSucesso(){
        System.out.println("Depósito realizado com sucesso. Saldo atualizado.");
    }

    public static void printSaqueSucesso(){
        System.out.println("Saque realizado com sucesso. Saldo atualizado.");
    }

    public static void printSaqueFalha(){
        System.out.println("Saldo Insuficiente");
    }

    public static void printValorInvalid(){
        System.out.print("Valor Invalido. Tente Novamente: ");
    }

    public static void printOpcaoInvalid(){
        System.out.print("Opcão Invalida. Tente Novamente: ");
    }

    public static void printDigiteValorValido(){
        System.out.println("Por favor digite um Valor valido");
    }

    public static void printSaldo(Account acc){
        System.out.println("Seu saldo atual é: R$"+acc.getBalance());
    }

    public static void printExtrato(Account acc){
        System.out.println("\n=================== EXTRATO ===================");
        ArrayList<Transaction> extrato = acc.getStatement();

        for (Transaction transacao:extrato){
            String seta = (transacao.getType()== Transaction.TransactionType.SAQUE) ? "▼" : "▲";
            double valorFormat = transacao.getTransactionValue();
            String tipoFormat = transacao.getType().name();
            String dataFormat = transacao.getDate();

            String transacaoFormat = String.format("%s | %-8s | %s R$ %8.2f",dataFormat,tipoFormat,seta,valorFormat);
            System.out.println(transacaoFormat);
        }
        System.out.println("===============================================\n"+"Saldo Atual: R$"+String.format("%8.2f",acc.getBalance()));
    }

    public static void printValorDeposito(){
        System.out.print("Digite o valor do depósito: ");
    }

    public static void printValorSaque(){
        System.out.print("Digite o valor do withdraw: ");
    }
}
