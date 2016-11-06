package src.fiuba.algo3.modelo.estados;

public final class Dormido extends EstadoAlterado {
	private int turnosRestantes;

	public Dormido(Estado estadoAnterior) {
		super.setEstadoAnterior(estadoAnterior);
		super.setVida(estadoAnterior.getVida());
		turnosRestantes = 3;
	}

	@Override
	public boolean puedeRealizarAccion() {
		return turnosRestantes == 0 && super.getEstadoAnterior().puedeRealizarAccion();
	}

	@Override
	public void accionRealizada() {
		super.getEstadoAnterior().accionRealizada();
		turnosRestantes--;
	}

	public int getTurnosRestantesDormido() {
		return turnosRestantes;
	}

}
