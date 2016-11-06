package src.fiuba.algo3.modelo.ataques;

import src.fiuba.algo3.modelo.AlgoMon;
import src.fiuba.algo3.modelo.Tipo;
import src.fiuba.algo3.modelo.efectos.Efecto;
import src.fiuba.algo3.modelo.efectos.EfectoMultiple;
import src.fiuba.algo3.modelo.efectos.QuitarVida;

public abstract class Ataque {
	protected String nombre;
	protected int potencia;
	protected int usosTotales;
	protected int usosRestantes;
	protected Tipo tipo;
	protected EfectoMultiple efecto = new EfectoMultiple();

	public Ataque(String nombre, int poder, int usosTotales, Efecto efectoBase) {
		this.nombre = nombre;
		this.potencia = poder;
		this.usosTotales = usosTotales;
		this.usosRestantes = usosTotales;
		efecto.agregarEfecto(efectoBase);
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
		return this.calcularDanio(algoMon);
	}

	/**
	 * Calcula el daño provocado a un algoMon dado.
	 * @param algoMon algoMon a atacar.
	 * @return el daño calculado.
	 */
	private double calcularDanio(AlgoMon algoMon) {
		return Math.floor(this.potencia * this.tipo.getMultiplicadorContra(algoMon.getTipo()));
	}

	public String nombre() {

		return nombre;

	}

	public double calcularDanioContraElTipo(Tipo tipo) {
		return Math.floor(this.potencia * this.tipo.getMultiplicadorContra(tipo));
	}

	public Efecto atacar(AlgoMon algoMon) throws AtaqueAgotado {
		if(this.usosRestantes == 0) {
			throw new AtaqueAgotado("No quedan más usos para este ataque!");
		}

		this.usosRestantes--;

		this.efecto.agregarEfecto(new QuitarVida(this.calcularDanio(algoMon)));

		return this.efecto;
	}
}
