package fiuba.algo3.modelo;

public final class Dormido extends EstadoAlterado {
	private int turnosRestantes;
	public Dormido(Estado estadoAnterior){
		super.setEstadoAnterior(estadoAnterior);
		turnosRestantes=3;
	}
	@Override
	public boolean puedeRealizarAccion() {
		return turnosRestantes==0&&super.getEstadoAnterior().puedeRealizarAccion();
	}

	@Override
	public void accionRealizada() {
		super.getEstadoAnterior().accionRealizada();
		turnosRestantes--;
	}

}
