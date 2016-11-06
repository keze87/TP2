package test.fiuba.algo3.modelo;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import src.fiuba.algo3.modelo.AlgoMon;
import src.fiuba.algo3.modelo.AlgoMonBuilder;
import src.fiuba.algo3.modelo.ataques.AtaqueAgotado;

public class AlgoMonTest {

	@Test
	public void test01SquirtleAtacaACharmanderConBurbujaYCanionDeAgua() {

		AlgoMon charmander = AlgoMonBuilder.crearCharmander();
		AlgoMon squirtle = AlgoMonBuilder.crearSquirtle();

		assertEquals(170, charmander.getVida(), 0.0001D);

		squirtle.ataque1(charmander);
		assertEquals(150, charmander.getVida(), 0.0001D);

		squirtle.ataque2(charmander);
		assertEquals(110, charmander.getVida(), 0.0001D);

	}

	@Test
	public void test02SquirtleAtacaABulbasaurConBurbujaYCanionDeAgua() {

		AlgoMon bulbasaur = AlgoMonBuilder.crearBulbasaur();
		AlgoMon squirtle = AlgoMonBuilder.crearSquirtle();

		assertEquals(140, bulbasaur.getVida(), 0.0001D);

		squirtle.ataque1(bulbasaur);
		assertEquals(135, bulbasaur.getVida(), 0.0001D);

		squirtle.ataque2(bulbasaur);
		assertEquals(125, bulbasaur.getVida(), 0.0001D);

	}

	@Test
	public void test03SquirtleAtacaALosOtrosAlgoMonesConBurbujaYCanionDeAgua() {

		AlgoMon squirtle = AlgoMonBuilder.crearSquirtle();
		AlgoMon jigglypuff = AlgoMonBuilder.crearJigglypuff();
		AlgoMon chansey = AlgoMonBuilder.crearChansey();
		AlgoMon rattata = AlgoMonBuilder.crearRattata();

		squirtle.ataque1(jigglypuff);

		assertEquals(120, jigglypuff.getVida(), 0.0001D);

		squirtle.ataque1(chansey);
		assertEquals(120, chansey.getVida(), 0.0001D);

		squirtle.ataque1(rattata);
		assertEquals(160, rattata.getVida(), 0.0001D);

		squirtle.ataque2(jigglypuff);
		assertEquals(100, jigglypuff.getVida(), 0.0001D);

		squirtle.ataque2(chansey);
		assertEquals(100, chansey.getVida(), 0.0001D);

		squirtle.ataque2(rattata);
		assertEquals(140, rattata.getVida(), 0.0001D);

	}

	@Test
	public void test04BulbasaurYChanseyAtacanASquirtleConLatigoCepa() {

		AlgoMon bulbasaur = AlgoMonBuilder.crearBulbasaur();
		AlgoMon chansey = AlgoMonBuilder.crearChansey();
		AlgoMon squirtle = AlgoMonBuilder.crearSquirtle();

		bulbasaur.ataque2(squirtle);
		assertEquals(120, squirtle.getVida(), 0.0001D);

		chansey.ataque2(squirtle);
		assertEquals(90, squirtle.getVida(), 0.0001D);
	}

	@Test
	public void test05BulbasaurYChanseyAtacanACharmanderConLatigoCepa() {

		AlgoMon bulbasaur = AlgoMonBuilder.crearBulbasaur();
		AlgoMon chansey = AlgoMonBuilder.crearChansey();
		AlgoMon charmander = AlgoMonBuilder.crearCharmander();

		bulbasaur.ataque2(charmander);
		assertEquals(163, charmander.getVida(), 0.0001D);

		chansey.ataque2(charmander);
		assertEquals(156, charmander.getVida(), 0.0001D);
	}

	@Test
	public void test06BulbasaurYChanseyAtacanALosOtrosAlgomonesConLatigoCepa() {

		AlgoMon bulbasaur = AlgoMonBuilder.crearBulbasaur();
		AlgoMon jigglypuff = AlgoMonBuilder.crearJigglypuff();
		AlgoMon chansey = AlgoMonBuilder.crearChansey();
		AlgoMon otroChansey = AlgoMonBuilder.crearChansey();
		AlgoMon rattata = AlgoMonBuilder.crearRattata();

		bulbasaur.ataque2(jigglypuff);
		assertEquals(115, jigglypuff.getVida(), 0.0001D);

		bulbasaur.ataque2(otroChansey);
		assertEquals(115, otroChansey.getVida(), 0.0001D);

		bulbasaur.ataque2(rattata);
		assertEquals(155, rattata.getVida(), 0.0001D);

		chansey.ataque2(jigglypuff);
		assertEquals(100, jigglypuff.getVida(), 0.0001D);

		chansey.ataque2(otroChansey);
		assertEquals(100, otroChansey.getVida(), 0.0001D);

		chansey.ataque2(rattata);
		assertEquals(140, rattata.getVida(), 0.0001D);

	}

