package test.fiuba.algo3.modelo;

import org.junit.Test;
import static org.junit.Assert.*;
import src.fiuba.algo3.modelo.*;

public class BatallaTests {

	@Test
	public void test01SquirtleAtacaACharmanderConBurbujaYCanionDeAgua() {

		AlgoMon charmander = AlgoMonBuilder.crearCharmander();
		AlgoMon squirtle = AlgoMonBuilder.crearSquirtle();

		assertEquals(170, charmander.getVida());

		squirtle.ataque1(charmander);
		assertEquals(150, charmander.getVida());

		squirtle.ataque2(charmander);
		assertEquals(110, charmander.getVida());

	}

	@Test
	public void test02SquirtleAtacaABulbasaurConBurbujaYCanionDeAgua() {

		AlgoMon bulbasaur = AlgoMonBuilder.crearBulbasaur();
		AlgoMon squirtle = AlgoMonBuilder.crearSquirtle();

		assertEquals(140, bulbasaur.getVida());

		squirtle.ataque1(bulbasaur);
		assertEquals(135, bulbasaur.getVida());

		squirtle.ataque2(bulbasaur);
		assertEquals(125, bulbasaur.getVida());

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
		assertEquals(120, jigglypuff.getVida());

		squirtle.ataque1(chansey);
		assertEquals(120, jigglypuff.getVida());

		squirtle.ataque1(rattata);
		assertEquals(160, rattata.getVida());

		squirtle.ataque2(jigglypuff);
		assertEquals(100, jigglypuff.getVida());

		squirtle.ataque2(chansey);
		assertEquals(100, chansey.getVida());

		squirtle.ataque2(rattata);
		assertEquals(100, rattata.getVida());

	}

	@Test
	public void test04BulbasaurYChanseyAtacanASquirtleConLatigoCepa() {

		AlgoMon bulbasaur = AlgoMonBuilder.crearBulbasaur();
		AlgoMon chansey = AlgoMonBuilder.crearChansey();
		AlgoMon squirtle = AlgoMonBuilder.crearSquirtle();

		bulbasaur.ataque2(squirtle);
		assertEquals(120, squirtle.getVida());

		chansey.ataque2(squirtle);
		assertEquals(90, squirtle.getVida());
	}

	@Test
	public void test05BulbasaurYChanseyAtacanACharmanderConLatigoCepa() {

		AlgoMon bulbasaur = AlgoMonBuilder.crearBulbasaur();
		AlgoMon chansey = AlgoMonBuilder.crearChansey();
		AlgoMon charmander = AlgoMonBuilder.crearCharmander();

		bulbasaur.ataque2(charmander);
		assertEquals(163, charmander.getVida());

		chansey.ataque2(charmander);
		assertEquals(156, charmander.getVida());
	}

	@Test
	public void test06BulbasaurYChanseyAtacanALosOtrosAlgomonesConLatigoCepa() {

		AlgoMon bulbasaur = AlgoMonBuilder.crearBulbasaur();
		AlgoMon jigglypuff = AlgoMonBuilder.crearJigglypuff();
		AlgoMon chansey = AlgoMonBuilder.crearChansey();
		AlgoMon otroChansey = AlgoMonBuilder.crearChansey();
		AlgoMon rattata = AlgoMonBuilder.crearRattata();

		bulbasaur.ataque2(jigglypuff);
		assertEquals(115, jigglypuff.getVida());

		bulbasaur.ataque2(otroChansey);
		assertEquals(115, otroChansey.getVida());

		bulbasaur.ataque2(rattata);
		assertEquals(155, rattata.getVida());

		chansey.ataque2(jigglypuff);
		assertEquals(100, jigglypuff.getVida());

		chansey.ataque2(otroChansey);
		assertEquals(100, otroChansey.getVida());

		chansey.ataque2(rattata);
		assertEquals(140, rattata.getVida());

	}

