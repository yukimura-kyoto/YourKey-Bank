package System;

import java.util.ArrayList;

public class Conta {

    private double saldo;
    private String nome;
    private double quantidade;

    private ArrayList<Transacao> extrato = new ArrayList<>();

    public Conta(double saldo, String nome){
        this.saldo = saldo;
        this.nome = nome;
    }

    public StatusTransacao deposito(double quantidade){
        if (quantidade<=0) return StatusTransacao.VALOR_INVALIDO;
        saldo+=quantidade;
        addTransacao(new Transacao(quantidade, Transacao.TipoTransacao.DEPOSITO));
        return StatusTransacao.SUCESSO;
    }

    public StatusTransacao saque(double quantidade){
        if (quantidade<=0) return StatusTransacao.VALOR_INVALIDO;
        if (quantidade>saldo) return StatusTransacao.FALHA;
        saldo-=quantidade;
        addTransacao(new Transacao(quantidade, Transacao.TipoTransacao.SAQUE));
        return StatusTransacao.SUCESSO;
    }

    public double getSaldo(){
        return saldo;
    }

    public String getNome(){
        return nome;
    }

    public void addTransacao(Transacao t){
        extrato.add(t);
    }

    public ArrayList<Transacao> getExtrato(){
        return new ArrayList<>(extrato);
    }
}
