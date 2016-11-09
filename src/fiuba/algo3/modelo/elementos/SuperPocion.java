package src.fiuba.algo3.modelo.elementos;

import src.fiuba.algo3.modelo.efectos.AumentarVida;

public final class SuperPocion extends Elemento {
	
	public SuperPocion(){
		this.setEfecto(new AumentarVida(40));
	}

}
