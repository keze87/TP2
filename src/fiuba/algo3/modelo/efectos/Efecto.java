package src.fiuba.algo3.modelo.efectos;

import src.fiuba.algo3.modelo.estados.Estado;

public abstract class Efecto {
	private double vidaQuitadaAlOponente;

	/* Establece el valor de this.vidaQuitadaAlOponente. */
	public void setVidaQuitadaAlOponente(double vidaQuitadaAlOponente) {
		this.vidaQuitadaAlOponente = vidaQuitadaAlOponente;
	}

	/* Devuelve el valor de this.vidaQuitadaAlOponente. */
	public double getVidaQuitadaAlOponente() {
		return vidaQuitadaAlOponente;
	}

	/**
	 * Aplica el efecto a un estado.
	 * @param estado estado a modificar.
	 * @return el estado actualizado.
	 */
	public abstract Estado aplicar(Estado estado);

}
