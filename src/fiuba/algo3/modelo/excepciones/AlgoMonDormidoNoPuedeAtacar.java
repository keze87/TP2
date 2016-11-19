package src.fiuba.algo3.modelo.excepciones;

public class AlgoMonDormidoNoPuedeAtacar extends RuntimeException {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	public AlgoMonDormidoNoPuedeAtacar() {
		super();
	}

	public AlgoMonDormidoNoPuedeAtacar(String mensaje) {
		super(mensaje);
	}
}
