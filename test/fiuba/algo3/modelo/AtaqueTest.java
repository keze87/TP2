package test.fiuba.algo3.modelo;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import src.fiuba.algo3.modelo.AlgoMon;
import src.fiuba.algo3.modelo.AlgoMonBuilder;
import src.fiuba.algo3.modelo.ataques.Ataque;
import src.fiuba.algo3.modelo.ataques.AtaqueAgotado;
import src.fiuba.algo3.modelo.ataques.AtaqueBuilder;

public class AtaqueTest {

	@Test
	public void test01DanioAtaqueRapido() {
		Ataque ataque = AtaqueBuilder.crearAtaqueRapido();
		AlgoMon charmander = AlgoMonBuilder.crearCharmander();
		AlgoMon squirtle = AlgoMonBuilder.crearSquirtle();
		AlgoMon bulbasaur = AlgoMonBuilder.crearBulbasaur();
		AlgoMon jigglypuff = AlgoMonBuilder.crearJigglypuff();
		AlgoMon chansey = AlgoMonBuilder.crearChansey();
		AlgoMon rattata = AlgoMonBuilder.crearRattata();

		charmander.recibirAtaque(ataque);
		squirtle.recibirAtaque(ataque);
		bulbasaur.recibirAtaque(ataque);
		jigglypuff.recibirAtaque(ataque);
		chansey.recibirAtaque(ataque);
		rattata.recibirAtaque(ataque);

		assertEquals(charmander.getVidaMaxima() - 10, charmander.getVida(), 0.0001D);
		assertEquals(squirtle.getVidaMaxima() - 10, squirtle.getVida(), 0.0001D);
		assertEquals(bulbasaur.getVidaMaxima() - 10, bulbasaur.getVida(), 0.0001D);
		assertEquals(jigglypuff.getVidaMaxima() - 10, jigglypuff.getVida(), 0.0001D);
		assertEquals(chansey.getVidaMaxima() - 10, chansey.getVida(), 0.0001D);
		assertEquals(rattata.getVidaMaxima() - 10, rattata.getVida(), 0.0001D);
	}
	@Test
	public void test01DanioAtaqueRapidoConAtacar() {
		Ataque ataque = AtaqueBuilder.crearAtaqueRapido();
		AlgoMon charmander = AlgoMonBuilder.crearCharmander();
		assertEquals(160, ataque.atacar(charmander).aplicar(charmander.getEstado()).getVida(), 0.0001D);//aca funciona
	}

	@Test
	public void test02DanioCanto() {
		Ataque ataque = AtaqueBuilder.crearCanto();
		AlgoMon charmander = AlgoMonBuilder.crearCharmander();
		AlgoMon squirtle = AlgoMonBuilder.crearSquirtle();
		AlgoMon bulbasaur = AlgoMonBuilder.crearBulbasaur();
		AlgoMon jigglypuff = AlgoMonBuilder.crearJigglypuff();
		AlgoMon chansey = AlgoMonBuilder.crearChansey();
		AlgoMon rattata = AlgoMonBuilder.crearRattata();

		charmander.recibirAtaque(ataque);
		squirtle.recibirAtaque(ataque);
		bulbasaur.recibirAtaque(ataque);
		jigglypuff.recibirAtaque(ataque);
		chansey.recibirAtaque(ataque);
		rattata.recibirAtaque(ataque);

		assertEquals(charmander.getVidaMaxima(), charmander.getVida(), 0.0001D);
		assertEquals(squirtle.getVidaMaxima(), squirtle.getVida(), 0.0001D);
		assertEquals(bulbasaur.getVidaMaxima(), bulbasaur.getVida(), 0.0001D);
		assertEquals(jigglypuff.getVidaMaxima(), jigglypuff.getVida(), 0.0001D);
		assertEquals(chansey.getVidaMaxima(), chansey.getVida(), 0.0001D);
		assertEquals(rattata.getVidaMaxima(), rattata.getVida(), 0.0001D);
	}

