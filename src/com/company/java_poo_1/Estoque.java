package com.company.java_poo_1;

import javax.swing.*;
import java.io.*;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Estoque {

    public void gravaEstoqueInicio(CarrinhoGenerico carrinhoGenericoArquivoTexto){
        FileOutputStream fo;
        ObjectOutput oo;
        File tmpDir = new File("estoque.ojb");
        if(tmpDir.exists())
            return;
        try {
//            FileWriter fw;
//            fw = new FileWriter("estoque.txt");
//            Produto p ;
//            for(int i=0;i<carrinhoGenericoArquivoTexto.p.length;i++){
//                if(carrinhoGenericoArquivoTexto.p[i]!=null){
//                    p = (ProdutoBasico) carrinhoGenericoArquivoTexto.p[i].get();
//                    //System.out.println(p.toStringFile());
//                    fw.write(p.toStringFile());
//                    //fw.write(p.toString()+"\r\n");
//                }
//            }
//            fw.close();


            fo = new FileOutputStream("estoque.obj");
            oo = new ObjectOutputStream(fo);
            oo.writeObject(carrinhoGenericoArquivoTexto);
            oo.close();
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, "Não foi possivel salvar o cadastro em arquivo!");
            e.printStackTrace();
        }

    }

    public CarrinhoGenerico leEstoque(){
        CarrinhoGenerico  carrinhoGenerico=null;
        FileInputStream fis;
        ObjectInputStream ois;

        FileReader fr;
        BufferedReader bf;

        try{
//            fr=new FileReader("estoque.txt");
//            bf=new BufferedReader(fr);
//            String linha;
//            linha=bf.readLine();
//            String[] produto;
//            int id,quantidade;
//            float preco;
//            ProdutoGenerico produtoGenerico;
//            produtoGenerico = new ProdutoGenerico();
//
//            carrinhoGenerico = new CarrinhoGenerico<>(100);
//            Produto p;
//
//            while(linha!=null){
//                produtoGenerico = new ProdutoGenerico();
//                produto=linha.split(";");
//                id=Integer.parseInt(produto[0]);
//                quantidade=Integer.parseInt(produto[3]);
//                preco=Float.parseFloat(produto[2]);
//                //1;P2;100.0;5
//                p=new ProdutoBasico(produto[1], preco, quantidade, id);
//                //System.out.println("id = "+id);
//                produtoGenerico.add(p);
//                carrinhoGenerico.guarda(produtoGenerico);
//                linha=bf.readLine();
//            }



            fis = new FileInputStream("estoque.obj");
            ois = new ObjectInputStream(fis);
            carrinhoGenerico = (CarrinhoGenerico) ois.readObject();
            ois.close();
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, "Não foi possivel salvar o cadastro em arquivo!");
            e.printStackTrace();
        }
        return carrinhoGenerico;
    }

    public void retiraEstoque(Produto p){
        p.setQuantidade(p.getQuantidade()-1);
    }

    public CarrinhoGenerico devolveEstoque(CarrinhoGenerico c, CarrinhoGenerico carrinhoDevolvido){
        CarrinhoGenerico cg;
        cg=c;
        //passar por todos produtos do carrinho
        for (int i = 0; i < carrinhoDevolvido.p.length; i++) {
            //para cada produto do carrinho vamos devolver no estoque usando o id
            if (carrinhoDevolvido.p[i]!=null){
                for (int j = 0; j < c.p.length; j++) {
                    int idCarrinho;
                    int idEstoque;
                    idCarrinho=((Produto)(carrinhoDevolvido.p[i].get())).getId();
                    idEstoque=((Produto)(c.p[j].get())).getId();
                    if(idCarrinho==idEstoque){
                        int q =((Produto)(c.p[j].get())).getQuantidade();
                        ((Produto)(cg.p[j].get())).setQuantidade(q+1);
                    }
                }
            }
        }
        return cg;
    }

    public void gravaVendas(String produtoQuantidadeValor, String vendaRealizadaPorCliente, float valorMedioPorCliente, float menorValorGasto, float maiorValorGasto, Integer  quantClienteDesistiu){
        //Para gravar de uma só vez foi utilizado o serializable.
        FileWriter fo;
        try {
            Date data;
            data = new Date();
            SimpleDateFormat sdf =new SimpleDateFormat("dd/MM/yyyy");
            fo = new FileWriter("vendas.txt",true);
            fo.write("Data...:"+sdf.format(data)+"\n");
            fo.write(produtoQuantidadeValor);
            fo.write(vendaRealizadaPorCliente);
            fo.write("Valor médio por Cliente.......");
            fo.write(valorMedioPorCliente+"\n");
            fo.write("Menor valor gasto.............");
            fo.write(menorValorGasto+"\n");
            fo.write("Maior valor gasto.............");
            fo.write(maiorValorGasto+"\n");
            fo.write("Quantidade de clientes que desistiram de comprar no mercado.......");
            fo.write(String.valueOf(quantClienteDesistiu)+"\n");
            fo.close();
        } catch(IOException e) {
            JOptionPane.showMessageDialog(null, "Não foi possivel salvar as vendas arquivo!");
            e.printStackTrace();
        }

    }

    public String mostra(CarrinhoGenerico estoqueCarregado){
        String resultado="";
        for (int i = 0; i < estoqueCarregado.p.length; i++) {
            if(estoqueCarregado.p[i]!=null){
                resultado += estoqueCarregado.p[i].get().toString()+"\n";
                //System.out.println(estoqueCarregado.p[i].toString());
            }
        }
        return resultado;
    }
}