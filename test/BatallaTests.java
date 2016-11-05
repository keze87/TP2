// Que les parece:
// test.fiuba.algo3.modelo.tests

package test;

import org.junit.Test;
import org.junit.Assert.*;

public class BatallaTests {

	@Test
	public void test01SquirtleAtacaACharmanderConBurbujaYCanionDeAgua() {

		/* Yo habia pensado usar builder pattern
		 * https://en.wikipedia.org/wiki/Builder_pattern
		 * pero lo hacemos como quieran.
		 */
		Algomon charmander = AlgomonBuilder.crearCharmander();
		Algomon squirtle = AlgomonBuilder.crearSquirtle();

		assertEquals(170, charmander.vida());

		squirtle.atacar("Burbuja", charmander);
		assertEquals(150, charmander.vida());

		squirtle.atacar("Ca��n de agua", charmander);
		assertEquals(110, charmander.vida());
		
	}

	@Test
	public void test02SquirtleAtacaABulbasaurConBurbujaYCanionDeAgua() {

		Algomon bulbasaur = AlgomonBuilder.crearBulbasaur();
		Algomon squirtle = AlgomonBuilder.crearSquirtle();

		assertEquals(140, bulbasaur.vida());

		squirtle.atacar("Burbuja", bulbasaur);
		assertEquals(135, bulbasaur.vida());

		squirtle.atacar("Ca��n de agua", bulbasaur);
		assertEquals(125, bulbasaur.vida());

	}

	@Test
	public void test03SquirtleAtacaALosOtrosAlgomonesConBurbujaYCanionDeAgua() {

	}

	@Test
	public void test04BulbasaurYChanseyAtacanASquirtleConLatigoCepa() {

	}

	@Test
	public void test05BulbasaurYChanseyAtacanACharmanderConLatigoCepa() {

	}

	@Test
	public void test06BulbasaurYChanseyAtacanALosOtrosAlgomonesConLatigoCepa() {

	}

	@Test
	public void test07CharmanderAtacaABulbasaurConBrasas() {

	}

	@Test
	public void test08CharmanderAtacaASquirtleConBrasas() {

	}

	@Test
	public void test09CharmanderAtacaALosOtrosAlgomonesConBrasas() {

	}

	@Test
	public void test10AlgomonesAtacanConAtaqueRapido() {

	}

	@Test
	public void test11AlgomonesAgotanCantidadDisponibleDeAtaques() {

	}
}
