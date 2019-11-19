/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import java.util.ArrayList;
import java.util.List;
import model.dao.FilmeDAO;
import model.bean.Filme;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author JVict
 */
public class FilmeTest {
    private Filme filme = new Filme();
    private FilmeDAO f = new FilmeDAO();
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
        System.out.println("Executando método tearDownClass");
    }
    
    @Before
    public void setUp() {
        this.filme = new Filme();
        this.filme.setIdFilme(40);
        this.filme.setDiretor("James");
        this.filme.setTitulo("Avatar");
        this.filme.setGenero("Ficção");
        this.filme.setIdioma("PT-BR");
        this.filme.setDuracao(120);
    }
    
    @After
    public void tearDown() {
        this.f.deleteFilme(filme);
        this.filme = null;
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
    public void createFilmeTest(){
        assertTrue(f.createFilme(filme));
    }
    
    @Test
    public void updateFilmeTest(){
        Filme fAtual = new Filme();
        fAtual.setDiretor("James Cameron");
        fAtual.setDuracao(200);
        fAtual.setGenero("Ficção Científica");
        fAtual.setIdFilme(2);
        fAtual.setIdioma("Dual Audio");
        fAtual.setTitulo("Avatar 2");
        
        this.f.createFilme(filme);
        assertTrue(f.updateFilme(fAtual));
    }
    
    @Test
    public void deleteFilmeTest(){
        this.f.createFilme(filme);
        assertTrue(f.deleteFilme(filme));
    }
    
    @Test
    public void readFilmeTestPossivel(){
        this.f.createFilme(filme);
        List<Filme> filmes = this.f.readFilmes();
        assertTrue(filmes.size()>0);
    }
    
    @Test
    public void readFilmeTestImpossivel(){
        this.f.createFilme(filme);
        List<Filme> filmes = this.f.readFilmes();
        assertFalse(filmes.size()<0);
    }
}
