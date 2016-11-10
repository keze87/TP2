package src.fiuba.algo3.modelo.elementos;

import src.fiuba.algo3.modelo.efectos.Restaurar;

public final class Restaurador extends Elemento {

	public Restaurador() {
		this.setEfecto(new Restaurar());
	}
}
