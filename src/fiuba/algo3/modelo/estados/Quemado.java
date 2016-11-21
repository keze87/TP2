package src.fiuba.algo3.modelo.estados;

import src.fiuba.algo3.modelo.excepciones.AlgoMonMurio;
import src.fiuba.algo3.modelo.excepciones.AlgoMonMurioPorQuemadura;
import src.fiuba.algo3.modelo.excepciones.AlgoMonRecibeDañoQuemadura;

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

		try {
			this.quitarVida((int) (this.vidaMaxima * Quemado.getPorcentajeVidaQuitada()));
			throw new AlgoMonRecibeDañoQuemadura(/*"¡El algoMon recibe daño de la quemadura!"*/);
		} catch(AlgoMonMurio e) {
			throw new AlgoMonMurioPorQuemadura();
		}
	}

}
