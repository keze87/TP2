package src.fiuba.algo3.modelo.estados;

public final class Quemado extends EstadoAlterado {
	private static double porcentajeVidaQuitada=0.10;

	public static double getPorcentajeVidaQuitada() {
		return porcentajeVidaQuitada;
	}
	public static double getVidaQuitada(double vidaMaxima) {
		return vidaMaxima * Quemado.getPorcentajeVidaQuitada();
	}

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
		this.quitarVida(this.vidaMaxima * Quemado.getPorcentajeVidaQuitada());
		throw new AlgoMonRecibeDañoQuemadura();
	}

}