	@Test
	public void test07CharmanderAtacaABulbasaurConBrasas() {

		AlgoMon charmander = AlgoMonBuilder.crearCharmander();
		AlgoMon bulbasaur = AlgoMonBuilder.crearBulbasaur();

		charmander.ataque1(bulbasaur);
		assertEquals(108, bulbasaur.getVida());

	}

	@Test
	public void test08CharmanderAtacaASquirtleConBrasas() {

		AlgoMon charmander = AlgoMonBuilder.crearCharmander();
		AlgoMon squirtle = AlgoMonBuilder.crearSquirtle();

		charmander.ataque1(squirtle);
		assertEquals(142, squirtle.getVida());

	}

	@Test
	public void test09CharmanderAtacaALosOtrosAlgomonesConBrasas() {

		AlgoMon charmander = AlgoMonBuilder.crearCharmander();
		AlgoMon jigglypuff = AlgoMonBuilder.crearJigglypuff();
		AlgoMon chansey = AlgoMonBuilder.crearChansey();
		AlgoMon rattata = AlgoMonBuilder.crearRattata();

		charmander.ataque1(jigglypuff);
		assertEquals(114, jigglypuff.getVida());

		charmander.ataque1(chansey);
		assertEquals(114, chansey.getVida());

		charmander.ataque1(rattata);
		assertEquals(154, rattata.getVida());

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
		assertEquals(140, squirtle.getVida());

		charmander.ataque3(bulbasaur);
		assertEquals(130, bulbasaur.getVida());

		charmander.ataque3(jigglypuff);
		assertEquals(120, jigglypuff.getVida());

		charmander.ataque3(chansey);
		assertEquals(120, chansey.getVida());

		charmander.ataque3(rattata);
		assertEquals(160, rattata.getVida());

		squirtle.ataque3(charmander);
		assertEquals(160, charmander.getVida());

		squirtle.ataque3(bulbasaur);
		assertEquals(120, bulbasaur.getVida());

		squirtle.ataque3(jigglypuff);
		assertEquals(110, jigglypuff.getVida());

		squirtle.ataque3(chansey);
		assertEquals(110, chansey.getVida());

		squirtle.ataque3(rattata);
		assertEquals(150, rattata.getVida());

		bulbasaur.ataque3(charmander);
		assertEquals(150, charmander.getVida());

		bulbasaur.ataque3(squirtle);
		assertEquals(120, squirtle.getVida());

		bulbasaur.ataque3(jigglypuff);
		assertEquals(100, jigglypuff.getVida());

		bulbasaur.ataque3(chansey);
		assertEquals(100, chansey.getVida());

		bulbasaur.ataque3(rattata);
		assertEquals(140, rattata.getVida());

		jigglypuff.ataque3(charmander);
		assertEquals(130, charmander.getVida());

		jigglypuff.ataque3(squirtle);
		assertEquals(110, squirtle.getVida());

		jigglypuff.ataque3(bulbasaur);
		assertEquals(100, bulbasaur.getVida());

		jigglypuff.ataque3(chansey);
		assertEquals(90, chansey.getVida());

		jigglypuff.ataque3(rattata);
		assertEquals(130, rattata.getVida());

		chansey.ataque3(charmander);
		assertEquals(120, charmander.getVida());

		chansey.ataque3(squirtle);
		assertEquals(100, squirtle.getVida());

		chansey.ataque3(bulbasaur);
		assertEquals(90, bulbasaur.getVida());

		chansey.ataque3(jigglypuff);
		assertEquals(80, jigglypuff.getVida());

		chansey.ataque3(rattata);
		assertEquals(120, rattata.getVida());

		rattata.ataque3(charmander);
		assertEquals(110, charmander.getVida());

		rattata.ataque3(squirtle);
		assertEquals(90, squirtle.getVida());

		rattata.ataque3(bulbasaur);
		assertEquals(80, bulbasaur.getVida());

		rattata.ataque3(jigglypuff);
		assertEquals(70, jigglypuff.getVida());

		rattata.ataque3(chansey);
		assertEquals(70, chansey.getVida());

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
