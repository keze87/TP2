package src.fiuba.algo3.modelo.estados;

public final class EstadoNormal extends Estado {

	public EstadoNormal(double d) {
		super.setVida(d);
		super.setVidaMaxima(d);
	}

	@Override
	public boolean puedeRealizarAccion() {
		return true;
	}

	@Override
	public void accionRealizada() {
	}

}
