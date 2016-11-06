package src.fiuba.algo3.modelo.ataques;

import src.fiuba.algo3.modelo.Normal;

public class AtaqueNormal extends Ataque {

	public AtaqueNormal(String nombre, int poder, int usosTotales) {
		super(nombre, poder, usosTotales);
		this.tipo = new Normal();
	}

}
