package src.fiuba.algo3.modelo.elementos;

import src.fiuba.algo3.modelo.AlgoMon;
import src.fiuba.algo3.modelo.efectos.Efecto;

public abstract class Elemento {

	protected Efecto efecto;

	/**
	 * Aplica el elemento a un algoMon.
	 * @param algoMon algoMon al que se le aplica el efecto.
	 */
	public void aplicar(AlgoMon algoMon) {
		algoMon.recibirEfecto(this.efecto);
	}

}
