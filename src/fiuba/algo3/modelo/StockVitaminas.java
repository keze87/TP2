package src.fiuba.algo3.modelo;

public class StockVitaminas extends StockElemento {

	public StockVitaminas() {
		super(5);
		this.generador = new GeneradorVitaminas();
	}

}