	@Test
	public void test07CharmanderAtacaABulbasaurConBrasas() {

		AlgoMon charmander = AlgoMonBuilder.crearCharmander();
		AlgoMon bulbasaur = AlgoMonBuilder.crearBulbasaur();

		charmander.ataque1(bulbasaur);
		assertEquals(108, bulbasaur.getVida(), 0.0001D);

	}

	@Test
	public void test08CharmanderAtacaASquirtleConBrasas() {

		AlgoMon charmander = AlgoMonBuilder.crearCharmander();
		AlgoMon squirtle = AlgoMonBuilder.crearSquirtle();

		charmander.ataque1(squirtle);
		assertEquals(142, squirtle.getVida(), 0.0001D);

	}

	@Test
	public void test09CharmanderAtacaALosOtrosAlgomonesConBrasas() {

		AlgoMon charmander = AlgoMonBuilder.crearCharmander();
		AlgoMon jigglypuff = AlgoMonBuilder.crearJigglypuff();
		AlgoMon chansey = AlgoMonBuilder.crearChansey();
		AlgoMon rattata = AlgoMonBuilder.crearRattata();

		charmander.ataque1(jigglypuff);
		assertEquals(114, jigglypuff.getVida(), 0.0001D);

		charmander.ataque1(chansey);
		assertEquals(114, chansey.getVida(), 0.0001D);

		charmander.ataque1(rattata);
		assertEquals(154, rattata.getVida(), 0.0001D);

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
		assertEquals(140, squirtle.getVida(), 0.0001D);

		charmander.ataque3(bulbasaur);
		assertEquals(130, bulbasaur.getVida(), 0.0001D);

		charmander.ataque3(jigglypuff);
		assertEquals(120, jigglypuff.getVida(), 0.0001D);

		charmander.ataque3(chansey);
		assertEquals(120, chansey.getVida(), 0.0001D);

		charmander.ataque3(rattata);
		assertEquals(160, rattata.getVida(), 0.0001D);

		squirtle.ataque3(charmander);
		assertEquals(160, charmander.getVida(), 0.0001D);

		squirtle.ataque3(bulbasaur);
		assertEquals(120, bulbasaur.getVida(), 0.0001D);

		squirtle.ataque3(jigglypuff);
		assertEquals(110, jigglypuff.getVida(), 0.0001D);

		squirtle.ataque3(chansey);
		assertEquals(110, chansey.getVida(), 0.0001D);

		squirtle.ataque3(rattata);
		assertEquals(150, rattata.getVida(), 0.0001D);

		bulbasaur.ataque3(charmander);
		assertEquals(150, charmander.getVida(), 0.0001D);

		bulbasaur.ataque3(squirtle);
		assertEquals(130, squirtle.getVida(), 0.0001D);

		bulbasaur.ataque3(jigglypuff);
		assertEquals(100, jigglypuff.getVida(), 0.0001D);

		bulbasaur.ataque3(chansey);
		assertEquals(100, chansey.getVida(), 0.0001D);

		bulbasaur.ataque3(rattata);
		assertEquals(140, rattata.getVida(), 0.0001D);

		jigglypuff.ataque3(charmander);
		assertEquals(140, charmander.getVida(), 0.0001D);

		jigglypuff.ataque3(squirtle);
		assertEquals(120, squirtle.getVida(), 0.0001D);

		jigglypuff.ataque3(bulbasaur);
		assertEquals(110, bulbasaur.getVida(), 0.0001D);

		jigglypuff.ataque3(chansey);
		assertEquals(90, chansey.getVida(), 0.0001D);

		jigglypuff.ataque3(rattata);
		assertEquals(130, rattata.getVida(), 0.0001D);

		chansey.ataque3(charmander);
		assertEquals(130, charmander.getVida(), 0.0001D);

		chansey.ataque3(squirtle);
		assertEquals(110, squirtle.getVida(), 0.0001D);

		chansey.ataque3(bulbasaur);
		assertEquals(100, bulbasaur.getVida(), 0.0001D);

		chansey.ataque3(jigglypuff);
		assertEquals(90, jigglypuff.getVida(), 0.0001D);

		chansey.ataque3(rattata);
		assertEquals(120, rattata.getVida(), 0.0001D);

		rattata.ataque3(charmander);
		assertEquals(120, charmander.getVida(), 0.0001D);

		rattata.ataque3(squirtle);
		assertEquals(100, squirtle.getVida(), 0.0001D);

		rattata.ataque3(bulbasaur);
		assertEquals(90, bulbasaur.getVida(), 0.0001D);

		rattata.ataque3(jigglypuff);
		assertEquals(80, jigglypuff.getVida(), 0.0001D);

		rattata.ataque3(chansey);
		assertEquals(80, chansey.getVida(), 0.0001D);

	}

	@Test(expected = AtaqueAgotado.class)
	public void test11AlgomonesAgotanCantidadDisponibleDeAtaques() {

		AlgoMon charmander = AlgoMonBuilder.crearCharmander();
		AlgoMon rattata = AlgoMonBuilder.crearRattata();

		charmander.ataque2(rattata);
		charmander.ataque2(rattata);
		charmander.ataque2(rattata);
		charmander.ataque2(rattata);
		charmander.ataque2(rattata);

	}

}
