package src.fiuba.algo3.modelo;

public class StockPociones extends StockElemento {

	public StockPociones() {
		super(4);
		this.generador = new GeneradorPociones();
	}

}
