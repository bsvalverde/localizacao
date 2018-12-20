package test.servicos.distanciasGeograficas;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import main.modelos.ObjetoGeografico;
import main.servicos.distanciasGeograficas.CalculadoraDistanciaEntreObjetosGeograficos;
import main.servicos.distanciasGeograficas.ConfiguracoesDistanciasGeograficas;
import test.factories.ObjetoGeograficoFactory;

class CalculadoraDistanciaEntreObjetosGeograficosTest {

	@Test
	void calculaCorretamenteDistanciaEntreDoisObjetos() {
		ObjetoGeografico objeto1 = ObjetoGeograficoFactory.criaObjetoGeograficoOcidental();
		ObjetoGeografico objeto2 = ObjetoGeograficoFactory.criaObjetoGeograficoOriental();
		double meiaCircunferenciaDaTerra = Math.PI * ConfiguracoesDistanciasGeograficas.RAIO_DA_TERRA;
		double distancia = new CalculadoraDistanciaEntreObjetosGeograficos(objeto1, objeto2).call();
		assertTrue(meiaCircunferenciaDaTerra == distancia);
	}

}
