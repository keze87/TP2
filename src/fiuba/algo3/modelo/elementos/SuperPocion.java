package src.fiuba.algo3.modelo.elementos;

import src.fiuba.algo3.modelo.AlgoMon;
import src.fiuba.algo3.modelo.efectos.AumentarVida;
import src.fiuba.algo3.modelo.excepciones.VidaCompleta;

public final class SuperPocion extends Elemento {
	private static int vidaAumentada = 40;
	
	public static int getVidaAumentada() {
		return vidaAumentada;
	}
	
	public SuperPocion() {
		this.efecto = new AumentarVida(SuperPocion.getVidaAumentada());
	}

	@Override
	public void aplicar(AlgoMon algoMon) {
		if(algoMon.tieneVidaCompleta()) {
			throw new VidaCompleta(algoMon.getNombre() + " tiene la vida completa!");
		}

		super.aplicar(algoMon);
	}

}
