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
import model.bean.Filme;

/**
 *
 * @author JVict
 */
public class FilmeDAO {

    public boolean createFilme(Filme f) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("INSERT INTO filmes (titulo,diretor,genero,idioma,duracao)VALUES(?,?,?,?,?)");
            stmt.setString(1, f.getTitulo());
            stmt.setString(2, f.getDiretor());
            stmt.setString(3, f.getGenero());
            stmt.setString(4, f.getIdioma());
            stmt.setInt(5, f.getDuracao());

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Filme inserido com Sucesso!");
            return true;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao adicionar o fime : " + ex);
            return false;
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }

    }

    public List<Filme> readFilmes() {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Filme> filmes = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT * FROM filmes");
            rs = stmt.executeQuery();

            while (rs.next()) {
                Filme filme = new Filme();

                filme.setIdFilme(rs.getInt("idfilme"));
                filme.setTitulo(rs.getString("titulo"));
                filme.setDiretor(rs.getString("diretor"));
                filme.setGenero(rs.getString("genero"));
                filme.setIdioma(rs.getString("idioma"));
                filme.setDuracao(rs.getInt("duracao"));
                filmes.add(filme);
            }
        } catch (SQLException ex) {
            Logger.getLogger(FilmeDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }

        return filmes;
    }

    public boolean updateFilme(Filme f) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("UPDATE filmes SET titulo = ?,diretor = ?,genero = ?,idioma = ?,duracao = ? WHERE idfilme = ?");
            stmt.setString(1, f.getTitulo());
            stmt.setString(2, f.getDiretor());
            stmt.setString(3, f.getGenero());
            stmt.setString(4, f.getIdioma());
            stmt.setInt(5, f.getDuracao());
            stmt.setInt(6, f.getIdFilme());

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Filme atualizado com Sucesso!");
            
            return true;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar o fime : " + ex);
            return false;
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }

    }

    public boolean deleteFilme(Filme f) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("DELETE FROM filmes WHERE idfilme = ?");
            stmt.setInt(1, f.getIdFilme());

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Filme excluido com Sucesso!");
             return true;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir o fime : " + ex);
            return false;
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }

    }

    public List<Filme> searchFilmes(String titulo) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Filme> filmes = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT * FROM filmes WHERE titulo LIKE ?");
            stmt.setString(1, "%" + titulo + "%");
            rs = stmt.executeQuery();

            while (rs.next()) {
                Filme filme = new Filme();
                filme.setIdFilme(rs.getInt("idfilme"));
                filme.setTitulo(rs.getString("titulo"));
                filme.setDiretor(rs.getString("diretor"));
                filme.setGenero(rs.getString("genero"));
                filme.setIdioma(rs.getString("idioma"));
                filme.setDuracao(rs.getInt("duracao"));

                filmes.add(filme);
            }
        } catch (SQLException ex) {
            Logger.getLogger(FilmeDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }

        return filmes;
    }
}
