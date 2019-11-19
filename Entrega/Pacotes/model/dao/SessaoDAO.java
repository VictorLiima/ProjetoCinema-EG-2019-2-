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
import model.bean.Sessao;

/**
 *
 * @author JVict
 */
public class SessaoDAO {
    public void createSessao(Sessao se){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt=con.prepareStatement("INSERT INTO sessoes (filme,sala,data,horario,valor_ingresso,ingressos_disponiveis)VALUES(?,?,?,?,?,?)");
            stmt.setString(1, se.getFilme());
            stmt.setInt(2, se.getSala());
            stmt.setString(3, se.getData());
            stmt.setString(4, se.getHorario());
            stmt.setInt(5, se.getValorIngresso());
            stmt.setInt(6, se.getIngressosDisponiveis());
            
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Sessão inserida com Sucesso!");
            
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null,"Erro ao adicionar a Sessão : "+ex);
            }finally{
                ConnectionFactory.closeConnection(con, stmt);
            }      
                
        }
    
    public List<Sessao> readSessao(){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Sessao> sessoes = new ArrayList<>();
        
        try {
            stmt = con.prepareStatement("SELECT * FROM sessoes");
            rs = stmt.executeQuery();
            
            while(rs.next()){
                Sessao sessao = new Sessao();
                
                sessao.setIdSessao(rs.getInt("idsessoes"));
                sessao.setFilme(rs.getString("filme"));
                sessao.setSala(rs.getInt("sala"));
                sessao.setData(rs.getString("data"));
                sessao.setHorario(rs.getString("horario"));
                sessao.setValorIngresso(rs.getInt("valor_ingresso"));
                sessao.setIngressosDisponiveis(rs.getInt("ingressos_disponiveis"));
                sessoes.add(sessao);
            }
        } catch (SQLException ex) {
            Logger.getLogger(FilmeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            ConnectionFactory.closeConnection(con, stmt);
        }
        
        return sessoes;
    }
    
    public void updateSessao(Sessao se){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt=con.prepareStatement("UPDATE sessoes SET filme = ?,sala = ?,data = ?,horario = ?,valor_ingresso = ?, ingressos_disponiveis =? WHERE idsessoes = ?");
            stmt.setString(1, se.getFilme());
            stmt.setInt(2, se.getSala());
            stmt.setString(3, se.getData());
            stmt.setString(4, se.getHorario());
            stmt.setInt(5, se.getValorIngresso());
            stmt.setInt(6, se.getIngressosDisponiveis());
            stmt.setInt(7, se.getIdSessao());
            
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Sessão atualizada com Sucesso!");
            
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null,"Erro ao atualizar a Sessão : "+ex);
            }finally{
                ConnectionFactory.closeConnection(con, stmt);
            }      
                
        }

    
    
    public void deleteSessão(Sessao se){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt=con.prepareStatement("DELETE FROM sessoes WHERE idsessoes = ?");
            stmt.setInt(1, se.getIdSessao());
            
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Sessão excluida com Sucesso!");
            
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null,"Erro ao excluir a S~ssão : "+ex);
            }finally{
                ConnectionFactory.closeConnection(con, stmt);
            }      
                
        }
    
    public List<Sessao> searchSessao(String filme){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Sessao> sessoes = new ArrayList<>();
        
        try {
            stmt = con.prepareStatement("SELECT * FROM sessoes WHERE filme LIKE ?");
            stmt.setString(1, "%"+filme+"%");
            rs = stmt.executeQuery();
            
            while(rs.next()){
                Sessao sessao = new Sessao();
                sessao.setIdSessao(rs.getInt("idsessoes"));
                sessao.setFilme(rs.getString("filme"));
                sessao.setSala(rs.getInt("sala"));
                sessao.setData(rs.getString("data"));
                sessao.setHorario(rs.getString("horario"));
                sessao.setValorIngresso(rs.getInt("valor_ingresso"));
                sessao.setIngressosDisponiveis(rs.getInt("ingressos_disponiveis"));
                
                sessoes.add(sessao);
            }
        } catch (SQLException ex) {
            Logger.getLogger(FilmeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            ConnectionFactory.closeConnection(con, stmt);
        }
        
        return sessoes;
    }
}