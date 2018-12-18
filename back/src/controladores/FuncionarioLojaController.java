package controladores;

import java.util.List;

import back.ConfiguracoesPrincipais;
import modelos.Funcionario;
import modelos.FuncionarioLoja;
import modelos.Loja;
import servicos.funcionarioLoja.SeletorDeLojasPorProximidadeAoFuncionario;

public class FuncionarioLojaController {

	public static void associaFuncionariosALojas(double distanciaMaxima) {
		List<Funcionario> funcionarios = ConfiguracoesPrincipais.FUNCIONARIO_GATEWAY.buscarTodos();
		List<Loja> lojas = ConfiguracoesPrincipais.LOJA_GATEWAY.buscarTodos();
		for(Funcionario funcionario : funcionarios) {
			List<Loja> lojasProximas = new SeletorDeLojasPorProximidadeAoFuncionario(funcionario, lojas, distanciaMaxima).call();
			for(Loja loja : lojasProximas) {
				FuncionarioLoja funcionarioLoja = new FuncionarioLoja(funcionario, loja);
				System.out.println("Associando " + funcionarioLoja.toString());
				ConfiguracoesPrincipais.FUNCIONARIO_LOJA_GATEWAY.salvar(funcionarioLoja);
			}
		}
	}

}
