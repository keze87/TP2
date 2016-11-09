package src.fiuba.algo3.modelo;

import java.util.ArrayList;
import java.util.List;

import src.fiuba.algo3.modelo.ataques.Ataque;
import src.fiuba.algo3.modelo.ataques.AtaqueBuilder;

public class AlgoMonBuilder {

	private List<Ataque> ataques = new ArrayList<>();
	private String nombre = "";
	private int vida = 0;

	public static AlgoMon crearCharmander() {
		AlgoMonBuilder builder = new AlgoMonBuilder();

		builder.nombre("Charmander").vida(170).ataque(AtaqueBuilder.crearBrasas()).
		ataque(AtaqueBuilder.crearFogonazo()).ataque(AtaqueBuilder.crearAtaqueRapido());

		return builder.crearTipoFuego();
	}

	public static AlgoMon crearSquirtle() {
		AlgoMonBuilder builder = new AlgoMonBuilder();

		builder.nombre("Squirtle").vida(150).ataque(AtaqueBuilder.crearBurbuja()).
		ataque(AtaqueBuilder.crearCanionDeAgua()).ataque(AtaqueBuilder.crearAtaqueRapido());

		return builder.crearTipoAgua();
	}

	public static AlgoMon crearBulbasaur() {
		AlgoMonBuilder builder = new AlgoMonBuilder();

		builder.nombre("Bulbasaur").vida(140).ataque(AtaqueBuilder.crearChupavidas()).
		ataque(AtaqueBuilder.crearLatigoCepa()).ataque(AtaqueBuilder.crearAtaqueRapido());

		return builder.crearTipoPlanta();
	}

	public static AlgoMon crearJigglypuff() {
		AlgoMonBuilder builder = new AlgoMonBuilder();

		builder.nombre("Jigglypuff").vida(130).ataque(AtaqueBuilder.crearCanto()).
		ataque(AtaqueBuilder.crearBurbuja()).ataque(AtaqueBuilder.crearAtaqueRapido());

		return builder.crearTipoNormal();
	}

	public static AlgoMon crearChansey() {
		AlgoMonBuilder builder = new AlgoMonBuilder();

		builder.nombre("Chansey").vida(130).ataque(AtaqueBuilder.crearCanto()).
		ataque(AtaqueBuilder.crearLatigoCepa()).ataque(AtaqueBuilder.crearAtaqueRapido());

		return builder.crearTipoNormal();
	}

	public static AlgoMon crearRattata() {
		AlgoMonBuilder builder = new AlgoMonBuilder();

		builder.nombre("Rattata").vida(170).ataque(AtaqueBuilder.crearFogonazo()).
		ataque(AtaqueBuilder.crearBurbuja()).ataque(AtaqueBuilder.crearAtaqueRapido());

		return builder.crearTipoNormal();
	}

	private AlgoMonBuilder ataque(Ataque ataque) {
		this.ataques.add(ataque);
		return this;
	}

	private AlgoMonBuilder nombre(String nombre) {
		this.nombre = nombre;
		return this;
	}

	private AlgoMonBuilder vida(int vida) {
		this.vida = vida;
		return this;
	}

	private AlgoMon crearTipoFuego() {
		return new AlgoMonFuego(nombre, vida, ataques);
	}

	private AlgoMon crearTipoAgua() {
		return new AlgoMonAgua(nombre, vida, ataques);

	}

	private AlgoMon crearTipoPlanta() {
		return new AlgoMonPlanta(nombre, vida, ataques);
	}

	private AlgoMon crearTipoNormal() {
		return new AlgoMonNormal(nombre, vida, ataques);
	}

}
