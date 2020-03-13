/*Uma empresa de cupons de descontos deseja construir um sistema responsavel 
pelo cadastro e pela consulta dos cupons de desconto que cada usuario possui. 
Cada usuario eh cadastrado utilizando o nome, email e cpf. 
nao podendo ocorrer a insercao de cpf duplicado no sistema. 
Cada cupom eh identificado pelo codigo de cupom, descricao e numero de pontos. 
cada usuario pode cadastrar ate 5 cupons ou ate 
a soma da pontuacao de seus cupons atingir 100.*/
package br.com.cuponsdesconto;

import br.com.cuponsdesconto.controllers.CupomController;
import br.com.cuponsdesconto.controllers.UsuarioController;
import br.com.cuponsdesconto.entidades.Cupom;
import br.com.cuponsdesconto.entidades.Usuario;

public class CuponsDesconto {

    public static void main(String[] args) {
        Usuario usuario = new Usuario();
        usuario.setNome("Arthur");
        usuario.setCpf("12345678900");
        
        UsuarioController usuarioController = new UsuarioController();
        //usuarioController.adicionar(usuario);
        
        Cupom cupom = new Cupom();
        cupom.setDescricao("Cupom teste descricao");
        cupom.setCodigoCupom(1);
        cupom.setNumeroDePontos(25);
        
        CupomController cupomController = new CupomController();
        //cupomController.adicionar(cupom);
    }
}
