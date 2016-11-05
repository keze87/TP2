package src.fiuba.algo3.modelo;

public class AtaqueAgotado extends RuntimeException {

	private static final long serialVersionUID = 5613242410037188327L;

	public AtaqueAgotado() {
		super();
	}

	public AtaqueAgotado(String mensaje) {
		super(mensaje);
	}

}
