package test.fiuba.algo3.modelo;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import src.fiuba.algo3.modelo.Agua;
import src.fiuba.algo3.modelo.Fuego;
import src.fiuba.algo3.modelo.Normal;
import src.fiuba.algo3.modelo.Planta;
import src.fiuba.algo3.modelo.Tipo;

public class TipoTests {

	@Test
	public void test01MultiplicadoresTipoFuego() {
		Tipo fuego = new Fuego();
		Tipo otroFuego = new Fuego();
		Tipo agua = new Agua();
		Tipo planta = new Planta();
		Tipo normal = new Normal();

		assertEquals(0.5f, fuego.getMultiplicadorContra(otroFuego), 0.0001D);
		assertEquals(0.5f, fuego.getMultiplicadorContra(agua), 0.0001D);
		assertEquals(2f, fuego.getMultiplicadorContra(planta), 0.0001D);
		assertEquals(1f, fuego.getMultiplicadorContra(normal), 0.0001D);
	}

	@Test
	public void test02MultiplicadoresTipoAgua() {
		Tipo fuego = new Fuego();
		Tipo agua = new Agua();
		Tipo otroAgua = new Agua();
		Tipo planta = new Planta();
		Tipo normal = new Normal();


		assertEquals(2f, agua.getMultiplicadorContra(fuego), 0.0001D);
		assertEquals(0.5f, agua.getMultiplicadorContra(otroAgua), 0.0001D);
		assertEquals(0.5f, agua.getMultiplicadorContra(planta), 0.0001D);
		assertEquals(1f, agua.getMultiplicadorContra(normal), 0.0001D);
	}

	@Test
	public void test03MultiplicadoresTipoPlanta() {
		Tipo fuego = new Fuego();
		Tipo agua = new Agua();
		Tipo planta = new Planta();
		Tipo otroPlanta = new Planta();
		Tipo normal = new Normal();

		assertEquals(0.5f, planta.getMultiplicadorContra(fuego), 0.0001D);
		assertEquals(2f, planta.getMultiplicadorContra(agua), 0.0001D);
		assertEquals(0.5f, planta.getMultiplicadorContra(otroPlanta), 0.0001D);
		assertEquals(1f, planta.getMultiplicadorContra(normal), 0.0001D);
	}

	@Test
	public void test04MultiplicadoresTipoNormal() {
		Tipo fuego = new Fuego();
		Tipo agua = new Agua();
		Tipo planta = new Planta();
		Tipo normal = new Normal();
		Tipo otroNormal = new Normal();

		assertEquals(1f, normal.getMultiplicadorContra(fuego), 0.0001D);
		assertEquals(1f, normal.getMultiplicadorContra(agua), 0.0001D);
		assertEquals(1f, normal.getMultiplicadorContra(planta), 0.0001D);
		assertEquals(1f, normal.getMultiplicadorContra(otroNormal), 0.0001D);
	}

}
