package src.fiuba.algo3.modelo;

import java.util.ArrayList;
import java.util.List;
import src.fiuba.algo3.modelo.ataques.Ataque;
import src.fiuba.algo3.modelo.ataques.AtaqueBuilder;
import src.fiuba.algo3.modelo.tipo.*;

public class AlgoMonBuilder {

	private List<Ataque> ataques = new ArrayList<>();
	private String nombre = "";
	private int vida = 0;
	private Tipo tipo = new Normal();

	public static AlgoMon crearBulbasaur() {

		AlgoMonBuilder builder = new AlgoMonBuilder();

		builder.nombre("Bulbasaur").vida(140).ataque(AtaqueBuilder.crearChupavidas()).
		ataque(AtaqueBuilder.crearLatigoCepa()).ataque(AtaqueBuilder.crearAtaqueRapido()).
		tipo(new Planta());

		return builder.crearAlgomon();

	}

	public static AlgoMon crearChansey() {

		AlgoMonBuilder builder = new AlgoMonBuilder();

		builder.nombre("Chansey").vida(130).ataque(AtaqueBuilder.crearCanto()).
		ataque(AtaqueBuilder.crearLatigoCepa()).ataque(AtaqueBuilder.crearAtaqueRapido()).
		tipo(new Normal());

		return builder.crearAlgomon();

	}

	public static AlgoMon crearCharmander() {

		AlgoMonBuilder builder = new AlgoMonBuilder();

		builder.nombre("Charmander").vida(170).ataque(AtaqueBuilder.crearBrasas()).
		ataque(AtaqueBuilder.crearFogonazo()).ataque(AtaqueBuilder.crearAtaqueRapido()).
		tipo(new Fuego());

		return builder.crearAlgomon();

	}

	public static AlgoMon crearJigglypuff() {

		AlgoMonBuilder builder = new AlgoMonBuilder();

		builder.nombre("Jigglypuff").vida(130).ataque(AtaqueBuilder.crearCanto()).
		ataque(AtaqueBuilder.crearBurbuja()).ataque(AtaqueBuilder.crearAtaqueRapido()).
		tipo(new Normal());

		return builder.crearAlgomon();

	}

	public static AlgoMon crearRattata() {

		AlgoMonBuilder builder = new AlgoMonBuilder();

		builder.nombre("Rattata").vida(170).ataque(AtaqueBuilder.crearFogonazo()).
		ataque(AtaqueBuilder.crearBurbuja()).ataque(AtaqueBuilder.crearAtaqueRapido()).
		tipo(new Normal());

		return builder.crearAlgomon();

	}

	public static AlgoMon crearSquirtle() {

		AlgoMonBuilder builder = new AlgoMonBuilder();

		builder.nombre("Squirtle").vida(150).ataque(AtaqueBuilder.crearBurbuja()).
		ataque(AtaqueBuilder.crearCanionDeAgua()).ataque(AtaqueBuilder.crearAtaqueRapido()).
		tipo(new Agua());

		return builder.crearAlgomon();

	}

	public AlgoMonBuilder ataque(Ataque ataque) {

		this.ataques.add(ataque);

		return this;

	}

	public AlgoMonBuilder nombre(String nombre) {

		this.nombre = nombre;

		return this;

	}

	public AlgoMonBuilder vida(int vida) {

		this.vida = vida;

		return this;

	}

	public AlgoMonBuilder tipo(Tipo tipo) {

		this.tipo = tipo;

		return this;

	}

	public AlgoMon crearAlgomon() {

		return new AlgoMon(nombre, vida, ataques, tipo);

	}

}
