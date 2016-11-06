package src.fiuba.algo3.modelo.efectos;

import src.fiuba.algo3.modelo.estados.Estado;

public final class SinEfecto extends Efecto {

	@Override
	public Estado aplicar(Estado estado) {
		return estado;
	}

}
