package src.fiuba.algo3.modelo;

import java.util.ArrayList;
import java.util.List;

import src.fiuba.algo3.modelo.ataques.NombreAtaque;

public class Juego {

	private List<Jugador> jugadores;
	private static int maximoJugadores = 2;
	private int indiceJugadorActivo;

	public Juego() {
		this.jugadores = new ArrayList<Jugador>();
		this.jugadores.add(new Jugador());
		this.jugadores.add(new Jugador());
		this.indiceJugadorActivo = 0;
	}

	public Jugador getJugador1() {
		return this.jugadores.get(0);
	}

	public Jugador getJugador2() {
		return this.jugadores.get(1);
	}

	public Jugador getJugadorActivo() {
		return this.jugadores.get(this.indiceJugadorActivo);
	}

	public Jugador getContrincante() {
		return this.jugadores.get(this.getIndiceProximoJugador());
	}

	public void jugadorActivoAtaca(NombreAtaque nombreAtaque) {
		this.getJugadorActivo().atacarConAlgoMonActivo(nombreAtaque, this.getContrincante().getAlgoMonActivo());
		this.finTurno();
	}

	private void finTurno() {
		this.cambiarJugadorActivo();
	}

	private void cambiarJugadorActivo() {
		this.indiceJugadorActivo = this.getIndiceProximoJugador();
	}

	private int getIndiceProximoJugador() {
		return (this.indiceJugadorActivo + 1) % Juego.maximoJugadores;
	}

}
