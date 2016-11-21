package src.fiuba.algo3.modelo;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Random;

import src.fiuba.algo3.modelo.ataques.NombreAtaque;
import src.fiuba.algo3.modelo.elementos.NombreElemento;
import src.fiuba.algo3.modelo.excepciones.AtaqueAgotado;
import src.fiuba.algo3.modelo.excepciones.StockAgotado;

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

	/* Establece el algoMon activo de cada jugador y determina qué jugador
	 * tiene el primer turno.
	 */
	public void inicializar() {
		for(Jugador jugador : this.jugadores) {
			jugador.listoParaPelear();
		}

		this.elegirJugadorActivoInicial();
	}

	/* Elije un jugador inicial aleatoriamente. */
	private void elegirJugadorActivoInicial() {
		Random random = new Random();

		this.indiceJugadorActivo = random.nextInt(2);
	}

	/* Devuelve el jugador 1. */
	public Jugador getJugador1() {
		return this.jugadores.get(0);
	}

	/* Devuelve el jugador 2.*/
	public Jugador getJugador2() {
		return this.jugadores.get(1);
	}

	/* Devuelve el jugador activo. */
	public Jugador getJugadorActivo() {
		return this.jugadores.get(this.indiceJugadorActivo);
	}

	/* Devuelve el contrincante del jugador activo. */
	public Jugador getContrincante() {
		return this.jugadores.get(this.getIndiceProximoJugador());
	}

	/* Devuelve una lista con los algoMon inactivos del jugador activo. */
	public List<AlgoMon> getAlgoMonInactivosJugadorActivo() {
		return this.getJugadorActivo().getAlgoMonInactivos();
	}

	/**
	 * El jugador activo ataca con su algoMon activo.
	 * @param nombreAtaque nombre del ataque.
	 */
	public void jugadorActivoAtaca(NombreAtaque nombreAtaque) {
		try {
			this.getJugadorActivo().atacarConAlgoMonActivo(nombreAtaque, this.getContrincante().getAlgoMonActivo());
			this.finTurno();
		} catch(AtaqueAgotado e) {
			throw e;
		} catch(Exception e) {
			this.finTurno();
			throw e;
		}
	}

	/**
	 * El jugador activo usa un elemento sobre su algoMon activo.
	 * @param nombreElemento nombre del elemento.
	 */
	public void jugadorActivoUsaElemento(NombreElemento nombreElemento) {
		try {
			this.getJugadorActivo().usarElemento(nombreElemento);
			this.finTurno();
		} catch(StockAgotado e) {
			throw e;
		} catch(Exception e) {
			this.finTurno();
			throw e;
		}
	}

	/**
	 * Cambia el algoMon activo del jugador activo.
	 * @param algoMon algoMon que se convertirá en el algoMon activo.
	 */
	public void cambiarAlgoMonActivoJugadorActivo(AlgoMon algoMon) {
		this.getJugadorActivo().cambiarAlgoMonActivo(algoMon);
		this.finTurno();
	}

	/* Devuelve una cola con los jugadores cuyos algoMon activo está muerto. */
	public Queue<Jugador> getJugadoresConAlgoMonActivoMuerto() {
		Queue<Jugador> jugadoresConAlgoMonActivoMuerto = new LinkedList<Jugador>();

		for(Jugador jugador : this.jugadores) {
			if(!jugador.getAlgoMonActivo().estaVivo()) {
				jugadoresConAlgoMonActivoMuerto.add(jugador);
			}
		}

		return jugadoresConAlgoMonActivoMuerto;
	}

	/* Determina si alguno de los jugadores ganó. */
	public boolean hayGanador() {
		return !(this.jugadores.get(0).puedeSeguirJugando() && this.jugadores.get(1).puedeSeguirJugando());
	}

	public void crearComputadora() {
		this.jugadores.remove(1);
		this.jugadores.add(new Computadora());
	}

	/* Termina el turno actual. */
	private void finTurno() {
		this.cambiarJugadorActivo();
	}

	/* Cambia el jugador activo. */
	private void cambiarJugadorActivo() {
		this.indiceJugadorActivo = this.getIndiceProximoJugador();
	}

	/* Calcula el índice de la lista de jugadores que corresponde al próximo
	 * jugador activo. */
	private int getIndiceProximoJugador() {
		return (this.indiceJugadorActivo + 1) % Juego.maximoJugadores;
	}

}
