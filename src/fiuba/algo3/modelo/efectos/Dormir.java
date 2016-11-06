package src.fiuba.algo3.modelo.efectos;
import src.fiuba.algo3.modelo.estados.Dormido;
import src.fiuba.algo3.modelo.estados.Estado;

public final class Dormir extends Efecto {

	@Override
	public Estado aplicar(Estado estado) {
		return new Dormido(estado);
	}

}
