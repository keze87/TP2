package fiuba.algo3.modelo;

public final class Quemado extends EstadoAlterado {
	public Quemado(Estado estadoAnterior){
		super.setEstadoAnterior(estadoAnterior);
		super.setVida(estadoAnterior.getVida());
	}
	@Override
	public boolean puedeRealizarAccion() {
		return true&&super.getEstadoAnterior().puedeRealizarAccion();
	}

	@Override
	public void accionRealizada() {
		super.getEstadoAnterior().accionRealizada();
		super.quitarVida(super.getVida()*0.10);
	}

}
