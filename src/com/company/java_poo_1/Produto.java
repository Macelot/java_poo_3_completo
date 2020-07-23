package com.company.java_poo_1;

import java.io.Serializable;

abstract class Produto implements Serializable {
    private String nome;
    private Float preco;
    private int id;
    private int quantidade;

//    public Produto(){
//        this.nome="item";
//        this.preco=0.01f;
//    }
//    public Produto(String nome, Float preco) {
//        this.nome = nome;
//        this.preco = preco;
//    }
//
//    public Produto(String nome, float preco, int q, int id){
//        this.id=id;
//        this.nome=nome;
//        this.preco=preco;
//        this.quantidade=q;
//
//    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Float getPreco() {
        return preco;
    }

    public void setPreco(Float preco) {
        this.preco = preco;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    @Override
    public String toString(){
        String resultado="";
        resultado += " id='" + getId() + "'";
        resultado += " nome='" + getNome() + "'";
        resultado += " preço='" + getPreco() + "'";
        resultado += " quant='" + getQuantidade() + "'";

        return resultado;
    }

    public String toStringFile(){
        String resultado="";
        resultado +=  getId() + ";";
        resultado +=  getNome() + ";";
        resultado +=  getPreco() + ";";
        resultado +=  getQuantidade() + ";";
        return resultado;

    }
}
