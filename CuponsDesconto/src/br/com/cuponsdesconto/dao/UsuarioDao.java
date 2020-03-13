package br.com.cuponsdesconto.dao;

import br.com.cuponsdesconto.entidades.Entidade;
import br.com.cuponsdesconto.entidades.Usuario;
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
        return false;
    }

    @Override
    public boolean atualizar(Entidade entidade) {
        return false;
    }

    @Override
    public Entidade buscar(int id) {
        return null;
    }

    @Override
    public List<Entidade> buscarTodos() {
        return null;
        
    }

}
