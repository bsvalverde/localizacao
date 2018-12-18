package servicos.angulos;

public class ConversorGrausEmRadianos {
	private double graus;
	
	public ConversorGrausEmRadianos(double graus) {
		this.graus = graus;
	}
	
	public double call() {
		return converte();
	}
	
	private double converte() {
		return graus * Math.PI / 180;
	}

}
