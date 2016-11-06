package test.fiuba.algo3.modelo;

import org.junit.Test;
import static org.junit.Assert.*;
import src.fiuba.algo3.modelo.*;

public class BatallaTests {

	@Test
	public void test01SquirtleAtacaACharmanderConBurbujaYCanionDeAgua() {

		AlgoMon charmander = AlgoMonBuilder.crearCharmander();
		AlgoMon squirtle = AlgoMonBuilder.crearSquirtle();

		assertEquals(170, charmander.vida());

		squirtle.ataque1(charmander);
		assertEquals(150, charmander.vida());

		squirtle.ataque2(charmander);
		assertEquals(110, charmander.vida());

	}

	@Test
	public void test02SquirtleAtacaABulbasaurConBurbujaYCanionDeAgua() {

		AlgoMon bulbasaur = AlgoMonBuilder.crearBulbasaur();
		AlgoMon squirtle = AlgoMonBuilder.crearSquirtle();

		assertEquals(140, bulbasaur.vida());

		squirtle.ataque1(bulbasaur);
		assertEquals(135, bulbasaur.vida());

		squirtle.ataque2(bulbasaur);
		assertEquals(125, bulbasaur.vida());

	}

	@Test
	public void test03SquirtleAtacaALosOtrosAlgoMonesConBurbujaYCanionDeAgua() {

		/* Otros AlgoMones:
		 * Chansey
		 * Rattata
		 * Jigglypuff
		 */

		AlgoMon squirtle = AlgoMonBuilder.crearSquirtle();
		AlgoMon jigglypuff = AlgoMonBuilder.crearJigglypuff();
		AlgoMon chansey = AlgoMonBuilder.crearChansey();
		AlgoMon rattata = AlgoMonBuilder.crearRattata();

		squirtle.ataque1(jigglypuff);
		assertEquals(120, jigglypuff.vida());

		squirtle.ataque1(chansey);
		assertEquals(120, jigglypuff.vida());

		squirtle.ataque1(rattata);
		assertEquals(160, rattata.vida());

		squirtle.ataque2(jigglypuff);
		assertEquals(100, jigglypuff.vida());

		squirtle.ataque2(chansey);
		assertEquals(100, chansey.vida());

		squirtle.ataque2(rattata);
		assertEquals(100, rattata.vida());

	}

	@Test
	public void test04BulbasaurYChanseyAtacanASquirtleConLatigoCepa() {

		AlgoMon bulbasaur = AlgoMonBuilder.crearBulbasaur();
		AlgoMon chansey = AlgoMonBuilder.crearChansey();
		AlgoMon squirtle = AlgoMonBuilder.crearSquirtle();

		bulbasaur.ataque2(squirtle);
		assertEquals(120, squirtle.vida());

		chansey.ataque2(squirtle);
		assertEquals(90, squirtle.vida());
	}

	@Test
	public void test05BulbasaurYChanseyAtacanACharmanderConLatigoCepa() {

		AlgoMon bulbasaur = AlgoMonBuilder.crearBulbasaur();
		AlgoMon chansey = AlgoMonBuilder.crearChansey();
		AlgoMon charmander = AlgoMonBuilder.crearCharmander();

		bulbasaur.ataque2(charmander);
		assertEquals(163, charmander.vida());

		chansey.ataque2(charmander);
		assertEquals(156, charmander.vida());
	}

	@Test
	public void test06BulbasaurYChanseyAtacanALosOtrosAlgomonesConLatigoCepa() {

		AlgoMon bulbasaur = AlgoMonBuilder.crearBulbasaur();
		AlgoMon jigglypuff = AlgoMonBuilder.crearJigglypuff();
		AlgoMon chansey = AlgoMonBuilder.crearChansey();
		AlgoMon otroChansey = AlgoMonBuilder.crearChansey();
		AlgoMon rattata = AlgoMonBuilder.crearRattata();

		bulbasaur.ataque2(jigglypuff);
		assertEquals(115, jigglypuff.vida());

		bulbasaur.ataque2(otroChansey);
		assertEquals(115, otroChansey.vida());

		bulbasaur.ataque2(rattata);
		assertEquals(155, rattata.vida());

		chansey.ataque2(jigglypuff);
		assertEquals(100, jigglypuff.vida());

		chansey.ataque2(otroChansey);
		assertEquals(100, otroChansey.vida());

		chansey.ataque2(rattata);
		assertEquals(140, rattata.vida());

	}

	@Test
	public void test07CharmanderAtacaABulbasaurConBrasas() {

		AlgoMon charmander = AlgoMonBuilder.crearCharmander();
		AlgoMon bulbasaur = AlgoMonBuilder.crearBulbasaur();

		charmander.ataque1(bulbasaur);
		assertEquals(108, bulbasaur.vida());

	}

