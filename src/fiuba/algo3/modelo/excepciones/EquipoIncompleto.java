package src.fiuba.algo3.modelo.excepciones;

public class EquipoIncompleto extends RuntimeException {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	public EquipoIncompleto(String mensaje) {
		super(mensaje);
	}

}
