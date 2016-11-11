package test.fiuba.algo3.modelo;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import src.fiuba.algo3.modelo.AlgoMon;
import src.fiuba.algo3.modelo.AlgoMonBuilder;
import src.fiuba.algo3.modelo.elementos.Pocion;
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

		charmander.atacar("Brasas", bulbasaur);
		assertEquals(bulbasaur.getVidaMaxima() - 32, bulbasaur.getVida(), 0.0001D);

		bulbasaur.recibirElemento(pocion);

		assertEquals((bulbasaur.getVidaMaxima() - 32) + 20, bulbasaur.getVida(), 0.0001D);

		squirtle.atacar("Cañón de agua", charmander);
		assertEquals(charmander.getVidaMaxima() - 40, charmander.getVida(), 0.0001D);

		charmander.recibirElemento(pocion);
		assertEquals((charmander.getVidaMaxima() - 40) + 20, charmander.getVida(), 0.0001D);
	}


	@Test
	public void test02SuperPocionAumenta40PuntosDeVida(){
		AlgoMon charmander = AlgoMonBuilder.crearCharmander();
		AlgoMon squirtle = AlgoMonBuilder.crearSquirtle();
		SuperPocion superPocion = new SuperPocion();

		squirtle.atacar("Cañón de agua", charmander);
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
				charmander.atacar("Brasas", squirtle);
				contador++;
			}

		} catch(AtaqueAgotado e) {
			assertEquals(12, contador);
		}

		contador = 0;

		try{
			while(true){
				charmander.atacar("Fogonazo", squirtle);
				contador++;
			}

		} catch(AtaqueAgotado e) {
			assertEquals(6, contador);
		}

		contador = 0;

		try{
			while(true){
				charmander.atacar("Ataque rápido", otroCharmander);
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

}