	@Test
	public void test03DanioBurbuja() {
		Ataque ataque = AtaqueBuilder.crearBurbuja();
		AlgoMon charmander = AlgoMonBuilder.crearCharmander();
		AlgoMon squirtle = AlgoMonBuilder.crearSquirtle();
		AlgoMon bulbasaur = AlgoMonBuilder.crearBulbasaur();
		AlgoMon jigglypuff = AlgoMonBuilder.crearJigglypuff();
		AlgoMon chansey = AlgoMonBuilder.crearChansey();
		AlgoMon rattata = AlgoMonBuilder.crearRattata();

		charmander.recibirAtaque(ataque);
		squirtle.recibirAtaque(ataque);
		bulbasaur.recibirAtaque(ataque);
		jigglypuff.recibirAtaque(ataque);
		chansey.recibirAtaque(ataque);
		rattata.recibirAtaque(ataque);

		assertEquals(charmander.getVidaMaxima() - 20, charmander.getVida(), 0.0001D);
		assertEquals(squirtle.getVidaMaxima() - 5, squirtle.getVida(), 0.0001D);
		assertEquals(bulbasaur.getVidaMaxima() - 5, bulbasaur.getVida(), 0.0001D);
		assertEquals(jigglypuff.getVidaMaxima() - 10, jigglypuff.getVida(), 0.0001D);
		assertEquals(chansey.getVidaMaxima() - 10, chansey.getVida(), 0.0001D);
		assertEquals(rattata.getVidaMaxima() - 10, rattata.getVida(), 0.0001D);
	}

	@Test
	public void test04DanioCanionDeAgua() {
		Ataque ataque = AtaqueBuilder.crearCanionDeAgua();
		AlgoMon charmander = AlgoMonBuilder.crearCharmander();
		AlgoMon squirtle = AlgoMonBuilder.crearSquirtle();
		AlgoMon bulbasaur = AlgoMonBuilder.crearBulbasaur();
		AlgoMon jigglypuff = AlgoMonBuilder.crearJigglypuff();
		AlgoMon chansey = AlgoMonBuilder.crearChansey();
		AlgoMon rattata = AlgoMonBuilder.crearRattata();

		charmander.recibirAtaque(ataque);
		squirtle.recibirAtaque(ataque);
		bulbasaur.recibirAtaque(ataque);
		jigglypuff.recibirAtaque(ataque);
		chansey.recibirAtaque(ataque);
		rattata.recibirAtaque(ataque);

		assertEquals(charmander.getVidaMaxima() - 40, charmander.getVida(), 0.0001D);
		assertEquals(squirtle.getVidaMaxima() - 10, squirtle.getVida(), 0.0001D);
		assertEquals(bulbasaur.getVidaMaxima() - 10, bulbasaur.getVida(), 0.0001D);
		assertEquals(jigglypuff.getVidaMaxima() - 20, jigglypuff.getVida(), 0.0001D);
		assertEquals(chansey.getVidaMaxima() - 20, chansey.getVida(), 0.0001D);
		assertEquals(rattata.getVidaMaxima() - 20, rattata.getVida(), 0.0001D);
	}

	@Test
	public void test05DanioChupavidas() {
		Ataque ataque = AtaqueBuilder.crearChupavidas();
		AlgoMon charmander = AlgoMonBuilder.crearCharmander();
		AlgoMon squirtle = AlgoMonBuilder.crearSquirtle();
		AlgoMon bulbasaur = AlgoMonBuilder.crearBulbasaur();
		AlgoMon jigglypuff = AlgoMonBuilder.crearJigglypuff();
		AlgoMon chansey = AlgoMonBuilder.crearChansey();
		AlgoMon rattata = AlgoMonBuilder.crearRattata();

		charmander.recibirAtaque(ataque);
		squirtle.recibirAtaque(ataque);
		bulbasaur.recibirAtaque(ataque);
		jigglypuff.recibirAtaque(ataque);
		chansey.recibirAtaque(ataque);
		rattata.recibirAtaque(ataque);

		assertEquals(charmander.getVidaMaxima() - 7, charmander.getVida(), 0.0001D);
		assertEquals(squirtle.getVidaMaxima() - 30, squirtle.getVida(), 0.0001D);
		assertEquals(bulbasaur.getVidaMaxima() - 7, bulbasaur.getVida(), 0.0001D);
		assertEquals(jigglypuff.getVidaMaxima() - 15, jigglypuff.getVida(), 0.0001D);
		assertEquals(chansey.getVidaMaxima() - 15, chansey.getVida(), 0.0001D);
		assertEquals(rattata.getVidaMaxima() - 15, rattata.getVida(), 0.0001D);
	}

