package test.fiuba.algo3.modelo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import src.fiuba.algo3.modelo.AlgoMon;
import src.fiuba.algo3.modelo.AlgoMonBuilder;
import src.fiuba.algo3.modelo.Jugador;
import src.fiuba.algo3.modelo.ataques.NombreAtaque;
import src.fiuba.algo3.modelo.excepciones.EquipoCompleto;

public class JugadorTest {

	@Test
	public void test01AgregarAlgoMonAEquipo() {
		Jugador jugador = new Jugador();
		AlgoMon charmander = AlgoMonBuilder.crearCharmander();

		assertFalse(jugador.tieneAlgoMonEnEquipo(charmander));

		jugador.agregarAlgoMonAlEquipo(charmander);
		assertTrue(jugador.tieneAlgoMonEnEquipo(charmander));
	}

	@Test
	public void test02AgregarMasDe3AlgoMonAlEquipoLanzaExcepcion() {
		Jugador jugador = new Jugador();
		AlgoMon charmander = AlgoMonBuilder.crearCharmander();
		AlgoMon squirtle = AlgoMonBuilder.crearSquirtle();
		AlgoMon bulbasaur = AlgoMonBuilder.crearBulbasaur();
		AlgoMon jigglypuff = AlgoMonBuilder.crearJigglypuff();

		try {
			jugador.agregarAlgoMonAlEquipo(charmander);
			jugador.agregarAlgoMonAlEquipo(squirtle);
			jugador.agregarAlgoMonAlEquipo(bulbasaur);
			jugador.agregarAlgoMonAlEquipo(jigglypuff);
		} catch(EquipoCompleto e) {
			assertTrue(jugador.tieneAlgoMonEnEquipo(charmander));
			assertTrue(jugador.tieneAlgoMonEnEquipo(squirtle));
			assertTrue(jugador.tieneAlgoMonEnEquipo(bulbasaur));
			assertFalse(jugador.tieneAlgoMonEnEquipo(jigglypuff));
		}

	}

	@Test
	public void test03SacarAlgoMonDelEquipo() {
		Jugador jugador = new Jugador();
		AlgoMon charmander = AlgoMonBuilder.crearCharmander();

		jugador.agregarAlgoMonAlEquipo(charmander);
		assertTrue(jugador.tieneAlgoMonEnEquipo(charmander));

		jugador.sacarAlgoMonDelEquipo(charmander);
		assertFalse(jugador.tieneAlgoMonEnEquipo(charmander));
	}

	@Test
	public void test04AtacarConAlgoMonActivo() {
		AlgoMon charmander = AlgoMonBuilder.crearCharmander();
		AlgoMon squirtle = AlgoMonBuilder.crearSquirtle();
		AlgoMon bulbasaur = AlgoMonBuilder.crearBulbasaur();
		Jugador jugador1 = new Jugador();

		jugador1.agregarAlgoMonAlEquipo(charmander);
		jugador1.agregarAlgoMonAlEquipo(squirtle);
		jugador1.agregarAlgoMonAlEquipo(bulbasaur);
		jugador1.listoParaPelear();

		AlgoMon jigglypuff = AlgoMonBuilder.crearJigglypuff();
		AlgoMon chansey = AlgoMonBuilder.crearChansey();
		AlgoMon rattata = AlgoMonBuilder.crearRattata();
		Jugador jugador2 = new Jugador();

		jugador2.agregarAlgoMonAlEquipo(jigglypuff);
		jugador2.agregarAlgoMonAlEquipo(chansey);
		jugador2.agregarAlgoMonAlEquipo(rattata);
		jugador2.listoParaPelear();

		jugador1.atacarConAlgoMonActivo(NombreAtaque.BRASAS, jugador2.getAlgoMonActivo());
		assertEquals(jugador2.getAlgoMonActivo().getVidaMaxima() - 16, jugador2.getAlgoMonActivo().getVida(), 0.0001D);

	}

}
