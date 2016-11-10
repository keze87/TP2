package src.fiuba.algo3.modelo.estados;

public final class Quemado extends EstadoAlterado {

	public Quemado(Estado estadoAnterior) {
		this.setEstadoAnterior(estadoAnterior);
		this.setVida(estadoAnterior.getVida());
	}

	@Override
	public boolean puedeRealizarAccion() {
		return this.getEstadoAnterior().puedeRealizarAccion();
	}

	@Override
	public void accionRealizada() {
		this.getEstadoAnterior().accionRealizada();
		this.quitarVida(this.getVida() * 0.10);
	}

}
