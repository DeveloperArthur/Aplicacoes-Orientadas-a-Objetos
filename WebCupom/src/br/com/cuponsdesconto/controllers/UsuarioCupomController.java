package br.com.cuponsdesconto.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.cuponsdesconto.dao.UsuarioCupomDao;
import br.com.cuponsdesconto.entidades.UsuarioCupom;

@WebServlet("/UsuarioCupomController")
public class UsuarioCupomController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public UsuarioCupomController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UsuarioCupomDao dao = new UsuarioCupomDao();
		String acao = request.getParameter("acao");
		switch(acao) {
			case "cadastrar":
				int idUsuarioParaCadastrar = Integer.parseInt(request.getParameter("idUsuario"));
				int idCupomParaCadastrar = Integer.parseInt(request.getParameter("idCupom"));
				
				UsuarioCupom usuCupCadastro = new UsuarioCupom(idUsuarioParaCadastrar, idCupomParaCadastrar);
				if(dao.adicionar(usuCupCadastro))
					request.setAttribute("mensagem", "Cadastro realizado com sucesso");
			    else
			    	request.setAttribute("mensagem", "Erro no cadastro");
			    
			    request.getRequestDispatcher("confirmacaoCadastro.jsp").forward(request, response);
			    break;
			case "listar":
				List<UsuarioCupom> usuarioscupons = (List<UsuarioCupom>)(List<?>) dao.buscarTodos();
		    	
				request.setAttribute("usuarioscupons", usuarioscupons);
				request.getRequestDispatcher("listarUsuariosCupons.jsp").forward(request, response);
				break;
			case "excluir":
				int idParaExcluir = Integer.parseInt(request.getParameter("id"));
				dao.deletar(idParaExcluir);
				response.sendRedirect("UsuarioCupomController?acao=listar");
				break;
			case "preEditar":
				int idParaPreAtualizar = Integer.parseInt(request.getParameter("id"));
				UsuarioCupom usuCupPreAtualizar = (UsuarioCupom)dao.buscar(idParaPreAtualizar);
				request.setAttribute("usuariocupom", usuCupPreAtualizar);
				request.getRequestDispatcher("editarUsuarioCupom.jsp").forward(request, response);
				break;
			case "atualizar":
				int idParaAtualizar = Integer.parseInt(request.getParameter("id"));
				int idUsuarioParaAtualizar = Integer.parseInt(request.getParameter("idUsuario"));
				int idCupomParaAtualizar = Integer.parseInt(request.getParameter("idCupom"));
				
				UsuarioCupom usuCupAtualizar = new UsuarioCupom(idParaAtualizar, idUsuarioParaAtualizar, idCupomParaAtualizar);
				if(dao.atualizar(usuCupAtualizar))
					request.setAttribute("mensagem", "Usuario cupom atualizado com sucesso");
			    else
			    	request.setAttribute("mensagem", "Erro na atualização");
			    
			    request.getRequestDispatcher("confirmacaoCadastro.jsp").forward(request, response);
			    break;
		}
	}

}
