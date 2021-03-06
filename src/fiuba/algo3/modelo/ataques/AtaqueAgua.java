package src.fiuba.algo3.modelo.ataques;

import src.fiuba.algo3.modelo.tipo.Agua;
import src.fiuba.algo3.modelo.efectos.Efecto;

public class AtaqueAgua extends Ataque {

	public AtaqueAgua(NombreAtaque nombre, int poder, int usosTotales, Efecto efectoBase, Efecto efectoAtacante) {
		super(nombre, poder, usosTotales, efectoBase, efectoAtacante);
		this.tipo = new Agua();
	}

}
