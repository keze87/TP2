package src.fiuba.algo3.modelo.ataques;

import src.fiuba.algo3.modelo.Planta;

public class AtaquePlanta extends Ataque {

	public AtaquePlanta(String nombre, int poder, int usosTotales) {
		super(nombre, poder, usosTotales);
		this.tipo = new Planta();
	}

}
