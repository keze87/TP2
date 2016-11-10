package test.fiuba.algo3.modelo;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import src.fiuba.algo3.modelo.AlgoMon;
import src.fiuba.algo3.modelo.AlgoMonBuilder;
import src.fiuba.algo3.modelo.elementos.Pocion;
import src.fiuba.algo3.modelo.elementos.SuperPocion;
import src.fiuba.algo3.modelo.elementos.Vitamina;
import src.fiuba.algo3.modelo.excepciones.VidaCompleta;

public class ElementosTest {

	@Test
	public void test01PocionAumenta20PuntosDeVida() {
		AlgoMon bulbasaur = AlgoMonBuilder.crearBulbasaur();
		AlgoMon charmander = AlgoMonBuilder.crearCharmander();
		AlgoMon squirtle = AlgoMonBuilder.crearSquirtle();
		Pocion pocion = new Pocion();

		charmander.ataque("Brasas", bulbasaur);
		assertEquals(bulbasaur.getVidaMaxima() - 32, bulbasaur.getVida(), 0.0001D);

		bulbasaur.recibirElemento(pocion);

		assertEquals((bulbasaur.getVidaMaxima() - 32) + 20, bulbasaur.getVida(), 0.0001D);

		squirtle.ataque("Cañón de agua", charmander);
		assertEquals(charmander.getVidaMaxima() - 40, charmander.getVida(), 0.0001D);

		charmander.recibirElemento(pocion);

		assertEquals((charmander.getVidaMaxima() - 40) + 20, charmander.getVida(), 0.0001D);
	}


	@Test
	public void test02SuperPocionAumenta40PuntosDeVida(){
		AlgoMon charmander = AlgoMonBuilder.crearCharmander();
		AlgoMon squirtle = AlgoMonBuilder.crearSquirtle();
		SuperPocion superPocion = new SuperPocion();

		squirtle.ataque("Cañón de agua", charmander);
		assertEquals(charmander.getVidaMaxima() - 40 , charmander.getVida(), 0.0001D);

		charmander.recibirElemento(superPocion);
		assertEquals(charmander.getVidaMaxima() , charmander.getVida(), 0.0001D);
	}

	@Test
	public void test03VitaminaAumentaPotenciaEn2DeTodosLosAtaques(){
		AlgoMon charmander = AlgoMonBuilder.crearCharmander();
		AlgoMon squirtle = AlgoMonBuilder.crearSquirtle();
		Vitamina vitamina = new Vitamina();

		charmander.recibirElemento(vitamina);

		charmander.ataque("Brasas", squirtle);
		assertEquals((squirtle.getVidaMaxima() - 8), squirtle.getVida(), 0.0001D);

		charmander.ataque("Brasas", squirtle);
		assertEquals((squirtle.getVidaMaxima() - 16), squirtle.getVida(), 0.0001D);

		charmander.ataque("Brasas", squirtle);
		assertEquals((squirtle.getVidaMaxima() - 24), squirtle.getVida(), 0.0001D);

		charmander.ataque("Brasas", squirtle);
		assertEquals((squirtle.getVidaMaxima() - 32), squirtle.getVida(), 0.0001D);

		charmander.ataque("Brasas", squirtle);
		assertEquals((squirtle.getVidaMaxima() - 40), squirtle.getVida(), 0.0001D);

		charmander.ataque("Brasas", squirtle);
		assertEquals((squirtle.getVidaMaxima() - 48), squirtle.getVida(), 0.0001D);

		charmander.ataque("Brasas", squirtle);
		assertEquals((squirtle.getVidaMaxima() - 56), squirtle.getVida(), 0.0001D);

		charmander.ataque("Brasas", squirtle);
		assertEquals((squirtle.getVidaMaxima() - 64), squirtle.getVida(), 0.0001D);

		charmander.ataque("Brasas", squirtle);
		assertEquals((squirtle.getVidaMaxima() - 72), squirtle.getVida(), 0.0001D);

		charmander.ataque("Brasas", squirtle);
		assertEquals((squirtle.getVidaMaxima() - 80), squirtle.getVida(), 0.0001D);

		// ??? Esto está mal.
		charmander = AlgoMonBuilder.crearCharmander();

		charmander.ataque("Brasas", squirtle);
		assertEquals((squirtle.getVidaMaxima() - 88), squirtle.getVida(), 0.0001D);

		charmander.ataque("Brasas", squirtle);
		assertEquals((squirtle.getVidaMaxima() - 96), squirtle.getVida(), 0.0001D);

	}

	@Test(expected = VidaCompleta.class)
	public void test04UsarPocionEnAlgoMonConVidaIgualAVidaMaximaLanzaExcepcion() {
		AlgoMon charmander = AlgoMonBuilder.crearCharmander();

		charmander.recibirElemento(new Pocion());
	}

	@Test(expected = VidaCompleta.class)
	public void tes05UsarSuperPocionEnAlgoMonConVidaIgualAVidaMaximaLanzaExcepcion() {
		AlgoMon rattata = AlgoMonBuilder.crearRattata();

		rattata.recibirElemento(new SuperPocion());
	}

}
