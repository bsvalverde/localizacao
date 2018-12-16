package services.angulos;

public class ConversorRadianosEmGraus {
	private double radianos;
	
	public ConversorRadianosEmGraus(double radianos) {
		this.radianos = radianos;
	}
	
	public double call() {
		return converte();
	}
	
	private double converte() {
		return radianos * 180 / Math.PI;
	}

}
