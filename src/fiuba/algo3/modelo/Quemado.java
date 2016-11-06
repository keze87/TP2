package fiuba.algo3.modelo;

public final class Quemado extends EstadoAlterado {
	public Quemado(Estado estadoAnterior){
		super.setEstadoAnterior(estadoAnterior);
	}
	@Override
	public boolean puedeRealizarAccion() {
		// TODO Auto-generated method stub
		return true&&super.getEstadoAnterior().puedeRealizarAccion();
	}

	@Override
	public void accionRealizada() {
		super.getEstadoAnterior().accionRealizada();
		super.quitarVida(super.getVida()*0.10);
	}

}
