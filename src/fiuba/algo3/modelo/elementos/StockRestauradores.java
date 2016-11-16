package src.fiuba.algo3.modelo.elementos;

public class StockRestauradores extends StockElemento {

	public StockRestauradores() {
		super(3);
		this.generador = new GeneradorRestauradores();
	}

}
