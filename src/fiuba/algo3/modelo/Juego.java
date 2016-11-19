package src.fiuba.algo3.modelo;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import src.fiuba.algo3.modelo.ataques.NombreAtaque;
import src.fiuba.algo3.modelo.elementos.NombreElemento;
<<<<<<< HEAD
=======
import src.fiuba.algo3.modelo.excepciones.AlgoMonRecibeDañoQuemadura;
>>>>>>> 06377395e68d7d5be7389d5c251b7b65f8a956c4
import src.fiuba.algo3.modelo.excepciones.AlgoMonDormidoNoPuedeAtacar;
import src.fiuba.algo3.modelo.excepciones.AlgoMonRecibeDañoQuemadura;
import src.fiuba.algo3.modelo.excepciones.JuegoTerminado;

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

	public void inicializar() {
		for(Jugador jugador : this.jugadores) {
			jugador.listoParaPelear();
		}

		this.elegirJugadorActivoInicial();
	}

	private void elegirJugadorActivoInicial() {
		Random random = new Random();

		this.indiceJugadorActivo = random.nextInt(2);
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

	public List<AlgoMon> getAlgoMonInactivosJugadorActivo() {
		return this.getJugadorActivo().getAlgoMonInactivos();
	}

	public void jugadorActivoAtaca(NombreAtaque nombreAtaque) {
		try {
			this.getJugadorActivo().atacarConAlgoMonActivo(nombreAtaque, this.getContrincante().getAlgoMonActivo());
			this.finTurno();
		} catch(AlgoMonDormidoNoPuedeAtacar | AlgoMonRecibeDañoQuemadura e) {
			this.finTurno();
			throw e;
		}
	}

	public void jugadorActivoUsaElemento(NombreElemento nombreElemento) {
		this.getJugadorActivo().usarElemento(nombreElemento);
		this.finTurno();
	}

	public void cambiarAlgoMonActivoJugadorActivo(AlgoMon algoMon) {
		this.getJugadorActivo().cambiarAlgoMonActivo(algoMon);
		this.finTurno();
	}

	private void finTurno() {
		if(!this.getContrincante().puedeSeguirJugando()) {
			throw new JuegoTerminado("El juego terminó!");
		}

		this.cambiarJugadorActivo();
	}

	private void cambiarJugadorActivo() {
		this.indiceJugadorActivo = this.getIndiceProximoJugador();
	}

	private int getIndiceProximoJugador() {
		return (this.indiceJugadorActivo + 1) % Juego.maximoJugadores;
	}

}
