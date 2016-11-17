package src.fiuba.algo3.modelo;

import java.util.HashMap;
import java.util.Map;

import src.fiuba.algo3.modelo.elementos.Elemento;
import src.fiuba.algo3.modelo.elementos.NombreElemento;
import src.fiuba.algo3.modelo.elementos.StockElemento;
import src.fiuba.algo3.modelo.elementos.StockPociones;
import src.fiuba.algo3.modelo.elementos.StockRestauradores;
import src.fiuba.algo3.modelo.elementos.StockSuperPociones;
import src.fiuba.algo3.modelo.elementos.StockVitaminas;

public class Mochila {

	private Map<NombreElemento, StockElemento> elementos;

	public Mochila() {
		this.elementos = new HashMap<NombreElemento, StockElemento>();
		this.elementos.put(NombreElemento.POCION, new StockPociones());
		this.elementos.put(NombreElemento.SUPERPOCION, new StockSuperPociones());
		this.elementos.put(NombreElemento.RESTAURADOR, new StockRestauradores());
		this.elementos.put(NombreElemento.VITAMINA, new StockVitaminas());
	}

	public Elemento getElemento(NombreElemento nombreElemento) {
		return this.elementos.get(nombreElemento).getElemento();
	}
}
