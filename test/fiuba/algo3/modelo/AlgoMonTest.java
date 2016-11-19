package test.fiuba.algo3.modelo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import src.fiuba.algo3.modelo.AlgoMon;
import src.fiuba.algo3.modelo.AlgoMonBuilder;
import src.fiuba.algo3.modelo.ataques.NombreAtaque;
import src.fiuba.algo3.modelo.excepciones.AlgoMonActivoMurio;
import src.fiuba.algo3.modelo.excepciones.AtaqueAgotado;

public class AlgoMonTest {

	@Test
	public void test01SquirtleAtacaACharmanderConBurbujaYCanionDeAgua() {

		AlgoMon charmander = AlgoMonBuilder.crearCharmander();
		AlgoMon squirtle = AlgoMonBuilder.crearSquirtle();

		assertEquals(charmander.getVidaMaxima(), charmander.getVida(), 0.0001D);

		squirtle.atacar(NombreAtaque.BURBUJA, charmander);
		assertEquals(charmander.getVidaMaxima() - 20, charmander.getVida(), 0.0001D);

		squirtle.atacar(NombreAtaque.CAÑONDEAGUA, charmander);
		assertEquals(charmander.getVidaMaxima() - 60, charmander.getVida(), 0.0001D);

	}

	@Test
	public void test02SquirtleAtacaABulbasaurConBurbujaYCanionDeAgua() {

		AlgoMon bulbasaur = AlgoMonBuilder.crearBulbasaur();
		AlgoMon squirtle = AlgoMonBuilder.crearSquirtle();

		assertEquals(bulbasaur.getVidaMaxima(), bulbasaur.getVida(), 0.0001D);

		squirtle.atacar(NombreAtaque.BURBUJA, bulbasaur);
		assertEquals(bulbasaur.getVidaMaxima() - 5, bulbasaur.getVida(), 0.0001D);

		squirtle.atacar(NombreAtaque.CAÑONDEAGUA, bulbasaur);
		assertEquals(bulbasaur.getVidaMaxima() - 15, bulbasaur.getVida(), 0.0001D);

	}

	@Test
	public void test03SquirtleAtacaALosOtrosAlgoMonesConBurbujaYCanionDeAgua() {

		AlgoMon squirtle = AlgoMonBuilder.crearSquirtle();
		AlgoMon jigglypuff = AlgoMonBuilder.crearJigglypuff();
		AlgoMon chansey = AlgoMonBuilder.crearChansey();
		AlgoMon rattata = AlgoMonBuilder.crearRattata();

		squirtle.atacar(NombreAtaque.BURBUJA, jigglypuff);
		assertEquals(jigglypuff.getVidaMaxima() - 10, jigglypuff.getVida(), 0.0001D);

		squirtle.atacar(NombreAtaque.BURBUJA, chansey);
		assertEquals(chansey.getVidaMaxima() - 10, chansey.getVida(), 0.0001D);

		squirtle.atacar(NombreAtaque.BURBUJA, rattata);
		assertEquals(rattata.getVidaMaxima() - 10, rattata.getVida(), 0.0001D);

		squirtle.atacar(NombreAtaque.CAÑONDEAGUA, jigglypuff);
		assertEquals(jigglypuff.getVidaMaxima() - 30, jigglypuff.getVida(), 0.0001D);

		squirtle.atacar(NombreAtaque.CAÑONDEAGUA, chansey);
		assertEquals(chansey.getVidaMaxima() - 30, chansey.getVida(), 0.0001D);

		squirtle.atacar(NombreAtaque.CAÑONDEAGUA, rattata);
		assertEquals(rattata.getVidaMaxima() - 30, rattata.getVida(), 0.0001D);

	}

	@Test
	public void test04BulbasaurYChanseyAtacanASquirtleConLatigoCepa() {

		AlgoMon bulbasaur = AlgoMonBuilder.crearBulbasaur();
		AlgoMon chansey = AlgoMonBuilder.crearChansey();
		AlgoMon squirtle = AlgoMonBuilder.crearSquirtle();

		bulbasaur.atacar(NombreAtaque.LATIGOCEPA, squirtle);
		assertEquals(squirtle.getVidaMaxima() - 30, squirtle.getVida(), 0.0001D);

		chansey.atacar(NombreAtaque.LATIGOCEPA, squirtle);
		assertEquals(squirtle.getVidaMaxima() - 60, squirtle.getVida(), 0.0001D);

	}

