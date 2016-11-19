package test.fiuba.algo3.modelo;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import src.fiuba.algo3.modelo.efectos.EfectoMultiple;
import src.fiuba.algo3.modelo.efectos.Quemar;
import src.fiuba.algo3.modelo.efectos.QuitarVida;
import src.fiuba.algo3.modelo.efectos.SinEfecto;
import src.fiuba.algo3.modelo.estados.AlgoMonRecibeQuemadura;
import src.fiuba.algo3.modelo.estados.Estado;
import src.fiuba.algo3.modelo.estados.EstadoNormal;

public class EfectoMultipleTest {
	private EfectoMultiple efecto;

	@Test
	public void testAplicarQuitarVidaYQuemadoAplicaAmbos() {
		efecto= new EfectoMultiple();
		EstadoNormal estado = new EstadoNormal(170);
		Estado nuevoEstado;

		efecto.agregarEfecto(new QuitarVida(100));
		efecto.agregarEfecto(new Quemar());
		nuevoEstado = efecto.aplicar(estado);
		try{nuevoEstado.accionRealizada();}catch(AlgoMonRecibeQuemadura e){}

		assertEquals(estado.getVidaMaxima()-100-17,nuevoEstado.getVida(),0.01);
	}

	@Test
	public void testAplicarSinEfectoYQuitarVidaSoloQuitaVida() {
		efecto= new EfectoMultiple();
		Estado estado = new EstadoNormal(140);
		efecto.agregarEfecto(new SinEfecto());
		efecto.agregarEfecto(new QuitarVida(10));
		estado = efecto.aplicar(estado);
		estado.accionRealizada();

		assertEquals(estado.getVidaMaxima()-10,estado.getVida(),0.01);
	}

}
