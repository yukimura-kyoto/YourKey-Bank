package System;

public class Transacao {

    private double valorTransacao;
    private String dataTransacao;
    private TipoTransacao tipo;

    public enum TipoTransacao{
        DEPOSITO, SAQUE
    }

    public Transacao(double valorTransacao, String dataTransacao, TipoTransacao tipo){
        this.valorTransacao = valorTransacao;
        this.dataTransacao = dataTransacao;
        this.tipo = tipo;
    }

    public TipoTransacao getTipo(){
        return tipo;
    }

    public double getValorTransacao(){
        return valorTransacao;
    }

    public String getDataTransacao(){
        return dataTransacao;
    }
}
