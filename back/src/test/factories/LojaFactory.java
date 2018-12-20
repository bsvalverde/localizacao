package test.factories;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import main.modelos.Loja;
import main.modelos.ObjetoGeografico;

public class LojaFactory {
	
	public static Loja criaLojaProxima(ObjetoGeografico referencia) {
		double novaLatitude = referencia.getLatitude() + (Math.random() * 10 - 5);
		double novaLongitude = referencia.getLongitude() + (Math.random() * 10 - 5);
		return new Loja("", novaLatitude, novaLongitude);
	}
	
	public static List<Loja> criaListaDeLojasProximas(ObjetoGeografico referencia, int quantidade) {
		List<Loja> lojasProximas = new ArrayList<>();
		for(int i = 0; i < quantidade; i++) {
			lojasProximas.add(criaLojaProxima(referencia));
		}
		return lojasProximas;
	}
	
	public static Loja criaLojaDistante(ObjetoGeografico referencia) {
		double novaLatitude = referencia.getLatitude() + 90 + (Math.random() * 10 - 5);
		if(novaLatitude > 90) {
			novaLatitude -= 180;
		}
		double novaLongitude = referencia.getLongitude() + 180 + (Math.random() * 10 - 5);
		if(novaLongitude > 180) {
			novaLongitude -= 360;
		}
		return new Loja("", novaLatitude, novaLongitude);
	}
	
	public static List<Loja> criaListaDeLojasDistantes(ObjetoGeografico referencia, int quantidade) {
		List<Loja> lojasDistantes = new ArrayList<>();
		for(int i = 0; i < quantidade; i++) {
			lojasDistantes.add(criaLojaDistante(referencia));
		}
		return lojasDistantes;
	}
	
	public static List<Loja> criaListaDeLojasVariadas(ObjetoGeografico referencia, int quantidadeProximos, int quantidadeDistantes) {
		List<Loja> lojasProximas = criaListaDeLojasProximas(referencia, quantidadeProximos);
		List<Loja> lojasDistantes = criaListaDeLojasDistantes(referencia, quantidadeDistantes);
		List<Loja> lojasVariadas = Stream.concat(lojasProximas.stream(), lojasDistantes.stream()).collect(Collectors.toList());
		return lojasVariadas;
	}

}
