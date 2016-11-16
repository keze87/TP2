package test.fiuba.algo3.modelo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import src.fiuba.algo3.modelo.AlgoMon;
import src.fiuba.algo3.modelo.AlgoMonBuilder;
import src.fiuba.algo3.modelo.Jugador;
import src.fiuba.algo3.modelo.ataques.NombreAtaque;
import src.fiuba.algo3.modelo.elementos.SuperPocion;
import src.fiuba.algo3.modelo.excepciones.AtaqueAgotado;
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

	@Test
	public void test05AplicarPocionAlAlgoMonActivoLeDevuelve20PuntosDeVida() {
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

		jugador1.atacarConAlgoMonActivo(NombreAtaque.ATAQUERAPIDO, jugador2.getAlgoMonActivo());
		jugador1.atacarConAlgoMonActivo(NombreAtaque.ATAQUERAPIDO, jugador2.getAlgoMonActivo());
		assertEquals(jugador2.getAlgoMonActivo().getVidaMaxima() - 20, jugador2.getAlgoMonActivo().getVida(), 0.0001D);

		jugador2.usarPocion();
		assertEquals(jugador2.getAlgoMonActivo().getVidaMaxima(), jugador2.getAlgoMonActivo().getVida(), 0.0001D);
	}

	@Test
	public void test06AplicarSuperPocionAlAlgoMonActivoLeDevuelve40PuntosDeVida() {
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

		jugador1.atacarConAlgoMonActivo(NombreAtaque.ATAQUERAPIDO, jugador2.getAlgoMonActivo());
		jugador1.atacarConAlgoMonActivo(NombreAtaque.ATAQUERAPIDO, jugador2.getAlgoMonActivo());
		jugador1.atacarConAlgoMonActivo(NombreAtaque.ATAQUERAPIDO, jugador2.getAlgoMonActivo());
		jugador1.atacarConAlgoMonActivo(NombreAtaque.ATAQUERAPIDO, jugador2.getAlgoMonActivo());
		assertEquals(jugador2.getAlgoMonActivo().getVidaMaxima() - 40, jugador2.getAlgoMonActivo().getVida(), 0.0001D);

		jugador2.usarSuperPocion();
		assertEquals(jugador2.getAlgoMonActivo().getVidaMaxima(), jugador2.getAlgoMonActivo().getVida(), 0.0001D);
	}

	@Test
	public void test07AplicarRestauradorAlAlgoMonActivoCuandoEstaQuemadoCuraLaQuemadura() {
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

		jugador1.atacarConAlgoMonActivo(NombreAtaque.FOGONAZO, jugador2.getAlgoMonActivo());
		jugador2.atacarConAlgoMonActivo(NombreAtaque.ATAQUERAPIDO, jugador1.getAlgoMonActivo());
		assertEquals(jugador2.getAlgoMonActivo().getVidaMaxima() - 15, jugador2.getAlgoMonActivo().getVida(), 0.0001D);

		jugador2.usarRestaurador();
		jugador2.atacarConAlgoMonActivo(NombreAtaque.ATAQUERAPIDO, jugador1.getAlgoMonActivo());
		assertEquals(jugador2.getAlgoMonActivo().getVidaMaxima() - 15, jugador2.getAlgoMonActivo().getVida(), 0.0001D);
	}

	@Test
	public void test08AplicarRestauradorAlAlgoMonActivoCuandoEstaDormidoLoDespierta() {
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

		jugador2.atacarConAlgoMonActivo(NombreAtaque.CANTO, jugador1.getAlgoMonActivo());
		jugador1.atacarConAlgoMonActivo(NombreAtaque.ATAQUERAPIDO, jugador2.getAlgoMonActivo());
		assertEquals(jugador2.getAlgoMonActivo().getVidaMaxima(), jugador2.getAlgoMonActivo().getVida(), 0.0001D);

		jugador1.usarRestaurador();
		jugador1.atacarConAlgoMonActivo(NombreAtaque.ATAQUERAPIDO, jugador2.getAlgoMonActivo());
		assertEquals(jugador2.getAlgoMonActivo().getVidaMaxima() - 10, jugador2.getAlgoMonActivo().getVida(), 0.0001D);
	}

	@Test
	public void test09AplicarVitaminaAlAlgoMonActivoAgrega2UsosACadaAtaque() {
		AlgoMon bulbasaur = AlgoMonBuilder.crearBulbasaur();
		AlgoMon charmander = AlgoMonBuilder.crearCharmander();
		AlgoMon squirtle = AlgoMonBuilder.crearSquirtle();
		Jugador jugador1 = new Jugador();

		jugador1.agregarAlgoMonAlEquipo(bulbasaur);
		jugador1.agregarAlgoMonAlEquipo(charmander);
		jugador1.agregarAlgoMonAlEquipo(squirtle);
		jugador1.listoParaPelear();

		AlgoMon jigglypuff = AlgoMonBuilder.crearJigglypuff();
		AlgoMon chansey = AlgoMonBuilder.crearChansey();
		AlgoMon rattata = AlgoMonBuilder.crearRattata();
		Jugador jugador2 = new Jugador();

		jugador2.agregarAlgoMonAlEquipo(jigglypuff);
		jugador2.agregarAlgoMonAlEquipo(chansey);
		jugador2.agregarAlgoMonAlEquipo(rattata);
		jugador2.listoParaPelear();

		try {
			while(true) {
				jugador1.atacarConAlgoMonActivo(NombreAtaque.CHUPAVIDAS, jugador2.getAlgoMonActivo());
			}
		} catch(AtaqueAgotado e) {
			jugador2.getAlgoMonActivo().recibirElemento(new SuperPocion());
			jugador2.getAlgoMonActivo().recibirElemento(new SuperPocion());
			jugador2.getAlgoMonActivo().recibirElemento(new SuperPocion());
		}

		try {
			while(true) {
				jugador1.atacarConAlgoMonActivo(NombreAtaque.LATIGOCEPA, jugador2.getAlgoMonActivo());
			}
		} catch(AtaqueAgotado e) {
			jugador2.getAlgoMonActivo().recibirElemento(new SuperPocion());
			jugador2.getAlgoMonActivo().recibirElemento(new SuperPocion());
			jugador2.getAlgoMonActivo().recibirElemento(new SuperPocion());
			jugador2.getAlgoMonActivo().recibirElemento(new SuperPocion());
		}

		try {
			while(true) {
				jugador1.atacarConAlgoMonActivo(NombreAtaque.ATAQUERAPIDO, jugador2.getAlgoMonActivo());
			}
		} catch(AtaqueAgotado e) {
			jugador2.getAlgoMonActivo().recibirElemento(new SuperPocion());
			jugador2.getAlgoMonActivo().recibirElemento(new SuperPocion());
			jugador2.getAlgoMonActivo().recibirElemento(new SuperPocion());
			jugador2.getAlgoMonActivo().recibirElemento(new SuperPocion());
		}

		assertEquals(jugador2.getAlgoMonActivo().getVidaMaxima(), jugador2.getAlgoMonActivo().getVida(), 0.0001D);
		jugador1.usarVitamina();

		jugador1.atacarConAlgoMonActivo(NombreAtaque.CHUPAVIDAS, jugador2.getAlgoMonActivo());
		jugador1.atacarConAlgoMonActivo(NombreAtaque.LATIGOCEPA, jugador2.getAlgoMonActivo());
		jugador1.atacarConAlgoMonActivo(NombreAtaque.ATAQUERAPIDO, jugador2.getAlgoMonActivo());
		jugador1.atacarConAlgoMonActivo(NombreAtaque.CHUPAVIDAS, jugador2.getAlgoMonActivo());
		jugador1.atacarConAlgoMonActivo(NombreAtaque.LATIGOCEPA, jugador2.getAlgoMonActivo());
		jugador1.atacarConAlgoMonActivo(NombreAtaque.ATAQUERAPIDO, jugador2.getAlgoMonActivo());

		assertEquals(jugador2.getAlgoMonActivo().getVidaMaxima() - 80, jugador2.getAlgoMonActivo().getVida(), 0.0001D);
	}

