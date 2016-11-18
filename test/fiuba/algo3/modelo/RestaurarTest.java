package test.fiuba.algo3.modelo;

import static org.junit.Assert.*;

import org.junit.Test;

import src.fiuba.algo3.modelo.efectos.Efecto;
import src.fiuba.algo3.modelo.efectos.Restaurar;
import src.fiuba.algo3.modelo.estados.Dormido;
import src.fiuba.algo3.modelo.estados.Estado;
import src.fiuba.algo3.modelo.estados.EstadoNormal;
import src.fiuba.algo3.modelo.estados.Quemado;

public class RestaurarTest {
	private Efecto restaurar;
	
	@Test
	public void testAplicarAQuemadoVuelveANormal() {
		restaurar= new Restaurar();
		Estado estado = new Quemado(new EstadoNormal(170));
		estado.accionRealizada();
		double vidaDespuesDeUnaAccionRealizada=estado.getVidaMaxima()-Quemado.getVidaQuitada(estado.getVidaMaxima());
		assertEquals(vidaDespuesDeUnaAccionRealizada,estado.getVida(),0.01);
		estado = restaurar.aplicar(estado);
		estado.accionRealizada();
		assertEquals(vidaDespuesDeUnaAccionRealizada,estado.getVida(),0.01);

	}
	
	@Test
	public void testAplicarADormidoVuelveANormal() {
		restaurar= new Restaurar();
		Estado estado = new Dormido(new EstadoNormal(170));
		assertFalse(estado.puedeRealizarAccion());
		estado = restaurar.aplicar(estado);
		assertTrue(estado.puedeRealizarAccion());
	}
	
	@Test
	public void testAplicarADormidoYQuemadoVuelveANormal() {
		restaurar= new Restaurar();
		Estado estado = new Dormido(new Quemado(new EstadoNormal(170)));
		double vidaDespuesDeUnaAccionRealizada=estado.getVidaMaxima()-Quemado.getVidaQuitada(estado.getVidaMaxima());
		assertFalse(estado.puedeRealizarAccion());
		estado.accionRealizada();
		assertEquals(vidaDespuesDeUnaAccionRealizada,estado.getVida(),0.01);
		estado = restaurar.aplicar(estado);
		assertTrue(estado.puedeRealizarAccion());
		assertEquals(vidaDespuesDeUnaAccionRealizada,estado.getVida(),0.01);

	}
}
