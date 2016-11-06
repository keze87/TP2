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

	public double calcularDanioContra(AlgoMon algoMon) {
		if(this.usosRestantes == 0) {
			throw new AtaqueAgotado("No quedan más usos para este ataque!");
		}

		this.usosRestantes--;
		return Math.floor(this.potencia * this.tipo.getMultiplicadorContra(algoMon.getTipo()));
	}
}