	@Test
	public void test06DanioLatigoCepa() {
		Ataque ataque = AtaqueBuilder.crearLatigoCepa();
		AlgoMon charmander = AlgoMonBuilder.crearCharmander();
		AlgoMon squirtle = AlgoMonBuilder.crearSquirtle();
		AlgoMon bulbasaur = AlgoMonBuilder.crearBulbasaur();
		AlgoMon jigglypuff = AlgoMonBuilder.crearJigglypuff();
		AlgoMon chansey = AlgoMonBuilder.crearChansey();
		AlgoMon rattata = AlgoMonBuilder.crearRattata();

		charmander.recibirAtaque(ataque);
		squirtle.recibirAtaque(ataque);
		bulbasaur.recibirAtaque(ataque);
		jigglypuff.recibirAtaque(ataque);
		chansey.recibirAtaque(ataque);
		rattata.recibirAtaque(ataque);

		assertEquals(charmander.getVidaMaxima() - 7, charmander.getVida(), 0.0001D);
		assertEquals(squirtle.getVidaMaxima() - 30, squirtle.getVida(), 0.0001D);
		assertEquals(bulbasaur.getVidaMaxima() - 7, bulbasaur.getVida(), 0.0001D);
		assertEquals(jigglypuff.getVidaMaxima() - 15, jigglypuff.getVida(), 0.0001D);
		assertEquals(chansey.getVidaMaxima() - 15, chansey.getVida(), 0.0001D);
		assertEquals(rattata.getVidaMaxima() - 15, rattata.getVida(), 0.0001D);
	}

	@Test
	public void test07DanioBrasas() {
		Ataque ataque = AtaqueBuilder.crearBrasas();
		AlgoMon charmander = AlgoMonBuilder.crearCharmander();
		AlgoMon squirtle = AlgoMonBuilder.crearSquirtle();
		AlgoMon bulbasaur = AlgoMonBuilder.crearBulbasaur();
		AlgoMon jigglypuff = AlgoMonBuilder.crearJigglypuff();
		AlgoMon chansey = AlgoMonBuilder.crearChansey();
		AlgoMon rattata = AlgoMonBuilder.crearRattata();

		charmander.recibirAtaque(ataque);
		squirtle.recibirAtaque(ataque);
		bulbasaur.recibirAtaque(ataque);
		jigglypuff.recibirAtaque(ataque);
		chansey.recibirAtaque(ataque);
		rattata.recibirAtaque(ataque);

		assertEquals(charmander.getVidaMaxima() - 8, charmander.getVida(), 0.0001D);
		assertEquals(squirtle.getVidaMaxima() - 8, squirtle.getVida(), 0.0001D);
		assertEquals(bulbasaur.getVidaMaxima() - 32, bulbasaur.getVida(), 0.0001D);
		assertEquals(jigglypuff.getVidaMaxima() - 16, jigglypuff.getVida(), 0.0001D);
		assertEquals(chansey.getVidaMaxima() - 16, chansey.getVida(), 0.0001D);
		assertEquals(rattata.getVidaMaxima() - 16, rattata.getVida(), 0.0001D);
	}

