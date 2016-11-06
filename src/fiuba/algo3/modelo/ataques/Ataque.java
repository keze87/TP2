package src.fiuba.algo3.modelo.ataques;

import src.fiuba.algo3.modelo.Tipo;

public abstract class Ataque {
	protected String nombre;
	protected int poder;
	protected int usosTotales;
	protected int usosRestantes;
	protected Tipo tipo;

	public Ataque(String nombre, int poder, int usosTotales) {
		this.nombre = nombre;
		this.poder = poder;
		this.usosTotales = usosTotales;
		this.usosRestantes = usosTotales;
	}

	public int getPoder() {
		return this.poder;
	}

	public Tipo getTipo() {
		return this.tipo;
	}
}
