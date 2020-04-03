package br.com.cuponsdesconto.controllers;

import br.com.cuponsdesconto.dao.CupomDao;
import br.com.cuponsdesconto.entidades.Cupom;

public class CupomController {
	
    public boolean adicionar(Cupom cupom){
        return new CupomDao().adicionar(cupom);
    }
    
    public boolean excluir(int id) {
    	return new CupomDao().deletar(id);
    }
    
    public Cupom buscar(int id) {
    	return (Cupom) new CupomDao().buscar(id);
    }
}
