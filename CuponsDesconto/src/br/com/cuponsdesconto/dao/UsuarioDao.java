package br.com.cuponsdesconto.dao;

import br.com.cuponsdesconto.entidades.Entidade;
import br.com.cuponsdesconto.entidades.Usuario;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UsuarioDao extends Dao implements FuncoesDao {

    @Override
    public boolean adicionar(Entidade entidade) {
        Usuario usuario = (Usuario) entidade;
        String sql = "insert into usuario (nome, cpf) values (?,?)";
        try{
        	this.conectar();
            this.stmt = this.conn.prepareStatement(sql);
            this.stmt.setString(1, usuario.getNome());
            this.stmt.setString(2, usuario.getCpf());
            this.stmt.execute();
            System.out.println("Usuario criado com sucesso!");
        } catch(SQLException ex){
            System.out.println("Erro ao inserir Usuario "+ex.getMessage());
            return false;
        }
        finally{
            try {
                this.conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return true;
    }

    @Override
    public boolean deletar(int id) {
        String sql = "delete from usuario where id = ?";
        try {
        	this.conectar();
        	this.stmt = this.conn.prepareStatement(sql);
        	this.stmt.setInt(1, id);
        	this.stmt.execute();
        }catch(SQLException ex) {
        	System.out.println("Erro ao deletar Usuario: "+ex.getMessage());
        	return false;
        }
        return true;
    }

    @Override
    public boolean atualizar(Entidade entidade) {
        Usuario usuario = (Usuario) entidade;
        String sql = "update usuario set nome = ?, cpf = ? where id = ?";
        try {
        	this.conectar();
        	this.stmt = this.conn.prepareStatement(sql);
        	this.stmt.setString(1, usuario.getNome());
        	this.stmt.setString(2, usuario.getCpf());
        	this.stmt.setInt(3, usuario.getId());
        	this.stmt.execute();
        }catch(SQLException ex) {
        	System.out.println("Erro ao atualizar Usuario: "+ex.getMessage());
        	return false;
        }
        return true;
    }

    @Override
    public Entidade buscar(int id) {
        String sql = "select * from usuario where id = ?";
        try {
        	this.conectar();
        	this.stmt = this.conn.prepareStatement(sql);
        	this.stmt.setInt(1, id);
        	ResultSet rs = this.stmt.executeQuery();
        	if(rs.next()) {
        		Usuario usuario = new Usuario();
        		usuario.setId(rs.getInt("id"));
        		usuario.setNome(rs.getString("nome"));
        		usuario.setCpf(rs.getString("cpf"));
        		return usuario;
        	}
        }catch(SQLException ex) {
        	System.out.println("Erro ao buscar Usuario: "+ex.getMessage());
        	return null;
        }
        return null;
    }

    @Override
    public List<Entidade> buscarTodos() {
        return null;
        
    }

}
