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
		} catch(AtaqueAgotado e) {
			throw e;
		} catch(Exception e) {
			this.finTurno();
			throw e;
		}
	}

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

	public void cambiarAlgoMonActivoJugadorActivo(AlgoMon algoMon) {
		this.getJugadorActivo().cambiarAlgoMonActivo(algoMon);
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

	public void crearComputadora() {

		this.jugadores.remove(1);
		this.jugadores.add(new Computadora());

	}

	public Queue<Jugador> getJugadoresConAlgoMonActivoMuerto() {
		Queue<Jugador> jugadoresConAlgoMonActivoMuerto = new LinkedList<Jugador>();

		for(Jugador jugador : this.jugadores) {
			if(!jugador.getAlgoMonActivo().estaVivo()) {
				jugadoresConAlgoMonActivoMuerto.add(jugador);
			}
		}

		return jugadoresConAlgoMonActivoMuerto;
	}

	public boolean hayGanador() {
		return !(this.jugadores.get(0).puedeSeguirJugando() && this.jugadores.get(1).puedeSeguirJugando());
	}

}
