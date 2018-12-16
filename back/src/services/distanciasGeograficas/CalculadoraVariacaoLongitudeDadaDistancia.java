package services.distanciasGeograficas;

import models.ObjetoGeografico;
import services.angulos.ConversorGrausEmRadianos;
import services.angulos.ConversorRadianosEmGraus;

public class CalculadoraVariacaoLongitudeDadaDistancia {
	private ObjetoGeografico objeto;
	private double distancia;
	
	private double raioDaTerra;
	private double latitudeInicial;
	private double longitudeInicial;
	private double distanciaAngular;
	private double direcao;
	
	private double longitudeFinal;
	
	public CalculadoraVariacaoLongitudeDadaDistancia(ObjetoGeografico objeto, double distancia) {
		this.objeto = objeto;
		this.distancia = distancia;
	}
	
	public double call() {
		inicializaVariaveis();
		calculaNovaLongitude();
		return calculaVariacao();
	}
	
	private void inicializaVariaveis() {
		raioDaTerra = 6371;
		latitudeInicial = new ConversorGrausEmRadianos(objeto.getLatitude()).call();
		longitudeInicial = new ConversorGrausEmRadianos(objeto.getLongitude()).call();
		distanciaAngular = distancia / raioDaTerra;
		double angulo = objeto.getLongitude() > 0 ? 270 : 90;
		direcao = new ConversorGrausEmRadianos(angulo).call();
	}
	
	private void calculaNovaLongitude() {
		double a = Math.sin(direcao) * Math.sin(distanciaAngular) * Math.cos(latitudeInicial);
		double b = Math.cos(distanciaAngular) - Math.pow(Math.sin(latitudeInicial), 2);
		longitudeFinal = longitudeInicial + Math.atan2(a, b);
	}
	
	private double calculaVariacao() {
		double variacao = Math.abs(longitudeInicial - longitudeFinal);
		return new ConversorRadianosEmGraus(variacao).call();
	}

}
