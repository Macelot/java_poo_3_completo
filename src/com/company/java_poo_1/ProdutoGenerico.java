package com.company.java_poo_1;

import java.io.Serializable;

public class ProdutoGenerico<T> implements Serializable {

   private T produto;

   public ProdutoGenerico(){
   }

   public ProdutoGenerico(T t){
       this.produto=t;
   }

   public void add(T t){
       this.produto=t;
   }

   public T get(){
       return produto;
   }

   @Override
   public String toString(){
       String resultado="";
       resultado = produto.toString();
       return resultado;
   }
}