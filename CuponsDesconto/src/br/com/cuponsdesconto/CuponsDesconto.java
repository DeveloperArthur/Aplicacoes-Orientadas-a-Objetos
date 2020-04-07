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

import javax.swing.*;

public class CuponsDesconto {
    public static void main(String[] args) {
        UsuarioController usuarioController = new UsuarioController();
        CupomController cupomController = new CupomController();

        int opcao = Integer.parseInt(JOptionPane.showInputDialog("***CuponsDesconto***\n\n"
                + "Informe uma das opcoes abaixo\n" + "Para Usuario:\n" + "1 - Adicionar Usuario\n"
                + "2 - Deletar Usuario\n" + "3 - Atualizar Usuario\n" + "4 - Buscar Usuario\n"
                + "5 - Buscar todos Usuarios\n" + "\nPara Cupom:\n" + "6 - Adicionar Cupom\n" + "7 - Deletar Cupom\n"
                + "8 - Atualizar Cupom\n" + "9 - Buscar Cupom\n" + "10 - Buscar todos Cupons"));

        switch (opcao) {
            case 1:
                Usuario usuarioParaAdicionar = new Usuario();

                String nomeParaAdicionar = String.valueOf(JOptionPane.showInputDialog("Informe o nome do Usuario"));
                String cpfParaAdicionar = String.valueOf(JOptionPane.showInputDialog("Informe o CPF do Usuario"));

                usuarioParaAdicionar.setNome(nomeParaAdicionar);
                usuarioParaAdicionar.setCpf(cpfParaAdicionar);

                boolean resultadoAdicionar = usuarioController.adicionar(usuarioParaAdicionar);
                if (resultadoAdicionar) {
                    JOptionPane.showMessageDialog(null, "Usuario adicionado com sucesso");
                } else {
                    JOptionPane.showMessageDialog(null, "Erro ao adicionar Usuario");
                }
                break;
            case 2:
                int idDoUsuarioParaExcluir = Integer.parseInt(JOptionPane.showInputDialog("Informe o Id a ser deletado"));
                boolean resultadoUsuarioExcluir = usuarioController.excluir(idDoUsuarioParaExcluir);
                if (resultadoUsuarioExcluir) {
                    JOptionPane.showMessageDialog(null, "Usuario deletado com sucesso");
                } else {
                    JOptionPane.showMessageDialog(null, "Erro ao deletar Usuario");
                }
                break;
            case 3:
                Usuario usuarioParaAtualizar = new Usuario();

                int idDoUsuarioParaAtualizar = Integer.parseInt(JOptionPane.showInputDialog("Informe o Id a ser atualizado"));
                String nomeParaAtualizar = String.valueOf(JOptionPane.showInputDialog("Informe o novo nome do Usuario"));
                String cpfParaAtualizar = String.valueOf(JOptionPane.showInputDialog("Informe o novo CPF do Usuario"));

                usuarioParaAtualizar.setId(idDoUsuarioParaAtualizar);
                usuarioParaAtualizar.setNome(nomeParaAtualizar);
                usuarioParaAtualizar.setCpf(cpfParaAtualizar);

                boolean resultadoUsuarioAtualizar = usuarioController.atualizar(usuarioParaAtualizar);
                if (resultadoUsuarioAtualizar) {
                    JOptionPane.showMessageDialog(null, "Usuario atualizado com sucesso");
                } else {
                    JOptionPane.showMessageDialog(null, "Erro ao atualizar Usuario");
                }
                break;
            case 4:
                int idUsuarioParaBuscar = Integer.parseInt(JOptionPane.showInputDialog("Informe o Id a ser buscado"));
                Usuario usuarioEncontrado = usuarioController.buscar(idUsuarioParaBuscar);
                if (usuarioEncontrado != null) {
                    JOptionPane.showMessageDialog(null, "Nome: " + usuarioEncontrado.getNome() + "\nCPF: " + usuarioEncontrado.getCpf());
                } else {
                    JOptionPane.showMessageDialog(null, "Usuario nao encontrado");
                }
                break;
            case 5:
                //FALTA IMPLEMENTAR
                break;
            case 6:
                Cupom cupomParaAdicionar = new Cupom();

                int codigoCupomParaAdicionar = Integer.parseInt(JOptionPane.showInputDialog("Informe o codigo do Cupom"));
                String descricaoParaAdicionar = String.valueOf(JOptionPane.showInputDialog("Informe a descricao do Cupom"));
                int numeroDePontosParaAdicionar = Integer.parseInt(JOptionPane.showInputDialog("Informe o numero de pontos do Cupom"));

                cupomParaAdicionar.setCodigoCupom(codigoCupomParaAdicionar);
                cupomParaAdicionar.setDescricao(descricaoParaAdicionar);
                cupomParaAdicionar.setNumeroDePontos(numeroDePontosParaAdicionar);

                boolean resultado = cupomController.adicionar(cupomParaAdicionar);
                if (resultado) {
                    JOptionPane.showMessageDialog(null, "Cupom adicionado com sucesso");
                } else {
                    JOptionPane.showMessageDialog(null, "Erro ao adicionar Cupom");
                }
                break;
            case 7:
                int idDoCupomParaExcluir = Integer.parseInt(JOptionPane.showInputDialog("Informe o Id a ser deletado"));
                boolean resultadoCupomExcluir = cupomController.excluir(idDoCupomParaExcluir);
                if (resultadoCupomExcluir) {
                    JOptionPane.showMessageDialog(null, "Cupom deletado com sucesso");
                } else {
                    JOptionPane.showMessageDialog(null, "Erro ao deletar Cupom");
                }
                break;
            case 8:
                Cupom cupomParaAtualizar = new Cupom();

                int idDoCupomParaAtualizar = Integer.parseInt(JOptionPane.showInputDialog("Informe o Id a ser atualizado"));
                int codigoCupomParaAtualizar = Integer.parseInt(JOptionPane.showInputDialog("Informe o codigo do Cupom"));
                String descricaoParaAtualizar = String.valueOf(JOptionPane.showInputDialog("Informe a descricao do Cupom"));
                int numeroDePontosParaAtualizar = Integer
                        .parseInt(JOptionPane.showInputDialog("Informe o numero de pontos do Cupom"));

                cupomParaAtualizar.setId(idDoCupomParaAtualizar);
                cupomParaAtualizar.setCodigoCupom(codigoCupomParaAtualizar);
                cupomParaAtualizar.setDescricao(descricaoParaAtualizar);
                cupomParaAtualizar.setNumeroDePontos(numeroDePontosParaAtualizar);

                boolean resultadoCupomAtualizar = cupomController.atualizar(cupomParaAtualizar);
                if (resultadoCupomAtualizar) {
                    JOptionPane.showMessageDialog(null, "Cupom atualizado com sucesso");
                } else {
                    JOptionPane.showMessageDialog(null, "Erro ao atualizar Cupom");
                }
                break;
            case 9:
                int idCupomParaBuscar = Integer.parseInt(JOptionPane.showInputDialog("Informe o Id a ser buscado"));
                Cupom cupom = cupomController.buscar(idCupomParaBuscar);
                if (cupom != null) {
                    JOptionPane.showMessageDialog(null, "Descricao: " + cupom.getDescricao());
                } else {
                    JOptionPane.showMessageDialog(null, "Cupom nao encontrado");
                }
                break;
            case 10:
                //FALTA IMPLEMENTAR
                break;
            default:
                JOptionPane.showMessageDialog(null, "Informe uma opcao valida");
                break;
        }
    }
}
