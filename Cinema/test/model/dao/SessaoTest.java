/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import java.sql.SQLException;
import java.util.List;
import model.bean.Filme;
import model.bean.Sala;
import model.dao.SessaoDAO;
import model.bean.Sessao;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;

/**
 *
 * @author JVict
 */
public class SessaoTest {
    
    private Sessao sessao = new Sessao();
    private Sessao seAtual = new Sessao();
    private SessaoDAO se = new SessaoDAO();
    private Filme filme = new Filme();
    private FilmeDAO f = new FilmeDAO();
    private Sala sala = new Sala();
    private SalaDAO sa = new SalaDAO();
    
    public SessaoTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        //Filme
        this.filme.setDiretor("James");
        this.filme.setDuracao(180);
        this.filme.setGenero("Ficção");
        this.filme.setIdFilme(1);
        this.filme.setIdioma("PT-BR");
        this.filme.setTitulo("Avatar");
        //Sala
        this.sala.setCapacidade(150);
        this.sala.setIdSala(1);
        this.sala.setNumero(1);
        //Sessao
        this.sessao.setData("29/10/2019");
        this.sessao.setFilme(filme.getTitulo());
        this.sessao.setHorario("22:00");
        this.sessao.setIdSessao(1);
        this.sessao.setIngressosDisponiveis(150);
        this.sessao.setSala(1);
        this.sessao.setValorIngresso(8);
        //Sessao Update
        this.seAtual.setData("30/10/2019");
        this.seAtual.setFilme(filme.getTitulo());
        this.seAtual.setHorario("22:00");
        this.seAtual.setIdSessao(1);
        this.seAtual.setIngressosDisponiveis(150);
        this.seAtual.setSala(1);
        this.seAtual.setValorIngresso(10);
        this.seAtual.setIngVendido(160);
    }
    
    @After
    public void tearDown() {
        this.se.deleteSessão(sessao);
        this.sessao = null;
        this.se.deleteSessão(seAtual);
        this.seAtual = null;
        this.f.deleteFilme(filme);
        this.filme = null;
        this.sa.deleteSala(sala);
        this.sala = null;
        
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    @Test
    public void createSessaoTest(){
        assertTrue(se.createSessao(sessao));
    }
    
    @Test 
   public void updateSessaoTest(){
        Sessao seAtual = new Sessao();
        seAtual.setData("30/10/2019");
        seAtual.setFilme(filme.getTitulo());
        seAtual.setHorario("23:00");
        seAtual.setIdSessao(3);
        seAtual.setIngressosDisponiveis(sala.getCapacidade());
        seAtual.setSala(sala.getNumero());
        seAtual.setValorIngresso(20);
        
        this.se.createSessao(sessao);
        assertTrue(se.updateSessao(seAtual));
    }
    
    @Test
    public void deleteSessaoTest(){
        this.se.createSessao(sessao);
        assertTrue(se.deleteSessão(sessao));
    }
    
    @Test
    public void readSessaoPossivelTest(){
        this.se.createSessao(sessao);
        List<Sessao> sessoes = this.se.readSessao();
        assertTrue(sessoes.size()>0);
    }
    
    @Test
    public void readSessaoImpossivelTest(){
        this.se.createSessao(sessao);
        List<Sessao> sessoes = this.se.readSessao();
        assertFalse(sessoes.size()<0);
    }
    
    @Test
    public void vendaIngressoImpossivelTest() throws SQLException{
        seAtual.setIngressosDisponiveis(150);
        seAtual.setIngVendido(151);
        this.se.createSessao(sessao);
        assertFalse(se.vendaIngresso(seAtual));
    }
    
    @Test
    public void vendaIngressoPossivelTest() throws SQLException{
        seAtual.setIngressosDisponiveis(150);
        seAtual.setIngVendido(140);
        this.se.createSessao(sessao);
        assertTrue(se.vendaIngresso(seAtual));
    }
    
}
