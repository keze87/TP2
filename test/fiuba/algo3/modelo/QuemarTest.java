package test.fiuba.algo3.modelo;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import src.fiuba.algo3.modelo.efectos.Quemar;
import src.fiuba.algo3.modelo.estados.AlgoMonRecibeQuemadura;
import src.fiuba.algo3.modelo.estados.Estado;
import src.fiuba.algo3.modelo.estados.EstadoNormal;
import src.fiuba.algo3.modelo.estados.Quemado;

public class QuemarTest {
	private Quemar quemar;

	@Test
	public void testAplicarSobreEstadoQuema() {
		this.quemar= new Quemar();

		EstadoNormal estado = new EstadoNormal(170);
		Estado nuevoEstado;

		nuevoEstado = this.quemar.aplicar(estado);
		try{nuevoEstado.accionRealizada();} catch(AlgoMonRecibeQuemadura e){}
		assertEquals(estado.getVidaMaxima()-Quemado.getVidaQuitada(estado.getVidaMaxima()), nuevoEstado.getVida(), 0.01);
	}

}