	@Test
	public void test08DanioFogonazo() {
		Ataque ataque = AtaqueBuilder.crearFogonazo();
		AlgoMon charmander = AlgoMonBuilder.crearCharmander();
		AlgoMon squirtle = AlgoMonBuilder.crearSquirtle();
		AlgoMon bulbasaur = AlgoMonBuilder.crearBulbasaur();
		AlgoMon jigglypuff = AlgoMonBuilder.crearJigglypuff();
		AlgoMon chansey = AlgoMonBuilder.crearChansey();
		AlgoMon rattata = AlgoMonBuilder.crearRattata();

		charmander.recibirAtaque(ataque);
		squirtle.recibirAtaque(ataque);
		bulbasaur.recibirAtaque(ataque);
		jigglypuff.recibirAtaque(ataque);

		assertEquals(charmander.getVidaMaxima() - 1, charmander.getVida(), 0.0001D);
		assertEquals(squirtle.getVidaMaxima() - 1, squirtle.getVida(), 0.0001D);
		assertEquals(bulbasaur.getVidaMaxima() - 4, bulbasaur.getVida(), 0.0001D);
		assertEquals(jigglypuff.getVidaMaxima() - 2, jigglypuff.getVida(), 0.0001D);

		ataque = AtaqueBuilder.crearFogonazo();
		chansey.recibirAtaque(ataque);
		rattata.recibirAtaque(ataque);

		assertEquals(chansey.getVidaMaxima() - 2, chansey.getVida(), 0.0001D);
		assertEquals(rattata.getVidaMaxima() - 2, rattata.getVida(), 0.0001D);
	}

	@Test
	public void test09UsosAtaqueRapido() {
		Ataque ataque = AtaqueBuilder.crearAtaqueRapido();
		AlgoMon rattata = AlgoMonBuilder.crearRattata();
		int contador = 0;

		try {

			while(true) {
				rattata.recibirAtaque(ataque);
				contador++;
			}

		} catch(AtaqueAgotado e) {
			assertEquals(16, contador);
		}
	}

	@Test
	public void test10UsosCanto() {
		Ataque ataque = AtaqueBuilder.crearCanto();
		AlgoMon rattata = AlgoMonBuilder.crearRattata();
		int contador = 0;

		try {

			while(true) {
				rattata.recibirAtaque(ataque);
				contador++;
			}

		} catch(AtaqueAgotado e) {
			assertEquals(6, contador);
		}
	}

	@Test
	public void test11UsosBurbuja() {
		Ataque ataque = AtaqueBuilder.crearBurbuja();
		AlgoMon rattata = AlgoMonBuilder.crearRattata();
		int contador = 0;

		try {

			while(true) {
				rattata.recibirAtaque(ataque);
				contador++;
			}

		} catch(AtaqueAgotado e) {
			assertEquals(15, contador);
		}
	}

	@Test
	public void test12UsosAtaqueCanionDeAgua() {
		Ataque ataque = AtaqueBuilder.crearCanionDeAgua();
		AlgoMon rattata = AlgoMonBuilder.crearRattata();
		int contador = 0;

		try {

			while(true) {
				rattata.recibirAtaque(ataque);
				contador++;
			}

		} catch(AtaqueAgotado e) {
			assertEquals(8, contador);
		}
	}

	@Test
	public void test13UsosChupavidas() {
		Ataque ataque = AtaqueBuilder.crearChupavidas();
		AlgoMon rattata = AlgoMonBuilder.crearRattata();
		int contador = 0;

		try {

			while(true) {
				rattata.recibirAtaque(ataque);
				contador++;
			}

		} catch(AtaqueAgotado e) {
			assertEquals(8, contador);
		}
	}

	@Test
	public void test14UsosLatigoCepa() {
		Ataque ataque = AtaqueBuilder.crearLatigoCepa();
		AlgoMon rattata = AlgoMonBuilder.crearRattata();
		int contador = 0;

		try {

			while(true) {
				rattata.recibirAtaque(ataque);
				contador++;
			}

		} catch(AtaqueAgotado e) {
			assertEquals(10, contador);
		}
	}

	@Test
	public void test15UsosBrasas() {
		Ataque ataque = AtaqueBuilder.crearBrasas();
		AlgoMon rattata = AlgoMonBuilder.crearRattata();
		int contador = 0;

		try {

			while(true) {
				rattata.recibirAtaque(ataque);
				contador++;
			}

		} catch(AtaqueAgotado e) {
			assertEquals(10, contador);
		}
	}

	@Test
	public void test16UsosFogonazo() {
		Ataque ataque = AtaqueBuilder.crearFogonazo();
		AlgoMon rattata = AlgoMonBuilder.crearRattata();
		int contador = 0;

		try {

			while(true) {
				rattata.recibirAtaque(ataque);
				contador++;
			}

		} catch(AtaqueAgotado e) {
			assertEquals(4, contador);
		}
	}

}
