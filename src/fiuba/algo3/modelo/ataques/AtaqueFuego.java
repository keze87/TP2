package src.fiuba.algo3.modelo.ataques;

import src.fiuba.algo3.modelo.tipo.Fuego;
import src.fiuba.algo3.modelo.efectos.Efecto;


public class AtaqueFuego extends Ataque {

	public AtaqueFuego(String nombre, int poder, int usosTotales, Efecto efectoBase, Efecto efectoAtacante) {
		super(nombre, poder, usosTotales, efectoBase, efectoAtacante);
		this.tipo = new Fuego();
	}
}
