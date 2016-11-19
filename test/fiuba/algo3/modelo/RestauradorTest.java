package test.fiuba.algo3.modelo;

import static org.junit.Assert.*;

import org.junit.Test;

import src.fiuba.algo3.modelo.AlgoMon;
import src.fiuba.algo3.modelo.AlgoMonBuilder;
import src.fiuba.algo3.modelo.ataques.NombreAtaque;
import src.fiuba.algo3.modelo.efectos.Dormir;
import src.fiuba.algo3.modelo.efectos.Quemar;
import src.fiuba.algo3.modelo.elementos.Restaurador;
import src.fiuba.algo3.modelo.estados.Quemado;
import src.fiuba.algo3.modelo.excepciones.AlgoMonDormidoNoPuedeAtacar;
import src.fiuba.algo3.modelo.excepciones.AlgoMonRecibeQuemadura;

public class RestauradorTest {
	private Restaurador restaurador;
	@Test
	public void testAplicarSobreQuemadoDejaDeEstarQuemado() {
		AlgoMon algomon = AlgoMonBuilder.crearCharmander();
		AlgoMon otroAlgomon = AlgoMonBuilder.crearCharmander();
		double vidaAnterior;
		restaurador = new Restaurador();
		algomon.recibirEfecto(new Quemar());
		try{algomon.atacar(NombreAtaque.ATAQUERAPIDO, otroAlgomon);} catch(AlgoMonRecibeQuemadura e){}
		vidaAnterior=algomon.getVida();
		assertEquals(algomon.getVidaMaxima()-Quemado.getVidaQuitada(algomon.getVidaMaxima()),vidaAnterior,0.01);
		restaurador.aplicar(algomon);
		algomon.atacar(NombreAtaque.ATAQUERAPIDO, otroAlgomon);
		assertEquals(vidaAnterior,algomon.getVida(),0.01);
	}
	
	@Test
	public void testAplicarSobreDormidoDejaDeEstarDormido() {
		AlgoMon algomon = AlgoMonBuilder.crearCharmander();
		AlgoMon otroAlgomon = AlgoMonBuilder.crearCharmander();
		restaurador = new Restaurador();
		algomon.recibirEfecto(new Dormir());
		try{algomon.atacar(NombreAtaque.ATAQUERAPIDO, otroAlgomon);}catch(AlgoMonDormidoNoPuedeAtacar e){}
		assertEquals(otroAlgomon.getVida(),otroAlgomon.getVidaMaxima(),0.01);
		
		restaurador.aplicar(algomon);
		algomon.atacar(NombreAtaque.ATAQUERAPIDO, otroAlgomon);
		assertEquals(otroAlgomon.getVidaMaxima()-10,otroAlgomon.getVida(),0.01);
	}
	
	@Test
	public void testAplicarSobreQuemadoYDormidoDejaDeEstarlo() {
		AlgoMon algomon = AlgoMonBuilder.crearCharmander();
		AlgoMon otroAlgomon = AlgoMonBuilder.crearCharmander();
		restaurador = new Restaurador();
		algomon.recibirEfecto(new Dormir());
		algomon.recibirEfecto(new Quemar());
		try{algomon.atacar(NombreAtaque.ATAQUERAPIDO, otroAlgomon);}catch(RuntimeException e){}
		assertEquals(otroAlgomon.getVida(),otroAlgomon.getVidaMaxima(),0.01);
		restaurador.aplicar(algomon);
		algomon.atacar(NombreAtaque.ATAQUERAPIDO, otroAlgomon);
		assertEquals(otroAlgomon.getVidaMaxima()-10,otroAlgomon.getVida(),0.01);
		assertEquals(algomon.getVidaMaxima()-Quemado.getVidaQuitada(algomon.getVidaMaxima()),algomon.getVida(),0.01);
	}

}
