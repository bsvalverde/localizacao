package test.servicos.angulos;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import main.servicos.angulos.ConversorGrausEmRadianos;

class ConversorGrausEmRadianosTest {

	@Test
	void converteCorretamenteGrausEmRadianos() {
		double graus = 180;
		double radianos = Math.PI;
		assertTrue(new ConversorGrausEmRadianos(graus).call() == radianos);
	}

}
