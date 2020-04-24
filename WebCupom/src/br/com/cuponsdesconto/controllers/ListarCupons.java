package br.com.cuponsdesconto.controllers;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.cuponsdesconto.dao.CupomDao;
import br.com.cuponsdesconto.entidades.Cupom;

@WebServlet("/ListarCupons")
public class ListarCupons extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ListarCupons() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	List<Cupom> cupons = (List<Cupom>)(List<?>) new CupomDao().buscarTodos();
    	
		request.setAttribute("cupons", cupons);
		request.getRequestDispatcher("listarCupons.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
