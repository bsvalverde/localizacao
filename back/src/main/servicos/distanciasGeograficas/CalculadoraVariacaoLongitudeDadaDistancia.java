package main.servicos.distanciasGeograficas;

import main.modelos.ObjetoGeografico;
import main.servicos.angulos.ConversorGrausEmRadianos;
import main.servicos.angulos.ConversorRadianosEmGraus;

public class CalculadoraVariacaoLongitudeDadaDistancia {
	private ObjetoGeografico objeto;
	private double distancia;

	private double latitudeInicial;
	private double longitudeInicial;
	private double distanciaAngular;
	private double direcao;

	private double longitudeFinal;
	private double variacao;

	public CalculadoraVariacaoLongitudeDadaDistancia(ObjetoGeografico objeto, double distancia) {
		this.objeto = objeto;
		this.distancia = distancia;
	}

	public double call() {
		inicializaVariaveis();
		calculaNovaLongitude();
		calculaVariacao();
		return variacao;
	}

	private void inicializaVariaveis() {
		latitudeInicial = new ConversorGrausEmRadianos(objeto.getLatitude()).call();
		longitudeInicial = new ConversorGrausEmRadianos(objeto.getLongitude()).call();
		distanciaAngular = distancia / ConfiguracoesDistanciasGeograficas.RAIO_DA_TERRA;
		double angulo = objeto.getLongitude() > 0 ? 270 : 90;
		direcao = new ConversorGrausEmRadianos(angulo).call();
	}

	private void calculaNovaLongitude() {
		double a = Math.sin(direcao) * Math.sin(distanciaAngular) * Math.cos(latitudeInicial);
		double b = Math.cos(distanciaAngular) - Math.pow(Math.sin(latitudeInicial), 2);
		longitudeFinal = longitudeInicial + Math.atan2(a, b);
	}

	private void calculaVariacao() {
		double variacaoEmRadianos = Math.abs(longitudeInicial - longitudeFinal);
		variacao = new ConversorRadianosEmGraus(variacaoEmRadianos).call();
	}

}
