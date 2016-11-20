package test.fiuba.algo3.modelo;

import static org.junit.Assert.*;

import org.junit.Test;

import src.fiuba.algo3.modelo.AlgoMon;
import src.fiuba.algo3.modelo.AlgoMonBuilder;
import src.fiuba.algo3.modelo.efectos.QuitarVida;
import src.fiuba.algo3.modelo.elementos.SuperPocion;

public class SuperPocionTest {
	private SuperPocion spocion;
	@Test
	public void testAplicar() {
		AlgoMon algomon = AlgoMonBuilder.crearCharmander();
		algomon.recibirEfecto(new QuitarVida(100));
		spocion = new SuperPocion();
		spocion.aplicar(algomon);
		assertEquals((algomon.getVidaMaxima()-100)+SuperPocion.getVidaAumentada(),algomon.getVida(),0.01);
	}

}
