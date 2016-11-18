package test.fiuba.algo3.modelo;

import static org.junit.Assert.*;

import org.junit.Test;

import src.fiuba.algo3.modelo.efectos.Vampiro;
import src.fiuba.algo3.modelo.estados.Estado;
import src.fiuba.algo3.modelo.estados.EstadoNormal;

public class VampiroTest {
	private Vampiro vampiro;
	@Test
	public void testAplicarSobreEstadoAtacanteLeAumentaLaVidaUn30PorcientoDeLaVidaQuitadaAlAtacado() {
		vampiro= new Vampiro();
		Estado estadoAtacante = new EstadoNormal(170);
		estadoAtacante.quitarVida(30);
		vampiro.setVidaQuitadaAlOponente(100);
		vampiro.aplicar(estadoAtacante);
		assertEquals(estadoAtacante.getVidaMaxima(),estadoAtacante.getVida(),0.01);
	}

}
