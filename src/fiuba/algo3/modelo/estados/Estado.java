package src.fiuba.algo3.modelo.estados;

public abstract class Estado {
	protected double vida;
	protected double vidaMaxima;

	public Estado() {

	}

	public Estado(double vidaMaxima) {
		this.vidaMaxima = vidaMaxima;
		this.vida = vidaMaxima;
	}

	public double getVida() {
		return this.vida;
	}

	public double getVidaMaxima() {
		return this.vidaMaxima;
	}

	public boolean estaVivo() {
		return this.vida > 0;
	}

	public void aumentarVida(double cantidad) {
		this.vida = Math.floor(this.vida + cantidad);

		if(this.vida > this.vidaMaxima) {
			this.vida = this.vidaMaxima;
		}
	}

	public void quitarVida(double cantidad) {
		this.vida -= cantidad;

		if(this.vida < 0) {
			this.vida = 0;
		}
	}

	protected void setVida(double cantidad) {
		this.vida = cantidad;
	}

	public abstract boolean puedeRealizarAccion();
	public abstract void accionRealizada();

}
