package src.fiuba.algo3.modelo.elementos;

public class StockSuperPociones extends StockElemento {

	public StockSuperPociones() {
		super(2);
		this.generador = new GeneradorSuperPociones();
	}

}
