package src.fiuba.algo3.modelo.efectos;

import src.fiuba.algo3.modelo.estados.Estado;

public abstract class Efecto {
	private double vidaQuitadaAlOponente;
	public void setVidaQuitadaAlOponente(double vidaQuitadaAlOponente) {
		this.vidaQuitadaAlOponente = vidaQuitadaAlOponente;
	}
	
	public double getVidaQuitadaAlOponente() {
		return vidaQuitadaAlOponente;
	}
	public abstract Estado aplicar(Estado estado);
}
