package test.fiuba.algo3.modelo;

import static org.junit.Assert.*;

import org.junit.Test;

import src.fiuba.algo3.modelo.efectos.Quemar;
import src.fiuba.algo3.modelo.estados.Estado;
import src.fiuba.algo3.modelo.estados.EstadoNormal;

public class QuemarTest {
	private Quemar quemar;
	@Test
	public void testAplicar() {
		quemar= new Quemar();
		EstadoNormal estado = new EstadoNormal(170);
		Estado nuevoEstado;
		nuevoEstado = quemar.aplicar(estado);
		nuevoEstado.accionRealizada();
		assertEquals(153,nuevoEstado.getVida(),0.01);
	}

}
