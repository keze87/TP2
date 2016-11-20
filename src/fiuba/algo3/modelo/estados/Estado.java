package src.fiuba.algo3.modelo.estados;

import src.fiuba.algo3.modelo.excepciones.AlgoMonMurio;

public abstract class Estado {
	protected double vida;
	protected double vidaMaxima;

	public Estado() {

	}

	public Estado(double vidaMaxima) {
		this.vidaMaxima = vidaMaxima;
		this.vida = vidaMaxima;
	}

	/* Devuelve el valor de la vida.*/
	public double getVida() {
		return this.vida;
	}

	/* Devuelve el valor de la vida máxima. */
	public double getVidaMaxima() {
		return this.vidaMaxima;
	}

	/* Determina si el estado corresponde a estar vivo.
	 * Si está vivo devuelve true, sino false.
	 */
	public boolean estaVivo() {
		return this.vida > 0;
	}

	/**
	 * Aumenta la vida en una cantidad dada.
	 * @param cantidad cantidad de vida a aumentar.
	 */
	public void aumentarVida(double cantidad) {
		this.vida = Math.floor(this.vida + cantidad);

		if(this.vida > this.vidaMaxima) {
			this.vida = this.vidaMaxima;
		}
	}

	/**
	 * Disminuye la vida en una cantidad dada.
	 * @param cantidad cantidad de vida a disminuir.
	 */
	public void quitarVida(double cantidad) {
		this.vida -= cantidad;

		if(this.vida <= 0) {
			this.vida = 0;
			throw new AlgoMonMurio();
		}
	}

	/**
	 * Establece el valor de la vida.
	 * @param cantidad cantidad de vida.
	 */
	protected void setVida(double cantidad) {
		this.vida = cantidad;
	}
	/* Devuelve true o false según si la vida es igual a la vida máxima. */
	public boolean tieneVidaCompleta() {
		return this.getVida() == this.getVidaMaxima();
	}

	/* Determina si es posible atacar. Si se puede atacar
	 * devuelve true, sino false.
	 */
	public abstract boolean puedeRealizarAccion();

	/* Actualiza el estado luego de haber atacado. */
	public abstract void accionRealizada();

}
