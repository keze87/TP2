package src.fiuba.algo3.modelo.estados;

public final class EstadoNormal extends Estado {

	public EstadoNormal(double vidaMaxima) {
		super(vidaMaxima);
	}

	public EstadoNormal(double vidaMaxima, double vida) {
		this.vidaMaxima = vidaMaxima;
		this.vida = vida;
	}

	@Override
	public boolean puedeRealizarAccion() {
		return true;
	}

	@Override
	public void accionRealizada() {
	}

}
