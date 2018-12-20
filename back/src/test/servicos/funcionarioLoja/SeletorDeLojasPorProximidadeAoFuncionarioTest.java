package test.servicos.funcionarioLoja;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import main.modelos.Funcionario;
import main.modelos.Loja;
import main.servicos.distanciasGeograficas.ConfiguracoesDistanciasGeograficas;
import main.servicos.funcionarioLoja.SeletorDeLojasPorProximidadeAoFuncionario;
import test.factories.FuncionarioFactory;
import test.factories.LojaFactory;

class SeletorDeLojasPorProximidadeAoFuncionarioTest {
	private Funcionario referencia;
	int quantidadeLojasProximas;
	int quantidadeLojasDistantes;
	
	@BeforeEach
	public void inicializaVariaveis() {
		referencia = FuncionarioFactory.criaFuncionarioAleatorio();
		quantidadeLojasProximas = (int)(Math.random() * 20);
		quantidadeLojasDistantes = (int)(Math.random() * 20);
	}

	@Test
	void naoSelecionaNenhumaLojaSeADistanciaEZero() {
		List<Loja> lojas = LojaFactory.criaListaDeLojasVariadas(referencia, quantidadeLojasProximas, quantidadeLojasDistantes);
		List<Loja> lojasProximas = new SeletorDeLojasPorProximidadeAoFuncionario(referencia, lojas, 0).call();
		assertEquals(lojasProximas.size(), 0);
	}

	@Test
	void selecionaTodasAsLojasSeTodasSaoProximas() {
		List<Loja> lojas = LojaFactory.criaListaDeLojasProximas(referencia, quantidadeLojasProximas);
		List<Loja> lojasProximas = new SeletorDeLojasPorProximidadeAoFuncionario(referencia, lojas, ConfiguracoesDistanciasGeograficas.RAIO_DA_TERRA / 10).call();
		assertEquals(lojasProximas.size(), lojas.size());
	}

	@Test
	void naoSelecionaNenhumaLojaSeTodasSaoDistantes() {
		List<Loja> lojas = LojaFactory.criaListaDeLojasDistantes(referencia, quantidadeLojasDistantes);
		List<Loja> lojasProximas = new SeletorDeLojasPorProximidadeAoFuncionario(referencia, lojas, ConfiguracoesDistanciasGeograficas.RAIO_DA_TERRA / 10).call();
		assertEquals(lojasProximas.size(), 0);
	}

	@Test
	void selecionaApenasAsLojasProximas() {
		List<Loja> lojas = LojaFactory.criaListaDeLojasVariadas(referencia, quantidadeLojasProximas, quantidadeLojasDistantes);
		List<Loja> lojasProximas = new SeletorDeLojasPorProximidadeAoFuncionario(referencia, lojas, ConfiguracoesDistanciasGeograficas.RAIO_DA_TERRA / 10).call();
		assertEquals(lojasProximas.size(), quantidadeLojasProximas);
	}

}
