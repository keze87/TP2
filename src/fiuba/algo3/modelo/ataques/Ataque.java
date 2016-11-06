package src.fiuba.algo3.modelo.ataques;

import src.fiuba.algo3.modelo.AlgoMon;
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

	/**
	 * Aplica el ataque a un algoMon dado.
	 * @param algoMon algoMon a atacar.
	 * @return el daño provocado por el ataque.
	 */
	public double aplicarAtaque(AlgoMon algoMon) {
		if(this.usosRestantes == 0) {
			throw new AtaqueAgotado("No quedan más usos para este ataque!");
		}

		this.usosRestantes--;
		return this.calcularDaño(algoMon);
	}

	/**
	 * Calcula el daño provocado a un algoMon dado.
	 * @param algoMon algoMon a atacar.
	 * @return el daño calculado.
	 */
	private double calcularDaño(AlgoMon algoMon) {
		return Math.floor(this.potencia * this.tipo.getMultiplicadorContra(algoMon.getTipo()));
	}

	public String nombre() {

		return nombre;

	}
}
