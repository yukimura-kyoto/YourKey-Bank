package System;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Transacao {

    private double valorTransacao;
    private String dataTransacao;
    private TipoTransacao tipo;

    public enum TipoTransacao{
        DEPOSITO, SAQUE
    }

    public Transacao(double valorTransacao, TipoTransacao tipo){
        this.valorTransacao = valorTransacao;
        dataTransacao = getDateTime();
        this.tipo = tipo;
    }

    private String getDateTime() {
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date date = new Date();
        return dateFormat.format(date);
    }

    public TipoTransacao getTipo(){
        return tipo;
    }

    public String getData(){
        return dataTransacao;
    }

    public double getValorTransacao(){
        return valorTransacao;
    }
}
