package test.fiuba.algo3.modelo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import src.fiuba.algo3.modelo.estados.Dormido;
import src.fiuba.algo3.modelo.estados.EstadoNormal;


public class DormidoTest {

	EstadoNormal estadoAnterior = new EstadoNormal(170);
	Dormido dormido;

	@Test
	public void testPuedeRealizarAccionFalsoAntesTresAcciones() {

		dormido = new Dormido(estadoAnterior);
		assertFalse(dormido.puedeRealizarAccion());

		dormido.accionRealizada();
		assertFalse(dormido.puedeRealizarAccion());

	}

	@Test
	public void testPuedeRealizarAccionVerdaderoDespuesTresAcciones() {

		dormido = new Dormido(estadoAnterior);
		dormido.accionRealizada();
		dormido.accionRealizada();
		dormido.accionRealizada();
		assertTrue(dormido.puedeRealizarAccion());

	}

	@Test
	public void testAccionRealizadaCambiaLosTurnosRestantes() {

		dormido = new Dormido(estadoAnterior);
		dormido.accionRealizada();
		dormido.accionRealizada();
		assertEquals(1, dormido.getTurnosRestantesDormido());

	}


	@Test
	public void testVolverEstadoAnterior() {

		dormido = new Dormido(estadoAnterior);
		assertSame(estadoAnterior, dormido.volverEstadoAnterior());

	}

}
