package src.fiuba.algo3.modelo;

import java.util.List;

import src.fiuba.algo3.modelo.ataques.Ataque;
import src.fiuba.algo3.modelo.tipo.Planta;

public class AlgoMonPlanta extends AlgoMon {

	public AlgoMonPlanta(String nombre, int vidaMaxima, List<Ataque> ataques) {
		super(nombre, vidaMaxima, ataques);
		this.tipo = new Planta();
	}

}
