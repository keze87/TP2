package src.fiuba.algo3.modelo;

import java.util.List;

import src.fiuba.algo3.modelo.ataques.Ataque;
import src.fiuba.algo3.modelo.tipo.Normal;

public class AlgoMonNormal extends AlgoMon {

	public AlgoMonNormal(String nombre, double vidaMaxima, List<Ataque> ataques) {
		super(nombre, vidaMaxima, ataques);
		this.tipo = new Normal();
	}

}
