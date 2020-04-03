/*Uma empresa de cupons de descontos deseja construir um sistema responsavel 
pelo cadastro e pela consulta dos cupons de desconto que cada usuario possui. 
Cada usuario eh cadastrado utilizando o nome, email e cpf. 
nao podendo ocorrer a insercao de cpf duplicado no sistema. 
Cada cupom eh identificado pelo codigo de cupom, descricao e numero de pontos. 
cada usuario pode cadastrar ate 5 cupons ou ate 
a soma da pontuacao de seus cupons atingir 100.*/
package br.com.cuponsdesconto;

import javax.swing.JOptionPane;

import br.com.cuponsdesconto.controllers.CupomController;
import br.com.cuponsdesconto.controllers.UsuarioController;
import br.com.cuponsdesconto.entidades.Cupom;
import br.com.cuponsdesconto.entidades.Usuario;

public class CuponsDesconto {
	UsuarioController usuarioController = new UsuarioController();
	CupomController cupomController = new CupomController();

	public static void main(String[] args) {
		CuponsDesconto cd = new CuponsDesconto();

		int opcao = Integer.parseInt(JOptionPane.showInputDialog("***CuponsDesconto***\n\n"
				+ "Informe uma das opcoes abaixo\n" + "Para Usuario:\n" + "1 - Adicionar Usuario\n"
				+ "2 - Deletar Usuario\n" + "3 - Atualizar Usuario\n" + "4 - Buscar Usuario\n"
				+ "5 - Buscar todos Usuarios\n" + "\nPara Cupom:\n" + "6 - Adicionar Cupom\n" + "7 - Deletar Cupom\n"
				+ "8 - Atualizar Cupom\n" + "9 - Buscar Cupom\n" + "10 - Buscar todos Cupons"));

		switch (opcao) {
		case 1:
			cd.adicionarUsuario();
			break;
		case 2:
			cd.deletarUsuario();
			break;
		case 3:
			cd.atualizarUsuario();
			break;
		case 4:
			cd.buscarUsuario();
			break;
		case 5:
			cd.buscarTodosUsuarios();
			break;
		case 6:
			cd.adicionarCupom();
			break;
		case 7:
			cd.deletarCupom();
			break;
		case 8:
			cd.atualizarCupom();
			break;
		case 9:
			cd.buscarCupom();
			break;
		case 10:
			cd.buscarTodosCupons();
			break;
		default:
			JOptionPane.showMessageDialog(null, "Informe uma opcao valida");
			break;
		}
	}

	public void adicionarUsuario() {
		Usuario usuario = new Usuario();

		String nomeDigitado = String.valueOf(JOptionPane.showInputDialog("Informe o nome do Usuario"));
		String cpfDigitado = String.valueOf(JOptionPane.showInputDialog("Informe o CPF do Usuario"));

		usuario.setNome(nomeDigitado);
		usuario.setCpf(cpfDigitado);

		boolean resultado = usuarioController.adicionar(usuario);
		if (resultado) {
			JOptionPane.showMessageDialog(null, "Usuario adicionado com sucesso");
		} else {
			JOptionPane.showMessageDialog(null, "Erro ao adicionar Usuario");
		}
	}

	public void deletarUsuario() {
		int id = Integer.parseInt(JOptionPane.showInputDialog("Informe o Id a ser deletado"));
		boolean resultado = usuarioController.excluir(id);
		if (resultado) {
			JOptionPane.showMessageDialog(null, "Usuario deletado com sucesso");
		} else {
			JOptionPane.showMessageDialog(null, "Erro ao deletar Usuario");
		}
	}

