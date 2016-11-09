package src.fiuba.algo3.modelo.efectos;

import src.fiuba.algo3.modelo.estados.Estado;

public class Vampiro extends Efecto {
	
	public Vampiro(){
		this.setVidaQuitadaAlOponente(0);
	}
	
	@Override
	public Estado aplicar(Estado estado) {
		estado.aumentarVida(this.getVidaQuitadaAlOponente()*0.3);
		return estado;
	}

}
