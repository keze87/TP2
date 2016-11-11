package test.fiuba.algo3.modelo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import src.fiuba.algo3.modelo.AlgoMon;
import src.fiuba.algo3.modelo.AlgoMonBuilder;
<<<<<<< HEAD
import src.fiuba.algo3.modelo.elementos.Elemento;
=======
import src.fiuba.algo3.modelo.ataques.NombreAtaque;
>>>>>>> 29d82e1c558c7ab8928fa9aebd14b00f9da8ec0b
import src.fiuba.algo3.modelo.elementos.Pocion;
import src.fiuba.algo3.modelo.elementos.Restaurador;
import src.fiuba.algo3.modelo.elementos.SuperPocion;
import src.fiuba.algo3.modelo.elementos.Vitamina;
import src.fiuba.algo3.modelo.excepciones.AtaqueAgotado;
import src.fiuba.algo3.modelo.excepciones.VidaCompleta;

public class ElementosTest {

	@Test
	public void test01PocionAumenta20PuntosDeVida() {
		AlgoMon bulbasaur = AlgoMonBuilder.crearBulbasaur();
		AlgoMon charmander = AlgoMonBuilder.crearCharmander();
		AlgoMon squirtle = AlgoMonBuilder.crearSquirtle();
		Pocion pocion = new Pocion();

		charmander.atacar(NombreAtaque.BRASAS, bulbasaur);
		assertEquals(bulbasaur.getVidaMaxima() - 32, bulbasaur.getVida(), 0.0001D);

		bulbasaur.recibirElemento(pocion);

		assertEquals((bulbasaur.getVidaMaxima() - 32) + 20, bulbasaur.getVida(), 0.0001D);

		squirtle.atacar(NombreAtaque.CAÑONDEAGUA, charmander);
		assertEquals(charmander.getVidaMaxima() - 40, charmander.getVida(), 0.0001D);

		charmander.recibirElemento(pocion);
		assertEquals((charmander.getVidaMaxima() - 40) + 20, charmander.getVida(), 0.0001D);
	}


	@Test
	public void test02SuperPocionAumenta40PuntosDeVida(){
		AlgoMon charmander = AlgoMonBuilder.crearCharmander();
		AlgoMon squirtle = AlgoMonBuilder.crearSquirtle();
		SuperPocion superPocion = new SuperPocion();

		squirtle.atacar(NombreAtaque.CAÑONDEAGUA, charmander);
		assertEquals(charmander.getVidaMaxima() - 40 , charmander.getVida(), 0.0001D);

		charmander.recibirElemento(superPocion);
		assertEquals(charmander.getVidaMaxima() , charmander.getVida(), 0.0001D);
	}

	@Test
	public void test03VitaminaAumentaEn2LaCantidadDeTodosLosAtaques(){
		AlgoMon charmander = AlgoMonBuilder.crearCharmander();
		AlgoMon squirtle = AlgoMonBuilder.crearSquirtle();
		AlgoMon otroCharmander = AlgoMonBuilder.crearCharmander();
		Vitamina vitamina = new Vitamina();

		charmander.recibirElemento(vitamina);
		int contador = 0;

		try{
			while(true){
				charmander.atacar(NombreAtaque.BRASAS, squirtle);
				contador++;
			}

		} catch(AtaqueAgotado e) {
			assertEquals(12, contador);
		}

		contador = 0;

		try{
			while(true){
				charmander.atacar(NombreAtaque.FOGONAZO, squirtle);
				contador++;
			}

		} catch(AtaqueAgotado e) {
			assertEquals(6, contador);
		}

		contador = 0;

		try{
			while(true){
				charmander.atacar(NombreAtaque.ATAQUERAPIDO, otroCharmander);
				contador++;
			}

		} catch(AtaqueAgotado e) {
			assertEquals(18, contador);
		}

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

	@Test
	public void test06UsarRestauradorEnAlgoMonDormidoLoDespierta() {
		AlgoMon jigglypuff = AlgoMonBuilder.crearJigglypuff();
		AlgoMon rattata = AlgoMonBuilder.crearRattata();
		Elemento restaurador = new Restaurador();

		jigglypuff.atacar("Canto", rattata);

		rattata.atacar("Ataque rápido", jigglypuff);
		assertTrue(jigglypuff.tieneVidaCompleta());

		rattata.recibirElemento(restaurador);
		rattata.atacar("Ataque rápido", jigglypuff);
		assertEquals(jigglypuff.getVidaMaxima() - 10, jigglypuff.getVida(), 0.0001D);
	}

	@Test
	public void test07UsarRestauradorEnAlgoMonQuemadoAnulaLaQuemadura() {
		AlgoMon charmander = AlgoMonBuilder.crearCharmander();
		AlgoMon rattata = AlgoMonBuilder.crearRattata();
		Elemento restaurador = new Restaurador();

		charmander.atacar("Fogonazo", rattata);

		rattata.atacar("Ataque rápido", charmander);
		assertEquals(rattata.getVidaMaxima() - 19, rattata.getVida(), 0.0001D);

		rattata.recibirElemento(restaurador);
		rattata.atacar("Ataque rápido", charmander);
		assertEquals(rattata.getVidaMaxima() - 19, rattata.getVida(), 0.0001D);
	}

	@Test
	public void test08UsarRestauradorEnAlgoMonDormidoYQuemado() {
		AlgoMon jigglypuff = AlgoMonBuilder.crearJigglypuff();
		AlgoMon charmander = AlgoMonBuilder.crearCharmander();
		AlgoMon rattata = AlgoMonBuilder.crearRattata();
		Elemento restaurador = new Restaurador();

		jigglypuff.atacar("Canto", rattata);
		charmander.atacar("Fogonazo", rattata);
		rattata.atacar("Ataque rápido", jigglypuff);
		assertTrue(jigglypuff.tieneVidaCompleta());
		assertEquals(rattata.getVidaMaxima() - 19, rattata.getVida(), 0.0001D);

		rattata.recibirElemento(restaurador);
		rattata.atacar("Ataque rápido", jigglypuff);
		assertEquals(jigglypuff.getVidaMaxima() - 10, jigglypuff.getVida(), 0.0001);
		assertEquals(rattata.getVidaMaxima() - 19, rattata.getVida(), 0.0001D);
	}

}
