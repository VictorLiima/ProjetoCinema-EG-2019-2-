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
import model.bean.Produto;

/**
 *
 * @author JVict
 */
public class ProdutoDAO {
    public boolean createProduto(Produto p) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("INSERT INTO produtos (nomeProduto,preco,pontosProd)VALUES(?,?,?)");
            stmt.setString(1, p.getNomeProduto());
            stmt.setFloat(2, p.getPreco());
            stmt.setInt(3, p.getPontosProd());

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Produto inserido com Sucesso!");
            return true;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao adicionar o Produto : " + ex);
            return false;
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }

    }

    public List<Produto> readProduto() {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Produto> produtos = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT * FROM produtos");
            rs = stmt.executeQuery();

            while (rs.next()) {
                Produto produto = new Produto();

                produto.setIdProduto(rs.getInt("idProduto"));
                produto.setNomeProduto(rs.getString("nomeProduto"));
                produto.setPreco(rs.getFloat("preco"));
                produto.setPontosProd(rs.getInt("pontosProd"));
                produtos.add(produto);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }

        return produtos;
    }

    public boolean updateProduto(Produto p) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("UPDATE produtos SET nomeProduto = ?,preco = ?,pontosProd = ? WHERE idProduto = ?");
            stmt.setString(1, p.getNomeProduto());
            stmt.setFloat(2, p.getPreco());
            stmt.setInt(3, p.getPontosProd());
            stmt.setInt(4, p.getIdProduto());

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Produto atualizado com Sucesso!");
            return true;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar o Produto : " + ex);
            return false;
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }

    }

    /*public boolean vendaProduto(Produto p) throws SQLException {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        int ingressos = se.getIngressosDisponiveis() - se.getIngVendido();
        if (ingressos > 0) {

            stmt = con.prepareStatement("UPDATE sessoes SET ingressos_disponiveis = ? WHERE idsessoes = ? AND ingressos_disponiveis > 0");
            stmt.setInt(1, ingressos);
            stmt.setInt(2, se.getIdSessao());
            System.out.println(" ing " + ingressos);
            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Ingressos vendidos com sucesso");
            ConnectionFactory.closeConnection(con, stmt);
            return true;
        } else {
            JOptionPane.showMessageDialog(null, "Quantidade de ingressos disponiveis é insuficiente.");
            ConnectionFactory.closeConnection(con, stmt);
            return false;
        }

    }
*/
    public boolean deleteProduto(Produto p) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("DELETE FROM produtos WHERE idProduto = ?");
            stmt.setInt(1, p.getIdProduto());

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Produto excluido com Sucesso!");
            return true;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir o Produto : " + ex);
            return false;
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }

    }

    public List<Produto> searchProduto(String nomeP) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Produto> produtos = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT * FROM produtos WHERE nomeProduto LIKE ?");
            stmt.setString(1, "%" + nomeP + "%");
            rs = stmt.executeQuery();

            while (rs.next()) {
                Produto prod = new Produto();
                prod.setIdProduto(rs.getInt("idProduto"));
                prod.setNomeProduto(rs.getString("nomeproduto"));
                prod.setPreco(rs.getFloat("preco"));
                prod.setPontosProd(rs.getInt("pontosProd"));
                
                produtos.add(prod);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }

        return produtos;
    }
}
