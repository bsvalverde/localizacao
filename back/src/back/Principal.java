package back;

import java.util.logging.Level;

import controladores.FuncionarioLojaController;

public class Principal {
	public static void main(String[] args) {
		java.util.logging.Logger.getLogger("org.mongodb.driver").setLevel(Level.SEVERE);
		FuncionarioLojaController.associaFuncionariosALojas(2);
	}

}