	@Test
	public void test08CharmanderAtacaASquirtleConBrasas() {

		AlgoMon charmander = AlgoMonBuilder.crearCharmander();
		AlgoMon squirtle = AlgoMonBuilder.crearSquirtle();

		charmander.ataque1(squirtle);
		assertEquals(142, squirtle.vida());

	}

	@Test
	public void test09CharmanderAtacaALosOtrosAlgomonesConBrasas() {

		AlgoMon charmander = AlgoMonBuilder.crearCharmander();
		AlgoMon jigglypuff = AlgoMonBuilder.crearJigglypuff();
		AlgoMon chansey = AlgoMonBuilder.crearChansey();
		AlgoMon rattata = AlgoMonBuilder.crearRattata();

		charmander.ataque1(jigglypuff);
		assertEquals(114, jigglypuff.vida());

		charmander.ataque1(chansey);
		assertEquals(114, chansey.vida());

		charmander.ataque1(rattata);
		assertEquals(154, rattata.vida());

	}

	@Test
	public void test10AlgomonesAtacanConAtaqueRapido() {

		AlgoMon charmander = AlgoMonBuilder.crearCharmander();
		AlgoMon squirtle = AlgoMonBuilder.crearSquirtle();
		AlgoMon bulbasaur = AlgoMonBuilder.crearBulbasaur();
		AlgoMon jigglypuff = AlgoMonBuilder.crearJigglypuff();
		AlgoMon chansey = AlgoMonBuilder.crearChansey();
		AlgoMon rattata = AlgoMonBuilder.crearRattata();

		charmander.ataque3(squirtle);
		assertEquals(140, squirtle.vida());

		charmander.ataque3(bulbasaur);
		assertEquals(130, bulbasaur.vida());

		charmander.ataque3(jigglypuff);
		assertEquals(120, jigglypuff.vida());

		charmander.ataque3(chansey);
		assertEquals(120, chansey.vida());

		charmander.ataque3(rattata);
		assertEquals(160, rattata.vida());

		squirtle.ataque3(charmander);
		assertEquals(160, charmander.vida());

		squirtle.ataque3(bulbasaur);
		assertEquals(120, bulbasaur.vida());

		squirtle.ataque3(jigglypuff);
		assertEquals(110, jigglypuff.vida());

		squirtle.ataque3(chansey);
		assertEquals(110, chansey.vida());

		squirtle.ataque3(rattata);
		assertEquals(150, rattata.vida());

		bulbasaur.ataque3(charmander);
		assertEquals(150, charmander.vida());

		bulbasaur.ataque3(squirtle);
		assertEquals(120, squirtle.vida());

		bulbasaur.ataque3(jigglypuff);
		assertEquals(100, jigglypuff.vida());

		bulbasaur.ataque3(chansey);
		assertEquals(100, chansey.vida());

		bulbasaur.ataque3(rattata);
		assertEquals(140, rattata.vida());

		jigglypuff.ataque3(charmander);
		assertEquals(130, charmander.vida());

		jigglypuff.ataque3(squirtle);
		assertEquals(110, squirtle.vida());

		jigglypuff.ataque3(bulbasaur);
		assertEquals(100, bulbasaur.vida());

		jigglypuff.ataque3(chansey);
		assertEquals(90, chansey.vida());

		jigglypuff.ataque3(rattata);
		assertEquals(130, rattata.vida());

		chansey.ataque3(charmander);
		assertEquals(120, charmander.vida());

		chansey.ataque3(squirtle);
		assertEquals(100, squirtle.vida());

		chansey.ataque3(bulbasaur);
		assertEquals(90, bulbasaur.vida());

		chansey.ataque3(jigglypuff);
		assertEquals(80, jigglypuff.vida());

		chansey.ataque3(rattata);
		assertEquals(120, rattata.vida());

		rattata.ataque3(charmander);
		assertEquals(110, charmander.vida());

		rattata.ataque3(squirtle);
		assertEquals(90, squirtle.vida());

		rattata.ataque3(bulbasaur);
		assertEquals(80, bulbasaur.vida());

		rattata.ataque3(jigglypuff);
		assertEquals(70, jigglypuff.vida());

		rattata.ataque3(chansey);
		assertEquals(70, chansey.vida());

	}

	@Test(expected = AtaqueAgotado.class)
	public void test11AlgomonesAgotanCantidadDisponibleDeAtaques() {

		AlgoMon charmander = AlgoMonBuilder.crearCharmander();
		AlgoMon rattata = AlgoMonBuilder.crearRattata();

		charmander.ataque2(rattata);
		charmander.ataque2(rattata);
		charmander.ataque2(rattata);
		charmander.ataque2(rattata);

	}

}
