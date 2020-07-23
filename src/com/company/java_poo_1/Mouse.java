package com.company.java_poo_1;

import java.io.Serializable;

public class Mouse extends ProdutoBasico implements Serializable {
    String tipo;
    String cor;

    public Mouse() {
    }

    public Mouse(String tipo, String cor) {
        this.tipo = tipo;
        this.cor = cor;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }


    @Override
    public String toString(){
        String resultado=super.toString();
        resultado += " tipo='" + getTipo()+ "'";
        resultado += " cor='" + getCor()+ "'";
        return resultado;

    }

    @Override
    public String toStringFile(){
        String resultado=super.toStringFile();
        resultado += getTipo() + ";";
        resultado += getCor() + "\n";
        return resultado;
    }


}
