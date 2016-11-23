package test.fiuba.algo3.modelo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;

import src.fiuba.algo3.modelo.AlgoMon;
import src.fiuba.algo3.modelo.AlgoMonBuilder;
import src.fiuba.algo3.modelo.Juego;
import src.fiuba.algo3.modelo.Jugador;
import src.fiuba.algo3.modelo.ataques.NombreAtaque;
import src.fiuba.algo3.modelo.elementos.NombreElemento;
import src.fiuba.algo3.modelo.excepciones.AlgoMonDormidoNoPuedeAtacar;

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

		AlgoMon jigglypuff = AlgoMonBuilder.crearJigglypuff();
		AlgoMon chansey = AlgoMonBuilder.crearChansey();
		AlgoMon rattata = AlgoMonBuilder.crearRattata();
		Jugador jugador2 = juego.getJugador2();

		jugador2.agregarAlgoMonAlEquipo(jigglypuff);
		jugador2.agregarAlgoMonAlEquipo(chansey);
		jugador2.agregarAlgoMonAlEquipo(rattata);

		juego.inicializar();

		Jugador jugadorActivoInicial = juego.getJugadorActivo();

		juego.jugadorActivoAtaca(NombreAtaque.ATAQUERAPIDO);

		Jugador jugadorActivoActual = juego.getJugadorActivo();

		assertNotSame(jugadorActivoActual, jugadorActivoInicial);

		juego.jugadorActivoAtaca(NombreAtaque.ATAQUERAPIDO);

		jugadorActivoActual = juego.getJugadorActivo();

		assertEquals(jugadorActivoActual, jugadorActivoInicial);
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

		AlgoMon jigglypuff = AlgoMonBuilder.crearJigglypuff();
		AlgoMon chansey = AlgoMonBuilder.crearChansey();
		AlgoMon rattata = AlgoMonBuilder.crearRattata();
		Jugador jugador2 = juego.getJugador2();

		jugador2.agregarAlgoMonAlEquipo(jigglypuff);
		jugador2.agregarAlgoMonAlEquipo(chansey);
		jugador2.agregarAlgoMonAlEquipo(rattata);
		juego.inicializar();

		Jugador jugadorActivoInicial = juego.getJugadorActivo();

		juego.jugadorActivoAtaca(NombreAtaque.ATAQUERAPIDO);

		Jugador jugadorActivoActual = juego.getJugadorActivo();

		assertNotSame(jugadorActivoActual, jugadorActivoInicial);

		juego.jugadorActivoUsaElemento(NombreElemento.POCION);

		jugadorActivoActual = juego.getJugadorActivo();

		assertEquals(jugadorActivoActual, jugadorActivoInicial);
	}

	@Test
	public void test03JugadorAtacaConAlgoMonActivoDormidoYElAlgoMonActivoDelContrincanteNoRecibeDañoDuranteElTurno() {
		Juego juego = new Juego();

		AlgoMon jigglypuff = AlgoMonBuilder.crearJigglypuff();
		AlgoMon chansey = AlgoMonBuilder.crearChansey();
		AlgoMon rattata = AlgoMonBuilder.crearRattata();
		Jugador jugador1 = juego.getJugador1();

		jugador1.agregarAlgoMonAlEquipo(jigglypuff);
		jugador1.agregarAlgoMonAlEquipo(chansey);
		jugador1.agregarAlgoMonAlEquipo(rattata);

		AlgoMon otroJigglypuff = AlgoMonBuilder.crearJigglypuff();
		AlgoMon squirtle = AlgoMonBuilder.crearSquirtle();
		AlgoMon bulbasaur = AlgoMonBuilder.crearBulbasaur();
		Jugador jugador2 = juego.getJugador2();

		jugador2.agregarAlgoMonAlEquipo(otroJigglypuff);
		jugador2.agregarAlgoMonAlEquipo(squirtle);
		jugador2.agregarAlgoMonAlEquipo(bulbasaur);

		juego.inicializar();

		juego.jugadorActivoAtaca(NombreAtaque.CANTO);
		try{juego.jugadorActivoAtaca(NombreAtaque.ATAQUERAPIDO);} catch(AlgoMonDormidoNoPuedeAtacar e){}

		assertTrue(juego.getJugadorActivo().getAlgoMonActivo().tieneVidaCompleta());
	}

	@Test
	public void test04CambiarAlgoMonActivoCambiaElTurnoDelJuego() {
		Juego juego = new Juego();

		AlgoMon charmander = AlgoMonBuilder.crearCharmander();
		AlgoMon squirtle = AlgoMonBuilder.crearSquirtle();
		AlgoMon bulbasaur = AlgoMonBuilder.crearBulbasaur();
		Jugador jugador1 = juego.getJugador1();

		jugador1.agregarAlgoMonAlEquipo(charmander);
		jugador1.agregarAlgoMonAlEquipo(squirtle);
		jugador1.agregarAlgoMonAlEquipo(bulbasaur);

		AlgoMon jigglypuff = AlgoMonBuilder.crearJigglypuff();
		AlgoMon chansey = AlgoMonBuilder.crearChansey();
		AlgoMon rattata = AlgoMonBuilder.crearRattata();
		Jugador jugador2 = juego.getJugador2();

		jugador2.agregarAlgoMonAlEquipo(jigglypuff);
		jugador2.agregarAlgoMonAlEquipo(chansey);
		jugador2.agregarAlgoMonAlEquipo(rattata);

		juego.inicializar();

		Jugador jugadorActivoInicial = juego.getJugadorActivo();

		List<AlgoMon> algoMonInactivosJugadorActivo = juego.getAlgoMonInactivosJugadorActivo();

		juego.cambiarAlgoMonActivoJugadorActivo(algoMonInactivosJugadorActivo.get(0));

		Jugador jugadorActivoActual = juego.getJugadorActivo();

		assertNotSame(jugadorActivoActual, jugadorActivoInicial);
	}

}
