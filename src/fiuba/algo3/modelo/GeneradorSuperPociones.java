package src.fiuba.algo3.modelo;

import src.fiuba.algo3.modelo.elementos.Elemento;
import src.fiuba.algo3.modelo.elementos.SuperPocion;

public class GeneradorSuperPociones implements GeneradorElemento {

	@Override
	public Elemento generarElemento() {
		return new SuperPocion();
	}

}
