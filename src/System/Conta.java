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
        }
    }

    public void saque(int quantidade){
        if (quantidade> saldo){
            System.out.println("Valor Invalido");
        }else{
            saldo -=quantidade;
            addExtrato(-quantidade);
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
            System.out.println(extrato.get(i));
        }
    }

}
