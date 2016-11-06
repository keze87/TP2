package test.fiuba.algo3.modelo;

import static org.junit.Assert.*;

import org.junit.Test;

import src.fiuba.algo3.modelo.efectos.Dormir;
import src.fiuba.algo3.modelo.estados.EstadoNormal;

public class DormirTest {
	private Dormir dormir;
	@Test
	public void testAplicar() {
		dormir= new Dormir();
		EstadoNormal estado = new EstadoNormal(170);
		assertFalse(dormir.aplicar(estado).puedeRealizarAccion());
	}

}
