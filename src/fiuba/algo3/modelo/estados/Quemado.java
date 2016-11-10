package src.fiuba.algo3.modelo.estados;

public final class Quemado extends EstadoAlterado {

	public Quemado(Estado estadoAnterior) {
		this.estadoAnterior = estadoAnterior;
		this.vida = estadoAnterior.getVida();
		this.vidaMaxima = estadoAnterior.getVidaMaxima();
	}

	@Override
	public boolean puedeRealizarAccion() {
		return this.getEstadoAnterior().puedeRealizarAccion();
	}

	@Override
	public void accionRealizada() {
		this.getEstadoAnterior().accionRealizada();
		this.quitarVida(this.vidaMaxima * 0.10);
	}

}
