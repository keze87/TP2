package src.fiuba.algo3.modelo;

import src.fiuba.algo3.modelo.elementos.Elemento;

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

	public Elemento getPocion() {
		return this.pociones.getElemento();
	}

	public Elemento getSuperPocion() {
		return this.superPociones.getElemento();
	}

	public Elemento getRestaurador() {
		return this.restauradores.getElemento();
	}

	public Elemento getVitamina() {
		return this.vitaminas.getElemento();
	}
}