	@Test
	public void test05BulbasaurYChanseyAtacanACharmanderConLatigoCepa() {

		AlgoMon bulbasaur = AlgoMonBuilder.crearBulbasaur();
		AlgoMon chansey = AlgoMonBuilder.crearChansey();
		AlgoMon charmander = AlgoMonBuilder.crearCharmander();

		bulbasaur.atacar(NombreAtaque.LATIGOCEPA, charmander);
		assertEquals(charmander.getVidaMaxima() - 7, charmander.getVida(), 0.0001D);

		chansey.atacar(NombreAtaque.LATIGOCEPA, charmander);
		assertEquals(charmander.getVidaMaxima() - 14, charmander.getVida(), 0.0001D);
	}

	@Test
	public void test06BulbasaurYChanseyAtacanALosOtrosAlgomonesConLatigoCepa() {

		AlgoMon bulbasaur = AlgoMonBuilder.crearBulbasaur();
		AlgoMon jigglypuff = AlgoMonBuilder.crearJigglypuff();
		AlgoMon chansey = AlgoMonBuilder.crearChansey();
		AlgoMon otroChansey = AlgoMonBuilder.crearChansey();
		AlgoMon rattata = AlgoMonBuilder.crearRattata();

		bulbasaur.atacar(NombreAtaque.LATIGOCEPA, jigglypuff);
		assertEquals(jigglypuff.getVidaMaxima() - 15, jigglypuff.getVida(), 0.0001D);

		bulbasaur.atacar(NombreAtaque.LATIGOCEPA, otroChansey);
		assertEquals(otroChansey.getVidaMaxima() - 15, otroChansey.getVida(), 0.0001D);

		bulbasaur.atacar(NombreAtaque.LATIGOCEPA, rattata);
		assertEquals(rattata.getVidaMaxima() - 15, rattata.getVida(), 0.0001D);

		chansey.atacar(NombreAtaque.LATIGOCEPA, jigglypuff);
		assertEquals(jigglypuff.getVidaMaxima() - 30, jigglypuff.getVida(), 0.0001D);

		chansey.atacar(NombreAtaque.LATIGOCEPA, otroChansey);
		assertEquals(otroChansey.getVidaMaxima() - 30, otroChansey.getVida(), 0.0001D);

		chansey.atacar(NombreAtaque.LATIGOCEPA, rattata);
		assertEquals(rattata.getVidaMaxima() - 30, rattata.getVida(), 0.0001D);

	}

	@Test
	public void test07CharmanderAtacaABulbasaurConBrasas() {

		AlgoMon charmander = AlgoMonBuilder.crearCharmander();
		AlgoMon bulbasaur = AlgoMonBuilder.crearBulbasaur();

		charmander.atacar(NombreAtaque.BRASAS, bulbasaur);
		assertEquals(bulbasaur.getVidaMaxima() - 32, bulbasaur.getVida(), 0.0001D);

	}

	@Test
	public void test08CharmanderAtacaASquirtleConBrasas() {

		AlgoMon charmander = AlgoMonBuilder.crearCharmander();
		AlgoMon squirtle = AlgoMonBuilder.crearSquirtle();

		charmander.atacar(NombreAtaque.BRASAS, squirtle);
		assertEquals(squirtle.getVidaMaxima() - 8, squirtle.getVida(), 0.0001D);

	}

