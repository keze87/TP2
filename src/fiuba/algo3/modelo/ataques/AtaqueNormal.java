package src.fiuba.algo3.modelo.ataques;

import src.fiuba.algo3.modelo.tipo.Normal;
import src.fiuba.algo3.modelo.efectos.Efecto;

public class AtaqueNormal extends Ataque {

	public AtaqueNormal(String nombre, int poder, int usosTotales, Efecto efectoBase, Efecto efectoAtacante) {
		super(nombre, poder, usosTotales, efectoBase, efectoAtacante);
		this.tipo = new Normal();
	}
}
