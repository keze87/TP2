package src.fiuba.algo3.modelo.elementos;

import java.util.HashMap;
import java.util.Map;

public class Mochila {

	private Map<NombreElemento, StockElemento> elementos;

	public Mochila() {
		this.elementos = new HashMap<NombreElemento, StockElemento>();
		this.elementos.put(NombreElemento.POCION, new StockPociones());
		this.elementos.put(NombreElemento.SUPERPOCION, new StockSuperPociones());
		this.elementos.put(NombreElemento.RESTAURADOR, new StockRestauradores());
		this.elementos.put(NombreElemento.VITAMINA, new StockVitaminas());
	}

	/**
	 * Devuelve una nueva instancia de un elemento.
	 * @param nombreElemento nombre del elemento.
	 * @return una instancia Elemento correspondiente al nombre.
	 */
	public Elemento getElemento(NombreElemento nombreElemento) {
		return this.elementos.get(nombreElemento).getElemento();
	}

	/**
	 * Devuelve la cantidad restante de un elemento.
	 * @param nombreElemento nombre del elemento.
	 * @return la cantidad restante.
	 */
	public int getCantidadRestanteElemento(NombreElemento nombreElemento) {
		return this.elementos.get(nombreElemento).getCantidadRestante();
	}

	/**
	 * Devuelve la cantidad total de un elemento.
	 * @param nombreElemento nombre del elemento.
	 * @return la cantidad total.
	 */
	public int getCantidadTotalElemento(NombreElemento nombreElemento) {
		return this.elementos.get(nombreElemento).getCantidadTotal();
	}

}
