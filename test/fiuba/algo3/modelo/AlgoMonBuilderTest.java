package test.fiuba.algo3.modelo;

import static org.junit.Assert.*;
import org.junit.Test;
import src.fiuba.algo3.modelo.*;

public class AlgoMonBuilderTest { // TODO: faltan los ataques

	AlgoMon algomon;

	@Test
	public void testCrearBulbasaur() {

		algomon = AlgoMonBuilder.crearBulbasaur();

		assertTrue( algomon.nombre().equals("Bulbasaur") );
		assertEquals( 140, algomon.getVida(), 0 );

	}

	@Test
	public void testCrearChansey() {

		algomon = AlgoMonBuilder.crearChansey();

		assertTrue( algomon.nombre().equals("Chansey") );
		assertEquals( 130, algomon.getVida(), 0 );

	}

	@Test
	public void testCrearCharmander() {

		algomon = AlgoMonBuilder.crearCharmander();

		assertTrue( algomon.nombre().equals("Charmander") );
		assertEquals( 170, algomon.getVida(), 0 );

	}

	@Test
	public void testCrearJigglypuff() {

		algomon = AlgoMonBuilder.crearJigglypuff();

		assertTrue( algomon.nombre().equals("Jigglypuff") );
		assertEquals( 130, algomon.getVida(), 0 );

	}

	@Test
	public void testCrearRattata() {

		algomon = AlgoMonBuilder.crearRattata();

		assertTrue( algomon.nombre().equals("Rattata") );
		assertEquals( 170, algomon.getVida(), 0 );

	}

	@Test
	public void testCrearSquirtle() {

		algomon = AlgoMonBuilder.crearSquirtle();

		assertTrue( algomon.nombre().equals("Squirtle") );
		assertEquals( 150, algomon.getVida(), 0 );

	}

}
