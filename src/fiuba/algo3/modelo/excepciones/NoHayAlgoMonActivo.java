package src.fiuba.algo3.modelo.excepciones;

public class NoHayAlgoMonActivo extends RuntimeException {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	public NoHayAlgoMonActivo(String mensaje) {
		super(mensaje);
	}

}
