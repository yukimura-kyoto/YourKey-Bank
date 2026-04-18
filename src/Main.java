import HUD.TerminalUI;
import System.Conta;

import java.util.Scanner;

import static HUD.TerminalUI.*;

public class Main {
    static void main(String[] args) {

        Conta acc = new Conta(0);
        TerminalUI ui = new TerminalUI();

        while (true){
            contaMenu();
            int c=ui.getInput();
            switch (c){
                case 1:
                    // get saldo
                    break;
                case 2:
                    // deposito
                    int a=ui.getInput();
                    acc.deposito(a);
                    break;
                case 3:
                    // saque
                    int b=ui.getInput();
                    acc.saque(b);
                    break;
                case 4:
                    // mostrar extrato de transferencia
                    printExtrato(acc);
                    break;
                case 0:
                    System.exit(0);
                default:
                    printInvalid();
            }
        }
    }
}