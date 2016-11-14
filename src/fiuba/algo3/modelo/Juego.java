package src.fiuba.algo3.modelo;

public class Juego {

	private Jugador jugador1;
	private Jugador jugador2;

	public Juego() {
		this.jugador1 = new Jugador();
		this.jugador2 = new Jugador();
	}

	public Jugador getJugador1() {
		return this.jugador1;
	}

	public Jugador getJugador2() {
		return this.jugador2;
	}
}
