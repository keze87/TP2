package test.fiuba.algo3.modelo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import src.fiuba.algo3.modelo.estados.EstadoNormal;
import src.fiuba.algo3.modelo.estados.Quemado;


public class QuemadoTest {

	EstadoNormal estadoAnterior = new EstadoNormal(170);
	Quemado quemado;

	@Test
	public void testPuedeRealizarAccionSiempreTrue() {
		this.quemado = new Quemado(this.estadoAnterior);
		assertTrue(this.quemado.puedeRealizarAccion());
	}

	@Test
	public void testAccionRealizadaQuitaVida() {
		this.quemado = new Quemado(this.estadoAnterior);
		this.quemado.accionRealizada();
		assertEquals(this.estadoAnterior.getVidaMaxima() - 17, this.quemado.getVida(), 0.01);
	}

	@Test
	public void testVolverEstadoAnterior() {
		this.quemado = new Quemado(this.estadoAnterior);
		assertSame(this.estadoAnterior, this.quemado.volverEstadoAnterior());
	}

}
