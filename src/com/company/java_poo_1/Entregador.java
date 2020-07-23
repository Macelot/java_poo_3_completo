package com.company.java_poo_1;

import java.util.Random;


public class Entregador {
    String nome;
    int tempo;
    Random t;
    Boolean ocupado;
    int clicoAtual;
    int contaCiclo;
    int pedidosEntregues;
    int idPedido;


    public Entregador(){
    }

    public Entregador(String n,Boolean ocupado){
        t=new Random();
        this.tempo=t.nextInt(5)+4;//nao ficou claro se os ciclos mudam a cada nova entrega, fiz fixo aqui mas modifico depois sempre
        this.nome=n;
        this.ocupado=ocupado;

    }

    public int getTempo() {
        return tempo;
    }

    public void setTempo(int tempo) {
        this.tempo = tempo;
    }

    public Random getT() {
        return t;
    }

    public void setT(Random t) {
        this.t = t;
    }

    public Boolean isOcupado() {
        return ocupado;
    }

    public void setOcupado(Boolean ocupado) {
        this.ocupado = ocupado;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getPedidosEntregues() {
        return pedidosEntregues;
    }

    public void setPedidosEntregues(int pedidosEntregues) {
        this.pedidosEntregues = pedidosEntregues;
    }



    public int getClicoAtual() {
        return clicoAtual;
    }

    public void setClicoAtual(int clicoAtual) {
        this.clicoAtual = clicoAtual;
    }

    public int getContaCiclo() {
        return contaCiclo;
    }

    public void setContaCiclo(int contaCiclo) {
        this.contaCiclo = contaCiclo;
    }

    public int getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }



    public String entregouMais(Entregador[] es){
        String r="";
        //achar maior
        int m=0;
        if((es[0].getPedidosEntregues()>=es[1].getPedidosEntregues())&&(es[0].getPedidosEntregues()>=es[2].getPedidosEntregues())){
            m=es[0].getPedidosEntregues();
        }else if((es[1].getPedidosEntregues()>=es[0].getPedidosEntregues())&&(es[1].getPedidosEntregues()>=es[2].getPedidosEntregues())){
            m=es[1].getPedidosEntregues();
        }else{
            m=es[2].getPedidosEntregues();
        }

//        System.out.println(es[0].getPedidosEntregues());
//        System.out.println(es[1].getPedidosEntregues());
//        System.out.println(es[2].getPedidosEntregues());

        //retornar o nome de todos que tem a quantidde igual a este maior
        if(es[0].getPedidosEntregues()==m){
            r+=es[0].getNome()+" ";
        }
        if(es[1].getPedidosEntregues()==m){
            r+=es[1].getNome()+" ";
        }
        if(es[2].getPedidosEntregues()==m){
            r+=es[2].getNome()+" ";
        }
        return r;
    }
}
