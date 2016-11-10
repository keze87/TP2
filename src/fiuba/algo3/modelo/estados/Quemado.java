package src.fiuba.algo3.modelo.estados;

public final class Quemado extends EstadoAlterado {

	public Quemado(Estado estadoAnterior) {
		super.setEstadoAnterior(estadoAnterior);
		super.setVida(estadoAnterior.getVida());
	}

	@Override
	public boolean puedeRealizarAccion() {
		return super.getEstadoAnterior().puedeRealizarAccion();
	}

	@Override
	public void accionRealizada() {
		super.getEstadoAnterior().accionRealizada();
		super.quitarVida(super.getVidaMaxima() * 0.10);
	}

}
