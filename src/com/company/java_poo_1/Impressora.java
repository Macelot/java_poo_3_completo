package com.company.java_poo_1;

import java.io.Serializable;
public class Impressora extends ProdutoBasico implements Serializable{
    //public class Impressora extends Produto{
    String cor;
    int quantidadeTanque;


    public Impressora() {

    }

    public Impressora(String cor, int quantidadeTanque) {
        this.cor = cor;
        this.quantidadeTanque = quantidadeTanque;
    }

    public Impressora cor(String cor) {
        this.cor = cor;
        return this;
    }

    public Impressora quantidade(int quantidade) {
        this.quantidadeTanque = quantidade;
        return this;
    }

    public String getCor() {
        return this.cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public int getQuantidadeTanque() {
        return quantidadeTanque;
    }

    public void setQuantidadeTanque(int quantidadeTanque) {
        this.quantidadeTanque = quantidadeTanque;
    }

    @Override
    public String toString(){
        String resultado=super.toString();
        resultado += " cor='" + getCor()+ "'";
        resultado += " quantidade Tanque='" + getQuantidadeTanque()+ "'";
        return resultado;
    }

    //@Override
    public String toStringFile(){
        String resultado=super.toString();
        resultado += getCor() + ";";
        resultado += getQuantidadeTanque() + "\n";
        return resultado;
    }

}