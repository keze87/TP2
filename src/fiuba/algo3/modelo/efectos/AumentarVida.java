package src.fiuba.algo3.modelo.efectos;

import src.fiuba.algo3.modelo.estados.Estado;

public final class AumentarVida extends Efecto {

	private double vidaAumentada;

	public AumentarVida(double vidaAumentada) {

		this.vidaAumentada = vidaAumentada;

	}

	@Override
	public Estado aplicar(Estado estado) {

		estado.aumentarVida(vidaAumentada);

		return estado;

	}

}
