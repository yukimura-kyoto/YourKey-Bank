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

    public StatusTransacao deposito(int quantidade){
        if (quantidade<=0) return StatusTransacao.VALOR_INVALIDO;
        saldo+=quantidade;
        extrato.add(new Transacao(quantidade, Transacao.TipoTransacao.DEPOSITO));
        return StatusTransacao.SUCESSO;
    }

    public StatusTransacao saque(int quantidade){
        if (quantidade<=0) return StatusTransacao.VALOR_INVALIDO;
        if (quantidade>saldo) return StatusTransacao.FALHA;
        saldo-=quantidade;
        extrato.add(new Transacao(quantidade, Transacao.TipoTransacao.SAQUE));
        return StatusTransacao.SUCESSO;
    }

    public double getSaldo(){
        return saldo;
    }

    public ArrayList<Transacao> getExtrato(){
        return new ArrayList<>(extrato);
    }
}
