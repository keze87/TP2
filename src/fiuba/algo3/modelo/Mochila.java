package src.fiuba.algo3.modelo;

import src.fiuba.algo3.modelo.elementos.Elemento;
import src.fiuba.algo3.modelo.elementos.StockElemento;
import src.fiuba.algo3.modelo.elementos.StockPociones;
import src.fiuba.algo3.modelo.elementos.StockRestauradores;
import src.fiuba.algo3.modelo.elementos.StockSuperPociones;
import src.fiuba.algo3.modelo.elementos.StockVitaminas;

public class Mochila {

	private StockElemento pociones;
	private StockElemento superPociones;
	private StockElemento restauradores;
	private StockElemento vitaminas;

	public Mochila() {
		this.pociones = new StockPociones();
		this.superPociones = new StockSuperPociones();
		this.restauradores = new StockRestauradores();
		this.vitaminas = new StockVitaminas();
	}

	/* Devuelve una poción del stock de pociones. */
	public Elemento getPocion() {
		return this.pociones.getElemento();
	}

	/* Devuelve una superpoción del stock de superpociones. */
	public Elemento getSuperPocion() {
		return this.superPociones.getElemento();
	}

	/* Devuelve un restaurador del stock de restauradores. */
	public Elemento getRestaurador() {
		return this.restauradores.getElemento();
	}

	/* Devuelve una vitamina del stock de vitamina, */
	public Elemento getVitamina() {
		return this.vitaminas.getElemento();
	}
}
