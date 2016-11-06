package src.fiuba.algo3.modelo.ataques;

import src.fiuba.algo3.modelo.Tipo;

public abstract class Ataque {
	protected String nombre;
	protected int potencia;
	protected int usosTotales;
	protected int usosRestantes;
	protected Tipo tipo;

	public Ataque(String nombre, int poder, int usosTotales) {
		this.nombre = nombre;
		this.potencia = poder;
		this.usosTotales = usosTotales;
		this.usosRestantes = usosTotales;
	}

	/* Devuelve el potencia del ataque. */
	public int getPotencia() {
		return this.potencia;
	}

	/* Devuelve el tipo del ataque. */
	public Tipo getTipo() {
		return this.tipo;
	}
}
