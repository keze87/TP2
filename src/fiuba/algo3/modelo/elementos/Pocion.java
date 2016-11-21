package src.fiuba.algo3.modelo.elementos;

import src.fiuba.algo3.modelo.AlgoMon;
import src.fiuba.algo3.modelo.efectos.AumentarVida;
import src.fiuba.algo3.modelo.excepciones.VidaCompleta;

public final class Pocion extends Elemento {
	private static int vidaAumentada = 20;

	public Pocion() {
		this.efecto = new AumentarVida(Pocion.getVidaAumentada());
	}

	/* Devuelve la cantidad de vida que aumenta el elemento. */
	public static int getVidaAumentada() {
		return vidaAumentada;
	}

	@Override
	public void aplicar(AlgoMon algoMon) {
		if(algoMon.tieneVidaCompleta()) {
			throw new VidaCompleta("¡" + algoMon.getNombre() + " tiene la vida completa!");
		}

		super.aplicar(algoMon);
	}

}
