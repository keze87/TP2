package src.fiuba.algo3.modelo;

import src.fiuba.algo3.modelo.elementos.Elemento;
import src.fiuba.algo3.modelo.elementos.Restaurador;

public class GeneradorRestauradores implements GeneradorElemento {

	@Override
	public Elemento generarElemento() {
		return new Restaurador();
	}

}
