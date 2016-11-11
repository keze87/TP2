package src.fiuba.algo3.modelo.elementos;

import src.fiuba.algo3.modelo.efectos.RestaurarAtaques;

public final class Vitamina extends Elemento {

	public Vitamina(){
		this.efecto = new RestaurarAtaques(2);
	}

}
