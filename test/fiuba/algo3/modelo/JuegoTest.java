package test.fiuba.algo3.modelo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import src.fiuba.algo3.modelo.AlgoMon;
import src.fiuba.algo3.modelo.AlgoMonBuilder;
import src.fiuba.algo3.modelo.Juego;
import src.fiuba.algo3.modelo.Jugador;
import src.fiuba.algo3.modelo.ataques.NombreAtaque;

public class JuegoTest {

	@Test
	public void test01UsarUnAtaqueCambiaElTurnoDelJuego() {
		Juego juego = new Juego();

		AlgoMon charmander = AlgoMonBuilder.crearCharmander();
		AlgoMon squirtle = AlgoMonBuilder.crearSquirtle();
		AlgoMon bulbasaur = AlgoMonBuilder.crearBulbasaur();
		Jugador jugador1 = juego.getJugador1();

		jugador1.agregarAlgoMonAlEquipo(charmander);
		jugador1.agregarAlgoMonAlEquipo(squirtle);
		jugador1.agregarAlgoMonAlEquipo(bulbasaur);
		jugador1.listoParaPelear();

		AlgoMon jigglypuff = AlgoMonBuilder.crearJigglypuff();
		AlgoMon chansey = AlgoMonBuilder.crearChansey();
		AlgoMon rattata = AlgoMonBuilder.crearRattata();
		Jugador jugador2 = juego.getJugador2();

		jugador2.agregarAlgoMonAlEquipo(jigglypuff);
		jugador2.agregarAlgoMonAlEquipo(chansey);
		jugador2.agregarAlgoMonAlEquipo(rattata);
		jugador2.listoParaPelear();

		String nombreAlgoMonActivoJugadorActivoInicial = juego.getJugadorActivo().getAlgoMonActivo().getNombre();
		String nombreAlgoMonActivoContrincanteInicial = juego.getContrincante().getAlgoMonActivo().getNombre();

		assertEquals(nombreAlgoMonActivoJugadorActivoInicial, juego.getJugadorActivo().getAlgoMonActivo().getNombre());
		juego.jugadorActivoAtaca(NombreAtaque.ATAQUERAPIDO);
		assertEquals(juego.getJugadorActivo().getAlgoMonActivo().getVidaMaxima() - 10, juego.getJugadorActivo().getAlgoMonActivo().getVida(), 0.0001D);

		assertEquals(nombreAlgoMonActivoContrincanteInicial, juego.getJugadorActivo().getAlgoMonActivo().getNombre());
		juego.jugadorActivoAtaca(NombreAtaque.ATAQUERAPIDO);
		assertEquals(juego.getJugadorActivo().getAlgoMonActivo().getVidaMaxima() - 10, juego.getJugadorActivo().getAlgoMonActivo().getVida(), 0.0001D);
	}

	@Test
	public void test02UsarUnElementoCambiaElTurnoDelJuego() {
		Juego juego = new Juego();

		AlgoMon charmander = AlgoMonBuilder.crearCharmander();
		AlgoMon squirtle = AlgoMonBuilder.crearSquirtle();
		AlgoMon bulbasaur = AlgoMonBuilder.crearBulbasaur();
		Jugador jugador1 = juego.getJugador1();

		jugador1.agregarAlgoMonAlEquipo(charmander);
		jugador1.agregarAlgoMonAlEquipo(squirtle);
		jugador1.agregarAlgoMonAlEquipo(bulbasaur);
		jugador1.listoParaPelear();

		AlgoMon jigglypuff = AlgoMonBuilder.crearJigglypuff();
		AlgoMon chansey = AlgoMonBuilder.crearChansey();
		AlgoMon rattata = AlgoMonBuilder.crearRattata();
		Jugador jugador2 = juego.getJugador2();

		jugador2.agregarAlgoMonAlEquipo(jigglypuff);
		jugador2.agregarAlgoMonAlEquipo(chansey);
		jugador2.agregarAlgoMonAlEquipo(rattata);
		jugador2.listoParaPelear();

		juego.jugadorActivoAtaca(NombreAtaque.BRASAS);
		assertEquals(juego.getJugadorActivo().getAlgoMonActivo().getVidaMaxima() - 20, juego.getJugadorActivo().getAlgoMonActivo().getVida(), 0.0001D);
		assertEquals("Jigglypuff", juego.getJugadorActivo().getAlgoMonActivo().getNombre());

		//juego.jugadorActivoUsaElemento(NombreElemento.POCION); //TODO

		assertEquals("Jigglypuff", juego.getContrincante().getAlgoMonActivo().getNombre());
		assertTrue(juego.getContrincante().getAlgoMonActivo().tieneVidaCompleta());
	}

	@Test
	public void test03JugadorAtacaConAlgoMonActivoDormidoYElAlgoMonActivoDelContrincanteNoRecibeDaño() {
		Juego juego = new Juego();

		AlgoMon jigglypuff = AlgoMonBuilder.crearJigglypuff();
		AlgoMon chansey = AlgoMonBuilder.crearChansey();
		AlgoMon rattata = AlgoMonBuilder.crearRattata();
		Jugador jugador1 = juego.getJugador1();

		jugador1.agregarAlgoMonAlEquipo(jigglypuff);
		jugador1.agregarAlgoMonAlEquipo(chansey);
		jugador1.agregarAlgoMonAlEquipo(rattata);
		jugador1.listoParaPelear();

		AlgoMon charmander = AlgoMonBuilder.crearCharmander();
		AlgoMon squirtle = AlgoMonBuilder.crearSquirtle();
		AlgoMon bulbasaur = AlgoMonBuilder.crearBulbasaur();
		Jugador jugador2 = juego.getJugador2();

		jugador2.agregarAlgoMonAlEquipo(charmander);
		jugador2.agregarAlgoMonAlEquipo(squirtle);
		jugador2.agregarAlgoMonAlEquipo(bulbasaur);
		jugador2.listoParaPelear();

		juego.jugadorActivoAtaca(NombreAtaque.CANTO);
		juego.jugadorActivoAtaca(NombreAtaque.ATAQUERAPIDO);

		assertTrue(juego.getJugadorActivo().getAlgoMonActivo().tieneVidaCompleta());
	}

}
