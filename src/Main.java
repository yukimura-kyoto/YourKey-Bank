import HUD.TerminalUI;
import model.Account;

import static HUD.TerminalUI.*;
import static repository.AccountRepository.loadAccount;
import static repository.AccountRepository.saveAccount;

import model.TransactionStatus;
import service.AccountService;

public class Main {
    static void main(String[] args) {

        Account acc = loadAccount("user");
        AccountService accService = new AccountService();

        TerminalUI ui = new TerminalUI();
        int opcao;
        TransactionStatus resultado;

        while (true){
            contaMenu();
            opcao=ui.getInt();
            switch (opcao){
                case 1:
                    // get saldo
                    printSaldo(acc);
                    break;
                case 2:
                    // deposit
                    printValorDeposito();
                    resultado = accService.deposit(acc,ui.getDouble());
                    switch (resultado) {
                        case SUCCESS -> printDepositoSucesso();
                        case INVALID_VALUE -> printValorInvalid();
                    }
                    break;
                case 3:
                    // withdraw
                    printValorSaque();
                    resultado = accService.withdraw(acc,ui.getDouble());
                    switch (resultado) {
                        case SUCCESS -> printSaqueSucesso();
                        case INVALID_VALUE -> printValorInvalid();
                        case FAILED -> printSaqueFalha();
                    }
                    break;
                case 4:
                    // mostrar extrato de transferencia
                    printExtrato(acc);
                    break;
                case 0:
                    saveAccount(acc);
                    System.exit(0);
                default:
                    printOpcaoInvalid();
            }
            saveAccount(acc);
        }
    }
}