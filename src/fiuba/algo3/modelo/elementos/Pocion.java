package src.fiuba.algo3.modelo.elementos;

import src.fiuba.algo3.modelo.AlgoMon;
import src.fiuba.algo3.modelo.efectos.AumentarVida;
import src.fiuba.algo3.modelo.excepciones.VidaCompleta;

public final class Pocion extends Elemento {

	public Pocion(){
		this.setEfecto(new AumentarVida(20));
	}

	@Override
	public void aplicar(AlgoMon algoMon) {
		if(algoMon.tieneVidaCompleta()) {
			throw new VidaCompleta(algoMon.getNombre() + " tiene la vida completa!");
		}

		super.aplicar(algoMon);
	}

}
