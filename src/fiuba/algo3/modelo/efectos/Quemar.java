package src.fiuba.algo3.modelo.efectos;

import src.fiuba.algo3.modelo.estados.Estado;
import src.fiuba.algo3.modelo.estados.Quemado;

public final class Quemar extends Efecto {

	@Override
	public Estado aplicar(Estado estado) {
		return new Quemado(estado);
	}

}
