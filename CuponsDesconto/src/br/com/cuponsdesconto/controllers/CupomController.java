package br.com.cuponsdesconto.controllers;

import br.com.cuponsdesconto.dao.CupomDao;
import br.com.cuponsdesconto.entidades.Cupom;

public class CupomController {
    public boolean adicionar(Cupom cupom){
        CupomDao dao = new CupomDao();
        return dao.adicionar(cupom);
    }
}
