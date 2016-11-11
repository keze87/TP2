package src.fiuba.algo3.modelo.estados;

public final class Dormido extends EstadoAlterado {
	private static int turnosDormido = 3;
	
	public static int getTurnosDormido() {
		return turnosDormido;
	}

	private int turnosRestantes;

	public Dormido(Estado estadoAnterior) {
		this.estadoAnterior = estadoAnterior;
		this.vida = estadoAnterior.getVida();
		this.vidaMaxima = estadoAnterior.getVidaMaxima();
		this.turnosRestantes = Dormido.getTurnosDormido();
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

	/* Devuelve la cantidad de turnos para los que el estado corresponde
	 * a estar dormido. */
	public int getTurnosRestantesDormido() {
		return this.turnosRestantes;
	}


}
