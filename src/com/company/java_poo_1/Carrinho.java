package com.company.java_poo_1;

public class Carrinho {
    private Produto[] p;

    public Carrinho() {
        p=new Produto[100];
    }

    public Carrinho(Produto[] p) {
        this.p = p;
    }

    public Produto[] getP() {
        return p;
    }

    public void setP(Produto[] p) {
        this.p = p;
    }

    public void remove(int posicao){
        this.p[posicao]=null;
    }
}
