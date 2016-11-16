package src.fiuba.algo3.modelo;

import java.util.ArrayList;
import java.util.List;

import src.fiuba.algo3.modelo.ataques.NombreAtaque;
import src.fiuba.algo3.modelo.elementos.Elemento;
import src.fiuba.algo3.modelo.excepciones.EquipoCompleto;
import src.fiuba.algo3.modelo.excepciones.NoHayAlgoMonActivo;

public class Jugador {

	private static int capacidadEquipo = 3;
	private List<AlgoMon> equipo;
	private AlgoMon algoMonActivo;
	private Mochila mochila;

	public Jugador() {
		this.equipo = new ArrayList<AlgoMon>();
		this.mochila = new Mochila();
	}

	public boolean tieneAlgoMonEnEquipo(AlgoMon algoMon) {
		return this.equipo.contains(algoMon);
	}

	public void agregarAlgoMonAlEquipo(AlgoMon algoMon) {
		if(this.equipoEstaCompleto()) {
			throw new EquipoCompleto("El equipo está completo!");
		}

		this.equipo.add(algoMon);
	}

	public void sacarAlgoMonDelEquipo(AlgoMon algoMon) {
		this.equipo.remove(algoMon);
	}

	public List<AlgoMon> getEquipo() {
		return this.equipo;
	}

	public boolean equipoEstaCompleto() {
		return this.equipo.size() == Jugador.capacidadEquipo;
	}

	public void listoParaPelear() {
		this.algoMonActivo = this.equipo.get(0);
	}

	public AlgoMon getAlgoMonActivo() {
		try {
			return this.algoMonActivo;
		} catch(NullPointerException e) {
			throw new NoHayAlgoMonActivo("No hay un algoMon activo!");
		}
	}

	public void atacarConAlgoMonActivo(NombreAtaque nombreAtaque, AlgoMon algoMon) {
		this.getAlgoMonActivo().atacar(nombreAtaque, algoMon);
	}

	public void usarPocion() {
		this.usarElemento(this.mochila.getPocion());
	}

	public void usarSuperPocion() {
		this.usarElemento(this.mochila.getSuperPocion());
	}

	public void usarRestaurador() {
		this.usarElemento(this.mochila.getRestaurador());
	}

	public void usarVitamina() {
		this.usarElemento(this.mochila.getVitamina());
	}

	private void usarElemento(Elemento elemento) {
		this.getAlgoMonActivo().recibirElemento(elemento);
	}

}
