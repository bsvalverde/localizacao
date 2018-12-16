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
		this.raioDaTerra = 6371;
		this.latitudeInicial = new ConversorGrausEmRadianos(objeto.getLatitude()).call();
		this.longitudeInicial = new ConversorGrausEmRadianos(objeto.getLongitude()).call();
		this.distanciaAngular = distancia / raioDaTerra;
		double angulo = objeto.getLongitude() > 0 ? 270 : 90;
		this.direcao = new ConversorGrausEmRadianos(angulo).call();
	}
	
	private void calculaNovaLongitude() {
		double a = Math.sin(direcao) * Math.sin(distanciaAngular) * Math.cos(latitudeInicial);
		double b = Math.cos(distanciaAngular) - Math.pow(Math.sin(latitudeInicial), 2);
		this.longitudeFinal = this.longitudeInicial + Math.atan2(a, b);
	}
	
	private double calculaVariacao() {
		double variacao = Math.abs(longitudeInicial - longitudeFinal);
		return new ConversorRadianosEmGraus(variacao).call();
	}

}
