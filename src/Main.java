import System.Conta;

import java.util.Scanner;

import static HUD.Interface.contaMenu;

public class Main {

    static void main() {

        Conta acc = new Conta(0);
        Scanner sc = new Scanner(System.in);

        while (true){
            contaMenu();
            int z = sc.nextInt();
            switch (z){
                case 1:
                    // get saldo
                    System.out.println(acc.getSaldo());
                    break;
                case 2:
                    // deposito
                    int i = sc.nextInt();
                    acc.deposito(i);
                    System.out.println(acc.getSaldo());
                    break;
                case 3:
                    // saque
                    int b = sc.nextInt();
                    acc.saque(b);
                    System.out.println(acc.getSaldo());
                    break;
                case 4:
                    // mostrar extrato de transferencia
                    acc.mostrarExtrato();
                case 0:
                    System.exit(0);
                default:
            }
        }
    }
}