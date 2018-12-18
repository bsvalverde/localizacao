package servicos.distanciasGeograficas;

import modelos.ObjetoGeografico;
import servicos.angulos.ConversorGrausEmRadianos;
import servicos.angulos.ConversorRadianosEmGraus;

public class CalculadoraVariacaoLatitudeDadaDistancia {
	private ObjetoGeografico objeto;
	private double distancia;
	
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
	
	private double calculaVariacao() {
		double variacao = Math.abs(latitudeInicial - latitudeFinal);
		return new ConversorRadianosEmGraus(variacao).call();
	}

}