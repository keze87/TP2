package src.fiuba.algo3.modelo.efectos;

import java.util.ArrayList;
import java.util.List;

import src.fiuba.algo3.modelo.estados.Estado;

public final class EfectoMultiple extends Efecto {
	private List<Efecto> efectos;

	public EfectoMultiple() {
		efectos = new ArrayList<Efecto>();
	}

	/**
	 * Agrega un efecto a la lista de efectos.
	 * @param efecto efecto a agregar.
	 */
	public void agregarEfecto(Efecto efecto){
		this.efectos.add(efecto);
	}

	@Override
	public Estado aplicar(Estado estado) {
		Estado estadoFinal = estado;
		for(Efecto efecto : efectos){
			estadoFinal = efecto.aplicar(estadoFinal);
		}
		return estadoFinal;
	}

}
