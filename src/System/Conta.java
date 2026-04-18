package System;

import java.util.ArrayList;

public class Conta {

    private double saldo;
    private String nome;

    private ArrayList<Transacao> extrato = new ArrayList<>();

    public Conta(double saldo){
        this.saldo = saldo;
    }

    public void deposito(int quantidade){
        if (quantidade<0){
            System.out.println("Valor Invalido");
        }else {
            saldo +=quantidade;
            extrato.add(new Transacao(quantidade, Transacao.TipoTransacao.DEPOSITO));
            System.out.println("Depósito realizado com sucesso");
        }
    }

    public void saque(int quantidade){
        if (quantidade> saldo){
            System.out.println("Valor Invalido");
        }else{
            saldo -=quantidade;
            extrato.add(new Transacao(quantidade, Transacao.TipoTransacao.SAQUE));
            System.out.println("Saque realizado com sucesso");
        }
    }

    public double getSaldo(){
        return saldo;
    }

    public ArrayList<Transacao> getExtrato(){
        return new ArrayList<>(extrato);
    }
}
