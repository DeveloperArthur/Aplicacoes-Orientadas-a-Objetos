package br.com.cuponsdesconto.dao;

import br.com.cuponsdesconto.entidades.Cupom;
import br.com.cuponsdesconto.entidades.Entidade;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CupomDao extends Dao implements FuncoesDao {

    @Override
    public boolean adicionar(Entidade entidade) {
        Cupom cupom = (Cupom) entidade;
        String sql = "insert into cupom (descricao, codigoCupom, numeroDePontos) values (?,?,?)";
        try{
            this.conectar();
            this.stmt = this.conn.prepareStatement(sql);
            this.stmt.setString(1, cupom.getDescricao());
            this.stmt.setInt(2, cupom.getCodigoCupom());
            this.stmt.setInt(3, cupom.getNumeroDePontos());
            this.stmt.execute();
            System.out.println("Cupom criado com sucesso!");
        } catch(SQLException ex){
            System.out.println("Erro ao inserir Cupom "+ex.getMessage());
            return false;
        }
        finally{
            try {
                this.conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(CupomDao.class.getName()).log(Level.SEVERE, null, ex);
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
