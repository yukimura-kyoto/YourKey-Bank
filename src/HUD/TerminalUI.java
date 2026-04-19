package HUD;

import java.util.ArrayList;
import java.util.Scanner;
import System.Conta;
import System.Transacao;

public class TerminalUI {

    static Scanner sc = new Scanner(System.in);


    public int getInput(){
        return sc.nextInt();
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
        System.out.println("Valor Invalido. Tente Novamente");
    }

    public static void printOpcaoInvalid(){
        System.out.println("Opcão Invalida");
    }

    public static void printSaldo(Conta acc){
        System.out.println("Seu saldo atual é: R$"+acc.getSaldo());
    }

    public static void printExtrato(Conta acc){
        System.out.println("\n=================== EXTRATO ===================");
        ArrayList<Transacao> extrato = acc.getExtrato();

        for (Transacao transacao:extrato){
            String seta = (transacao.getTipo()==Transacao.TipoTransacao.SAQUE) ? "▼" : "▲";
            double valorFormat = transacao.getValorTransacao();
            String tipoFormat = transacao.getTipo().name();
            String dataFormat = transacao.getData();

            String transacaoFormat = String.format("%s | %-8s | %s R$ %8.2f",dataFormat,tipoFormat,seta,valorFormat);
            System.out.println(transacaoFormat);
        }
        System.out.println("===============================================\n");
    }

    public static void printValorDeposito(){
        System.out.print("Digite o valor do depósito: ");
    }

    public static void printValorSaque(){
        System.out.print("Digite o valor do saque: ");
    }
}
