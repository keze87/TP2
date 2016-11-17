package test.fiuba.algo3.modelo;

import static org.junit.Assert.*;

import org.junit.Test;

import src.fiuba.algo3.modelo.AlgoMon;
import src.fiuba.algo3.modelo.AlgoMonBuilder;
import src.fiuba.algo3.modelo.efectos.QuitarVida;
import src.fiuba.algo3.modelo.elementos.Pocion;

public class PocionTest {
	private Pocion pocion;
	@Test
	public void testAplicarAumentaLaVida() {
		AlgoMon algomon = AlgoMonBuilder.crearCharmander();
		algomon.recibirEfecto(new QuitarVida(100));
		pocion = new Pocion();
		pocion.aplicar(algomon);
		assertEquals(algomon.getVidaMaxima()-100+Pocion.getVidaAumentada(),algomon.getVida(),0.01);
		
	}

}
