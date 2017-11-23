package br.iesb.meuprograma.dados;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class AlunoDAO implements DAO<Aluno> {

    @Override
    public void inserir(Aluno entidade) throws DadosException {
        Connection conexao = ConexaoBD.getConexao();
        String sql = "INSERT INTO alunos(nome, email, data_nascimento) VALUES (?, ?, ?)";
        try {
            PreparedStatement comando = conexao.prepareStatement(sql);
            comando.setString(1, entidade.getNome());
            comando.setString(2, entidade.getEmail());
            comando.setString(3, entidade.getDataNascimento());
            comando.executeUpdate();
        } catch (SQLException ex) {
            throw new DadosException("Erro ao inserir: " + ex.getMessage());
        }
    }

    @Override
    public void alterar(Aluno entidade) throws DadosException {
        Connection conexao = ConexaoBD.getConexao();
        String sql = "UPDATE alunos SET nome=?, email=?, data_nascimento=? where id=?";
        try {
            PreparedStatement comando = conexao.prepareStatement(sql);
            comando.setString(1, entidade.getNome());
            comando.setString(2, entidade.getEmail());
            comando.setString(3, entidade.getDataNascimento());
            comando.setInt(4, entidade.getId());
            comando.executeUpdate();
        } catch (SQLException ex) {
            throw new DadosException("Erro ao inserir: " + ex.getMessage());
        }
    }

    @Override
    public void excluir(Aluno entidade) throws DadosException {
        Connection conexao = ConexaoBD.getConexao();
        String sql = "DELETE FROM alunos where id=?";
        try {
            PreparedStatement comando = conexao.prepareStatement(sql);
            comando.setInt(1, entidade.getId());
            comando.executeUpdate();
            conexao.close();
        } catch (SQLException ex) {
            throw new DadosException("Erro ao excluir: " + ex.getMessage());
        }
    }

    @Override
    public Aluno consultar(int id) throws DadosException {
        Aluno aluno = new Aluno();
        Connection conexao = ConexaoBD.getConexao();
        String sql = "DELETE FROM alunos where id=?";
        try {
            PreparedStatement comando = conexao.prepareStatement(sql);
            comando.setInt(1, id);
            ResultSet resultado = comando.executeQuery();
            if (resultado.next()) {
            aluno.setId(resultado.getInt(1));
            aluno.setNome(resultado.getString(2));
            aluno.setEmail(resultado.getString(3));
            aluno.setDataNascimento(resultado.getString(4));
            }
            conexao.close();
        } catch (SQLException ex) {
            throw new DadosException("Erro ao consultar: " + ex.getMessage());
        }
        return aluno;
    }

    @Override
    public List<Aluno> listar() throws DadosException {
        List<Aluno> lista = new ArrayList<Aluno>();
        Connection conexao = ConexaoBD.getConexao();
        String sql = "SELECT * FROM alunos";
        
        try {
         Statement comando = conexao.createStatement();
         ResultSet resultado = comando.executeQuery(sql);
         
         while (resultado.next()) {
         Aluno aluno = new Aluno();
         aluno.setId(resultado.getInt(1));
         aluno.setNome(resultado.getString(2));
         aluno.setEmail (resultado.getString(3));
         aluno.setDataNascimento(resultado.getString(4));
         
         lista.add(aluno);
         }
         conexao.close();          
        } catch (SQLException ex) {
        throw new DadosException("Erro ao listar: " + ex.getMessage());
        }
        
        return lista;
    }  
}

