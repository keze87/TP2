package src.fiuba.algo3.modelo;

import java.util.ArrayList;
import java.util.List;

import src.fiuba.algo3.modelo.excepciones.EquipoCompleto;

public class Jugador {

	private static int capacidadEquipo = 3;
	private List<AlgoMon> equipo;

	public Jugador() {
		this.equipo = new ArrayList<AlgoMon>();
	}

	public boolean tieneAlgoMonEnEquipo(AlgoMon algoMon) {
		return this.equipo.contains(algoMon);
	}

	public void agregarAlgoMonAlEquipo(AlgoMon algoMon) {
		if(this.equipoEstaCompleto()) {
			throw new EquipoCompleto("El equipo est� completo!");
		}

		this.equipo.add(algoMon);
	}

	public void sacarAlgoMonDelEquipo(AlgoMon algoMon) {
		this.equipo.remove(algoMon);
	}

	public List<AlgoMon> getEquipo() {
		return this.equipo;
	}

	private boolean equipoEstaCompleto() {
		return this.equipo.size() == Jugador.capacidadEquipo;
	}

}
