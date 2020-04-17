package br.com.cuponsdesconto.controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.cuponsdesconto.dao.CupomDao;
import br.com.cuponsdesconto.entidades.Cupom;

@WebServlet("/CadastrarCupom")
public class CadastrarCupom extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public CadastrarCupom() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    int codigoCupom = Integer.parseInt(request.getParameter("codigoCupom"));
	    String descricao = request.getParameter("descricao");
	    int numeroDePontos = Integer.parseInt(request.getParameter("numeroDePontos"));
	    
	    Cupom cupom = new Cupom(codigoCupom, descricao, numeroDePontos);
	    if(new CupomDao().adicionar(cupom))
	    	request.setAttribute("mensagem", "Cadastro realizado com sucesso");
	    else
	    	request.setAttribute("mensagem", "Erro no cadastro");
	    
	    request.getRequestDispatcher("confirmacaoCadastro.jsp").forward(request, response);	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
