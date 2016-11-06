package src.fiuba.algo3.modelo.ataques;

import src.fiuba.algo3.modelo.Planta;
import src.fiuba.algo3.modelo.efectos.Efecto;

public class AtaquePlanta extends Ataque {

	public AtaquePlanta(String nombre, int poder, int usosTotales, Efecto efectoBase) {
		super(nombre, poder, usosTotales, efectoBase);
		this.tipo = new Planta();
	}

}
