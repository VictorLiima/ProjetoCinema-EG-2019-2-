/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import java.util.List;
import model.bean.Sala;
import model.dao.SalaDAO;
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
public class SalaTest {
    
    private Sala sala = new Sala();
    private SalaDAO sa = new SalaDAO();
    
    
    public SalaTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        this.sala.setCapacidade(150);
        this.sala.setIdSala(1);
        this.sala.setNumero(5);
    }
    
    @After
    public void tearDown() {
        this.sa.deleteSala(sala);
        this.sala = null;
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    
    @Test
    public void createSalaTest(){
        assertTrue(sa.createSala(sala));
    }
    
    @Test
    public void updateSalaTest(){
        Sala saAtual = new Sala();
        saAtual.setCapacidade(200);
        saAtual.setIdSala(2);
        saAtual.setNumero(2);
        
        this.sa.createSala(sala);
        this.sa.updateSala(saAtual);
    }
    
    @Test
    public void deleteSalaTest(){
        this.sa.createSala(sala);
        assertTrue(sa.deleteSala(sala));
    }
    
    @Test
    public void readSalaTestPossivel(){
        this.sa.createSala(sala);
        List<Sala> salas = this.sa.readSala();
        assertTrue(salas.size()> 0);
    }
    
    @Test
    public void readSalaTestImpossivel(){
        this.sa.createSala(sala);
        List<Sala> salas = this.sa.readSala();
        assertFalse(salas.size()< 0);
    }
}
