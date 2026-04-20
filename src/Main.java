import HUD.TerminalUI;
import System.Conta;

import static HUD.TerminalUI.*;
import static System.AccountManager.carregarConta;
import static System.AccountManager.salvarConta;

import System.StatusTransacao;

public class Main {
    static void main(String[] args) {

        Conta acc = carregarConta("user");

        TerminalUI ui = new TerminalUI();
        int opcao;
        StatusTransacao resultado;

        while (true){
            contaMenu();
            opcao=ui.getInt();
            switch (opcao){
                case 1:
                    // get saldo
                    printSaldo(acc);
                    break;
                case 2:
                    // deposito
                    printValorDeposito();
                    resultado = acc.deposito(ui.getDouble());
                    switch (resultado) {
                        case SUCESSO           -> printDepositoSucesso();
                        case VALOR_INVALIDO    -> printValorInvalid();
                    }
                    break;
                case 3:
                    // saque
                    printValorSaque();
                    resultado = acc.saque(ui.getDouble());
                    switch (resultado) {
                        case SUCESSO           -> printSaqueSucesso();
                        case VALOR_INVALIDO    -> printValorInvalid();
                        case FALHA -> printSaqueFalha();
                    }
                    break;
                case 4:
                    // mostrar extrato de transferencia
                    printExtrato(acc);
                    break;
                case 0:
                    System.exit(0);
                default:
                    printOpcaoInvalid();
            }
            salvarConta(acc);
        }
    }
}