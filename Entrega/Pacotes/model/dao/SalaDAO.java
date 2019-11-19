/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.bean.Sala;

/**
 *
 * @author JVict
 */
public class SalaDAO {
    public void createSala(Sala s){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt=con.prepareStatement("INSERT INTO salas (numero,capacidade)VALUES(?,?)");
            stmt.setInt(1, s.getNumero());
            stmt.setInt(2, s.getCapacidade());
            
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Sala inserida com Sucesso!");
            
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null,"Erro ao adicionar a sala : "+ex);
            }finally{
                ConnectionFactory.closeConnection(con, stmt);
            }      
                
        }
    
    public List<Sala> readSala(){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Sala> salas = new ArrayList<>();
        
        try {
            stmt = con.prepareStatement("SELECT * FROM salas");
            rs = stmt.executeQuery();
            
            while(rs.next()){
                Sala sala = new Sala();
                
                sala.setIdSala(rs.getInt("idsala"));
                sala.setNumero(rs.getInt("numero"));
                sala.setCapacidade(rs.getInt("capacidade"));
                salas.add(sala);
            }
        } catch (SQLException ex) {
            Logger.getLogger(FilmeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            ConnectionFactory.closeConnection(con, stmt);
        }
        
        return salas;
    }
    
    public void updateSala(Sala s){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt=con.prepareStatement("UPDATE salas SET numero = ?,capacidade = ? WHERE idsala = ?");
            stmt.setInt(1, s.getNumero());
            stmt.setInt(2, s.getCapacidade());
            stmt.setInt(3, s.getIdSala());
            
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Sala atualizada com Sucesso!");
            
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null,"Erro ao atualizar a Sala : "+ex);
            }finally{
                ConnectionFactory.closeConnection(con, stmt);
            }      
                
        }
    
    
    public void deleteSala(Sala s){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt=con.prepareStatement("DELETE FROM salas WHERE idsala = ?");
            stmt.setInt(1, s.getIdSala());
            
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Sala excluida com Sucesso!");
            
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null,"Erro ao excluir a Sala : "+ex);
            }finally{
                ConnectionFactory.closeConnection(con, stmt);
            }      
                
        }
    
    public List<Sala> searchSala(int numero){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Sala> salas = new ArrayList<>();
        
        try {
            stmt = con.prepareStatement("SELECT * FROM salas WHERE numero LIKE ?");
            stmt.setString(1, "%"+numero+"%");
            rs = stmt.executeQuery();
            
            while(rs.next()){
                Sala sala = new Sala();
                sala.setIdSala(rs.getInt("idsala"));
                sala.setNumero(rs.getInt("numero"));
                sala.setCapacidade(rs.getInt("capacidade"));
                
                salas.add(sala);
            }
        } catch (SQLException ex) {
            Logger.getLogger(FilmeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            ConnectionFactory.closeConnection(con, stmt);
        }
        
        return salas;
    }
}
