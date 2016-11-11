package src.fiuba.algo3.modelo.ataques;

import src.fiuba.algo3.modelo.efectos.Efecto;
import src.fiuba.algo3.modelo.tipo.Planta;

public class AtaquePlanta extends Ataque {

	public AtaquePlanta(NombreAtaque nombre, int poder, int usosTotales, Efecto efectoBase, Efecto efectoAtacante) {
		super(nombre, poder, usosTotales, efectoBase, efectoAtacante);
		this.tipo = new Planta();
	}

}
