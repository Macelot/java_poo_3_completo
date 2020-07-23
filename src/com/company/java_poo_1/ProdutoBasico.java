package com.company.java_poo_1;

public class ProdutoBasico extends Produto {

    public ProdutoBasico(){
        this.setNome("item");
        this.setPreco(0.01f);
    }
    public ProdutoBasico(String nome, Float preco) {
        this.setNome(nome);
        this.setPreco(preco);
    }

    public ProdutoBasico(String nome, float preco, int q, int id){
        this.setId(id);
        this.setNome(nome);
        this.setPreco(preco);
        this.setQuantidade(q);
    }

}
