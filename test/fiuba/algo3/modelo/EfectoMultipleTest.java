package test.fiuba.algo3.modelo;

import static org.junit.Assert.*;

import org.junit.Test;

import src.fiuba.algo3.modelo.efectos.EfectoMultiple;
import src.fiuba.algo3.modelo.efectos.Quemar;
import src.fiuba.algo3.modelo.efectos.QuitarVida;
import src.fiuba.algo3.modelo.estados.Estado;
import src.fiuba.algo3.modelo.estados.EstadoNormal;

public class EfectoMultipleTest {
	private EfectoMultiple efecto;
	@Test
	public void testAplicar() {
		efecto= new EfectoMultiple();
		EstadoNormal estado = new EstadoNormal(170);
		Estado nuevoEstado;

		efecto.agregarEfecto(new QuitarVida(100));
		efecto.agregarEfecto(new Quemar());
		nuevoEstado = efecto.aplicar(estado);
		nuevoEstado.accionRealizada();
		
		assertEquals(63,nuevoEstado.getVida(),0.01);
		
		
	}

}