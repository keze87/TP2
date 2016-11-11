package test.fiuba.algo3.modelo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import org.junit.Test;

import src.fiuba.algo3.modelo.AlgoMon;
import src.fiuba.algo3.modelo.AlgoMonBuilder;


public class Test2daEntrega {

	@Test
	public void test01JigglypuffYChanseyAtacanConCantoYElAlgoMonAtacadoNoPuedeAtacarPor3Turnos() {
		AlgoMon jigglypuff = AlgoMonBuilder.crearJigglypuff();
		AlgoMon chansey = AlgoMonBuilder.crearChansey();
		AlgoMon charmander = AlgoMonBuilder.crearCharmander();
		AlgoMon squirtle = AlgoMonBuilder.crearSquirtle();

		jigglypuff.atacar("Canto", charmander);

		charmander.atacar("Brasas", jigglypuff);
		assertEquals(jigglypuff.getVidaMaxima(), jigglypuff.getVida(), 0.0001D);

		charmander.atacar("Fogonazo", jigglypuff);
		assertEquals(jigglypuff.getVidaMaxima(), jigglypuff.getVida(), 0.0001D);

		charmander.atacar("Ataque rápido", jigglypuff);
		assertEquals(jigglypuff.getVidaMaxima(), jigglypuff.getVida(), 0.0001D);

		charmander.atacar("Brasas", jigglypuff);
		assertEquals(jigglypuff.getVidaMaxima() - 16, jigglypuff.getVida(), 0.0001D);

		chansey.atacar("Canto", squirtle);

		squirtle.atacar("Burbuja", chansey);
		assertEquals(chansey.getVidaMaxima(), chansey.getVida(), 0.0001);

		squirtle.atacar("Cañón de agua", chansey);
		assertEquals(chansey.getVidaMaxima(), chansey.getVida(), 0.0001);

		squirtle.atacar("Ataque rápido", chansey);
		assertEquals(chansey.getVidaMaxima(), chansey.getVida(), 0.0001);

		squirtle.atacar("Burbuja", chansey);
		assertEquals(chansey.getVidaMaxima() - 10, chansey.getVida(), 0.0001);

	}

	@Test
	public void test02BulbasaurAtacaConChupavidasACharmanderQuitandole7PuntosYGanando2Puntos() {
		AlgoMon bulbasaur = AlgoMonBuilder.crearBulbasaur();
		AlgoMon charmander = AlgoMonBuilder.crearCharmander();

		charmander.atacar("Brasas", bulbasaur);
		assertEquals(bulbasaur.getVidaMaxima() - 32, bulbasaur.getVida(), 0.0001D);

		bulbasaur.atacar("Chupavidas", charmander);
		assertEquals(charmander.getVidaMaxima() - 7, charmander.getVida(), 0.0001D);
		assertEquals(bulbasaur.getVida(), (bulbasaur.getVidaMaxima() - 32) + 2, 0.0001D);
	}

	@Test
	public void test03BulbasaurAtacaConChupavidasASquirtleQuitandole30PuntosGanando9Puntos(){
		AlgoMon bulbasaur = AlgoMonBuilder.crearBulbasaur();
		AlgoMon squirtle = AlgoMonBuilder.crearSquirtle();

		squirtle.atacar("Burbuja", bulbasaur);
		assertEquals(bulbasaur.getVidaMaxima() - 5, bulbasaur.getVida(), 0.0001D);

		squirtle.atacar("Cañón de agua", bulbasaur);
		assertEquals(bulbasaur.getVidaMaxima() - 15, bulbasaur.getVida(), 0.0001D);

		bulbasaur.atacar("Chupavidas", squirtle);
		assertEquals(squirtle.getVidaMaxima() - 30, squirtle.getVida(), 0.0001D);
		assertEquals(bulbasaur.getVida(), (bulbasaur.getVidaMaxima() - 15) + 9, 0.0001D);
	}

	@Test
	public void test04BulbasaurAtacaConChupavidasAOtrosAlgomonesQuitando15PuntosGanando4Puntos(){
		AlgoMon bulbasaur = AlgoMonBuilder.crearBulbasaur();
		AlgoMon ratata = AlgoMonBuilder.crearRattata();
		AlgoMon jigglypuff = AlgoMonBuilder.crearJigglypuff();
		AlgoMon chansey = AlgoMonBuilder.crearChansey();

		ratata.atacar("Ataque rápido", bulbasaur);
		assertEquals(bulbasaur.getVida(), bulbasaur.getVidaMaxima() - 10, 0.0001D);

		chansey.atacar("Ataque rápido", bulbasaur);
		assertEquals(bulbasaur.getVida(), bulbasaur.getVidaMaxima() - 20, 0.0001D);

		jigglypuff.atacar("Ataque rápido", bulbasaur);
		assertEquals(bulbasaur.getVida(), bulbasaur.getVidaMaxima() - 30, 0.0001D);

		bulbasaur.atacar("Chupavidas", ratata);
		assertEquals(ratata.getVida(), ratata.getVidaMaxima() - 15, 0.0001D);
		assertEquals(bulbasaur.getVida(), (bulbasaur.getVidaMaxima() - 30) + 4, 0.0001D);

		bulbasaur.atacar("Chupavidas", chansey);
		assertEquals(chansey.getVida() ,chansey.getVidaMaxima() - 15, 0.0001D);
		assertEquals(bulbasaur.getVida() , (bulbasaur.getVidaMaxima() - 30) + 8, 0.0001D);

		bulbasaur.atacar("Chupavidas", jigglypuff);
		assertEquals(jigglypuff.getVida() ,jigglypuff.getVidaMaxima() - 15, 0.0001D);
		assertEquals(bulbasaur.getVida(), (bulbasaur.getVidaMaxima() - 30) + 12, 0.0001D);
	}

