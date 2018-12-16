package services.distanciasGeograficas;

import models.ObjetoGeografico;
import services.angulos.ConversorGrausEmRadianos;
import services.angulos.ConversorRadianosEmGraus;

public class CalculadoraVariacaoLatitudeDadaDistancia {
	private ObjetoGeografico objeto;
	private double distancia;
	
	private double raioDaTerra;
	private double latitudeInicial;
	private double distanciaAngular;
	private double direcao;
	
	private double latitudeFinal;
	
	public CalculadoraVariacaoLatitudeDadaDistancia(ObjetoGeografico objeto, double distancia) {
		this.objeto = objeto;
		this.distancia = distancia;
	}
	
	public double call() {
		inicializaVariaveis();
		calculaNovaLatitude();
		return calculaVariacao();
	}
	
	private void inicializaVariaveis() {
		this.raioDaTerra = 6371;
		this.latitudeInicial = new ConversorGrausEmRadianos(objeto.getLatitude()).call();
		this.distanciaAngular = distancia / raioDaTerra;
		double angulo = objeto.getLatitude() > 0 ? 180 : 0;
		this.direcao = new ConversorGrausEmRadianos(angulo).call();
	}
	
	private void calculaNovaLatitude() {
		double a = Math.sin(latitudeInicial) * Math.cos(distanciaAngular) +
				Math.cos(latitudeInicial) * Math.sin(distanciaAngular) * Math.cos(direcao);
		this.latitudeFinal = Math.asin(a);
	}
	
	private double calculaVariacao() {
		double variacao = Math.abs(latitudeInicial - latitudeFinal);
		return new ConversorRadianosEmGraus(variacao).call();
	}

}
