package src.fiuba.algo3.modelo.efectos;
import src.fiuba.algo3.modelo.estados.Estado;

public final class QuitarVida extends Efecto {
	private double vidaQuitada;

	public QuitarVida(double vidaQuitada) {
		this.vidaQuitada = vidaQuitada;
	}
	@Override
	public Estado aplicar(Estado estado) {
		estado.quitarVida(vidaQuitada);
		return estado;
	}

}
