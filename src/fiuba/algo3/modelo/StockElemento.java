package src.fiuba.algo3.modelo;

import src.fiuba.algo3.modelo.elementos.Elemento;
import src.fiuba.algo3.modelo.excepciones.StockAgotado;

public abstract class StockElemento {

	protected GeneradorElemento generador;
	protected int cantidadRestante;

	public StockElemento(int cantidadTotal) {
		this.cantidadRestante = cantidadTotal;
	}

	public Elemento getElemento() {
		if(!this.validarExistencia()) {
			throw new StockAgotado("No queda más stock de este elemento!");
		}

		this.cantidadRestante--;
		return this.generador.generarElemento();
	}

	protected boolean validarExistencia() {
		return this.cantidadRestante > 0;
	}

}
