package com.company.java_poo_1;

public class Cliente {

    String nome;

    CarrinhoGenerico<Produto> carrinho;
    int t=1;

    public Cliente(){
        //carrinho = new CarrinhoGenerico[t];
        //this.t++;
    }

    public CarrinhoGenerico<Produto> getCarrinho() {
        return carrinho;
    }

    public void setCarrinho(CarrinhoGenerico<Produto> carrinho) {
        this.carrinho = carrinho;
    }


    public Cliente(String nome, CarrinhoGenerico<Produto> carrinho, int t) {
        this.nome = nome;
        this.carrinho = carrinho;
        this.t = t;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }



    /* public int quantasCompras(CarrinhoGenerico[] car){
        int t=0;
        //t=car.p.length;
        //remover as compras abandonadas
        for (int i = 0; i < car.length; i++) {
            //ProdutoGenerico pg = (ProdutoGenerico) car.p[i].get();
            CarrinhoGenerico cg = car[i];
            if(!cg.abandonado){
                t++;
            }
            //if(car.p[i].get().)
        }
        return t;
    } */

    //acho que pode tirar o for
    public int quantasComprasAbandonadas(){
        int t=0;
        //t=car.p.length;
        //remover as compras abandonadas
        for (int i = 0; i < this.carrinho.p.length; i++) {
            //ProdutoGenerico pg = (ProdutoGenerico) car.p[i].get();
            CarrinhoGenerico cg = this.carrinho;
            if(cg.abandonado){
                t++;
            }
            //if(car.p[i].get().)
        }
        return t;
    }


    //TotalDasCompras
    public float totalDasCompras(){
        float t=0f;
        for (int i = 0; i < this.carrinho.p.length; i++) {
            CarrinhoGenerico cg = this.carrinho;
            if(!cg.abandonado){
                for (int j = 0; j < cg.p.length; j++) {
                    ProdutoGenerico pg = (ProdutoGenerico) cg.p[j].get();
                    Produto p = (Produto)pg.get();
                    t+=p.getPreco();
                }
            }
        }
        return t;
    }

    public void abandonar(){
        this.carrinho.setAbandonado(true);
    }

    public int quantClienteDesistiu(Cliente[] cliente){
        int q=0;
        for (int i = 0; i < cliente.length; i++) {
            //pode ser que não temos os 20 clientes, então vamos validar
            if(cliente[i]!=null){
                if(cliente[i].getCarrinho().isAbandonado()){
                    q++;
                }
            }
        }
        return q;
    }

    public float maiorValorGasto(Cliente[] cliente){
        float v=0f;
        //analisar todos 20 clientes
        for (int i = 0; i < cliente.length; i++) {
            //pode ser que não temos os 20 clientes, então vamos validar
            if(cliente[i]!=null){
                //verificar se não é um carrinho abandonado
                if(!cliente[i].getCarrinho().isAbandonado()){
                    //System.out.println("ttttkkkkkkkkkkkkkk");
                    //testar se o total deste carrinho é maior que o v, caso seja maior vamos atribuir este valor em v
                    if(cliente[i].getCarrinho().totalDoCarrinho()>v)
                        v=cliente[i].getCarrinho().totalDoCarrinho();
                }
            }
        }
        return v;
    }

    public float menorValorGasto(Cliente[] cliente){
        float v=Float.MAX_VALUE;

        //analisar todos 20 clientes
        for (int i = 0; i < cliente.length; i++) {
            //pode ser que não temos os 20 clientes, então vamos validar
            if(cliente[i]!=null){
                //verificar se não é um carrinho abandonado
                if(!cliente[i].getCarrinho().isAbandonado()){
                    //System.out.println("ttttkkkkkkkkkkkkkk");
                    //testar se o total deste carrinho é maior que o v, caso seja maior vamos atribuir este valor em v
                    if(cliente[i].getCarrinho().totalDoCarrinho()<v)
                        v=cliente[i].getCarrinho().totalDoCarrinho();
                }
            }
        }
        if(v==Float.MAX_VALUE)
            return 0;
        return v;
    }

