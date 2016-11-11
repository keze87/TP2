package src.fiuba.algo3.modelo.elementos;

import src.fiuba.algo3.modelo.AlgoMon;
import src.fiuba.algo3.modelo.efectos.SinEfecto;

public final class Vitamina extends Elemento {
	private int cantAtaquesRestaurados=2;
	
	public Vitamina(){
		this.efecto = new SinEfecto();
	}
	
	public void aplicar(AlgoMon algoMon) {
		algoMon.aumentarCantidadAtaquesDisponibles(cantAtaquesRestaurados);
	}

}