	@Test
	public void test05AlgoMonQuemadoPierde10PorcientoDeSuVidaMaximaPorTurno() {
		AlgoMon charmander = AlgoMonBuilder.crearCharmander();
		AlgoMon rattata = AlgoMonBuilder.crearRattata();
		AlgoMon bulbasaur = AlgoMonBuilder.crearBulbasaur();
		AlgoMon squirtle = AlgoMonBuilder.crearSquirtle();

		charmander.atacar("Fogonazo", bulbasaur);
		assertEquals(bulbasaur.getVidaMaxima() - 4, bulbasaur.getVida(), 0.0001D);

		bulbasaur.atacar("Ataque rápido", charmander);
		assertEquals(bulbasaur.getVidaMaxima() - 18, bulbasaur.getVida(), 0.0001D);

		bulbasaur.atacar("Ataque rápido", charmander);
		assertEquals(bulbasaur.getVidaMaxima() - 32, bulbasaur.getVida(), 0.0001D);

		bulbasaur.atacar("Ataque rápido", charmander);
		assertEquals(bulbasaur.getVidaMaxima() - 46, bulbasaur.getVida(), 0.0001D);

		bulbasaur.atacar("Ataque rápido", charmander);
		assertEquals(bulbasaur.getVidaMaxima() - 60, bulbasaur.getVida(), 0.0001D);

		bulbasaur.atacar("Ataque rápido", charmander);
		assertEquals(bulbasaur.getVidaMaxima() - 74, bulbasaur.getVida(), 0.0001D);

		bulbasaur.atacar("Ataque rápido", charmander);
		assertEquals(bulbasaur.getVidaMaxima() - 88, bulbasaur.getVida(), 0.0001D);

		bulbasaur.atacar("Ataque rápido", charmander);
		assertEquals(bulbasaur.getVidaMaxima() - 102, bulbasaur.getVida(), 0.0001D);

		bulbasaur.atacar("Ataque rápido", charmander);
		assertEquals(bulbasaur.getVidaMaxima() - 116, bulbasaur.getVida(), 0.0001D);

		bulbasaur.atacar("Ataque rápido", charmander);
		assertEquals(bulbasaur.getVidaMaxima() - 130, bulbasaur.getVida(), 0.0001D);

		bulbasaur.atacar("Ataque rápido", charmander);
		assertEquals(bulbasaur.getVidaMaxima() - 140, bulbasaur.getVida(), 0.0001D);

		assertFalse(bulbasaur.estaVivo());


		rattata.atacar("Fogonazo", squirtle);
		assertEquals(squirtle.getVidaMaxima() - 1, squirtle.getVida(), 0.0001D);

		squirtle.atacar("Burbuja", rattata);
		assertEquals(squirtle.getVidaMaxima() - 16, squirtle.getVida(), 0.0001D);

		squirtle.atacar("Burbuja", rattata);
		assertEquals(squirtle.getVidaMaxima() - 31, squirtle.getVida(), 0.0001D);

		squirtle.atacar("Burbuja", rattata);
		assertEquals(squirtle.getVidaMaxima() - 46, squirtle.getVida(), 0.0001D);

		squirtle.atacar("Burbuja", rattata);
		assertEquals(squirtle.getVidaMaxima() - 61, squirtle.getVida(), 0.0001D);

		squirtle.atacar("Burbuja", rattata);
		assertEquals(squirtle.getVidaMaxima() - 76, squirtle.getVida(), 0.0001D);

		squirtle.atacar("Burbuja", rattata);
		assertEquals(squirtle.getVidaMaxima() - 91, squirtle.getVida(), 0.0001D);

		squirtle.atacar("Burbuja", rattata);
		assertEquals(squirtle.getVidaMaxima() - 106, squirtle.getVida(), 0.0001D);

		squirtle.atacar("Burbuja", rattata);
		assertEquals(squirtle.getVidaMaxima() - 121, squirtle.getVida(), 0.0001D);

		squirtle.atacar("Burbuja", rattata);
		assertEquals(squirtle.getVidaMaxima() - 136, squirtle.getVida(), 0.0001D);

		squirtle.atacar("Burbuja", rattata);
		assertEquals(squirtle.getVidaMaxima() - 150, squirtle.getVida(), 0.0001D);

		assertFalse(squirtle.estaVivo());
	}

}
