package src.fiuba.algo3.modelo;

import java.util.List;

import src.fiuba.algo3.modelo.ataques.Ataque;
import src.fiuba.algo3.modelo.tipo.Agua;

public class AlgoMonAgua extends AlgoMon {

	public AlgoMonAgua(NombreAlgoMon nombre, double vidaMaxima, List<Ataque> ataques) {
		super(nombre, vidaMaxima, ataques);
		this.tipo = new Agua();
	}

}
