package src.fiuba.algo3.modelo.elementos;

import src.fiuba.algo3.modelo.AlgoMon;
import src.fiuba.algo3.modelo.efectos.SinEfecto;

public final class Vitamina extends Elemento {
	private static int cantAtaquesRestaurados=2;
	
	public static int getCantAtaquesRestaurados() {
		return cantAtaquesRestaurados;
	}

	public Vitamina(){
		this.efecto = new SinEfecto();
	}
	
	public void aplicar(AlgoMon algoMon) {
		algoMon.aumentarCantidadAtaquesDisponibles(Vitamina.getCantAtaquesRestaurados());
	}

}
