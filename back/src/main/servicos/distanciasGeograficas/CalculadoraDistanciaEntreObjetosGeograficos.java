package main.servicos.distanciasGeograficas;

import main.modelos.ObjetoGeografico;
import main.servicos.angulos.ConversorGrausEmRadianos;

public class CalculadoraDistanciaEntreObjetosGeograficos {
	private ObjetoGeografico objeto1;
	private ObjetoGeografico objeto2;

	private double latitude1;
	private double latitude2;
	private double variacaoLatitude;
	private double variacaoLongitude;

	private double distancia;

	public CalculadoraDistanciaEntreObjetosGeograficos(ObjetoGeografico objeto1, ObjetoGeografico objeto2) {
		this.objeto1 = objeto1;
		this.objeto2 = objeto2;
	}

	public double call() {
		inicializaVariaveis();
		calculaDistancia();
		return distancia;
	}

	private void inicializaVariaveis() {
		latitude1 = new ConversorGrausEmRadianos(objeto1.getLatitude()).call();
		latitude2 = new ConversorGrausEmRadianos(objeto2.getLatitude()).call();
		variacaoLatitude = variacaoEntreCoordenadasEmRadianos(objeto1.getLatitude(), objeto2.getLatitude());
		variacaoLongitude = variacaoEntreCoordenadasEmRadianos(objeto1.getLongitude(), objeto2.getLongitude());
	}

	private void calculaDistancia() {
		double a = Math.pow(Math.sin(variacaoLatitude / 2), 2) +
				Math.cos(latitude1) * Math.cos(latitude2) *
				Math.pow(Math.sin(variacaoLongitude / 2), 2);
		double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
		distancia = ConfiguracoesDistanciasGeograficas.RAIO_DA_TERRA * c;
	}

	private double variacaoEntreCoordenadasEmRadianos(double coordenada1, double coordenada2) {
		double variacao = Math.abs(coordenada1 - coordenada2);
		return new ConversorGrausEmRadianos(variacao).call();
	}

}
