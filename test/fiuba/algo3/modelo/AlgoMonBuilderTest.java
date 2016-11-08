package test.fiuba.algo3.modelo;

import static org.junit.Assert.*;
import org.junit.Test;
import src.fiuba.algo3.modelo.*;

public class AlgoMonBuilderTest {

	AlgoMon algomon;

	@Test
	public void testCrearBulbasaur() {

		algomon = AlgoMonBuilder.crearBulbasaur();

		assertTrue( algomon.getNombre().equals("Bulbasaur") );
		assertEquals( 140, algomon.getVida(), 0 );

		assertTrue( algomon.getTipo() instanceof Planta );
		assertTrue( algomon.contieneAtaque("Chupavidas") );
		assertTrue( algomon.contieneAtaque("Látigo cepa") );
		assertTrue( algomon.contieneAtaque("Ataque rápido") );

	}

	@Test
	public void testCrearChansey() {

		algomon = AlgoMonBuilder.crearChansey();

		assertTrue( algomon.getNombre().equals("Chansey") );
		assertEquals( 130, algomon.getVida(), 0 );

		assertTrue( algomon.getTipo() instanceof Normal );
		assertTrue( algomon.contieneAtaque("Canto") );
		assertTrue( algomon.contieneAtaque("Látigo cepa") );
		assertTrue( algomon.contieneAtaque("Ataque rápido") );

	}

	@Test
	public void testCrearCharmander() {

		algomon = AlgoMonBuilder.crearCharmander();

		assertTrue( algomon.getNombre().equals("Charmander") );
		assertEquals( 170, algomon.getVida(), 0 );

		assertTrue( algomon.getTipo() instanceof Fuego );
		assertTrue( algomon.contieneAtaque("Brasas") );
		assertTrue( algomon.contieneAtaque("Fogonazo") );
		assertTrue( algomon.contieneAtaque("Ataque rápido") );

	}

	@Test
	public void testCrearJigglypuff() {

		algomon = AlgoMonBuilder.crearJigglypuff();

		assertTrue( algomon.getNombre().equals("Jigglypuff") );
		assertEquals( 130, algomon.getVida(), 0 );

		assertTrue( algomon.getTipo() instanceof Normal );
		assertTrue( algomon.contieneAtaque("Canto") );
		assertTrue( algomon.contieneAtaque("Burbuja") );
		assertTrue( algomon.contieneAtaque("Ataque rápido") );

	}

	@Test
	public void testCrearRattata() {

		algomon = AlgoMonBuilder.crearRattata();

		assertTrue( algomon.getNombre().equals("Rattata") );
		assertEquals( 170, algomon.getVida(), 0 );

		assertTrue( algomon.getTipo() instanceof Normal );
		assertTrue( algomon.contieneAtaque("Fogonazo") );
		assertTrue( algomon.contieneAtaque("Burbuja") );
		assertTrue( algomon.contieneAtaque("Ataque rápido") );

	}

	@Test
	public void testCrearSquirtle() {

		algomon = AlgoMonBuilder.crearSquirtle();

		assertTrue( algomon.getNombre().equals("Squirtle") );
		assertEquals( 150, algomon.getVida(), 0 );

		assertTrue( algomon.getTipo() instanceof Agua );
		assertTrue( algomon.contieneAtaque("Burbuja") );
		assertTrue( algomon.contieneAtaque("Cañón de agua") );
		assertTrue( algomon.contieneAtaque("Ataque rápido") );

	}

}
