package test.fiuba.algo3.modelo;

import static org.junit.Assert.*;

import org.junit.Test;

import src.fiuba.algo3.modelo.efectos.AumentarVida;
import src.fiuba.algo3.modelo.estados.Estado;
import src.fiuba.algo3.modelo.estados.EstadoNormal;

public class AumentarVidaTest {
	private AumentarVida efecto;
	@Test
	public void testAplicarAumentaLaVidaEnElValorDado() {
		efecto = new AumentarVida(100);
		Estado estado = new EstadoNormal(170);
		estado.quitarVida(100);
		efecto.aplicar(estado);
		assertEquals(estado.getVidaMaxima(),estado.getVida(),0.01);
	}

}
