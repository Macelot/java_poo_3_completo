package com.company.java_poo_1;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
	    // write your code here
        ProdutoBasico p = new ProdutoBasico();
        System.out.println(p.toString());

        Carrinho carrinho = new Carrinho();
        System.out.println("Tamanho do carrinho "+carrinho.getP().length);

        p = new ProdutoBasico("Notebook",1500.00f);
        System.out.println(p.toString());

        System.out.printf("Colocando Notebook no carrinho");
        carrinho.getP()[0]=p;

        Produto p2;
        p2 = new ProdutoBasico("Pen",30.0f);
        System.out.printf("Colocando Pen no carrinho");
        carrinho.getP()[1]=p2;

        Armazenamento armazenamento;
        armazenamento = new Armazenamento();
        armazenamento.setNome("SSD");
        armazenamento.setUnidade("T");

        Armazenamento armazenamento2;
        armazenamento2 = new Armazenamento();
        armazenamento2.setCapacidade(32);

        System.out.printf("Colocando armazenamento e armazenamento2 no carrinho");
        carrinho.getP()[2]=armazenamento;
        carrinho.getP()[3]=armazenamento2;

        System.out.println("Conteudo do carrinho");
        for (int i =0;i<carrinho.getP().length;i++){
            if(carrinho.getP()[i]!=null){
                System.out.println(carrinho.getP()[i].toString());
            }
        }
        System.out.println("Removendo Pen");
        carrinho.remove(1);
        System.out.println("-----------------");
        for (int i =0;i<carrinho.getP().length;i++){
            if(carrinho.getP()[i]!=null){
                System.out.println(carrinho.getP()[i].toString());
            }
        }
        System.out.println("Testes genericos");
        CarrinhoGenerico carrinhoGenerico;
        carrinhoGenerico = new CarrinhoGenerico<>(10);
        ProdutoGenerico produtoGenerico;
        produtoGenerico=new ProdutoGenerico();

        produtoGenerico.add(p);
        carrinhoGenerico.guarda(produtoGenerico);

        produtoGenerico = new ProdutoGenerico();
        produtoGenerico.add(armazenamento);
        carrinhoGenerico.guarda(produtoGenerico);

        produtoGenerico = new ProdutoGenerico();
        produtoGenerico.add(armazenamento2);
        carrinhoGenerico.guarda(produtoGenerico);

        System.out.println("Impressão do Carrinho Genérico");
        for (int i=0;i<carrinhoGenerico.p.length;i++){
            if (carrinhoGenerico.p[i]!=null){
                System.out.println(carrinhoGenerico.p[i].toString());
            }
        }

        System.out.println("Retira SSD");
        carrinhoGenerico.retira(1);

        System.out.println("impressão depois de retirar o SSD");
        for (int i = 0; i < carrinhoGenerico.p.length; i++) {
            if(carrinhoGenerico.p[i]!=null){
                System.out.println(carrinhoGenerico.p[i].toString());
            }
        }

        Mouse mouse;
        mouse = new Mouse("USB","Preto");
        produtoGenerico=new ProdutoGenerico();
        produtoGenerico.add(mouse);
        carrinhoGenerico.guarda(produtoGenerico);
        System.out.println("Com o Mouse");
        for (int i = 0; i < carrinhoGenerico.p.length; i++) {
            if(carrinhoGenerico.p[i]!=null){
                System.out.println(carrinhoGenerico.p[i].toString());
            }
        }

        System.out.println("####################################");
        Mouse m_ = (Mouse) produtoGenerico.get();
        System.out.println("o m é um mouse USB preto");
        System.out.println(m_.toString());

        Object m2 = produtoGenerico.get();//é o mesmo mouse USB preto
        Armazenamento a = new Armazenamento();
        if(m2.getClass().isInstance(a)){
            a=(Armazenamento)m2;
            System.out.println("é um armazenamento "+a.toString());
            a.setCapacidade(10);
        }
        System.out.println("Setando o mouse para Branco");
        Mouse m3 = new Mouse();
        if(m2.getClass().isInstance(m3)){
            m3=(Mouse) m2;
            m3.setCor("Branco");
            System.out.println("é um mouse "+m3.toString());
        }

        System.out.println("----teste No arquivo Texto");
        ProdutoGenerico produtoGenerico2;
        CarrinhoGenerico estoqueNoArquivoTexto;
        estoqueNoArquivoTexto = new CarrinhoGenerico<>(14);


        System.out.println("Criando 10 Pen");
        Float preco_;
        int quant_;
        int id_;
        for (int i=0;i<10; i++){
            preco_=(50.0f)+(i*5);
            quant_=(i+100);
            id_=(i+1);
            p = new Armazenamento("Pen ", preco_, quant_, id_);
            int capacidade_=512;
            String unidade_="GB";
            p = new Armazenamento("Pen ", preco_, quant_, id_, capacidade_, unidade_);
            produtoGenerico2=new ProdutoGenerico();
            produtoGenerico2.add(p);
            estoqueNoArquivoTexto.guarda(produtoGenerico2);
        }

        //modificado
        //Mouse
        produtoGenerico2=new ProdutoGenerico();
        m3.setId(11);
        m3.setQuantidade(500);
        m3.setPreco(200.00f);
        produtoGenerico2.add(m3);
        estoqueNoArquivoTexto.guarda(produtoGenerico2);

        produtoGenerico2=new ProdutoGenerico();
        armazenamento.setId(12);
        armazenamento.setQuantidade(400);
        armazenamento.setPreco(255.00f);
        produtoGenerico2.add(armazenamento);
        estoqueNoArquivoTexto.guarda(produtoGenerico2);

        produtoGenerico2=new ProdutoGenerico();
        armazenamento2.setId(13);
        armazenamento2.setQuantidade(300);
        armazenamento2.setPreco(290.00f);
        produtoGenerico2.add(armazenamento2);
        boolean armazenou = estoqueNoArquivoTexto.guarda(produtoGenerico2);
        if(armazenou){
            System.out.println("O produto armazenamento2 foi armazenado com sucesso");
        }
        //adicionar um impressora
        Impressora impressora;
        impressora = new Impressora();
        impressora.setId(14);
        impressora.setCor("Monocromática");
        impressora.setQuantidadeTanque(400);
        produtoGenerico2=new ProdutoGenerico();
        produtoGenerico2.add(impressora);
        estoqueNoArquivoTexto.guarda(produtoGenerico2);

        Estoque estoque;
        estoque = new Estoque();
        estoque.gravaEstoqueInicio(estoqueNoArquivoTexto);

        CarrinhoGenerico estoqueCarregado = estoque.leEstoque();
        System.out.println("Estoque estoqueCarregado ***************************");
        for (int i = 0; i < estoqueCarregado.p.length; i++) {
            if(estoqueCarregado.p[i]!=null){
                System.out.println(estoqueCarregado.p[i].get().toString());
                //System.out.println(estoqueCarregado.p[i].toString());
            }
        }

        //Live #3--------------------------------------------------------------------------------

        Cliente[] cliente = new Cliente[20];
        Cliente clienteOperacoes = new Cliente();

        CarrinhoGenerico<Produto> c1;
        c1=new CarrinhoGenerico();
        cliente[0]=new Cliente();
        cliente[0].setNome("Cliente Zero");
        cliente[0].setCarrinho(c1);
        cliente[0].setCarrinho(new CarrinhoGenerico<>(5));
        cliente[0].getCarrinho().setAbandonado(false);

        //comprou primeiro penDrive
         p = (ProdutoBasico) estoqueCarregado.p[0].get();
        if((p.getQuantidade()>0)){
            //adicionar no carrinho
            cliente[0].getCarrinho().guarda(estoqueCarregado.p[0]);
            //setar nova quantidade
            estoque.retiraEstoque(p);
        }else{
            System.out.println("Quantidade insuficiente");
        }

        System.out.println("atualizar estoque***************************");
        estoque.gravaEstoqueInicio(estoqueCarregado);
        estoqueCarregado = estoque.leEstoque();

        System.out.println("Mostra Estoque comprou primeiro pen");
        System.out.println(estoque.mostra(estoqueCarregado));

        //comprou segundo penDrive
        p = (ProdutoBasico) estoqueCarregado.p[1].get();
        if((p.getQuantidade()>0)){
            //adicionar no carrinho
            cliente[0].getCarrinho().guarda(estoqueCarregado.p[1]);
            //setar nova quantidade
            estoque.retiraEstoque(p);
        }else{
            System.out.println("Quantidade insuficiente");
        }

        //atualizar estoque
        estoque.gravaEstoqueInicio(estoqueCarregado);
        estoqueCarregado = estoque.leEstoque();

        System.out.println("Mostra Estoque comprou segundo Pen");
        System.out.println(estoque.mostra(estoqueCarregado));

        CarrinhoGenerico<Produto> c2;
        c2=new CarrinhoGenerico();
        cliente[1]=new Cliente();
        cliente[1].setNome("Cliente Um");
        cliente[1].setCarrinho(c2);
        cliente[1].setCarrinho(new CarrinhoGenerico<>(20));
        cliente[1].getCarrinho().setAbandonado(false);

        //comprou segundo penDrive. ja vendeu 2
        p2 = (ProdutoBasico) estoqueCarregado.p[1].get();
        if((p2.getQuantidade()>0)){
            cliente[1].getCarrinho().guarda(estoqueCarregado.p[1]);
            estoque.retiraEstoque(p2);
        }else{
            System.out.println("Quantidade insuficiente");
        }

        //comprou segundo penDrive ja vendeu 3
        if((p2.getQuantidade()>0)){
            //adicionar no carrinho
            cliente[1].getCarrinho().guarda(estoqueCarregado.p[1]);
            //setar nova quantidade
            estoque.retiraEstoque(p2);
        }else{
            System.out.println("Quantidade insuficiente");
        }
        //comprou segundo penDrive ja vendeu 4
        if((p2.getQuantidade()>0)){
            //adicionar no carrinho
            cliente[1].getCarrinho().guarda(estoqueCarregado.p[1]);
            //setar nova quantidade
            estoque.retiraEstoque(p2);
        }else{
            System.out.println("Quantidade insuficiente");
        }

        //comprou segundo penDrive novamente  ja vendeu 5
        p2 = (Produto) estoqueCarregado.p[1].get();
        if((p2.getQuantidade()>0)){
            //adicionar no carrinho
            cliente[1].getCarrinho().guarda(estoqueCarregado.p[1]);
            //setar nova quantidade
            p2.setQuantidade(p2.getQuantidade()-1);
        }else{
            System.out.println("Quantidade insuficiente");
        }

        //atualizar estoque
        estoque.gravaEstoqueInicio(estoqueCarregado);
        estoqueCarregado = estoque.leEstoque();

        System.out.println("Mostra Estoque comprou segundo Pen 5 vezes");
        System.out.println(estoque.mostra(estoqueCarregado));

        //cliente desistir compra
