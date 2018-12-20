package main.servicos.angulos;

public class ConversorRadianosEmGraus {
	private double radianos;

	private double graus;

	public ConversorRadianosEmGraus(double radianos) {
		this.radianos = radianos;
	}

	public double call() {
		converteRadianosEmGraus();
		return graus;
	}

	private void converteRadianosEmGraus() {
		graus = radianos * 180 / Math.PI;
	}

}
