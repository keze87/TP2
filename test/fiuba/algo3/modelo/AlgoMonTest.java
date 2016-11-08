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

		assertEquals(charmander.getVidaMaxima(), charmander.getVida(), 0.0001D);

		squirtle.ataque("Burbuja", charmander);
		assertEquals(charmander.getVidaMaxima() - 20, charmander.getVida(), 0.0001D);

		squirtle.ataque("Cañón de agua", charmander);
		assertEquals(charmander.getVidaMaxima() - 60, charmander.getVida(), 0.0001D);

	}

	@Test
	public void test02SquirtleAtacaABulbasaurConBurbujaYCanionDeAgua() {

		AlgoMon bulbasaur = AlgoMonBuilder.crearBulbasaur();
		AlgoMon squirtle = AlgoMonBuilder.crearSquirtle();

		assertEquals(bulbasaur.getVidaMaxima(), bulbasaur.getVida(), 0.0001D);

		squirtle.ataque("Burbuja", bulbasaur);
		assertEquals(bulbasaur.getVidaMaxima() - 5, bulbasaur.getVida(), 0.0001D);

		squirtle.ataque("Cañón de agua", bulbasaur);
		assertEquals(bulbasaur.getVidaMaxima() - 15, bulbasaur.getVida(), 0.0001D);

	}

	@Test
	public void test03SquirtleAtacaALosOtrosAlgoMonesConBurbujaYCanionDeAgua() {

		AlgoMon squirtle = AlgoMonBuilder.crearSquirtle();
		AlgoMon jigglypuff = AlgoMonBuilder.crearJigglypuff();
		AlgoMon chansey = AlgoMonBuilder.crearChansey();
		AlgoMon rattata = AlgoMonBuilder.crearRattata();

		squirtle.ataque("Burbuja", jigglypuff);
		assertEquals(jigglypuff.getVidaMaxima() - 10, jigglypuff.getVida(), 0.0001D);

		squirtle.ataque("Burbuja", chansey);
		assertEquals(chansey.getVidaMaxima() - 10, chansey.getVida(), 0.0001D);

		squirtle.ataque("Burbuja", rattata);
		assertEquals(rattata.getVidaMaxima() - 10, rattata.getVida(), 0.0001D);

		squirtle.ataque("Cañón de agua", jigglypuff);
		assertEquals(jigglypuff.getVidaMaxima() - 30, jigglypuff.getVida(), 0.0001D);

		squirtle.ataque("Cañón de agua", chansey);
		assertEquals(chansey.getVidaMaxima() - 30, chansey.getVida(), 0.0001D);

		squirtle.ataque("Cañón de agua", rattata);
		assertEquals(rattata.getVidaMaxima() - 30, rattata.getVida(), 0.0001D);

	}

	@Test
	public void test04BulbasaurYChanseyAtacanASquirtleConLatigoCepa() {

		AlgoMon bulbasaur = AlgoMonBuilder.crearBulbasaur();
		AlgoMon chansey = AlgoMonBuilder.crearChansey();
		AlgoMon squirtle = AlgoMonBuilder.crearSquirtle();

		bulbasaur.ataque("Látigo cepa", squirtle);
		assertEquals(squirtle.getVidaMaxima() - 30, squirtle.getVida(), 0.0001D);

		chansey.ataque("Látigo cepa", squirtle);
		assertEquals(squirtle.getVidaMaxima() - 60, squirtle.getVida(), 0.0001D);

	}

	@Test
	public void test05BulbasaurYChanseyAtacanACharmanderConLatigoCepa() {

		AlgoMon bulbasaur = AlgoMonBuilder.crearBulbasaur();
		AlgoMon chansey = AlgoMonBuilder.crearChansey();
		AlgoMon charmander = AlgoMonBuilder.crearCharmander();

		bulbasaur.ataque("Látigo cepa", charmander);
		assertEquals(charmander.getVidaMaxima() - 7, charmander.getVida(), 0.0001D);

		chansey.ataque("Látigo cepa", charmander);
		assertEquals(charmander.getVidaMaxima() - 14, charmander.getVida(), 0.0001D);
	}

	@Test
	public void test06BulbasaurYChanseyAtacanALosOtrosAlgomonesConLatigoCepa() {

		AlgoMon bulbasaur = AlgoMonBuilder.crearBulbasaur();
		AlgoMon jigglypuff = AlgoMonBuilder.crearJigglypuff();
		AlgoMon chansey = AlgoMonBuilder.crearChansey();
		AlgoMon otroChansey = AlgoMonBuilder.crearChansey();
		AlgoMon rattata = AlgoMonBuilder.crearRattata();

		bulbasaur.ataque("Látigo cepa", jigglypuff);
		assertEquals(jigglypuff.getVidaMaxima() - 15, jigglypuff.getVida(), 0.0001D);

		bulbasaur.ataque("Látigo cepa", otroChansey);
		assertEquals(otroChansey.getVidaMaxima() - 15, otroChansey.getVida(), 0.0001D);

		bulbasaur.ataque("Látigo cepa", rattata);
		assertEquals(rattata.getVidaMaxima() - 15, rattata.getVida(), 0.0001D);

		chansey.ataque("Látigo cepa", jigglypuff);
		assertEquals(jigglypuff.getVidaMaxima() - 30, jigglypuff.getVida(), 0.0001D);

		chansey.ataque("Látigo cepa", otroChansey);
		assertEquals(otroChansey.getVidaMaxima() - 30, otroChansey.getVida(), 0.0001D);

		chansey.ataque("Látigo cepa", rattata);
		assertEquals(rattata.getVidaMaxima() - 30, rattata.getVida(), 0.0001D);

	}

	@Test
	public void test07CharmanderAtacaABulbasaurConBrasas() {

		AlgoMon charmander = AlgoMonBuilder.crearCharmander();
		AlgoMon bulbasaur = AlgoMonBuilder.crearBulbasaur();

		charmander.ataque("Brasas", bulbasaur);
		assertEquals(bulbasaur.getVidaMaxima() - 32, bulbasaur.getVida(), 0.0001D);

	}

	@Test
	public void test08CharmanderAtacaASquirtleConBrasas() {

		AlgoMon charmander = AlgoMonBuilder.crearCharmander();
		AlgoMon squirtle = AlgoMonBuilder.crearSquirtle();

		charmander.ataque("Brasas", squirtle);
		assertEquals(squirtle.getVidaMaxima() - 8, squirtle.getVida(), 0.0001D);

	}

	@Test
	public void test09CharmanderAtacaALosOtrosAlgomonesConBrasas() {

		AlgoMon charmander = AlgoMonBuilder.crearCharmander();
		AlgoMon jigglypuff = AlgoMonBuilder.crearJigglypuff();
		AlgoMon chansey = AlgoMonBuilder.crearChansey();
		AlgoMon rattata = AlgoMonBuilder.crearRattata();

		charmander.ataque("Brasas", jigglypuff);
		assertEquals(jigglypuff.getVidaMaxima() - 16, jigglypuff.getVida(), 0.0001D);

		charmander.ataque("Brasas", chansey);
		assertEquals(chansey.getVidaMaxima() - 16, chansey.getVida(), 0.0001D);

		charmander.ataque("Brasas", rattata);
		assertEquals(rattata.getVidaMaxima() - 16, rattata.getVida(), 0.0001D);

	}

	@Test
	public void test10AlgomonesAtacanConAtaqueRapido() {

		AlgoMon charmander = AlgoMonBuilder.crearCharmander();
		AlgoMon squirtle = AlgoMonBuilder.crearSquirtle();
		AlgoMon bulbasaur = AlgoMonBuilder.crearBulbasaur();
		AlgoMon jigglypuff = AlgoMonBuilder.crearJigglypuff();
		AlgoMon chansey = AlgoMonBuilder.crearChansey();
		AlgoMon rattata = AlgoMonBuilder.crearRattata();

		charmander.ataque("Ataque rápido", squirtle);
		assertEquals(squirtle.getVidaMaxima() - 10, squirtle.getVida(), 0.0001D);

		charmander.ataque("Ataque rápido", bulbasaur);
		assertEquals(bulbasaur.getVidaMaxima() - 10, bulbasaur.getVida(), 0.0001D);

		charmander.ataque("Ataque rápido", jigglypuff);
		assertEquals(jigglypuff.getVidaMaxima() - 10, jigglypuff.getVida(), 0.0001D);

		charmander.ataque("Ataque rápido", chansey);
		assertEquals(chansey.getVidaMaxima() - 10, chansey.getVida(), 0.0001D);

		charmander.ataque("Ataque rápido", rattata);
		assertEquals(rattata.getVidaMaxima() - 10, rattata.getVida(), 0.0001D);

		squirtle.ataque("Ataque rápido", charmander);
		assertEquals(charmander.getVidaMaxima() - 10, charmander.getVida(), 0.0001D);

		squirtle.ataque("Ataque rápido", bulbasaur);
		assertEquals(bulbasaur.getVidaMaxima() - 20, bulbasaur.getVida(), 0.0001D);

		squirtle.ataque("Ataque rápido", jigglypuff);
		assertEquals(jigglypuff.getVidaMaxima() - 20, jigglypuff.getVida(), 0.0001D);

		squirtle.ataque("Ataque rápido", chansey);
		assertEquals(chansey.getVidaMaxima() - 20, chansey.getVida(), 0.0001D);

		squirtle.ataque("Ataque rápido", rattata);
		assertEquals(rattata.getVidaMaxima() - 20, rattata.getVida(), 0.0001D);

		bulbasaur.ataque("Ataque rápido", charmander);
		assertEquals(charmander.getVidaMaxima() - 20, charmander.getVida(), 0.0001D);

		bulbasaur.ataque("Ataque rápido", squirtle);
		assertEquals(squirtle.getVidaMaxima() - 20, squirtle.getVida(), 0.0001D);

		bulbasaur.ataque("Ataque rápido", jigglypuff);
		assertEquals(jigglypuff.getVidaMaxima() - 30, jigglypuff.getVida(), 0.0001D);

		bulbasaur.ataque("Ataque rápido", chansey);
		assertEquals(chansey.getVidaMaxima() - 30, chansey.getVida(), 0.0001D);

		bulbasaur.ataque("Ataque rápido", rattata);
		assertEquals(rattata.getVidaMaxima() - 30, rattata.getVida(), 0.0001D);

		jigglypuff.ataque("Ataque rápido", charmander);
		assertEquals(charmander.getVidaMaxima() - 30, charmander.getVida(), 0.0001D);

		jigglypuff.ataque("Ataque rápido", squirtle);
		assertEquals(squirtle.getVidaMaxima() - 30, squirtle.getVida(), 0.0001D);

		jigglypuff.ataque("Ataque rápido", bulbasaur);
		assertEquals(bulbasaur.getVidaMaxima() - 30, bulbasaur.getVida(), 0.0001D);

		jigglypuff.ataque("Ataque rápido", chansey);
		assertEquals(chansey.getVidaMaxima() - 40, chansey.getVida(), 0.0001D);

		jigglypuff.ataque("Ataque rápido", rattata);
		assertEquals(rattata.getVidaMaxima() - 40, rattata.getVida(), 0.0001D);

		chansey.ataque("Ataque rápido", charmander);
		assertEquals(charmander.getVidaMaxima() - 40, charmander.getVida(), 0.0001D);

		chansey.ataque("Ataque rápido", squirtle);
		assertEquals(squirtle.getVidaMaxima() - 40, squirtle.getVida(), 0.0001D);

		chansey.ataque("Ataque rápido", bulbasaur);
		assertEquals(bulbasaur.getVidaMaxima() - 40, bulbasaur.getVida(), 0.0001D);

		chansey.ataque("Ataque rápido", jigglypuff);
		assertEquals(jigglypuff.getVidaMaxima() - 40, jigglypuff.getVida(), 0.0001D);

		chansey.ataque("Ataque rápido", rattata);
		assertEquals(rattata.getVidaMaxima() - 50, rattata.getVida(), 0.0001D);

		rattata.ataque("Ataque rápido", charmander);
		assertEquals(charmander.getVidaMaxima() - 50, charmander.getVida(), 0.0001D);

		rattata.ataque("Ataque rápido", squirtle);
		assertEquals(squirtle.getVidaMaxima() - 50, squirtle.getVida(), 0.0001D);

		rattata.ataque("Ataque rápido", bulbasaur);
		assertEquals(bulbasaur.getVidaMaxima() - 50, bulbasaur.getVida(), 0.0001D);

		rattata.ataque("Ataque rápido", jigglypuff);
		assertEquals(jigglypuff.getVidaMaxima() - 50, jigglypuff.getVida(), 0.0001D);

		rattata.ataque("Ataque rápido", chansey);
		assertEquals(chansey.getVidaMaxima() - 50, chansey.getVida(), 0.0001D);

	}

	@Test(expected = AtaqueAgotado.class)
	public void test11AlgomonesAgotanCantidadDisponibleDeAtaques() {

		AlgoMon charmander = AlgoMonBuilder.crearCharmander();
		AlgoMon rattata = AlgoMonBuilder.crearRattata();

		charmander.ataque("Fogonazo", rattata);
		charmander.ataque("Fogonazo", rattata);
		charmander.ataque("Fogonazo", rattata);
		charmander.ataque("Fogonazo", rattata);
		charmander.ataque("Fogonazo", rattata);

	}

}