//        cliente[0].abandonar();
//        estoqueCarregado=estoque.devolveEstoque(estoqueCarregado,cliente[0].getCarrinho());
//
//        cliente[1].abandonar();
//        estoqueCarregado=estoque.devolveEstoque(estoqueCarregado,cliente[1].getCarrinho());
//
//        //atualizar estoque
//        estoque.gravaEstoqueInicio(estoqueCarregado);
//        estoqueCarregado = estoque.leEstoque();

        System.out.println("Os dois clientes desistiram das compras");
        System.out.println(estoque.mostra(estoqueCarregado));

        //produto quantidade valor
        String produtoQuantidadeValor=clienteOperacoes.produtoQuantidadeValor(cliente,estoqueCarregado);

        //venda realizada por cliente
        String vendaRealizadaPorCliente=clienteOperacoes.vendaRealizadaPorCliente(cliente);

        //valor médio por cliente,
        float valorMedioPorCliente=clienteOperacoes.valorMedioPorCliente(cliente);

        //o  menor valor gasto
        float menorValorGasto=clienteOperacoes.menorValorGasto(cliente);

        //o maior valor gasto
        float maiorValorGasto=clienteOperacoes.maiorValorGasto(cliente);

        //quantidade cliente desistiu
        Integer quantClienteDesistiu=clienteOperacoes.quantClienteDesistiu(cliente);

        //gravar arquivo vendas
        System.out.println("Geração de relatório de Vendas");
        estoque.gravaVendas(produtoQuantidadeValor,vendaRealizadaPorCliente,valorMedioPorCliente,menorValorGasto,maiorValorGasto,quantClienteDesistiu);

        System.out.println("----------------------------Parte final Simulação--------------------------");
        LinkedList<Pedido> pedidos;
        pedidos = new LinkedList<>();

        LinkedList<Pedido> pedidosSeparar;
        pedidosSeparar = new LinkedList<>();

        LinkedList<Pedido> pedidosEntregar;
        pedidosEntregar = new LinkedList<>();

        Pedido pedidoOperacoes;
        pedidoOperacoes = new Pedido();

        Separador[] separador;
        separador = new Separador[3];

        Separador pcOperacoes;
        pcOperacoes = new Separador();

        separador[0]=new Separador("Separador 1",false);//cria PessoaColetor com estado "Ocupado"=false;
        separador[1]=new Separador("Separador 2",false);
        separador[2]=new Separador("Separador 3",false);

        Entregador[] entregador;
        entregador = new Entregador[3];
        Entregador eOperacoes;
        eOperacoes = new Entregador();

        entregador[0]=new Entregador("Entregador 1",false);//cria entregador com estado "Ocupado"=false;
        entregador[1]=new Entregador("Entregador 2",false);
        entregador[2]=new Entregador("Entregador 3",false);

        int ciclos=0;

        Random r;
        r=new Random();
        int n,qual,quantos,sorteiaSeparador,sorteiaEntregador;
        int pedidosEntrada=0;
        //int quaseCancelado=0;
        //int cancelado=0;

        ArrayList<Cliente> clis;
        clis = new ArrayList<>();

        while(true){
            n=r.nextInt(2);//0 1
            //probabildiade de entrar pedido em cada ciclo é de 50%
            if(n==1){
                //entrou pedido novo
                pedidosEntrada++;
                System.out.print("Entrou pedido novo. Ciclo {");
                System.out.printf("%3d}",ciclos);
                System.out.printf("%9s%3d%3s"," Pedido [",pedidosEntrada,"]\n");
                //criar cliente
                Cliente c;
                c=new Cliente();
                c.setNome("Cliente "+ciclos);

                //criar carrinho com produtos para este cliente
                c.setCarrinho(new CarrinhoGenerico<>(20));
                c.getCarrinho().setAbandonado(false);
                //comprou algum dos 4 PenDrive
                qual=r.nextInt(4);//0  1  2 ou 3
                p = (ProdutoBasico) estoqueCarregado.p[qual].get();
                if((p.getQuantidade()>0)){
                    //adicionar no carrinho
                    c.getCarrinho().guarda(estoqueCarregado.p[qual]);
                    //setar nova quantidade
                    estoque.retiraEstoque(p);
                }else{
                    System.out.println("Quantidade insuficiente");
                }
                //sortear se vai comprar mais nada, um, dois ou tres produtos..12
                quantos=r.nextInt(11)+1;// 1 2 ou 3
                for (int i = 0; i < quantos; i++) {
                    qual=i; //1, 2 ou 3, poque o produto 0 já foi comprado
                    p = (ProdutoBasico) estoqueCarregado.p[qual].get();
                    if((p.getQuantidade()>0)){
                        //adicionar no carrinho
                        c.getCarrinho().guarda(estoqueCarregado.p[qual]);
                        //setar nova quantidade
                        estoque.retiraEstoque(p);
                    }else{
                        System.out.println("Quantidade insuficiente");
                    }
                }
                clis.add(c);

                //criar pedido
                Pedido pedido;
                pedido = new Pedido();
                pedido.setId(ciclos);
                pedido.setCiclos(quantos+1);//cada pedido vai ter quantidade de ciclos de acordo com a quantidade de produtos
                pedido.setIniciado(true);//quando este é true precisa entrar para separação
                pedido.setCiclosEntrega(0);
                pedidos.add(pedido);
                pedidosSeparar.add(pedido);
            }//fim do if probabilidade


            //int desistir=r.nextInt(10);//probabilidade 10% em 50
            int desistir=r.nextInt(25);//probabilidade de desistir

            if(desistir==0){
                System.out.println("desistir "+desistir);
                pedidos = pedidoOperacoes.cancelar(pedidos);
                //verificar se já foi lancado para separar, remover de lá
                pedidosSeparar=pedidoOperacoes.removerCancelado(pedidos,pedidosSeparar);
            }

            ///-------------------------separador-------------------------
            //verificar se tem pedido para separar
            if(pedidosSeparar.size()>0){
                //verificar quem pode separar o pedido
                sorteiaSeparador=r.nextInt(3);
                int sorteios=1;
                //while( (separador[sorteiaSeparador].isOcupado()==true) || (sorteios<=3) ){
                while(sorteios<=3){
                    sorteios++;
                    boolean estadoAnterior=separador[sorteiaSeparador].isOcupado();
                    if(estadoAnterior==false){
                        separador[sorteiaSeparador].setOcupado(true);
                        separador[sorteiaSeparador].setCicloAtual(pedidosSeparar.getFirst().getCiclos());//tempo que vai demorar para separar
                        int idTemp=pedidosSeparar.getFirst().getId();
                        separador[sorteiaSeparador].setIdPedido(idTemp);
                        pedidos = pedidoOperacoes.setaSeparando(pedidos,idTemp);//colocar false no setIniciado
                        pedidosSeparar.removeFirst();
                        separador[sorteiaSeparador].setContaCiclo(1);
                        break;
                    }
                    sorteiaSeparador=r.nextInt(3);
                }
            }

            ///-------------------------separador-------------------------
            //todos que estão ocupados incrementa Ciclo no ContaCiclo
            //se ContaCiclo == CicloAtual, então separador ficou ocupado=false
            for (int i = 0; i < separador.length; i++) {
                if(separador[i].isOcupado()){
                    separador[i].setContaCiclo(separador[i].getContaCiclo()+1);
                    if(separador[i].getContaCiclo()==separador[i].getCicloAtual()){
                        separador[i].setOcupado(false);
                        int idTemp=separador[i].getIdPedido();
                        //definir pedido como pronto
                        pedidos = pedidoOperacoes.setaPronto(pedidos,idTemp);
                        Pedido pTemp=pedidoOperacoes.getPedido(pedidos,idTemp);
                        //ja posso colocar na fila de pedidosEntregar
                        pedidosEntregar.add(pTemp);
                        separador[i].setPedidosSeparados(separador[i].getPedidosSeparados()+1);
                    }
                }
            }

            ///-------------------------entregador-------------------------
            //todos que estão entregando incrementa Ciclo no ContaCiclo
            //se ContaCiclo == tempo, então pcs ficou ocupado=false
            for (int i = 0; i < entregador.length; i++) {
                if(entregador[i].isOcupado()){
                    entregador[i].setContaCiclo(entregador[i].getContaCiclo()+1);
                    if(entregador[i].getContaCiclo()==entregador[i].getTempo()){
                        entregador[i].setOcupado(false);
                        //definir pedido como entregue
                        int idTemp=entregador[i].getIdPedido();
                        pedidos=pedidoOperacoes.setaEntregue(pedidos,idTemp);
                        entregador[i].setPedidosEntregues(entregador[i].getPedidosEntregues()+1);
                        //remover do pedidosEntregar
                    }
                }
            }

            ///-------------------------entregador-------------------------
            //se finalizou enviar para entregador
            if(pedidosEntregar.size()>0){
                //verificar quem pode entregar o pedido
                sorteiaEntregador=r.nextInt(3);
                int sorteios=1;
                int tempo=r.nextInt(5)+4; // 0 1 2 3 4  + 4

                while(sorteios<=3){
                    sorteios++;
                    boolean estadoAnterior=entregador[sorteiaEntregador].isOcupado();
                    if(estadoAnterior==false){
                        entregador[sorteiaEntregador].setOcupado(true);
                        //iniciar entregador de 4 a 8
                        entregador[sorteiaEntregador].setTempo(tempo);
                        int idTemp=pedidosEntregar.getFirst().getId();
                        entregador[sorteiaEntregador].setIdPedido(idTemp);
                        //pedidoOperacoes.setaSeparando(pedidos,idTemp);
                        pedidos = pedidoOperacoes.setaEntregando(pedidos,idTemp,tempo);//aqui é definido quanto tempo será necessário para entregar
                        pedidosEntregar.removeFirst();
                        entregador[sorteiaEntregador].setContaCiclo(1);
                        //entregador[sorteiaEntregador].setPedidosEntregues(separador[sorteiaEntregador].getPedidosSeparados()+1);
                        //sorteios=3;
                        break;
                    }
                    sorteiaEntregador=r.nextInt(3);
                }
            }

            ciclos++;
            if(ciclos==50){
                break;
            }

            System.out.println("----------"+pedidoOperacoes.SepEnt(pedidos));

        }//fim do while true

        //atualizar estoque
        System.out.println("atualizar estoque***************************");
        estoque.gravaEstoqueInicio(estoqueCarregado);
        estoqueCarregado = estoque.leEstoque();
        System.out.printf(estoque.mostra(estoqueCarregado));

        //quantos pedidos deram entrada
        System.out.println("Pedidos entrada...........: "+pedidosEntrada);

        //quantos bem sucedidos
        System.out.println("Pedidos bem sucedido......: "+pedidoOperacoes.entregues(pedidos));

        //quantos pedidos quase foram cancelados
        System.out.println("Quase Cancelado ..........: "+pedidoOperacoes.quase(pedidos));

        //quantos pedidos foram efetivamente cancelados, acho que todos não entregues na simulação
        //System.out.println("Cancelado ................: "+(pedidosEntrada-pedidoOperacoes.entregues(pedidos)));
        System.out.println("Cancelado ................: "+pedidoOperacoes.contaCancelados(pedidos));

        //qual separou mais pedidos
        System.out.println("Separou mais .............: "+pcOperacoes.separouMais(separador));

        //qual fez mais entregas
        System.out.println("Entregou mais.............: "+eOperacoes.entregouMais(entregador));

        //tempo médio dos pedidos na Fila (Separação + Entrega)
        System.out.println("Tempo médio dos pedidos ..: "+pedidoOperacoes.tempoMedio(pedidos));

        //pedido que levou mais tempo na Fila (Separação + Entrega)
        //conforme a quantidade de produtos + tempo do entregador + tempo espera separação + tempo espera antes de entregar
        System.out.println("Pedido levou mais tempo...: "+pedidoOperacoes.maisTempo(pedidos));

        System.out.println("---------DEBUG-------------------------------------------");
        System.out.println("Ciclos ..............: "+ciclos);
        System.out.println("Clientes ............: "+clis.size());
        System.out.println("Pedidos .............: "+pedidos.size());
        System.out.println("Prontos .............: "+pedidoOperacoes.prontos(pedidos));
        System.out.println("falta s .............: "+pedidoOperacoes.faltaSeparar(pedidos));
        System.out.println("Entregues ...........: "+pedidoOperacoes.entregues(pedidos));
        System.out.println("Falta e .............: "+pedidoOperacoes.naoEntregues(pedidos));

    }
}
