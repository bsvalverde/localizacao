package servicos.funcionarioLoja;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import modelos.Funcionario;
import modelos.Loja;
import servicos.distanciasGeograficas.CalculadoraDistanciaEntreObjetosGeograficos;
import servicos.distanciasGeograficas.CalculadoraVariacaoLatitudeDadaDistancia;
import servicos.distanciasGeograficas.CalculadoraVariacaoLongitudeDadaDistancia;

public class SeletorDeLojasPorProximidadeAoFuncionario {
	private Funcionario funcionario;
	private List<Loja> lojasElegiveis;
	private double distanciaMaxima;

	private double latitudeMinima;
	private double latitudeMaxima;
	private double longitudeMinima;
	private double longitudeMaxima;
	private List<Loja> lojasSelecionadas;

	public SeletorDeLojasPorProximidadeAoFuncionario(Funcionario funcionario, List<Loja> lojasElegiveis, double distanciaMaxima) {
		this.funcionario = funcionario;
		this.lojasElegiveis = new ArrayList<Loja>(lojasElegiveis);
		this.distanciaMaxima = distanciaMaxima;
		lojasSelecionadas = new ArrayList<Loja>();
	}

	public List<Loja> call() {
		System.out.println("Iniciando cálculos para " + funcionario.getNome());
		calculaLimitesDeLatitude();
		filtraLojasElegiveisPorLatitude();
		System.out.println("Lojas elegíveis após filtro por latitude: " + lojasElegiveis.size());
		calculaLimitesDeLongitude();
		filtraLojasElegiveisPorLongitude();
		System.out.println("Lojas elegíveis após filtro por longitude: " + lojasElegiveis.size());
		System.out.println("Iniciando cálculos remanescentes");
		calculaDistanciaAteLojasRestantes();
		return lojasSelecionadas;
	}

	private void calculaLimitesDeLatitude() {
		double variacaoLatitude = new CalculadoraVariacaoLatitudeDadaDistancia(funcionario, distanciaMaxima).call();
		latitudeMinima = funcionario.getLatitude() - variacaoLatitude;
		latitudeMaxima = funcionario.getLatitude() + variacaoLatitude;
	}

	private void filtraLojasElegiveisPorLatitude() {
		lojasElegiveis = lojasElegiveis.stream()
				.filter(l -> l.getLatitude() >= latitudeMinima && l.getLatitude() <= latitudeMaxima)
				.collect(Collectors.toList());
	}

	private void calculaLimitesDeLongitude() {
		double variacaoLongitude = new CalculadoraVariacaoLongitudeDadaDistancia(funcionario, distanciaMaxima).call();
		longitudeMinima = funcionario.getLongitude() - variacaoLongitude;
		longitudeMaxima = funcionario.getLongitude() + variacaoLongitude;
	}

	private void filtraLojasElegiveisPorLongitude() {
		lojasElegiveis = lojasElegiveis.stream()
				.filter(l -> l.getLongitude() >= longitudeMinima && l.getLongitude() <= longitudeMaxima)
				.collect(Collectors.toList());
	}

	private void calculaDistanciaAteLojasRestantes() {
		for(Loja loja : lojasElegiveis) {
			if(lojaEProximaOSuficiente(loja)) {
				lojasSelecionadas.add(loja);
			}
		}
	}

	private boolean lojaEProximaOSuficiente(Loja loja) {
		double distancia = new CalculadoraDistanciaEntreObjetosGeograficos(funcionario, loja).call();
		System.out.println("Distância entre " + funcionario.getNome() + " e " + loja.getNome() + ": " + distancia);
		System.out.println(distancia <= distanciaMaxima ? "Aprovado" : "Descartado");
		return distancia <= distanciaMaxima;
	}

}
