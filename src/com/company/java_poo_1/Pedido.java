package com.company.java_poo_1;

import java.util.LinkedList;

public class Pedido {
    CarrinhoGenerico carrinhoGenerico;

    int id;

    //identifica se o pedido foi iniciado ou não, caso tiver true precisa ir para separação, os que tiver false já foram separados, ou seja não precisam ser iniciados
    boolean iniciado;

    //identifica se os produtos foram coletados
    boolean pronto;//enquando estiver com false ainda esta em separação

    //iniciado e pronto serão usados juntos. O pedido pode ser feito e fica em espera para que alguem comece a separar
    //iniciado = true ainda não esta em separação
    //pronto = false esta em separação
    //pronto = true esta liberado para entrega

    //identifia se foi entregue pelo entregador
    boolean entregue;

    //identifica se o pedido foi cancelado
    boolean cancelado;

    //identifica se o pedido foi quase cancelado
    boolean quaseCancelado;

    //tempo para separar os itens
    int ciclos;

    int contaCiclos;

    int ciclosEntrega;//este valor so vai ser setado quando definir o entregador

    int contaCiclosEntrega;

    public CarrinhoGenerico getCarrinhoGenerico() {
        return carrinhoGenerico;
    }

    public void setCarrinhoGenerico(CarrinhoGenerico carrinhoGenerico) {
        this.carrinhoGenerico = carrinhoGenerico;
    }

    public boolean isPronto() {
        return pronto;
    }

    public void setPronto(boolean pronto) {
        this.pronto = pronto;
    }

    public boolean isCancelado() {
        return cancelado;
    }

    public void setCancelado(boolean cancelado) {
        this.cancelado = cancelado;
    }

    public boolean isQuaseCancelado() {
        return quaseCancelado;
    }

    public void setQuaseCancelado(boolean quaseCancelado) {
        this.quaseCancelado = quaseCancelado;
    }

    public int getCiclos() {
        return ciclos;
    }

    public void setCiclos(int ciclos) {
        this.ciclos = ciclos;
    }

    public int getContaCiclos() {
        return contaCiclos;
    }

