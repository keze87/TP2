package test.fiuba.algo3.modelo;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import src.fiuba.algo3.modelo.AlgoMon;
import src.fiuba.algo3.modelo.AlgoMonBuilder;


public class Test2daEntrega {

	@Test
	public void test02BulbasaurAtacaConChupavidasACharmanderQuitandole7PuntosYGanando9Puntos() {
		AlgoMon bulbasaur = AlgoMonBuilder.crearBulbasaur();
		AlgoMon charmander = AlgoMonBuilder.crearCharmander();

		bulbasaur.ataque("Chupavidas", charmander);

		assertEquals(charmander.getVidaMaxima() - 7, charmander.getVida(), 0.0001D);

		assertEquals(bulbasaur.getVidaMaxima() + 9 , 149, 0.0001D);

	}



	@Test
	public void test03BulbasaurAtacaConChupavidasASquirtleQuitandole30PuntosGanando2Puntos(){
		AlgoMon bulbasaur = AlgoMonBuilder.crearBulbasaur();
		AlgoMon squirtle = AlgoMonBuilder.crearSquirtle();

		bulbasaur.ataque("Chupavidas", squirtle);

		assertEquals(squirtle.getVidaMaxima() - 30, squirtle.getVida(), 0.0001D);

		assertEquals(bulbasaur.getVidaMaxima() + 2 , 142, 0.0001D);
	}


	@Test
	public void test04BulbasaurAtacaConChupavidasAOtrosAlgomonesQuitando15PuntosGanando4Puntos(){
		AlgoMon bulbasaur = AlgoMonBuilder.crearBulbasaur();
		AlgoMon ratata = AlgoMonBuilder.crearRattata();
		AlgoMon jigglypuff = AlgoMonBuilder.crearJigglypuff();
		AlgoMon chansey = AlgoMonBuilder.crearChansey();

		bulbasaur.ataque("Chupavidas", ratata);

		assertEquals(bulbasaur.getVidaMaxima() + 4 , 144, 0.0001D);

		bulbasaur.ataque("Chupavidas", chansey);

		assertEquals(bulbasaur.getVidaMaxima() + 8 , 148, 0.0001D);

		bulbasaur.ataque("Chupavidas", jigglypuff);

		assertEquals(bulbasaur.getVidaMaxima() + 12 , 152, 0.0001D);
	}


	@Test
	public void test05JigglypuffYChanseyAtacanConCantoYElAlgomónAtacadoNoPuedeAtacarPorTresTurnos(){
		//AlgoMon jigglypuff = AlgoMonBuilder.crearJigglypuff();


	}


}
