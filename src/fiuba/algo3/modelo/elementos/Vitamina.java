package src.fiuba.algo3.modelo.elementos;

import src.fiuba.algo3.modelo.AlgoMon;
import src.fiuba.algo3.modelo.efectos.SinEfecto;

public final class Vitamina extends Elemento {
	
	public Vitamina(){
		this.setEfecto(new SinEfecto());
	}
	
	@Override
	public void aplicar(AlgoMon algomon) {
		
	}

}
