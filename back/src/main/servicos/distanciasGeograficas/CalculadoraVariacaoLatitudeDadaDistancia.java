package main.servicos.distanciasGeograficas;

import main.modelos.ObjetoGeografico;
import main.servicos.angulos.ConversorGrausEmRadianos;
import main.servicos.angulos.ConversorRadianosEmGraus;

public class CalculadoraVariacaoLatitudeDadaDistancia {
	private ObjetoGeografico objeto;
	private double distancia;

	private double latitudeInicial;
	private double distanciaAngular;
	private double direcao;

	private double latitudeFinal;
	private double variacao;

	public CalculadoraVariacaoLatitudeDadaDistancia(ObjetoGeografico objeto, double distancia) {
		this.objeto = objeto;
		this.distancia = distancia;
	}

	public double call() {
		inicializaVariaveis();
		calculaNovaLatitude();
		calculaVariacao();
		return variacao;
	}

	private void inicializaVariaveis() {
		latitudeInicial = new ConversorGrausEmRadianos(objeto.getLatitude()).call();
		distanciaAngular = distancia / ConfiguracoesDistanciasGeograficas.RAIO_DA_TERRA;
		double angulo = objeto.getLatitude() > 0 ? 180 : 0;
		direcao = new ConversorGrausEmRadianos(angulo).call();
	}

	private void calculaNovaLatitude() {
		double a = Math.sin(latitudeInicial) * Math.cos(distanciaAngular) +
				Math.cos(latitudeInicial) * Math.sin(distanciaAngular) * Math.cos(direcao);
		this.latitudeFinal = Math.asin(a);
	}

	private void calculaVariacao() {
		double variacaoEmRadianos = Math.abs(latitudeInicial - latitudeFinal);
		variacao = new ConversorRadianosEmGraus(variacaoEmRadianos).call();
	}

}
