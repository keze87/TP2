package src.fiuba.algo3.modelo;

import src.fiuba.algo3.modelo.ataques.Ataque;

public class AlgoMonAgua extends AlgoMon {

	public AlgoMonAgua(String nombre, int vidaMaxima, Ataque ataque1, Ataque ataque2, Ataque ataque3) {
		super(nombre, vidaMaxima, ataque1, ataque2, ataque3);
		this.tipo = new Agua();
	}

}
