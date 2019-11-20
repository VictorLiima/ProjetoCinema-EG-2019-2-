/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.bean.Cliente;

/**
 *
 * @author JVict
 */
public class ClienteDAO {
    public boolean createCliente(Cliente c) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("INSERT INTO clientes (cpf,nome,nascimento,pontuacao)VALUES(?,?,?,?)");
            stmt.setString(1, c.getCpf());
            stmt.setString(2, c.getNome());
            stmt.setString(3, c.getNascimento());
            stmt.setInt(4, c.getPontuacao());

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Cliente inserido com Sucesso!");
            return true;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao adicionar o cliente : " + ex);
            return false;
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }

    }

    public List<Cliente> readClientes() {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Cliente> clientes = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT * FROM clientes");
            rs = stmt.executeQuery();

            while (rs.next()) {
                Cliente cliente = new Cliente();

                cliente.setIdCliente(rs.getInt("idCliente"));
                cliente.setCpf(rs.getString("cpf"));
                cliente.setNome(rs.getString("nome"));
                cliente.setNascimento(rs.getString("nascimento"));
                cliente.setPontuacao(rs.getInt("pontuacao"));
                clientes.add(cliente);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }

        return clientes;
    }

    public boolean updateCliente(Cliente c) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("UPDATE clientes SET cpf = ?,nome = ?,nascimento = ?,pontuacao = ? WHERE idCliente = ?");
            stmt.setString(1, c.getCpf());
            stmt.setString(2, c.getNome());
            stmt.setString(3, c.getNascimento());
            stmt.setInt(4, c.getPontuacao());
            stmt.setInt(5, c.getIdCliente());

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Cadastro do cliente foi atualizado com Sucesso!");
            
            return true;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar o cadastro do cliente : " + ex);
            return false;
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }

    }

    public boolean deleteCliente(Cliente c) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("DELETE FROM clientes WHERE idCliente = ?");
            stmt.setInt(1, c.getIdCliente());

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Cliente excluido com Sucesso!");
             return true;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir o Cliente : " + ex);
            return false;
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }

    }

    public List<Cliente> searchCliente(String cpf) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Cliente> clientes = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT * FROM clientes WHERE cpf LIKE ?");
            stmt.setString(1, "%" + cpf + "%");
            rs = stmt.executeQuery();

            while (rs.next()) {
                Cliente cliente = new Cliente();
                cliente.setIdCliente(rs.getInt("idCliente"));
                cliente.setCpf(rs.getString("cpf"));
                cliente.setNome(rs.getString("nome"));
                cliente.setNascimento(rs.getString("nascimento"));
                cliente.setPontuacao(rs.getInt("pontuacao"));

                clientes.add(cliente);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }

        return clientes;
    }
    
    public void contabilizarPontos(int pontos, Cliente c, String cpf){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("UPDATE clientes SET pontuacao = ? WHERE cpf = ?");
            stmt.setInt(1, c.getPontuacao());
            stmt.setString(2, cpf);

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Pontos contabilizados com Sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao contabilizar os pontos : " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
}
