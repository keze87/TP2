package test.fiuba.algo3.modelo;

import org.junit.Test;
import static org.junit.Assert.*;
import src.fiuba.algo3.modelo.*;

public class QuemadoTest {
	EstadoNormal estadoAnterior= new EstadoNormal(170);
	Quemado quemado;
	@Test
	public void testPuedeRealizarAccionSiempreTrue() {
		quemado= new Quemado(estadoAnterior);
		assertTrue(quemado.puedeRealizarAccion());
	}

	@Test
	public void testAccionRealizadaQuitaVida() {
		quemado= new Quemado(estadoAnterior);
		quemado.accionRealizada();
		assertEquals(153,quemado.getVida(),0.01);
	}


	@Test
	public void testVolverEstadoAnterior() {
		quemado= new Quemado(estadoAnterior);
		assertSame(estadoAnterior, quemado.volverEstadoAnterior());
	}

}
