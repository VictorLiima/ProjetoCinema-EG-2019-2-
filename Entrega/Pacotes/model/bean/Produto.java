/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.bean;

/**
 *
 * @author JVict
 */
public class Produto {
    private int idProduto;
    private String nomeProduto;
    private float preco;
    private int pontosProd;
    private int vendas;

    /**
     * @return the idProduto
     */
    public int getIdProduto() {
        return idProduto;
    }

    /**
     * @param idProduto the idProduto to set
     */
    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
    }

    /**
     * @return the nomeProduto
     */
    public String getNomeProduto() {
        return nomeProduto;
    }

    /**
     * @param nomeProduto the nomeProduto to set
     */
    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    /**
     * @return the preco
     */
    public float getPreco() {
        return preco;
    }

    /**
     * @param preco the preco to set
     */
    public void setPreco(float preco) {
        this.preco = preco;
    }

    /**
     * @return the pontosProd
     */
    public int getPontosProd() {
        return pontosProd;
    }

    /**
     * @param pontosProd the pontosProd to set
     */
    public void setPontosProd(int pontosProd) {
        this.pontosProd = pontosProd;
    }

    /**
     * @return the vendas
     */
    public int getVendas() {
        return vendas;
    }

    /**
     * @param vendas the vendas to set
     */
    public void setVendas(int vendas) {
        this.vendas = vendas;
    }
}
