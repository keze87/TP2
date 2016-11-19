package test.fiuba.algo3.modelo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import src.fiuba.algo3.modelo.AlgoMon;
import src.fiuba.algo3.modelo.AlgoMonBuilder;
import src.fiuba.algo3.modelo.ataques.NombreAtaque;
import src.fiuba.algo3.modelo.efectos.AumentarVida;
import src.fiuba.algo3.modelo.elementos.Elemento;
import src.fiuba.algo3.modelo.elementos.Pocion;
import src.fiuba.algo3.modelo.elementos.Restaurador;
import src.fiuba.algo3.modelo.elementos.SuperPocion;
import src.fiuba.algo3.modelo.elementos.Vitamina;
import src.fiuba.algo3.modelo.estados.AlgoMonRecibeQuemadura;
import src.fiuba.algo3.modelo.excepciones.AlgoMonDormidoNoPuedeAtacar;
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
	public void test03VitaminaAumentaEn2LaCantidadDeTodosLosAtaquesDeCharmander(){
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
				otroCharmander.recibirEfecto(new AumentarVida(10));				
				contador++;
			}

		} catch(AtaqueAgotado e ) {
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

		jigglypuff.atacar(NombreAtaque.CANTO, rattata);
		try{
		rattata.atacar(NombreAtaque.ATAQUERAPIDO, jigglypuff);} catch(AlgoMonDormidoNoPuedeAtacar e){}
		assertTrue(jigglypuff.tieneVidaCompleta());

		rattata.recibirElemento(restaurador);
		rattata.atacar(NombreAtaque.ATAQUERAPIDO, jigglypuff);
		assertEquals(jigglypuff.getVidaMaxima() - 10, jigglypuff.getVida(), 0.0001D);
	}

	@Test
	public void test07UsarRestauradorEnAlgoMonQuemadoAnulaLaQuemadura() {
		AlgoMon charmander = AlgoMonBuilder.crearCharmander();
		AlgoMon rattata = AlgoMonBuilder.crearRattata();
		Elemento restaurador = new Restaurador();

		charmander.atacar(NombreAtaque.FOGONAZO, rattata);
		try{
		rattata.atacar(NombreAtaque.ATAQUERAPIDO, charmander);} catch(AlgoMonRecibeQuemadura e){}
		assertEquals(rattata.getVidaMaxima() - 19, rattata.getVida(), 0.0001D);

		rattata.recibirElemento(restaurador);
		rattata.atacar(NombreAtaque.ATAQUERAPIDO, charmander);
		assertEquals(rattata.getVidaMaxima() - 19, rattata.getVida(), 0.0001D);
	}

	@Test
	public void test08UsarRestauradorEnAlgoMonDormidoYQuemado() {
		AlgoMon jigglypuff = AlgoMonBuilder.crearJigglypuff();
		AlgoMon charmander = AlgoMonBuilder.crearCharmander();
		AlgoMon rattata = AlgoMonBuilder.crearRattata();
		Elemento restaurador = new Restaurador();
		try{
		jigglypuff.atacar(NombreAtaque.CANTO, rattata);
		charmander.atacar(NombreAtaque.FOGONAZO, rattata);
		rattata.atacar(NombreAtaque.ATAQUERAPIDO, jigglypuff);
		} catch(RuntimeException e){}
		assertTrue(jigglypuff.tieneVidaCompleta());
		assertEquals(rattata.getVidaMaxima() - 19, rattata.getVida(), 0.0001D);
		try{
		rattata.recibirElemento(restaurador);
		rattata.atacar(NombreAtaque.ATAQUERAPIDO, jigglypuff);
		} catch(RuntimeException e){}
		assertEquals(jigglypuff.getVidaMaxima() - 10, jigglypuff.getVida(), 0.0001);
		assertEquals(rattata.getVidaMaxima() - 19, rattata.getVida(), 0.0001D);
	}

	@Test
	public void test09VitaminaAumentaEn2LaCantidadDeTodosLosAtaquesDeSquirtle(){
		AlgoMon bulbasaur = AlgoMonBuilder.crearBulbasaur();
		AlgoMon squirtle = AlgoMonBuilder.crearSquirtle();
		AlgoMon otroBulbasaur = AlgoMonBuilder.crearBulbasaur();
		AlgoMon tercerBulbasaur = AlgoMonBuilder.crearBulbasaur();
		Vitamina vitamina = new Vitamina();

		squirtle.recibirElemento(vitamina);
		int contador = 0;

		try{
			while(true){
				squirtle.atacar(NombreAtaque.BURBUJA, bulbasaur);
				contador++;
			}

		} catch(AtaqueAgotado e) {
			assertEquals(17, contador);
		}

		contador = 0;

		try{
			while(true){
				squirtle.atacar(NombreAtaque.CAÑONDEAGUA, otroBulbasaur);
				contador++;
			}

		} catch(AtaqueAgotado e) {
			assertEquals(10, contador);
		}

		contador = 0;

		try{
			while(true){
				
				squirtle.atacar(NombreAtaque.ATAQUERAPIDO, tercerBulbasaur);
				tercerBulbasaur.recibirEfecto(new AumentarVida(10));
				contador++;
			}

		} catch(AtaqueAgotado e) {
			assertEquals(18, contador);
		}

	}

	@Test
	public void test10VitaminaAumentaEn2LaCantidadDeTodosLosAtaquesDeBulbasaur(){
		AlgoMon bulbasaur = AlgoMonBuilder.crearBulbasaur();
		AlgoMon squirtle = AlgoMonBuilder.crearSquirtle();
		AlgoMon charmander = AlgoMonBuilder.crearCharmander();
		AlgoMon otroSquirtle = AlgoMonBuilder.crearSquirtle();
		Vitamina vitamina = new Vitamina();

		bulbasaur.recibirElemento(vitamina);
		int contador = 0;

		try{
			while(true){
				bulbasaur.atacar(NombreAtaque.CHUPAVIDAS, squirtle);
				squirtle.recibirEfecto(new AumentarVida(20));
				contador++;
			}

		} catch(AtaqueAgotado e) {
			assertEquals(10, contador);
		}

		contador = 0;

		try{
			while(true){
				bulbasaur.atacar(NombreAtaque.LATIGOCEPA, charmander);
				contador++;
			}

		} catch(AtaqueAgotado e) {
			assertEquals(12, contador);
		}

		contador = 0;

		try{
			while(true){
				bulbasaur.atacar(NombreAtaque.ATAQUERAPIDO, otroSquirtle);
				otroSquirtle.recibirEfecto(new AumentarVida(10));
				contador++;
			}

		} catch(AtaqueAgotado e) {
			assertEquals(18, contador);
		}

	}

	@Test
	public void test11VitaminaAumentaEn2LaCantidadDeTodosLosAtaquesDeJigglypuff(){
		AlgoMon jigglypuff = AlgoMonBuilder.crearJigglypuff();
		AlgoMon squirtle = AlgoMonBuilder.crearSquirtle();
		AlgoMon charmander = AlgoMonBuilder.crearCharmander();
		AlgoMon otroCharmarder = AlgoMonBuilder.crearCharmander();
		Vitamina vitamina = new Vitamina();

		jigglypuff.recibirElemento(vitamina);
		int contador = 0;

		try{
			while(true){
				jigglypuff.atacar(NombreAtaque.CANTO, charmander);
				contador++;
			}

		} catch(AtaqueAgotado e) {
			assertEquals(8, contador);
		}

		contador = 0;

		try{
			while(true){
				jigglypuff.atacar(NombreAtaque.BURBUJA, charmander);
				charmander.recibirEfecto(new AumentarVida(20));
				contador++;
			}

		} catch(AtaqueAgotado e) {
			assertEquals(17, contador);
		}

		contador = 0;

		while(otroCharmarder.estaVivo()){
			jigglypuff.atacar(NombreAtaque.ATAQUERAPIDO, otroCharmarder);
			contador++;
		}

		jigglypuff.atacar(NombreAtaque.ATAQUERAPIDO, squirtle);
		contador++;

		try{
			jigglypuff.atacar(NombreAtaque.BURBUJA, charmander);

		} catch(AtaqueAgotado e) {
			assertEquals(18, contador);
		}
	}

	@Test
	public void test12VitaminaAumentaEn2LaCantidadDeTodosLosAtaquesDeChansey(){
		AlgoMon chansey = AlgoMonBuilder.crearChansey();
		AlgoMon charmander = AlgoMonBuilder.crearCharmander();
		AlgoMon otroCharmander = AlgoMonBuilder.crearCharmander();
		Vitamina vitamina = new Vitamina();

		chansey.recibirElemento(vitamina);
		int contador = 0;

		try{
			while(true){
				chansey.atacar(NombreAtaque.CANTO, charmander);
				contador++;
			}

		} catch(AtaqueAgotado e) {
			assertEquals(8, contador);
		}

		contador = 0;

		try{
			while(true){
				chansey.atacar(NombreAtaque.LATIGOCEPA, charmander);
				contador++;
			}

		} catch(AtaqueAgotado e) {
			assertEquals(12, contador);
		}

		contador = 0;

		while(otroCharmander.estaVivo()){
			chansey.atacar(NombreAtaque.ATAQUERAPIDO, otroCharmander);
			contador++;
		}

		chansey.atacar(NombreAtaque.ATAQUERAPIDO, charmander);
		contador++;

		try{
			chansey.atacar(NombreAtaque.ATAQUERAPIDO, charmander);

		} catch(AtaqueAgotado e) {
			assertEquals(18, contador);
		}

	}

	@Test
	public void test13VitaminaAumentaEn2LaCantidadDeTodosLosAtaquesDeRattata(){
		AlgoMon rattata = AlgoMonBuilder.crearRattata();
		AlgoMon charmander = AlgoMonBuilder.crearCharmander();
		AlgoMon squirtle = AlgoMonBuilder.crearSquirtle();
		Vitamina vitamina = new Vitamina();

		rattata.recibirElemento(vitamina);
		int contador = 0;

		try{
			while(true){
				rattata.atacar(NombreAtaque.FOGONAZO, squirtle);
				contador++;
			}

		} catch(AtaqueAgotado e) {
			assertEquals(6, contador);
		}

		contador = 0;

		try{
			while(true){
				rattata.atacar(NombreAtaque.BURBUJA, squirtle);
				contador++;
			}

		} catch(AtaqueAgotado e) {
			assertEquals(17, contador);
		}

		contador = 0;

		while(charmander.estaVivo()){
			rattata.atacar(NombreAtaque.ATAQUERAPIDO, charmander);
			contador++;
		}

		rattata.atacar(NombreAtaque.ATAQUERAPIDO, squirtle);
		contador++;

		try{
			rattata.atacar(NombreAtaque.ATAQUERAPIDO, squirtle);

		} catch(AtaqueAgotado e) {
			assertEquals(18, contador);
		}
	}

}
