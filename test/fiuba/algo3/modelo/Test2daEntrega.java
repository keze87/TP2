package test.fiuba.algo3.modelo;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import src.fiuba.algo3.modelo.AlgoMon;
import src.fiuba.algo3.modelo.AlgoMonBuilder;


public class Test2daEntrega {

	@Test
	public void test02BulbasaurAtacaConChupavidasACharmanderQuitandole7PuntosYGanando2Puntos() {
		AlgoMon bulbasaur = AlgoMonBuilder.crearBulbasaur();
		AlgoMon charmander = AlgoMonBuilder.crearCharmander();

		charmander.ataque("Brasas", bulbasaur);

		assertEquals(bulbasaur.getVidaMaxima() - 32 , bulbasaur.getVida(), 0.0001D);

		bulbasaur.ataque("Chupavidas", charmander);

		assertEquals(charmander.getVidaMaxima() - 7, charmander.getVida(), 0.0001D);

		assertEquals(bulbasaur.getVida() , (bulbasaur.getVidaMaxima() - 32) + 2, 0.0001D);

	}



	@Test
	public void test03BulbasaurAtacaConChupavidasASquirtleQuitandole30PuntosGanando9Puntos(){
		AlgoMon bulbasaur = AlgoMonBuilder.crearBulbasaur();
		AlgoMon squirtle = AlgoMonBuilder.crearSquirtle();

		squirtle.ataque("Burbuja", bulbasaur);

		assertEquals(bulbasaur.getVidaMaxima() - 5 , bulbasaur.getVida(), 0.0001D);

		squirtle.ataque("Cañón de agua", bulbasaur);

		assertEquals(bulbasaur.getVidaMaxima() - 15 , bulbasaur.getVida(), 0.0001D);

		bulbasaur.ataque("Chupavidas", squirtle);

		assertEquals(squirtle.getVidaMaxima() - 30, squirtle.getVida(), 0.0001D);

		assertEquals(bulbasaur.getVida() , (bulbasaur.getVidaMaxima() - 15) + 9, 0.0001D);
	}


	@Test
	public void test04BulbasaurAtacaConChupavidasAOtrosAlgomonesQuitando15PuntosGanando4Puntos(){
		AlgoMon bulbasaur = AlgoMonBuilder.crearBulbasaur();
		AlgoMon ratata = AlgoMonBuilder.crearRattata();
		AlgoMon jigglypuff = AlgoMonBuilder.crearJigglypuff();
		AlgoMon chansey = AlgoMonBuilder.crearChansey();

		ratata.ataque("Ataque rápido", bulbasaur);

		assertEquals(bulbasaur.getVida() ,bulbasaur.getVidaMaxima() - 10, 0.0001D);

		chansey.ataque("Ataque rápido", bulbasaur);

		assertEquals(bulbasaur.getVida() ,bulbasaur.getVidaMaxima() - 20, 0.0001D);

		jigglypuff.ataque("Ataque rápido", bulbasaur);

		assertEquals(bulbasaur.getVida() ,bulbasaur.getVidaMaxima() - 30, 0.0001D);

		bulbasaur.ataque("Chupavidas", ratata);

		assertEquals(ratata.getVida() ,ratata.getVidaMaxima() - 15, 0.0001D);

		assertEquals(bulbasaur.getVida() , (bulbasaur.getVidaMaxima() - 30) + 4, 0.0001D);

		bulbasaur.ataque("Chupavidas", chansey);

		assertEquals(chansey.getVida() ,chansey.getVidaMaxima() - 15, 0.0001D);

		assertEquals(bulbasaur.getVida() , (bulbasaur.getVidaMaxima() - 30) + 8, 0.0001D);

		bulbasaur.ataque("Chupavidas", jigglypuff);

		assertEquals(jigglypuff.getVida() ,jigglypuff.getVidaMaxima() - 15, 0.0001D);

		assertEquals(bulbasaur.getVida(), (bulbasaur.getVidaMaxima() - 30) + 12, 0.0001D);
	}



}
