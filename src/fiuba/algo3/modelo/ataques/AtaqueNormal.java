package src.fiuba.algo3.modelo.ataques;

import src.fiuba.algo3.modelo.Normal;
import src.fiuba.algo3.modelo.efectos.Efecto;

public class AtaqueNormal extends Ataque {

	public AtaqueNormal(String nombre, int poder, int usosTotales, Efecto efectoBase) {
		super(nombre, poder, usosTotales, efectoBase);
		this.tipo = new Normal();
	}
}
