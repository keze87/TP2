package src.fiuba.algo3.modelo.elementos;

import src.fiuba.algo3.modelo.AlgoMon;
import src.fiuba.algo3.modelo.efectos.Efecto;

public abstract class Elemento {

	private Efecto efecto;

	public void aplicar(AlgoMon algomon) {
		algomon.recibirEfecto(this.efecto);
	}

	protected void setEfecto(Efecto efecto) {
		this.efecto = efecto;
	}
}
