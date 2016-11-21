package src.fiuba.algo3.modelo.elementos;

import src.fiuba.algo3.modelo.excepciones.StockAgotado;

public abstract class StockElemento {

	protected GeneradorElemento generador;
	protected int cantidadTotal;
	protected int cantidadRestante;

	public StockElemento(int cantidadTotal) {
		this.cantidadTotal = cantidadTotal;
		this.cantidadRestante = cantidadTotal;
	}

	/* Devuelve una nueva instancia de Elemento siempre y cuando
	 * cantidadRestante sea mayor que cero. Sino lanza una excepción.
	 */
	public Elemento getElemento() {
		if(!this.validarExistencia()) {
			throw new StockAgotado("¡No queda más stock de este elemento!");
		}

		this.cantidadRestante--;
		return this.generador.generarElemento();
	}

	/* Determina si quedan elementos en el stock. */
	protected boolean validarExistencia() {
		return this.cantidadRestante > 0;
	}

	/* Devuelve la cantidad restante. */
	public int getCantidadRestante() {
		return this.cantidadRestante;
	}

	/* Devuelve la cantidad total. */
	public int getCantidadTotal() {
		return this.cantidadTotal;
	}

}