    public float valorMedioPorCliente(Cliente[] cliente){
        float v=0f;
        float m=0f;
        int totalClientes=0;
        //analisar todos 20 clientes
        //eliminar clientes que não compraram
        for (int i = 0; i < cliente.length;i++) {
            if(cliente[i]!=null){
                if(cliente[i].getCarrinho().totalDoCarrinho()==0){
                    cliente[i]=null;
                }
            }
        }

        for (int i = 0; i < cliente.length; i++) {
            //pode ser que não temos os 20 clientes, então vamos validar
            if(cliente[i]!=null){
                //verificar se não é um carrinho abandonado
                if(!cliente[i].getCarrinho().isAbandonado()){
                    totalClientes++;
                    v+=cliente[i].getCarrinho().totalDoCarrinho();
                }
            }

        }
        //System.out.println("total c "+totalClientes);
        if(totalClientes==0)
            return 0;
        try {
            m=v/totalClientes;
        }
        catch (Exception err) {
            System.out.println("Erro ao calcular valor médio");
        }
        return m;
    }

    public String vendaRealizadaPorCliente(Cliente[] cliente){
        String r="venda realizada por cliente:\n";
        for (int i = 0; i < cliente.length; i++) {
            //pode ser que não temos os 20 clientes, então vamos validar
            if(cliente[i]!=null){
                //verificar se não é um carrinho abandonado
                if(!cliente[i].getCarrinho().isAbandonado()){
                    for (int j = 0; j < cliente[i].getCarrinho().p.length; j++) {
                        //verificar se tem produto no carrinho
                        if(cliente[i].getCarrinho().p[j]!=null){
                            r+="Cliente ["+cliente[i].getNome()+"]";
                            Produto pg = (Produto) cliente[i].getCarrinho().p[j].get();
                            r+=pg.toString()+"\n";
                            //r+=pg.toStringRelatorio()+"\n";
                        }
                    }
                }
            }
        }
        return r;
    }

    public String produtoQuantidadeValor(Cliente[] cliente, CarrinhoGenerico estoqueCarregado){
        String r="Produto Quantidade Valor\n";
        Relatorio[] rel;
        rel = new Relatorio[100];
        int posicao=0;

        for (int i = 0; i < estoqueCarregado.p.length; i++) {
            if(estoqueCarregado.p[i]!=null){
                Produto pg = (Produto) estoqueCarregado.p[i].get();
                rel[posicao]=new Relatorio();
                rel[posicao].setId(pg.getId());
                rel[posicao].setProduto(pg.getNome());

                int totalVenda=totalVendasProdutoX(cliente, pg.getId());
                rel[posicao].setQuantidade(totalVenda);

                float valor=valorVendasProdutoX(cliente, pg.getId());
                rel[posicao].setValor(valor);
                posicao++;
            }
        }

        for (int i = 0; i < rel.length; i++) {
            if(rel[i]!=null){
                r+=rel[i].getProduto()+"\t";
                r+=rel[i].getQuantidade()+"\t";
                r+=rel[i].getValor()+"\t \n";
            }
        }
        return r;
    }


    public int totalVendasProdutoX(Cliente[] cliente,int x){
        int total=0;
        //analisar todos 20 clientes
        for (int i = 0; i < cliente.length; i++) {
            //pode ser que não temos os 20 clientes, então vamos validar
            if(cliente[i]!=null){
                //verificar se não é um carrinho abandonado
                if(!cliente[i].getCarrinho().isAbandonado()){
                    //System.out.println("ttttkkkkkkkkkkkkkk");
                    //testar se o total deste carrinho é maior que o v, caso seja maior vamos atribuir este valor em v
                    for (int j = 0; j < cliente[i].getCarrinho().p.length; j++) {
                        if(cliente[i].getCarrinho().p[j]!=null){
                            Produto produto = (Produto) cliente[i].getCarrinho().p[j].get();
                            if(x==produto.getId())
                                total++;
                        }
                    }
                }
            }
        }
        return total;
    }

    public float valorVendasProdutoX(Cliente[] cliente,int x){
        float total=0f;
        //analisar todos 20 clientes
        for (int i = 0; i < cliente.length; i++) {
            //pode ser que não temos os 20 clientes, então vamos validar
            if(cliente[i]!=null){
                //verificar se não é um carrinho abandonado
                if(!cliente[i].getCarrinho().isAbandonado()){
                    //System.out.println("ttttkkkkkkkkkkkkkk");
                    //testar se o total deste carrinho é maior que o v, caso seja maior vamos atribuir este valor em v
                    for (int j = 0; j < cliente[i].getCarrinho().p.length; j++) {
                        if(cliente[i].getCarrinho().p[j]!=null){
                            Produto produto = (Produto) cliente[i].getCarrinho().p[j].get();
                            if(x==produto.getId())
                                total+=produto.getPreco();
                        }
                    }
                }
            }
        }
        return total;
    }
}
