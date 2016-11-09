package src.fiuba.algo3.modelo.elementos;

import src.fiuba.algo3.modelo.efectos.AumentarVida;

public final class Pocion extends Elemento {
	
	public Pocion(){
		this.setEfecto(new AumentarVida(20));
	}
	
}
