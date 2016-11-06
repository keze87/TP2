package src.fiuba.algo3.modelo.ataques;

import src.fiuba.algo3.modelo.Agua;

public class AtaqueAgua extends Ataque {

	public AtaqueAgua(String nombre, int poder, int usosTotales) {
		super(nombre, poder, usosTotales);
		this.tipo = new Agua();
	}

}
