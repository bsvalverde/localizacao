package controladores;

import java.util.List;

import back.ConfiguracoesPrincipais;
import modelos.Funcionario;
import modelos.Loja;
import servicos.funcionarioLoja.SeletorDeLojasPorProximidadeAoFuncionario;

public class FuncionarioLojaController {
	
	public static void associaFuncionariosALojas(int distanciaMaxima) {
		List<Funcionario> funcionarios = ConfiguracoesPrincipais.FUNCIONARIO_GATEWAY.buscarTodos();
		List<Loja> lojas = ConfiguracoesPrincipais.LOJA_GATEWAY.buscarTodos();
		for(Funcionario funcionario : funcionarios) {
			List<Loja> lojasProximas = new SeletorDeLojasPorProximidadeAoFuncionario(funcionario, lojas, distanciaMaxima).call();
			for(Loja loja : lojasProximas) {
				String texto = funcionario.getNome() + " e " + loja.getNome();
				System.out.println(texto);
			}
			//itera pelas lojas criando a associação e persistindo
		}
	}

}
