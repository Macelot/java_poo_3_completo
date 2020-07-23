package com.company.java_poo_1;

public class Separador {
    String nome;
    int pedidosSeparados;
    int cicloAtual;
    int contaCiclo;
    boolean ocupado;
    int idPedido;

    public Separador (){

    }

    public Separador (String n,Boolean ocupado){
        this.nome=n;
        this.ocupado=ocupado;

    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getPedidosSeparados() {
        return pedidosSeparados;
    }

    public void setPedidosSeparados(int pedidosSeparados) {
        this.pedidosSeparados = pedidosSeparados;
    }


    public int getContaCiclo() {
        return contaCiclo;
    }

    public void setContaCiclo(int contaCiclo) {
        this.contaCiclo = contaCiclo;
    }

    public boolean isOcupado() {
        return ocupado;
    }

    public void setOcupado(boolean ocupado) {
        this.ocupado = ocupado;
    }

    public int getCicloAtual() {
        return cicloAtual;
    }

    public void setCicloAtual(int cicloAtual) {
        this.cicloAtual = cicloAtual;
    }

    public int getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }



    public String separouMais(Separador[] ps){
        String r="";
        //achar maior
        int m=0;
        if((ps[0].getPedidosSeparados()>=ps[1].getPedidosSeparados())&&(ps[0].getPedidosSeparados()>=ps[2].getPedidosSeparados())){
            m=ps[0].getPedidosSeparados();
        }else if((ps[1].getPedidosSeparados()>=ps[0].getPedidosSeparados())&&(ps[1].getPedidosSeparados()>=ps[2].getPedidosSeparados())){
            m=ps[1].getPedidosSeparados();
        }else{
            m=ps[2].getPedidosSeparados();
        }
//        System.out.println(ps[0].getPedidosSeparados());
//        System.out.println(ps[1].getPedidosSeparados());
//        System.out.println(ps[2].getPedidosSeparados());

        //retornar o nome de todos que tem a quantidde igual a este maior
        if(ps[0].getPedidosSeparados()==m){
            r+=ps[0].getNome()+" ";
        }
        if(ps[1].getPedidosSeparados()==m){
            r+=ps[1].getNome()+" ";
        }
        if(ps[2].getPedidosSeparados()==m){
            r+=ps[2].getNome()+" ";
        }
        return r;
    }
}
