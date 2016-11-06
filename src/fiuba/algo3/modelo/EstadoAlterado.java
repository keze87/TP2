package fiuba.algo3.modelo;

public abstract class EstadoAlterado extends Estado {
	private Estado estadoAnterior;
	protected Estado getEstadoAnterior() {
		return estadoAnterior;
	}
	protected void setEstadoAnterior(Estado estadoAnterior) {
		this.estadoAnterior = estadoAnterior;
	}
	public Estado volverEstadoAnterior(){
		estadoAnterior.setVida(super.getVida());
		return estadoAnterior;
	}
	
}
