// Que les parece:
// test.fiuba.algo3.modelo.tests
package test;

import org.junit.Test;
import org.junit.Assert.*;

public class BatallaTests {

	@Test
	public void test01SquirtleAtacaACharmanderConBurbujaYCanionDeAgua() {

		/* Yo habia pensado usar buidler pattern
		 * https://en.wikipedia.org/wiki/Builder_pattern
		 * pero lo hacemos como quieran.
		 */

		Algomon charmander = new AlgomonBuilder().crearCharmander();
		Algomon squirtle = new AlgomonBuilder().crearSquirtle();

		assertEquals(170, charmander.vida());

		/* Como le decimos cual ataque?
		 * Un enum?
		 */
		squirtle.atacar( /* Ataque.BURBUJA ,*/ charmander);


		assertEquals(150, charmander.vida());

		squirtle.atacar( /* Ataque.CAÑONAGUA ,*/ charmander);

		assertEquals(110, charmander.vida());

	}

	@Test
	public void test02SquirtleAtacaABulbasaurConBurbujaYCanionDeAgua() {

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
