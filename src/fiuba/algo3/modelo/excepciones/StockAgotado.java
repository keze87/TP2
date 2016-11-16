package src.fiuba.algo3.modelo.excepciones;

public class StockAgotado extends RuntimeException {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	public StockAgotado(String mensaje) {
		super(mensaje);
	}

}