	@Test
	public void test09CharmanderAtacaALosOtrosAlgomonesConBrasas() {

		AlgoMon charmander = AlgoMonBuilder.crearCharmander();
		AlgoMon jigglypuff = AlgoMonBuilder.crearJigglypuff();
		AlgoMon chansey = AlgoMonBuilder.crearChansey();
		AlgoMon rattata = AlgoMonBuilder.crearRattata();

		charmander.atacar(NombreAtaque.BRASAS, jigglypuff);
		assertEquals(jigglypuff.getVidaMaxima() - 16, jigglypuff.getVida(), 0.0001D);

		charmander.atacar(NombreAtaque.BRASAS, chansey);
		assertEquals(chansey.getVidaMaxima() - 16, chansey.getVida(), 0.0001D);

		charmander.atacar(NombreAtaque.BRASAS, rattata);
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

		charmander.atacar(NombreAtaque.ATAQUERAPIDO, squirtle);
		assertEquals(squirtle.getVidaMaxima() - 10, squirtle.getVida(), 0.0001D);

		charmander.atacar(NombreAtaque.ATAQUERAPIDO, bulbasaur);
		assertEquals(bulbasaur.getVidaMaxima() - 10, bulbasaur.getVida(), 0.0001D);

		charmander.atacar(NombreAtaque.ATAQUERAPIDO, jigglypuff);
		assertEquals(jigglypuff.getVidaMaxima() - 10, jigglypuff.getVida(), 0.0001D);

		charmander.atacar(NombreAtaque.ATAQUERAPIDO, chansey);
		assertEquals(chansey.getVidaMaxima() - 10, chansey.getVida(), 0.0001D);

		charmander.atacar(NombreAtaque.ATAQUERAPIDO, rattata);
		assertEquals(rattata.getVidaMaxima() - 10, rattata.getVida(), 0.0001D);

		squirtle.atacar(NombreAtaque.ATAQUERAPIDO, charmander);
		assertEquals(charmander.getVidaMaxima() - 10, charmander.getVida(), 0.0001D);

		squirtle.atacar(NombreAtaque.ATAQUERAPIDO, bulbasaur);
		assertEquals(bulbasaur.getVidaMaxima() - 20, bulbasaur.getVida(), 0.0001D);

		squirtle.atacar(NombreAtaque.ATAQUERAPIDO, jigglypuff);
		assertEquals(jigglypuff.getVidaMaxima() - 20, jigglypuff.getVida(), 0.0001D);

		squirtle.atacar(NombreAtaque.ATAQUERAPIDO, chansey);
		assertEquals(chansey.getVidaMaxima() - 20, chansey.getVida(), 0.0001D);

		squirtle.atacar(NombreAtaque.ATAQUERAPIDO, rattata);
		assertEquals(rattata.getVidaMaxima() - 20, rattata.getVida(), 0.0001D);

		bulbasaur.atacar(NombreAtaque.ATAQUERAPIDO, charmander);
		assertEquals(charmander.getVidaMaxima() - 20, charmander.getVida(), 0.0001D);

		bulbasaur.atacar(NombreAtaque.ATAQUERAPIDO, squirtle);
		assertEquals(squirtle.getVidaMaxima() - 20, squirtle.getVida(), 0.0001D);

		bulbasaur.atacar(NombreAtaque.ATAQUERAPIDO, jigglypuff);
		assertEquals(jigglypuff.getVidaMaxima() - 30, jigglypuff.getVida(), 0.0001D);

		bulbasaur.atacar(NombreAtaque.ATAQUERAPIDO, chansey);
		assertEquals(chansey.getVidaMaxima() - 30, chansey.getVida(), 0.0001D);

		bulbasaur.atacar(NombreAtaque.ATAQUERAPIDO, rattata);
		assertEquals(rattata.getVidaMaxima() - 30, rattata.getVida(), 0.0001D);

		jigglypuff.atacar(NombreAtaque.ATAQUERAPIDO, charmander);
		assertEquals(charmander.getVidaMaxima() - 30, charmander.getVida(), 0.0001D);

		jigglypuff.atacar(NombreAtaque.ATAQUERAPIDO, squirtle);
		assertEquals(squirtle.getVidaMaxima() - 30, squirtle.getVida(), 0.0001D);

		jigglypuff.atacar(NombreAtaque.ATAQUERAPIDO, bulbasaur);
		assertEquals(bulbasaur.getVidaMaxima() - 30, bulbasaur.getVida(), 0.0001D);

		jigglypuff.atacar(NombreAtaque.ATAQUERAPIDO, chansey);
		assertEquals(chansey.getVidaMaxima() - 40, chansey.getVida(), 0.0001D);

		jigglypuff.atacar(NombreAtaque.ATAQUERAPIDO, rattata);
		assertEquals(rattata.getVidaMaxima() - 40, rattata.getVida(), 0.0001D);

		chansey.atacar(NombreAtaque.ATAQUERAPIDO, charmander);
		assertEquals(charmander.getVidaMaxima() - 40, charmander.getVida(), 0.0001D);

		chansey.atacar(NombreAtaque.ATAQUERAPIDO, squirtle);
		assertEquals(squirtle.getVidaMaxima() - 40, squirtle.getVida(), 0.0001D);

		chansey.atacar(NombreAtaque.ATAQUERAPIDO, bulbasaur);
		assertEquals(bulbasaur.getVidaMaxima() - 40, bulbasaur.getVida(), 0.0001D);

		chansey.atacar(NombreAtaque.ATAQUERAPIDO, jigglypuff);
		assertEquals(jigglypuff.getVidaMaxima() - 40, jigglypuff.getVida(), 0.0001D);

		chansey.atacar(NombreAtaque.ATAQUERAPIDO, rattata);
		assertEquals(rattata.getVidaMaxima() - 50, rattata.getVida(), 0.0001D);

		rattata.atacar(NombreAtaque.ATAQUERAPIDO, charmander);
		assertEquals(charmander.getVidaMaxima() - 50, charmander.getVida(), 0.0001D);

		rattata.atacar(NombreAtaque.ATAQUERAPIDO, squirtle);
		assertEquals(squirtle.getVidaMaxima() - 50, squirtle.getVida(), 0.0001D);

		rattata.atacar(NombreAtaque.ATAQUERAPIDO, bulbasaur);
		assertEquals(bulbasaur.getVidaMaxima() - 50, bulbasaur.getVida(), 0.0001D);

		rattata.atacar(NombreAtaque.ATAQUERAPIDO, jigglypuff);
		assertEquals(jigglypuff.getVidaMaxima() - 50, jigglypuff.getVida(), 0.0001D);

		rattata.atacar(NombreAtaque.ATAQUERAPIDO, chansey);
		assertEquals(chansey.getVidaMaxima() - 50, chansey.getVida(), 0.0001D);

	}

