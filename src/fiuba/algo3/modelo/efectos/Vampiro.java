package src.fiuba.algo3.modelo.efectos;

import src.fiuba.algo3.modelo.estados.Estado;

public class Vampiro extends Efecto {
	private static double porcentajeVidaQuitadaAlAlgomonAtacado=0.3;

	public static double getPorcentajeVidaQuitadaAlAlgomonAtacado() {
		return porcentajeVidaQuitadaAlAlgomonAtacado;
	}

	public Vampiro(){
		this.setVidaQuitadaAlOponente(0);
	}

	@Override
	public Estado aplicar(Estado estado) {
		estado.aumentarVida(this.getVidaQuitadaAlOponente() * Vampiro.getPorcentajeVidaQuitadaAlAlgomonAtacado());
		return estado;
	}

}
