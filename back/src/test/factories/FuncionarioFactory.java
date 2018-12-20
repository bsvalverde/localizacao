package test.factories;

import main.modelos.Funcionario;

public class FuncionarioFactory {
	
	public static Funcionario criaFuncionarioAleatorio() {
		double latitude = Math.random() * 180 - 90;
		double longitude = Math.random() * 360 - 180;
		return new Funcionario("", latitude, longitude);
	}

}
