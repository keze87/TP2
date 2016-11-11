package src.fiuba.algo3.modelo.excepciones;

public class AlgoMonNoTieneAtaque extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public AlgoMonNoTieneAtaque(String mensaje) {
		super(mensaje);
	}

}
