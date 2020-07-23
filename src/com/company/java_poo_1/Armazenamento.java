package com.company.java_poo_1;

import java.io.Serializable;

public class Armazenamento extends ProdutoBasico implements Serializable {
    private int capacidade;
    private String unidade;



    public Armazenamento() {
        this.capacidade = 1;
        this.unidade="Byte";
    }

    public Armazenamento(int capacidade, String unidade) {
        this.capacidade = capacidade;
        this.unidade = unidade;
    }

    /**
     *
     * Construtor Armazenamento
     * @param nome Nome do Armazenamento
     * @param preco Preço do Armazenamento
     * @param quant Quantidade do Armazenamento
     * @param id Identificador do Armazenamento
     * @see ProdutoBasico
     * @return Armazenamento
     * @auor Marcelot
     * @version Live#3
    */
    public Armazenamento(String nome, float preco, int quant, int id){
        super();
        this.setId(id);
        this.setNome(nome);
        this.setPreco(preco);
        this.setQuantidade(quant);
    }


    public Armazenamento(String nome, float preco, int quant, int id, int capacidade, String unidade ){
        super();
        this.setId(id);
        this.setNome(nome);
        this.setPreco(preco);
        this.setQuantidade(quant);
        this.capacidade=capacidade;
        this.unidade=unidade;
    }


    public int getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(int capacidade) {
        this.capacidade = capacidade;
    }

    public String getUnidade() {
        return unidade;
    }

    public void setUnidade(String unidade) {
        this.unidade = unidade;
    }

    @Override
    public String toString(){
        String resultado=super.toString();
        //exemplo super
        resultado += " capacidade='" + getCapacidade() + "'";
        resultado += " unidade='" + getUnidade() + "'";
        return resultado;
    }
    @Override
    public String toStringFile(){
        String resultado=super.toStringFile();
        resultado += getCapacidade() + ";";
        resultado += getUnidade() + "\n";
        return resultado;
    }



}
