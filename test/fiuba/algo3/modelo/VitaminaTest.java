package test.fiuba.algo3.modelo;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import src.fiuba.algo3.modelo.AlgoMon;
import src.fiuba.algo3.modelo.AlgoMonBuilder;
import src.fiuba.algo3.modelo.ataques.NombreAtaque;
import src.fiuba.algo3.modelo.elementos.Vitamina;

public class VitaminaTest {
	private Vitamina vitamina;
	@Test
	public void testAplicarAumentaCantidadAtaquesDisponibles() {
		vitamina = new Vitamina();
		AlgoMon algomon = AlgoMonBuilder.crearCharmander();
		int usosAntesVitamina=algomon.getUsosRestantesAtaque(NombreAtaque.ATAQUERAPIDO);
		vitamina.aplicar(algomon);
		assertEquals(usosAntesVitamina+Vitamina.getCantAtaquesRestaurados(),
				algomon.getUsosRestantesAtaque(NombreAtaque.ATAQUERAPIDO));
	}

}
