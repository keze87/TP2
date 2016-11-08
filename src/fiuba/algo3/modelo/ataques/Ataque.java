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
	protected EfectoMultiple efecto;
	protected Efecto efectoBase;

	public Ataque(String nombre, int poder, int usosTotales, Efecto efectoBase) {
		this.nombre = nombre;
		this.potencia = poder;
		this.usosTotales = usosTotales;
		this.usosRestantes = usosTotales;
		this.efectoBase = efectoBase;
	}

	/**
	 * Aplica el ataque a un algoMon dado.
	 * @param algoMon algoMon a atacar.
	 * @return el daño provocado por el ataque.
	 */
//	public double aplicarAtaque(AlgoMon algoMon) {
//		if(this.usosRestantes == 0) {
//			throw new AtaqueAgotado("No quedan más usos para este ataque!");
//		}
//
//		this.usosRestantes--;
//		return this.calcularDaño(algoMon);
//	}

	/**
	 * Calcula el daño provocado a un algoMon dado.
	 * @param algoMon algoMon a atacar.
	 * @return el daño calculado.
	 */
	private double calcularDaño(AlgoMon algoMon) {
		return Math.floor(this.potencia * this.tipo.getMultiplicadorContra(algoMon.getTipo()));
	}

	public String getNombre() {
		return nombre;
	}

//	public double calcularDanioContraElTipo(Tipo tipo) {
//		return Math.floor(this.potencia * this.tipo.getMultiplicadorContra(tipo));
//	}

	public Efecto atacar(AlgoMon algoMon) throws AtaqueAgotado {
		this.efecto = new EfectoMultiple();
		this.efecto.agregarEfecto(this.efectoBase);

		if(this.usosRestantes == 0) {
			throw new AtaqueAgotado("No quedan más usos para este ataque!");
		}

		this.efecto.agregarEfecto(new QuitarVida(this.calcularDaño(algoMon)));

		this.usosRestantes--;
		return this.efecto;
	}
}
