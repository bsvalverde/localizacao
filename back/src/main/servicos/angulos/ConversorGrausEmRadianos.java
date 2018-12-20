package main.servicos.angulos;

public class ConversorGrausEmRadianos {
	private double graus;

	private double radianos;

	public ConversorGrausEmRadianos(double graus) {
		this.graus = graus;
	}

	public double call() {
		converteGrausEmRadianos();
		return radianos;
	}

	private void converteGrausEmRadianos() {
		radianos = graus * Math.PI / 180;
	}

}
