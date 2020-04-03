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

    public static void main(String[] args) {
    	//ADICIONAR
        Usuario usuario = new Usuario();
        usuario.setNome("Arthur");
        usuario.setCpf("12345678900");
        
        UsuarioController usuarioController = new UsuarioController();
//        usuarioController.adicionar(usuario);
        
        Cupom cupom = new Cupom();
        cupom.setDescricao("Cupom teste descricao");
        cupom.setCodigoCupom(1);
        cupom.setNumeroDePontos(25);
        
        CupomController cupomController = new CupomController();
//        cupomController.adicionar(cupom);
        
        //DELETAR
        int id1 = Integer.parseInt(JOptionPane.showInputDialog("Informe o Id a ser deletado"));
        UsuarioController controller1 = new UsuarioController();
        controller1.excluir(id1);
        
        int id3 = Integer.parseInt(JOptionPane.showInputDialog("Informe o Id a ser deletado"));
        CupomController controller3 = new CupomController();
        controller1.excluir(id1);
        
        //BUSCAR
        int id2 = Integer.parseInt(JOptionPane.showInputDialog("Informe o Id a ser buscado"));
        UsuarioController controller2 = new UsuarioController();
        Usuario usuarioEncontrado = controller2.buscar(id2);
        if(usuarioEncontrado != null) {
        	JOptionPane.showMessageDialog(null, "Nome: "+usuario.getNome()+" - CPF: "+usuario.getCpf());
        }else {
        	JOptionPane.showMessageDialog(null, "Usuario nao encontrado");
        }
        
        int id4 = Integer.parseInt(JOptionPane.showInputDialog("Informe o Id a ser buscado"));
        CupomController controller5 = new CupomController();
        Cupom cupomEncontrado = controller5.buscar(id4);
        if(cupomEncontrado != null) {
        	JOptionPane.showMessageDialog(null, "Descricao: "+cupomEncontrado.getDescricao());
        }else {
        	JOptionPane.showMessageDialog(null, "Cupom nao encontrado");
        }
    }
}
