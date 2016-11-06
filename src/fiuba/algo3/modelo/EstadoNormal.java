package fiuba.algo3.modelo;

public final class EstadoNormal extends Estado {

	public EstadoNormal(int vida){
		super.setVida(vida);
	}
	@Override
	public boolean puedeRealizarAccion() {
		return true;
	}

	@Override
	public void accionRealizada() {
	}

}
