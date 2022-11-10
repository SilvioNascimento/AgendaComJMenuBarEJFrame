package br.ufpb.dcx.silvio.agenda;

import java.io.Serializable;

public class Contato implements Serializable {

    private String nome;
    private int dia;
    private int mes;

    public Contato(String nome, int dia, int mes) {
        this.nome = nome;
        this.dia = dia;
        this.mes = mes;
    }

    public String getNome() {
        return this.nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public int getDiaAniversariante() {
        return this.dia;
    }
    public void setDiaAniversariante(int dia) {
        this.dia = dia;
    }
    public int getMesAniversariante() {
        return this.mes;
    }
    public void setMesAniversariante(int mes) {
        this.mes = mes;
    }
    public String toString() {
        return "O nome da pessoa é " + this.nome + " e fará aniversário no dia " + this.dia +
                " do mês " + this.mes;
    }
    
}
