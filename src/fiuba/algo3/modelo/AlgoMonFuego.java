package src.fiuba.algo3.modelo;

import java.util.List;

import src.fiuba.algo3.modelo.ataques.Ataque;

public class AlgoMonFuego extends AlgoMon {

	public AlgoMonFuego(String nombre, int vidaMaxima, List<Ataque> ataques) {
		super(nombre, vidaMaxima, ataques);
		this.tipo = new Fuego();
	}

}
