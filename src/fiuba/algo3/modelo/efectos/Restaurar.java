package src.fiuba.algo3.modelo.efectos;

import src.fiuba.algo3.modelo.estados.Estado;
import src.fiuba.algo3.modelo.estados.EstadoNormal;

public final class Restaurar extends Efecto {

	@Override
	public Estado aplicar(Estado estado) {
		return new EstadoNormal(estado.getVida());
	}

}