    public void setContaCiclos(int contaCiclos) {
        this.contaCiclos = contaCiclos;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isEntregue() {
        return entregue;
    }

    public void setEntregue(boolean entregue) {
        this.entregue = entregue;
    }

    public boolean isIniciado() {
        return iniciado;
    }

    public void setIniciado(boolean iniciado) {
        this.iniciado = iniciado;
    }

    public int getCiclosEntrega() {
        return ciclosEntrega;
    }

    public void setCiclosEntrega(int ciclosEntrega) {
        this.ciclosEntrega = ciclosEntrega;
    }

    public int getContaCiclosEntrega() {
        return contaCiclosEntrega;
    }



    public void setContaCiclosEntrega(int contaCiclosEntrega) {
        this.contaCiclosEntrega = contaCiclosEntrega;
    }


    public Pedido getPedido(LinkedList<Pedido> pedidos,int id){
        Pedido ps=new Pedido();
        for (int i = 0; i < pedidos.size(); i++) {
            if(pedidos.get(i).getId()==id){
                ps=pedidos.get(i);
            }
        }
        return ps;
    }

    public LinkedList<Pedido> setaEntregando(LinkedList<Pedido> pedidos,int id,int tempo){
        //na verdade vou apenas colocar o tempo de entrega
        LinkedList<Pedido> ps=pedidos;
        for (int i = 0; i < ps.size(); i++) {
            if(ps.get(i).getId()==id){
                ps.get(i).setCiclosEntrega(tempo);
                //System.out.println("-------------------------------================================="+tempo);
            }
        }
        return ps;
    }

    public LinkedList<Pedido> setaEntregue(LinkedList<Pedido> pedidos,int id){
        LinkedList<Pedido> ps=pedidos;
        for (int i = 0; i < ps.size(); i++) {
            if(ps.get(i).getId()==id){
                ps.get(i).setEntregue(true);
            }
        }
        return ps;
    }

    public LinkedList<Pedido> setaPronto(LinkedList<Pedido> pedidos,int id){
        LinkedList<Pedido> ps=pedidos;
        for (int i = 0; i < ps.size(); i++) {
            if(ps.get(i).getId()==id){
                ps.get(i).setPronto(true);
            }
        }
        return ps;
    }


    public LinkedList<Pedido> setaSeparando(LinkedList<Pedido> pedidos,int id){
        LinkedList<Pedido> ps=pedidos;
        for (int i = 0; i < ps.size(); i++) {
            if(ps.get(i).getId()==id){
                ps.get(i).setIniciado(false);
                ps.get(i).setPronto(false);
            }
        }
        return ps;
    }


    public LinkedList<Pedido> cancelar(LinkedList<Pedido> pedidos){
        LinkedList<Pedido> ps=pedidos;
        for (int i = 0; i < ps.size(); i++) {
            //se não tiver cancelado
            if(!ps.get(i).isCancelado()){
                //precisa estar false no Pronto, isto é não pode estar na entrega
                if(!ps.get(i).isPronto()){
                    ps.get(i).setCancelado(true);
                    return ps;
                }
            }
        }
        return ps;
    }

    public LinkedList<Pedido> removerCancelado(LinkedList<Pedido> pedidos,LinkedList<Pedido> separar){
        int ids=0;
        for (int i = 0; i < pedidos.size(); i++) {
            //se não tiver cancelado
            if(!pedidos.get(i).isCancelado()){
                ids=pedidos.get(i).getId();
                for (int j = 0; j < separar.size(); j++) {
                    if(separar.get(j).getId()==ids){
                        separar.remove(j);
                        return separar;
                    }
                }
            }
        }
        return separar;
    }

    public int prontos(LinkedList<Pedido> pedidos) {
        int t=0;
        for (Pedido p: pedidos) {
            if(p.pronto)
                t++;
        }
        return t;
    }

    public int faltaSeparar(LinkedList<Pedido> pedidos) {
        int t=0;
        for (Pedido p: pedidos) {
            if(!p.pronto)
                t++;
        }
        return t;
    }

    public int entregues(LinkedList<Pedido> pedidos) {
        int t=0;
        for (Pedido p: pedidos) {
            if(p.entregue)
                t++;
        }
        return t;
    }

    public int naoEntregues(LinkedList<Pedido> pedidos) {
        int t=0;
        for (Pedido p: pedidos) {
            if(!p.entregue)
                t++;
        }
        return t;
    }

    //fazer
    public String tempoMedio(LinkedList<Pedido> pedidos) {
        //somente entra para a média os que foram separados e entregues
        String t="";
        int somaTempos=0;
        float media;
        int quantosProntosEntregues=0;
        //vou considerar os ciclos da separação mais entrega
        for (int i = 0; i < pedidos.size(); i++) {
            if((pedidos.get(i).isPronto()) && (pedidos.get(i).isEntregue())){
                quantosProntosEntregues++;
                somaTempos+=pedidos.get(i).getCiclos();
                somaTempos+=pedidos.get(i).getCiclosEntrega();
//                System.out.println("Pedido "+i);
//                System.out.println(" ciclos   "+pedidos.get(i).getCiclos());
//                System.out.println(" ciclosEn "+pedidos.get(i).getCiclosEntrega());
            }

        }
        media=somaTempos/quantosProntosEntregues;
        return String.format("%5.2f",media);
    }

    public String maisTempo(LinkedList<Pedido> pedidos) {
        int tempo=0;
        int somaTempos;
        //vou considerar os ciclos da separação mais entrega
        for (int i = 0; i < pedidos.size(); i++) {
            if((pedidos.get(i).isPronto()) && (pedidos.get(i).isEntregue())){
                somaTempos=pedidos.get(i).getCiclos()+pedidos.get(i).getCiclosEntrega();
                if(somaTempos>tempo){
                    tempo=somaTempos;
                }
            }
        }
        return String.format("%2d",tempo);
    }

    //verificar os pedidos separados e entregados
    public String SepEnt(LinkedList<Pedido> pedidos) {
        String r="";
        int sep=0;
        int ent=0;
        for (int i = 0; i < pedidos.size(); i++) {
            if(pedidos.get(i).isPronto()){
                sep++;
            }
            if(pedidos.get(i).isEntregue()){
                ent++;
            }
        }
        r+="Separados "+sep+", ";
        r+="Entregues "+ent;
        return r;
    }

    public int quase(LinkedList<Pedido> pedidos) {
        int r=0;
        for (int i = 0; i < pedidos.size(); i++) {
            // para ser quase cancelado, precisa estar já iniciado e nao ter sido definido o ciclosEntrega
            if((pedidos.get(i).isIniciado())&&(pedidos.get(i).getCiclosEntrega()==0)){
                r++;
            }
        }
        return r;
    }

    public int contaCancelados(LinkedList<Pedido> pedidos) {
        int r=0;
        for (int i = 0; i < pedidos.size(); i++) {
            // para ser quase cancelado, precisa estar já iniciado e nao ter sido definido o ciclosEntrega
            if(pedidos.get(i).isCancelado()){
                r++;
            }
        }
        return r;
    }
}
