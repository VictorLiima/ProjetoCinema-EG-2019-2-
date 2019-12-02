/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.bean;

import java.sql.Date;
import java.sql.Time;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

/**
 *
 * @author JVict
 */
public class Sessao {
    private int idSessao;
    private String filme;
    private int sala;
    private String data;
    private String horario;
    private int valorIngressoInteira;
    private int valorIngressoMeia;
    private int ingressosDisponiveis;
    private int ingVendido;
    /**
     * @return the idSessao
     */
    public int getIdSessao() {
        return idSessao;
    }

    /**
     * @param idSessao the idSessao to set
     */
    public void setIdSessao(int idSessao) {
        this.idSessao = idSessao;
    }

    /**
     * @return the filme
     */
    public String getFilme() {
        return filme;
    }

    /**
     * @param filme the filme to set
     */
    public void setFilme(String filme) {
        this.filme = filme;
    }

    /**
     * @return the sala
     */
    public int getSala() {
        return sala;
    }

    /**
     * @param sala the sala to set
     */
    public void setSala(int sala) {
        this.sala = sala;
    }

    /**
     * @return the data
     */
    public String getData() {
        return data;
    }

    /**
     * @param data the data to set
     */
    public void setData(String data) {
        this.data = data;
    }

    /**
     * @return the horario
     */
    public String getHorario() {
        return horario;
    }

    /**
     * @param horario the horario to set
     */
    public void setHorario(String horario) {
        this.horario = horario;
    }


    /**
     * @return the ingressosDisponiveis
     */
    public int getIngressosDisponiveis() {
        return ingressosDisponiveis;
    }

    /**
     * @param ingressosDisponiveis the ingressosDisponiveis to set
     */
    public void setIngressosDisponiveis(int ingressosDisponiveis) {
        this.ingressosDisponiveis = ingressosDisponiveis;
    }

    /**
     * @return the ingVendido
     */
    public int getIngVendido() {
        return ingVendido;
    }

    /**
     * @param ingVendido the ingVendido to set
     */
    public void setIngVendido(int ingVendido) {
        this.ingVendido = ingVendido;
    }

    /**
     * @return the valorIngressoInteira
     */
    public int getValorIngressoInteira() {
        return valorIngressoInteira;
    }

    /**
     * @param valorIngressoInteira the valorIngressoInteira to set
     */
    public void setValorIngressoInteira(int valorIngressoInteira) {
        this.valorIngressoInteira = valorIngressoInteira;
    }

    /**
     * @return the valorIngressoMeia
     */
    public int getValorIngressoMeia() {
        return valorIngressoMeia;
    }

    /**
     * @param valorIngressoMeia the valorIngressoMeia to set
     */
    public void setValorIngressoMeia(int valorIngressoMeia) {
        this.valorIngressoMeia = valorIngressoMeia;
    }
}
