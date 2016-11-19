package test.fiuba.algo3.modelo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import src.fiuba.algo3.modelo.AlgoMon;
import src.fiuba.algo3.modelo.AlgoMonBuilder;
import src.fiuba.algo3.modelo.Jugador;
import src.fiuba.algo3.modelo.ataques.NombreAtaque;
import src.fiuba.algo3.modelo.efectos.AumentarVida;
import src.fiuba.algo3.modelo.elementos.NombreElemento;
import src.fiuba.algo3.modelo.elementos.SuperPocion;
import src.fiuba.algo3.modelo.excepciones.AlgoMonActivoMurio;
import src.fiuba.algo3.modelo.excepciones.AlgoMonDormidoNoPuedeAtacar;
import src.fiuba.algo3.modelo.excepciones.AlgoMonNoExiste;
import src.fiuba.algo3.modelo.excepciones.AlgoMonRecibeQuemadura;
import src.fiuba.algo3.modelo.excepciones.AlgoMonYaEstaActivo;
import src.fiuba.algo3.modelo.excepciones.AtaqueAgotado;
import src.fiuba.algo3.modelo.excepciones.EquipoCompleto;
import src.fiuba.algo3.modelo.excepciones.StockAgotado;

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

		jugador2.usarElemento(NombreElemento.POCION);
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

		jugador2.usarElemento(NombreElemento.SUPERPOCION);
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
		try {jugador2.atacarConAlgoMonActivo(NombreAtaque.ATAQUERAPIDO, jugador1.getAlgoMonActivo());}catch(AlgoMonRecibeQuemadura e){}
		assertEquals(jugador2.getAlgoMonActivo().getVidaMaxima() - 15, jugador2.getAlgoMonActivo().getVida(), 0.0001D);

		jugador2.usarElemento(NombreElemento.RESTAURADOR);;
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

		try{jugador2.atacarConAlgoMonActivo(NombreAtaque.CANTO, jugador1.getAlgoMonActivo());} catch(AlgoMonDormidoNoPuedeAtacar e) {}
		try{jugador1.atacarConAlgoMonActivo(NombreAtaque.ATAQUERAPIDO, jugador2.getAlgoMonActivo());} catch(AlgoMonDormidoNoPuedeAtacar e) {}
		assertEquals(jugador2.getAlgoMonActivo().getVidaMaxima(), jugador2.getAlgoMonActivo().getVida(), 0.0001D);

		jugador1.usarElemento(NombreElemento.RESTAURADOR);;
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
				jugador2.getAlgoMonActivo().recibirEfecto(new AumentarVida(10));
			}
		} catch(AtaqueAgotado e) {
			jugador2.getAlgoMonActivo().recibirElemento(new SuperPocion());
			jugador2.getAlgoMonActivo().recibirElemento(new SuperPocion());
		}

		try {
			while(true) {
				jugador1.atacarConAlgoMonActivo(NombreAtaque.ATAQUERAPIDO, jugador2.getAlgoMonActivo());
				jugador2.getAlgoMonActivo().recibirEfecto(new AumentarVida(10));
			}
		} catch(AtaqueAgotado e) {}
			

		assertEquals(jugador2.getAlgoMonActivo().getVidaMaxima(), jugador2.getAlgoMonActivo().getVida(), 0.0001D);
		jugador1.usarElemento(NombreElemento.VITAMINA);;

		jugador1.atacarConAlgoMonActivo(NombreAtaque.CHUPAVIDAS, jugador2.getAlgoMonActivo());
		jugador1.atacarConAlgoMonActivo(NombreAtaque.LATIGOCEPA, jugador2.getAlgoMonActivo());
		jugador1.atacarConAlgoMonActivo(NombreAtaque.ATAQUERAPIDO, jugador2.getAlgoMonActivo());
		jugador1.atacarConAlgoMonActivo(NombreAtaque.CHUPAVIDAS, jugador2.getAlgoMonActivo());
		jugador1.atacarConAlgoMonActivo(NombreAtaque.LATIGOCEPA, jugador2.getAlgoMonActivo());
		jugador1.atacarConAlgoMonActivo(NombreAtaque.ATAQUERAPIDO, jugador2.getAlgoMonActivo());

		assertEquals(jugador2.getAlgoMonActivo().getVidaMaxima() - 80, jugador2.getAlgoMonActivo().getVida(), 0.0001D);
	}

	@Test(expected = StockAgotado.class)
	public void test10UsarPocionCuandoNoHayPocionesRestantesLanzaExcepcion() {
		AlgoMon squirtle = AlgoMonBuilder.crearSquirtle();
		AlgoMon bulbasaur = AlgoMonBuilder.crearBulbasaur();
		AlgoMon charmander = AlgoMonBuilder.crearCharmander();
		Jugador jugador1 = new Jugador();

		jugador1.agregarAlgoMonAlEquipo(squirtle);
		jugador1.agregarAlgoMonAlEquipo(bulbasaur);
		jugador1.agregarAlgoMonAlEquipo(charmander);
		jugador1.listoParaPelear();

		AlgoMon jigglypuff = AlgoMonBuilder.crearJigglypuff();
		AlgoMon chansey = AlgoMonBuilder.crearChansey();
		AlgoMon rattata = AlgoMonBuilder.crearRattata();
		Jugador jugador2 = new Jugador();

		jugador2.agregarAlgoMonAlEquipo(jigglypuff);
		jugador2.agregarAlgoMonAlEquipo(chansey);
		jugador2.agregarAlgoMonAlEquipo(rattata);
		jugador2.listoParaPelear();

		jugador1.atacarConAlgoMonActivo(NombreAtaque.CAÑONDEAGUA, jugador2.getAlgoMonActivo());
		jugador2.usarElemento(NombreElemento.POCION);

		jugador1.atacarConAlgoMonActivo(NombreAtaque.CAÑONDEAGUA, jugador2.getAlgoMonActivo());
		jugador2.usarElemento(NombreElemento.POCION);

		jugador1.atacarConAlgoMonActivo(NombreAtaque.CAÑONDEAGUA, jugador2.getAlgoMonActivo());
		jugador2.usarElemento(NombreElemento.POCION);

		jugador1.atacarConAlgoMonActivo(NombreAtaque.CAÑONDEAGUA, jugador2.getAlgoMonActivo());
		jugador2.usarElemento(NombreElemento.POCION);

		assertTrue(jugador2.getAlgoMonActivo().tieneVidaCompleta());

		jugador1.atacarConAlgoMonActivo(NombreAtaque.CAÑONDEAGUA, jugador2.getAlgoMonActivo());

		assertEquals(jugador2.getAlgoMonActivo().getVidaMaxima() - 20, jugador2.getAlgoMonActivo().getVida(), 0.0001D);

		jugador2.usarElemento(NombreElemento.POCION);
	}

	@Test(expected = StockAgotado.class)
	public void test11UsarSuperPocionCuandoNoHaySuperPocionesRestantesLanzaExcepcion() {
		AlgoMon squirtle = AlgoMonBuilder.crearSquirtle();
		AlgoMon bulbasaur = AlgoMonBuilder.crearBulbasaur();
		AlgoMon jigglypuff = AlgoMonBuilder.crearJigglypuff();
		Jugador jugador1 = new Jugador();

		jugador1.agregarAlgoMonAlEquipo(squirtle);
		jugador1.agregarAlgoMonAlEquipo(bulbasaur);
		jugador1.agregarAlgoMonAlEquipo(jigglypuff);
		jugador1.listoParaPelear();

		AlgoMon charmander = AlgoMonBuilder.crearCharmander();
		AlgoMon chansey = AlgoMonBuilder.crearChansey();
		AlgoMon rattata = AlgoMonBuilder.crearRattata();
		Jugador jugador2 = new Jugador();

		jugador2.agregarAlgoMonAlEquipo(charmander);
		jugador2.agregarAlgoMonAlEquipo(chansey);
		jugador2.agregarAlgoMonAlEquipo(rattata);
		jugador2.listoParaPelear();

		jugador1.atacarConAlgoMonActivo(NombreAtaque.CAÑONDEAGUA, jugador2.getAlgoMonActivo());
		jugador2.usarElemento(NombreElemento.SUPERPOCION);

		jugador1.atacarConAlgoMonActivo(NombreAtaque.CAÑONDEAGUA, jugador2.getAlgoMonActivo());
		jugador2.usarElemento(NombreElemento.SUPERPOCION);

		jugador1.atacarConAlgoMonActivo(NombreAtaque.CAÑONDEAGUA, jugador2.getAlgoMonActivo());
		jugador2.usarElemento(NombreElemento.SUPERPOCION);

		jugador1.atacarConAlgoMonActivo(NombreAtaque.CAÑONDEAGUA, jugador2.getAlgoMonActivo());
		jugador2.usarElemento(NombreElemento.SUPERPOCION);

		assertTrue(jugador2.getAlgoMonActivo().tieneVidaCompleta());

		jugador1.atacarConAlgoMonActivo(NombreAtaque.CAÑONDEAGUA, jugador2.getAlgoMonActivo());

		assertEquals(jugador2.getAlgoMonActivo().getVidaMaxima() - 20, jugador2.getAlgoMonActivo().getVida(), 0.0001D);

		jugador2.usarElemento(NombreElemento.SUPERPOCION);
	}

	@Test
	public void test11UsarRestauradorCuandoNoHayRestauradoresRestantesLanzaExcepcion() {
		AlgoMon squirtle = AlgoMonBuilder.crearSquirtle();
		AlgoMon bulbasaur = AlgoMonBuilder.crearBulbasaur();
		AlgoMon charmander = AlgoMonBuilder.crearCharmander();
		Jugador jugador1 = new Jugador();

		jugador1.agregarAlgoMonAlEquipo(squirtle);
		jugador1.agregarAlgoMonAlEquipo(bulbasaur);
		jugador1.agregarAlgoMonAlEquipo(charmander);
		jugador1.listoParaPelear();

		AlgoMon jigglypuff = AlgoMonBuilder.crearJigglypuff();
		AlgoMon chansey = AlgoMonBuilder.crearChansey();
		AlgoMon rattata = AlgoMonBuilder.crearRattata();
		Jugador jugador2 = new Jugador();

		jugador2.agregarAlgoMonAlEquipo(jigglypuff);
		jugador2.agregarAlgoMonAlEquipo(chansey);
		jugador2.agregarAlgoMonAlEquipo(rattata);
		jugador2.listoParaPelear();

		int usosRestaurador = 0;

		try {
			while(true) {
				jugador2.atacarConAlgoMonActivo(NombreAtaque.CANTO, jugador1.getAlgoMonActivo());
				jugador1.usarElemento(NombreElemento.RESTAURADOR);;
				usosRestaurador++;
			}
		} catch(StockAgotado e) {
			assertEquals(3, usosRestaurador, 0.0001D);
		}
	}

	@Test(expected = StockAgotado.class)
	public void test13UsarVitaminaCuandoNoHayVitaminasRestantesLanzaExcepcion() {
		AlgoMon bulbasaur = AlgoMonBuilder.crearBulbasaur();
		AlgoMon squirtle = AlgoMonBuilder.crearSquirtle();
		AlgoMon jigglypuff = AlgoMonBuilder.crearJigglypuff();
		Jugador jugador1 = new Jugador();

		jugador1.agregarAlgoMonAlEquipo(bulbasaur);
		jugador1.agregarAlgoMonAlEquipo(squirtle);
		jugador1.agregarAlgoMonAlEquipo(jigglypuff);
		jugador1.listoParaPelear();

		AlgoMon charmander = AlgoMonBuilder.crearCharmander();
		AlgoMon chansey = AlgoMonBuilder.crearChansey();
		AlgoMon rattata = AlgoMonBuilder.crearRattata();
		Jugador jugador2 = new Jugador();

		jugador2.agregarAlgoMonAlEquipo(charmander);
		jugador2.agregarAlgoMonAlEquipo(chansey);
		jugador2.agregarAlgoMonAlEquipo(rattata);
		jugador2.listoParaPelear();

		try {
			while(true) {
				jugador1.atacarConAlgoMonActivo(NombreAtaque.LATIGOCEPA, jugador2.getAlgoMonActivo());
			}
		} catch(AtaqueAgotado e) {
			assertEquals(jugador2.getAlgoMonActivo().getVidaMaxima() - 70, jugador2.getAlgoMonActivo().getVida(), 0.0001D);
			jugador2.usarElemento(NombreElemento.SUPERPOCION);
			jugador2.usarElemento(NombreElemento.SUPERPOCION);
		}

		jugador1.usarElemento(NombreElemento.VITAMINA);;
		jugador1.usarElemento(NombreElemento.VITAMINA);;
		jugador1.usarElemento(NombreElemento.VITAMINA);;
		jugador1.usarElemento(NombreElemento.VITAMINA);;
		jugador1.usarElemento(NombreElemento.VITAMINA);;

		try {
			while(true) {
				jugador1.atacarConAlgoMonActivo(NombreAtaque.LATIGOCEPA, jugador2.getAlgoMonActivo());
			}
		} catch(AtaqueAgotado e) {
			assertEquals(jugador2.getAlgoMonActivo().getVidaMaxima() - 70, jugador2.getAlgoMonActivo().getVida(), 0.0001D);
		}

		jugador1.usarElemento(NombreElemento.VITAMINA);;
	}

	@Test
	public void test14CambiarAlgoMonActivoPorOtroAlgoMonQueEstaEnElEquipo() {
		AlgoMon charmander = AlgoMonBuilder.crearCharmander();
		AlgoMon squirtle = AlgoMonBuilder.crearSquirtle();
		AlgoMon bulbasaur = AlgoMonBuilder.crearBulbasaur();
		Jugador jugador1 = new Jugador();

		jugador1.agregarAlgoMonAlEquipo(charmander);
		jugador1.agregarAlgoMonAlEquipo(squirtle);
		jugador1.agregarAlgoMonAlEquipo(bulbasaur);
		jugador1.listoParaPelear();

		assertEquals("Charmander", jugador1.getAlgoMonActivo().getNombre());

		jugador1.cambiarAlgoMonActivo(squirtle);

		assertEquals("Squirtle", jugador1.getAlgoMonActivo().getNombre());

		jugador1.cambiarAlgoMonActivo(bulbasaur);

		assertEquals("Bulbasaur", jugador1.getAlgoMonActivo().getNombre());
	}

	@Test(expected = AlgoMonNoExiste.class)
	public void test15CambiarAlgoMonActivoPorOtroAlgoMonQueNoEstaEnElEquipoLanzaExcepcion() {
		AlgoMon charmander = AlgoMonBuilder.crearCharmander();
		AlgoMon squirtle = AlgoMonBuilder.crearSquirtle();
		AlgoMon bulbasaur = AlgoMonBuilder.crearBulbasaur();
		Jugador jugador1 = new Jugador();

		jugador1.agregarAlgoMonAlEquipo(charmander);
		jugador1.agregarAlgoMonAlEquipo(squirtle);
		jugador1.agregarAlgoMonAlEquipo(bulbasaur);
		jugador1.listoParaPelear();

		AlgoMon jigglypuff = AlgoMonBuilder.crearJigglypuff();

		jugador1.cambiarAlgoMonActivo(jigglypuff);
	}

	@Test(expected = AlgoMonYaEstaActivo.class)
	public void test16CambiarAlgoMonActivoPorElMismoLanzaExcepcion() {
		AlgoMon charmander = AlgoMonBuilder.crearCharmander();
		AlgoMon squirtle = AlgoMonBuilder.crearSquirtle();
		AlgoMon bulbasaur = AlgoMonBuilder.crearBulbasaur();
		Jugador jugador1 = new Jugador();

		jugador1.agregarAlgoMonAlEquipo(charmander);
		jugador1.agregarAlgoMonAlEquipo(squirtle);
		jugador1.agregarAlgoMonAlEquipo(bulbasaur);
		jugador1.listoParaPelear();

		jugador1.cambiarAlgoMonActivo(charmander);
	}

	// TODO: intentar cambiar algoMon activo por otro algoMon muerto lanza excepción.
	@Test(expected = AlgoMonActivoMurio.class)
	public void test17CambiarAlgoMonActivoPorAlgoMonMuertoLanzaExcepcion() {
		AlgoMon squirtle = AlgoMonBuilder.crearSquirtle();
		AlgoMon bulbasaur = AlgoMonBuilder.crearBulbasaur();
		AlgoMon jigglypuff = AlgoMonBuilder.crearJigglypuff();
		AlgoMon charmander = AlgoMonBuilder.crearCharmander();
		Jugador jugador1 = new Jugador();

		jugador1.agregarAlgoMonAlEquipo(squirtle);
		jugador1.agregarAlgoMonAlEquipo(bulbasaur);
		jugador1.agregarAlgoMonAlEquipo(jigglypuff);
		jugador1.listoParaPelear();

		charmander.atacar(NombreAtaque.BRASAS, bulbasaur);
		charmander.atacar(NombreAtaque.BRASAS, bulbasaur);
		charmander.atacar(NombreAtaque.BRASAS, bulbasaur);
		charmander.atacar(NombreAtaque.BRASAS, bulbasaur);
		charmander.atacar(NombreAtaque.BRASAS, bulbasaur);

		assertFalse(bulbasaur.estaVivo());

		jugador1.cambiarAlgoMonActivo(bulbasaur);
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
