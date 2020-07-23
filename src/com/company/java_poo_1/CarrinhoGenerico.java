package com.company.java_poo_1;

import java.io.Serializable;

public class CarrinhoGenerico<E> implements Serializable {
    ProdutoGenerico<E>[] p;

    ProdutoGenerico<E> produtoGenerico;

    boolean abandonado;

    public CarrinhoGenerico(int capacidade){
        p=new ProdutoGenerico[capacidade];
    }

    public CarrinhoGenerico(){
        abandonado=true;
    }

    public boolean isAbandonado() {
        return abandonado;
    }

    public void setAbandonado(boolean abandonado) {
        this.abandonado = abandonado;
    }

    public void retiraEstoque(ProdutoGenerico elemento, int posicao){
        retira(posicao);
        this.p[posicao]=elemento;
    }

    public ProdutoGenerico retira(int posicao){
        // se não tem elemento na posição
        // ou posição informada esta fora do intervalo (>=this.p.length ou <0)
        if(posicao<0){
            produtoGenerico = new ProdutoGenerico();
            return produtoGenerico;
        }else if( (this.p[posicao]==null) || (posicao>=this.p.length) ){
            produtoGenerico = new ProdutoGenerico();
            return produtoGenerico;
        }else{
            this.p[posicao]=null;
            return null;
        }

    }

    public boolean guarda(ProdutoGenerico elemento){
        //achar posição vazia
        for (int i = 0; i < this.p.length; i++) {
            if(this.p[i]==null){
                this.p[i]=elemento;
                return true;
            }
        }
        return false;
    }

    public float totalDoCarrinho(){
        float t=0f;
        for (int i = 0; i < this.p.length; i++) {
            if(this.p[i]!=null){
                Produto p = (Produto)this.p[i].get();
                t+=p.getPreco();
            }
        }
        return t;
    }
}
