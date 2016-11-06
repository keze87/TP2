package src.fiuba.algo3.modelo.estados;

public abstract class Estado {
	private double vida;

	public void aumentarVida(double cantidad) {
		vida += cantidad;
	}

	public void quitarVida(double cantidad) {
		vida -= cantidad;
	}

	public double getVida() {
		return vida;
	}

	protected void setVida(double cantidad) {
		vida = cantidad;
	}

	public boolean estaVivo() {
		return vida > 0;
	}

	public abstract boolean puedeRealizarAccion();
	public abstract void accionRealizada();

}