//	@Test(expected = NoHayAlgoMonActivo.class)
//	public void test09AtacarSinEstablecerElAlgoMonActivoLanzaExcepcion() {
//		AlgoMon charmander = AlgoMonBuilder.crearCharmander();
//		AlgoMon squirtle = AlgoMonBuilder.crearSquirtle();
//		AlgoMon bulbasaur = AlgoMonBuilder.crearBulbasaur();
//		Jugador jugador1 = new Jugador();
//
//		jugador1.agregarAlgoMonAlEquipo(charmander);
//		jugador1.agregarAlgoMonAlEquipo(squirtle);
//		jugador1.agregarAlgoMonAlEquipo(bulbasaur);
//
//		AlgoMon jigglypuff = AlgoMonBuilder.crearJigglypuff();
//		AlgoMon chansey = AlgoMonBuilder.crearChansey();
//		AlgoMon rattata = AlgoMonBuilder.crearRattata();
//		Jugador jugador2 = new Jugador();
//
//		jugador2.agregarAlgoMonAlEquipo(jigglypuff);
//		jugador2.agregarAlgoMonAlEquipo(chansey);
//		jugador2.agregarAlgoMonAlEquipo(rattata);
//		jugador2.listoParaPelear();
//
//		jugador1.atacarConAlgoMonActivo(NombreAtaque.ATAQUERAPIDO, jugador2.getAlgoMonActivo());
//	}

//	@Test(expected = NoHayAlgoMonActivo.class)
//	public void test10RecibirAtaqueSinEstablecerElAlgoMonActivoLanzaExcepcion() {
//		AlgoMon charmander = AlgoMonBuilder.crearCharmander();
//		AlgoMon squirtle = AlgoMonBuilder.crearSquirtle();
//		AlgoMon bulbasaur = AlgoMonBuilder.crearBulbasaur();
//		Jugador jugador1 = new Jugador();
//
//		jugador1.agregarAlgoMonAlEquipo(charmander);
//		jugador1.agregarAlgoMonAlEquipo(squirtle);
//		jugador1.agregarAlgoMonAlEquipo(bulbasaur);
//		jugador1.listoParaPelear();
//
//		AlgoMon jigglypuff = AlgoMonBuilder.crearJigglypuff();
//		AlgoMon chansey = AlgoMonBuilder.crearChansey();
//		AlgoMon rattata = AlgoMonBuilder.crearRattata();
//		Jugador jugador2 = new Jugador();
//
//		jugador2.agregarAlgoMonAlEquipo(jigglypuff);
//		jugador2.agregarAlgoMonAlEquipo(chansey);
//		jugador2.agregarAlgoMonAlEquipo(rattata);
//
//		jugador1.atacarConAlgoMonActivo(NombreAtaque.ATAQUERAPIDO, jugador2.getAlgoMonActivo());
//	}

}
