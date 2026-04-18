package System;

import java.util.ArrayList;

public class Conta {

    private double saldo;
    private String nome;
    private double quantidade;

    private ArrayList<Transacao> extrato = new ArrayList<>();

    public Conta(double saldo){
        this.saldo = saldo;
    }

    public boolean deposito(int quantidade){
        if (quantidade>0){
            saldo+=quantidade;
            extrato.add(new Transacao(quantidade, Transacao.TipoTransacao.DEPOSITO));
            return true;
        }else {
            return false;
        }
    }

    public boolean saque(int quantidade){
        if (quantidade<saldo){
            saldo-=quantidade;
            extrato.add(new Transacao(quantidade, Transacao.TipoTransacao.SAQUE));
            return true;
        }else{
            return false;
        }
    }

    public double getSaldo(){
        return saldo;
    }

    public ArrayList<Transacao> getExtrato(){
        return new ArrayList<>(extrato);
    }
}
