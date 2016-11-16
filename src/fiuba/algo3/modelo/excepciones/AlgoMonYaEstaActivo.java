package src.fiuba.algo3.modelo.excepciones;

public class AlgoMonYaEstaActivo extends RuntimeException {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	public AlgoMonYaEstaActivo(String mensaje) {
		super(mensaje);
	}

}