	public void atualizarUsuario() {
		Usuario usuario = new Usuario();

		int idDigitado = Integer.parseInt(JOptionPane.showInputDialog("Informe o Id a ser atualizado"));
		String nomeDigitado = String.valueOf(JOptionPane.showInputDialog("Informe o novo nome do Usuario"));
		String cpfDigitado = String.valueOf(JOptionPane.showInputDialog("Informe o novo CPF do Usuario"));

		usuario.setId(idDigitado);
		usuario.setNome(nomeDigitado);
		usuario.setCpf(cpfDigitado);

		boolean resultado = usuarioController.atualizar(usuario);
		if (resultado) {
			JOptionPane.showMessageDialog(null, "Usuario atualizado com sucesso");
		} else {
			JOptionPane.showMessageDialog(null, "Erro ao atualizar Usuario");
		}
	}

	public void buscarUsuario() {
		int id = Integer.parseInt(JOptionPane.showInputDialog("Informe o Id a ser buscado"));
		Usuario usuario = usuarioController.buscar(id);
		if (usuario != null) {
			JOptionPane.showMessageDialog(null, "Nome: " + usuario.getNome() + "\nCPF: " + usuario.getCpf());
		} else {
			JOptionPane.showMessageDialog(null, "Usuario nao encontrado");
		}
	}

	public void buscarTodosUsuarios() {

	}

	public void adicionarCupom() {
		Cupom cupom = new Cupom();

		int codigoCupomDigitado = Integer.parseInt(JOptionPane.showInputDialog("Informe o codigo do Cupom"));
		String descricaoDigitada = String.valueOf(JOptionPane.showInputDialog("Informe a descricao do Cupom"));
		int numeroDePontosDigitado = Integer
				.parseInt(JOptionPane.showInputDialog("Informe o numero de pontos do Cupom"));

		cupom.setCodigoCupom(codigoCupomDigitado);
		cupom.setDescricao(descricaoDigitada);
		cupom.setNumeroDePontos(numeroDePontosDigitado);

		boolean resultado = cupomController.adicionar(cupom);
		if (resultado) {
			JOptionPane.showMessageDialog(null, "Cupom adicionado com sucesso");
		} else {
			JOptionPane.showMessageDialog(null, "Erro ao adicionar Cupom");
		}
	}

	public void deletarCupom() {
		int id = Integer.parseInt(JOptionPane.showInputDialog("Informe o Id a ser deletado"));
		boolean resultado = cupomController.excluir(id);
		if (resultado) {
			JOptionPane.showMessageDialog(null, "Cupom deletado com sucesso");
		} else {
			JOptionPane.showMessageDialog(null, "Erro ao deletar Cupom");
		}
	}

	public void atualizarCupom() {
		Cupom cupom = new Cupom();

		int idDigitado = Integer.parseInt(JOptionPane.showInputDialog("Informe o Id a ser atualizado"));
		int codigoCupomDigitado = Integer.parseInt(JOptionPane.showInputDialog("Informe o codigo do Cupom"));
		String descricaoDigitada = String.valueOf(JOptionPane.showInputDialog("Informe a descricao do Cupom"));
		int numeroDePontosDigitado = Integer
				.parseInt(JOptionPane.showInputDialog("Informe o numero de pontos do Cupom"));

		cupom.setId(idDigitado);
		cupom.setCodigoCupom(codigoCupomDigitado);
		cupom.setDescricao(descricaoDigitada);
		cupom.setNumeroDePontos(numeroDePontosDigitado);

		boolean resultado = cupomController.atualizar(cupom);
		if (resultado) {
			JOptionPane.showMessageDialog(null, "Cupom atualizado com sucesso");
		} else {
			JOptionPane.showMessageDialog(null, "Erro ao atualizar Cupom");
		}
	}

	public void buscarCupom() {
		int id = Integer.parseInt(JOptionPane.showInputDialog("Informe o Id a ser buscado"));
		Cupom cupom = cupomController.buscar(id);
		if (cupom != null) {
			JOptionPane.showMessageDialog(null, "Descricao: " + cupom.getDescricao());
		} else {
			JOptionPane.showMessageDialog(null, "Cupom nao encontrado");
		}
	}

	public void buscarTodosCupons() {

	}
}
