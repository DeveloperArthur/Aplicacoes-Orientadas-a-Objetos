package br.com.cuponsdesconto.controllers;

import br.com.cuponsdesconto.dao.UsuarioDao;
import br.com.cuponsdesconto.entidades.Usuario;

public class UsuarioController {
	
    public boolean adicionar(Usuario usuario){
        return new UsuarioDao().adicionar(usuario);
    }
    
    public boolean excluir(int id) {
    	return new UsuarioDao().deletar(id);
    }
    
    public Usuario buscar(int id) {
    	return (Usuario) new UsuarioDao().buscar(id);
    }
}
