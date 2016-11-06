package test.fiuba.algo3.modelo;

import static org.junit.Assert.*;

import org.junit.Test;

import src.fiuba.algo3.modelo.efectos.QuitarVida;
import src.fiuba.algo3.modelo.estados.EstadoNormal;

public class QuitarVidaTest {
	private QuitarVida quitarVida;
	@Test
	public void testAplicar() {
		quitarVida= new QuitarVida(150);
		EstadoNormal estado = new EstadoNormal(170);
		assertEquals(20,quitarVida.aplicar(estado).getVida(),0.01);
	}

}
