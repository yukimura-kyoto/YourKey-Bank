package System;

import java.util.ArrayList;

public class Conta {

    private double saldo;
    private String nome;

    private ArrayList<Integer> extrato = new ArrayList<>();

    public Conta(double saldo){
        this.saldo = saldo;
    }

    public void deposito(int quantidade){
        if (quantidade<0){
            System.out.println("Valor Invalido");
        }else {
            saldo +=quantidade;
            addExtrato(quantidade);
            System.out.println("Depósito realizado com sucesso");
        }
    }

    public void saque(int quantidade){
        if (quantidade> saldo){
            System.out.println("Valor Invalido");
        }else{
            saldo -=quantidade;
            addExtrato(quantidade);
            System.out.println("Saque realizado com sucesso");
        }
    }

    public double getSaldo(){
        return saldo;
    }

    private void addExtrato(int valor) {
        extrato.add(valor);
    }

    public void mostrarExtrato() {
        System.out.println("=== EXTRATO ===");

        for (int i = 0; i < extrato.size(); i++) {

            int visual = extrato.get(i);

            if (visual>=0){
                System.out.println("▲ Depósito: "+visual);
            } else {
                System.out.println("▼ Saque: "+visual);
            }
        }
    }

}
