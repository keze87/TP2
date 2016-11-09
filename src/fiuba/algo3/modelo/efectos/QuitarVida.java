package src.fiuba.algo3.modelo.efectos;
import src.fiuba.algo3.modelo.estados.Estado;

public final class QuitarVida extends Efecto {

	public QuitarVida(double vidaQuitada) {
		this.setVidaQuitadaAlOponente(vidaQuitada);
	}

	@Override
	public Estado aplicar(Estado estado) {
		estado.quitarVida(this.getVidaQuitadaAlOponente());
		return estado;
	}

}
