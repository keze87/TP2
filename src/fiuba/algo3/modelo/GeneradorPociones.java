package src.fiuba.algo3.modelo;

import src.fiuba.algo3.modelo.elementos.Elemento;
import src.fiuba.algo3.modelo.elementos.Pocion;

public class GeneradorPociones implements GeneradorElemento {

	@Override
	public Elemento generarElemento() {
		return new Pocion();
	}

}
