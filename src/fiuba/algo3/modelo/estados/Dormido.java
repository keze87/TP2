package src.fiuba.algo3.modelo.estados;

public final class Dormido extends EstadoAlterado {
	private int turnosRestantes;

	public Dormido(Estado estadoAnterior) {
		this.setEstadoAnterior(estadoAnterior);
		this.setVida(estadoAnterior.getVida());
		this.turnosRestantes = 3;
	}

	@Override
	public boolean puedeRealizarAccion() {
		return this.turnosRestantes == 0 && this.getEstadoAnterior().puedeRealizarAccion();
	}

	@Override
	public void accionRealizada() {
		this.getEstadoAnterior().accionRealizada();
		this.turnosRestantes--;
	}

	public int getTurnosRestantesDormido() {
		return this.turnosRestantes;
	}

}
