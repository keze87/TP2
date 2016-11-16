package src.fiuba.algo3.modelo;

import src.fiuba.algo3.modelo.elementos.Elemento;
import src.fiuba.algo3.modelo.elementos.Vitamina;

public class GeneradorVitaminas implements GeneradorElemento {

	@Override
	public Elemento generarElemento() {
		return new Vitamina();
	}

}
