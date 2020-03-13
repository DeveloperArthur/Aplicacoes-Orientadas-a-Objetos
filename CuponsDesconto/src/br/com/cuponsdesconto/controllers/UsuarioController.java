package br.com.cuponsdesconto.controllers;

import br.com.cuponsdesconto.dao.UsuarioDao;
import br.com.cuponsdesconto.entidades.Usuario;

public class UsuarioController {
    public boolean adicionar(Usuario usuario){
        UsuarioDao dao = new UsuarioDao();
        return dao.adicionar(usuario);
    }
}