	@Test(expected = AtaqueAgotado.class)
	public void test11AlgomonesAgotanCantidadDisponibleDeAtaques() {

		AlgoMon charmander = AlgoMonBuilder.crearCharmander();
		AlgoMon rattata = AlgoMonBuilder.crearRattata();

		charmander.atacar(NombreAtaque.FOGONAZO, rattata);
		charmander.atacar(NombreAtaque.FOGONAZO, rattata);
		charmander.atacar(NombreAtaque.FOGONAZO, rattata);
		charmander.atacar(NombreAtaque.FOGONAZO, rattata);
		charmander.atacar(NombreAtaque.FOGONAZO, rattata);

	}

	@Test
	public void test12AlgoMonConVidaMenorOIgualACeroEstaMuerto() {
		AlgoMon charmander = AlgoMonBuilder.crearCharmander();
		AlgoMon bulbasaur = AlgoMonBuilder.crearBulbasaur();

		charmander.atacar(NombreAtaque.BRASAS, bulbasaur);
		assertEquals(bulbasaur.getVidaMaxima() - 32, bulbasaur.getVida(), 0.0001D);
		assertTrue(bulbasaur.estaVivo());

		charmander.atacar(NombreAtaque.BRASAS, bulbasaur);
		assertEquals(bulbasaur.getVidaMaxima() - 64, bulbasaur.getVida(), 0.0001D);
		assertTrue(bulbasaur.estaVivo());

		charmander.atacar(NombreAtaque.BRASAS, bulbasaur);
		assertEquals(bulbasaur.getVidaMaxima() - 96, bulbasaur.getVida(), 0.0001D);
		assertTrue(bulbasaur.estaVivo());

		charmander.atacar(NombreAtaque.BRASAS, bulbasaur);
		assertEquals(bulbasaur.getVidaMaxima() - 128, bulbasaur.getVida(), 0.0001D);
		assertTrue(bulbasaur.estaVivo());

		try{charmander.atacar(NombreAtaque.BRASAS, bulbasaur);}catch(AlgoMonActivoMurio e){}
		assertEquals(bulbasaur.getVidaMaxima() - 140, bulbasaur.getVida(), 0.0001D);
		assertFalse(bulbasaur.estaVivo());
	}

}
