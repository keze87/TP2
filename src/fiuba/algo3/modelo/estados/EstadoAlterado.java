package src.fiuba.algo3.modelo.estados;

public abstract class EstadoAlterado extends Estado {
	protected Estado estadoAnterior;

	protected Estado getEstadoAnterior() {
		return estadoAnterior;
	}

	/**
	 * Establece el estado anterior.
	 * @param estadoAnterior valor del estado anterior.
	 */
	protected void setEstadoAnterior(Estado estadoAnterior) {
		this.estadoAnterior = estadoAnterior;
	}

	/**
	 * Cambia el estado al estado anterior.
	 * @return el estado anterior.
	 */
	public Estado volverEstadoAnterior() {
		estadoAnterior.setVida(super.getVida());
		return estadoAnterior;
	}

}
