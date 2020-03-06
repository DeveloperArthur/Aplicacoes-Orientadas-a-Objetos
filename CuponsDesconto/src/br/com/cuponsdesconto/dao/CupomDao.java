package br.com.cuponsdesconto.dao;

import br.com.cuponsdesconto.entidades.Entidade;
import java.util.List;

public class CupomDao extends Dao implements FuncoesDao {

    @Override
    public boolean adicionar(Entidade entidade) {
        return false;
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
