package src.fiuba.algo3.modelo.excepciones;

public class JuegoTerminado extends RuntimeException {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	public JuegoTerminado(String mensaje) {
		super(mensaje);
	}

}
