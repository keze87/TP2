package test.fiuba.algo3.modelo;

import static org.junit.Assert.*;
import org.junit.Test;
import src.fiuba.algo3.modelo.*;

public class AlgoMonBuilderTest {

	AlgoMon algomon;

	@Test
	public void testCrearBulbasaur() {

		algomon = AlgoMonBuilder.crearBulbasaur();

		assertTrue( algomon.nombre().equals("Bulbasaur") );
		assertEquals( 140, algomon.getVida(), 0 );

		assertTrue( algomon instanceof AlgoMonPlanta );
		assertTrue( algomon.ataque1().nombre().equals("Chupavidas") );
		assertTrue( algomon.ataque2().nombre().equals("Látigo cepa") );
		assertTrue( algomon.ataque3().nombre().equals("Ataque Rápido") );

	}

	@Test
	public void testCrearChansey() {

		algomon = AlgoMonBuilder.crearChansey();

		assertTrue( algomon.nombre().equals("Chansey") );
		assertEquals( 130, algomon.getVida(), 0 );

		assertTrue( algomon instanceof AlgoMonNormal );
		assertTrue( algomon.ataque1().nombre().equals("Canto") );
		assertTrue( algomon.ataque2().nombre().equals("Látigo cepa") );
		assertTrue( algomon.ataque3().nombre().equals("Ataque Rápido") );

	}

	@Test
	public void testCrearCharmander() {

		algomon = AlgoMonBuilder.crearCharmander();

		assertTrue( algomon.nombre().equals("Charmander") );
		assertEquals( 170, algomon.getVida(), 0 );

		assertTrue( algomon instanceof AlgoMonFuego );
		assertTrue( algomon.ataque1().nombre().equals("Brasas") );
		assertTrue( algomon.ataque2().nombre().equals("Fogonazo") );
		assertTrue( algomon.ataque3().nombre().equals("Ataque Rápido") );

	}

	@Test
	public void testCrearJigglypuff() {

		algomon = AlgoMonBuilder.crearJigglypuff();

		assertTrue( algomon.nombre().equals("Jigglypuff") );
		assertEquals( 130, algomon.getVida(), 0 );

		assertTrue( algomon instanceof AlgoMonNormal );
		assertTrue( algomon.ataque1().nombre().equals("Canto") );
		assertTrue( algomon.ataque2().nombre().equals("Burbuja") );
		assertTrue( algomon.ataque3().nombre().equals("Ataque Rápido") );

	}

	@Test
	public void testCrearRattata() {

		algomon = AlgoMonBuilder.crearRattata();

		assertTrue( algomon.nombre().equals("Rattata") );
		assertEquals( 170, algomon.getVida(), 0 );

		assertTrue( algomon instanceof AlgoMonNormal );
		assertTrue( algomon.ataque1().nombre().equals("Fogonazo") );
		assertTrue( algomon.ataque2().nombre().equals("Burbuja") );
		assertTrue( algomon.ataque3().nombre().equals("Ataque Rápido") );

	}

	@Test
	public void testCrearSquirtle() {

		algomon = AlgoMonBuilder.crearSquirtle();

		assertTrue( algomon.nombre().equals("Squirtle") );
		assertEquals( 150, algomon.getVida(), 0 );

		assertTrue( algomon instanceof AlgoMonAgua );
		assertTrue( algomon.ataque1().nombre().equals("Burbuja") );
		assertTrue( algomon.ataque2().nombre().equals("Cañón de agua") );
		assertTrue( algomon.ataque3().nombre().equals("Ataque Rápido") );

	}

}
