package test.fiuba.algo3.modelo;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import src.fiuba.algo3.modelo.tipo.Agua;
import src.fiuba.algo3.modelo.tipo.EfectividadTipo;
import src.fiuba.algo3.modelo.tipo.Fuego;
import src.fiuba.algo3.modelo.tipo.Normal;
import src.fiuba.algo3.modelo.tipo.Planta;
import src.fiuba.algo3.modelo.tipo.Tipo;

public class TipoTests {

	@Test
	public void test01MultiplicadoresTipoFuego() {
		Tipo fuego = new Fuego();
		Tipo otroFuego = new Fuego();
		Tipo agua = new Agua();
		Tipo planta = new Planta();
		Tipo normal = new Normal();

		assertEquals(EfectividadTipo.POCOEFECTIVO, fuego.getMultiplicadorContra(otroFuego));
		assertEquals(EfectividadTipo.POCOEFECTIVO, fuego.getMultiplicadorContra(agua));
		assertEquals(EfectividadTipo.SUPEREFECTIVO, fuego.getMultiplicadorContra(planta));
		assertEquals(EfectividadTipo.NORMAL, fuego.getMultiplicadorContra(normal));
	}

	@Test
	public void test02MultiplicadoresTipoAgua() {
		Tipo fuego = new Fuego();
		Tipo agua = new Agua();
		Tipo otroAgua = new Agua();
		Tipo planta = new Planta();
		Tipo normal = new Normal();


		assertEquals(EfectividadTipo.SUPEREFECTIVO, agua.getMultiplicadorContra(fuego));
		assertEquals(EfectividadTipo.POCOEFECTIVO, agua.getMultiplicadorContra(otroAgua));
		assertEquals(EfectividadTipo.POCOEFECTIVO, agua.getMultiplicadorContra(planta));
		assertEquals(EfectividadTipo.NORMAL, agua.getMultiplicadorContra(normal));
	}

	@Test
	public void test03MultiplicadoresTipoPlanta() {
		Tipo fuego = new Fuego();
		Tipo agua = new Agua();
		Tipo planta = new Planta();
		Tipo otroPlanta = new Planta();
		Tipo normal = new Normal();

		assertEquals(EfectividadTipo.POCOEFECTIVO, planta.getMultiplicadorContra(fuego));
		assertEquals(EfectividadTipo.SUPEREFECTIVO, planta.getMultiplicadorContra(agua));
		assertEquals(EfectividadTipo.POCOEFECTIVO, planta.getMultiplicadorContra(otroPlanta));
		assertEquals(EfectividadTipo.NORMAL, planta.getMultiplicadorContra(normal));
	}

	@Test
	public void test04MultiplicadoresTipoNormal() {
		Tipo fuego = new Fuego();
		Tipo agua = new Agua();
		Tipo planta = new Planta();
		Tipo normal = new Normal();
		Tipo otroNormal = new Normal();

		assertEquals(EfectividadTipo.NORMAL, normal.getMultiplicadorContra(fuego));
		assertEquals(EfectividadTipo.NORMAL, normal.getMultiplicadorContra(agua));
		assertEquals(EfectividadTipo.NORMAL, normal.getMultiplicadorContra(planta));
		assertEquals(EfectividadTipo.NORMAL, normal.getMultiplicadorContra(otroNormal));
	}

}
