package src.fiuba.algo3.modelo.efectos;
import src.fiuba.algo3.modelo.estados.Estado;

public final class QuitarVida extends Efecto {
	public QuitarVida(int vidaQuitada) {
		this.vidaQuitada = vidaQuitada;
	}
	private int vidaQuitada;
	@Override
	public Estado aplicar(Estado estado) {
		estado.quitarVida(vidaQuitada);
		return estado;
	}

}
