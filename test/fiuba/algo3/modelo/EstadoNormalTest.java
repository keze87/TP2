package test.fiuba.algo3.modelo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import src.fiuba.algo3.modelo.estados.Estado;
import src.fiuba.algo3.modelo.estados.EstadoNormal;
import src.fiuba.algo3.modelo.excepciones.AlgoMonMurio;


public class EstadoNormalTest {
	Estado estado;

	@Test
	public void testPuedeRealizarAccionSiempreTrueEnEstadoNormal() {
		estado = new EstadoNormal(170);
		assertTrue(estado.puedeRealizarAccion());
	}

	@Test
	public void testAccionRealizadaNoHaceNadaEnEstadoNormal() {
		estado = new EstadoNormal(170);
		estado.accionRealizada();
		assertEquals(170, estado.getVida(), 0.01);
	}

	@Test
	public void testAumentarVida() {
		estado = new EstadoNormal(170);

		estado.aumentarVida(10);
		assertEquals(170, estado.getVida(), 0.01);

		estado.quitarVida(20);
		assertEquals(150,estado.getVida(),0.01);
		estado.aumentarVida(10);
		assertEquals(160, estado.getVida(), 0.01);
	}

	@Test
	public void testQuitarVida() {
		estado = new EstadoNormal(170);
		estado.quitarVida(10);

		assertEquals(160, estado.getVida(), 0.01);
		assertEquals(160, estado.getVida(), 0.01);
	}

	@Test
	public void testGetVida() {
		estado = new EstadoNormal(170);
		assertEquals(170, estado.getVida(), 0.01);
	}

	@Test
	public void testEstaVivo() {
		estado = new EstadoNormal(170);
		assertTrue(estado.estaVivo());
	}

	@Test
	public void testNoEstaVivo() {
		try {
			estado = new EstadoNormal(170);
			estado.quitarVida(170);
		} catch(AlgoMonMurio e) {
			assertFalse(estado.estaVivo());
		}
	}

}
