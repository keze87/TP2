package src.fiuba.algo3.modelo.excepciones;

public class AtaqueAgotado extends RuntimeException {

	private static final long serialVersionUID = 5613242410037188327L;

	public AtaqueAgotado(String mensaje) {
		super(mensaje);
	}

}
