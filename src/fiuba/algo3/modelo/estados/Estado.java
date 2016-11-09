package src.fiuba.algo3.modelo.estados;

public abstract class Estado {
	private double vida;
	private double vidaMaxima;

	public void aumentarVida(double cantidad) {

		if ( vidaMaxima >= (vida + cantidad) ) {

			vida += cantidad;

		} else {

			vida = vidaMaxima;

		}

	}

	public void quitarVida(double cantidad) {

		if ( 0 <= (vida - cantidad) ) {

			vida -= cantidad;

		} else {

			vida = 0;

		}

	}

	public double getVida() {
		return vida;
	}

	public void setVida(double cantidad) {
		vida = cantidad;
	}

	public boolean estaVivo() {
		return vida > 0;
	}

	public abstract boolean puedeRealizarAccion();
	public abstract void accionRealizada();

	public double getVidaMaxima() {
		return vidaMaxima;
	}

	public void setVidaMaxima(double cantidad) {
		vidaMaxima = cantidad;
	}

}
