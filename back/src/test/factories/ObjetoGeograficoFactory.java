package test.factories;

import main.modelos.ObjetoGeografico;

public class ObjetoGeograficoFactory {
	
	public static ObjetoGeografico criaObjetoGeograficoOcidental() {
		ObjetoGeografico objeto = new ObjetoGeografico(0, -90);
		return objeto;
	}
	
	public static ObjetoGeografico criaObjetoGeograficoOriental() {
		ObjetoGeografico objeto = new ObjetoGeografico(0, 90);
		return objeto;
	}

}
