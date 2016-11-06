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

		assertEquals(10, ataque.calcularDanioContra(charmander), 0.0001D);
		assertEquals(10, ataque.calcularDanioContra(squirtle), 0.0001D);
		assertEquals(10, ataque.calcularDanioContra(bulbasaur), 0.0001D);
		assertEquals(10, ataque.calcularDanioContra(jigglypuff), 0.0001D);
		assertEquals(10, ataque.calcularDanioContra(chansey), 0.0001D);
		assertEquals(10, ataque.calcularDanioContra(rattata), 0.0001D);
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

		assertEquals(0, ataque.calcularDanioContra(charmander), 0.0001D);
		assertEquals(0, ataque.calcularDanioContra(squirtle), 0.0001D);
		assertEquals(0, ataque.calcularDanioContra(bulbasaur), 0.0001D);
		assertEquals(0, ataque.calcularDanioContra(jigglypuff), 0.0001D);
		assertEquals(0, ataque.calcularDanioContra(chansey), 0.0001D);
		assertEquals(0, ataque.calcularDanioContra(rattata), 0.0001D);
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

		assertEquals(20, ataque.calcularDanioContra(charmander), 0.0001D);
		assertEquals(5, ataque.calcularDanioContra(squirtle), 0.0001D);
		assertEquals(5, ataque.calcularDanioContra(bulbasaur), 0.0001D);
		assertEquals(10, ataque.calcularDanioContra(jigglypuff), 0.0001D);
		assertEquals(10, ataque.calcularDanioContra(chansey), 0.0001D);
		assertEquals(10, ataque.calcularDanioContra(rattata), 0.0001D);
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

		assertEquals(40, ataque.calcularDanioContra(charmander), 0.0001D);
		assertEquals(10, ataque.calcularDanioContra(squirtle), 0.0001D);
		assertEquals(10, ataque.calcularDanioContra(bulbasaur), 0.0001D);
		assertEquals(20, ataque.calcularDanioContra(jigglypuff), 0.0001D);
		assertEquals(20, ataque.calcularDanioContra(chansey), 0.0001D);
		assertEquals(20, ataque.calcularDanioContra(rattata), 0.0001D);
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

		assertEquals(7, ataque.calcularDanioContra(charmander), 0.0001D);
		assertEquals(30, ataque.calcularDanioContra(squirtle), 0.0001D);
		assertEquals(7, ataque.calcularDanioContra(bulbasaur), 0.0001D);
		assertEquals(15, ataque.calcularDanioContra(jigglypuff), 0.0001D);
		assertEquals(15, ataque.calcularDanioContra(chansey), 0.0001D);
		assertEquals(15, ataque.calcularDanioContra(rattata), 0.0001D);
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

		assertEquals(7, ataque.calcularDanioContra(charmander), 0.0001D);
		assertEquals(30, ataque.calcularDanioContra(squirtle), 0.0001D);
		assertEquals(7, ataque.calcularDanioContra(bulbasaur), 0.0001D);
		assertEquals(15, ataque.calcularDanioContra(jigglypuff), 0.0001D);
		assertEquals(15, ataque.calcularDanioContra(chansey), 0.0001D);
		assertEquals(15, ataque.calcularDanioContra(rattata), 0.0001D);
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

		assertEquals(8, ataque.calcularDanioContra(charmander), 0.0001D);
		assertEquals(8, ataque.calcularDanioContra(squirtle), 0.0001D);
		assertEquals(32, ataque.calcularDanioContra(bulbasaur), 0.0001D);
		assertEquals(16, ataque.calcularDanioContra(jigglypuff), 0.0001D);
		assertEquals(16, ataque.calcularDanioContra(chansey), 0.0001D);
		assertEquals(16, ataque.calcularDanioContra(rattata), 0.0001D);
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

		assertEquals(1, ataque.calcularDanioContra(charmander), 0.0001D);
		assertEquals(1, ataque.calcularDanioContra(squirtle), 0.0001D);
		assertEquals(4, ataque.calcularDanioContra(bulbasaur), 0.0001D);
		assertEquals(2, ataque.calcularDanioContra(jigglypuff), 0.0001D);

		ataque = AtaqueBuilder.crearFogonazo();

		assertEquals(2, ataque.calcularDanioContra(chansey), 0.0001D);
		assertEquals(2, ataque.calcularDanioContra(rattata), 0.0001D);
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
