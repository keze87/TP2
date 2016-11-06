package src.fiuba.algo3.modelo.ataques;

import src.fiuba.algo3.modelo.Fuego;

public class AtaqueFuego extends Ataque {

	public AtaqueFuego(String nombre, int poder, int usosTotales) {
		super(nombre, poder, usosTotales);
		this.tipo = new Fuego();
	}

}
