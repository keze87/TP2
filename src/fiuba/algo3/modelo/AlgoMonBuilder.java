package src.fiuba.algo3.modelo;

import java.util.ArrayList;
import java.util.List;

import src.fiuba.algo3.modelo.ataques.Ataque;
import src.fiuba.algo3.modelo.ataques.AtaqueBuilder;

public class AlgoMonBuilder {

	private List<Ataque> ataques = new ArrayList<>();
	private String nombre = "";
	private double vida = 0;

	/* Devuelve un nuevo algoMon con los atributos de Charmander. */
	public static AlgoMon crearCharmander() {
		AlgoMonBuilder builder = new AlgoMonBuilder();

		builder.setNombre("Charmander").setVida(170).agregarAtaque(AtaqueBuilder.crearBrasas()).
		agregarAtaque(AtaqueBuilder.crearFogonazo()).agregarAtaque(AtaqueBuilder.crearAtaqueRapido());

		return builder.crearTipoFuego();
	}

	/* Devuelve un nuevo algoMon con los atributos de Squirtle. */
	public static AlgoMon crearSquirtle() {
		AlgoMonBuilder builder = new AlgoMonBuilder();

		builder.setNombre("Squirtle").setVida(150).agregarAtaque(AtaqueBuilder.crearBurbuja()).
		agregarAtaque(AtaqueBuilder.crearCanionDeAgua()).agregarAtaque(AtaqueBuilder.crearAtaqueRapido());

		return builder.crearTipoAgua();
	}

	/* Devuelve un nuevo algoMon con los atributos de Bulbasaur. */
	public static AlgoMon crearBulbasaur() {
		AlgoMonBuilder builder = new AlgoMonBuilder();

		builder.setNombre("Bulbasaur").setVida(140).agregarAtaque(AtaqueBuilder.crearChupavidas()).
		agregarAtaque(AtaqueBuilder.crearLatigoCepa()).agregarAtaque(AtaqueBuilder.crearAtaqueRapido());

		return builder.crearTipoPlanta();
	}

	/* Devuelve un nuevo algoMon con los atributos de Jigglyupuff. */
	public static AlgoMon crearJigglypuff() {
		AlgoMonBuilder builder = new AlgoMonBuilder();

		builder.setNombre("Jigglypuff").setVida(130).agregarAtaque(AtaqueBuilder.crearCanto()).
		agregarAtaque(AtaqueBuilder.crearBurbuja()).agregarAtaque(AtaqueBuilder.crearAtaqueRapido());

		return builder.crearTipoNormal();
	}

	/* Devuelve un nuevo algoMon con los atributos de Chansey. */
	public static AlgoMon crearChansey() {
		AlgoMonBuilder builder = new AlgoMonBuilder();

		builder.setNombre("Chansey").setVida(130).agregarAtaque(AtaqueBuilder.crearCanto()).
		agregarAtaque(AtaqueBuilder.crearLatigoCepa()).agregarAtaque(AtaqueBuilder.crearAtaqueRapido());

		return builder.crearTipoNormal();
	}

	/* Devuelve un nuevo algoMon con los atributos de Rattata. */
	public static AlgoMon crearRattata() {
		AlgoMonBuilder builder = new AlgoMonBuilder();

		builder.setNombre("Rattata").setVida(170).agregarAtaque(AtaqueBuilder.crearFogonazo()).
		agregarAtaque(AtaqueBuilder.crearBurbuja()).agregarAtaque(AtaqueBuilder.crearAtaqueRapido());

		return builder.crearTipoNormal();
	}

	/**
	 * Agrega un ataque a la lista de ataques.
	 * @param ataque ataque a agregar.
	 * @return this.
	 */
	private AlgoMonBuilder agregarAtaque(Ataque ataque) {
		this.ataques.add(ataque);
		return this;
	}

	/**
	 * Establece el nombre del algoMon a crear.
	 * @param nombre nombre del algoMon a crear.
	 * @return this.
	 */
	private AlgoMonBuilder setNombre(String nombre) {
		this.nombre = nombre;
		return this;
	}

	/**
	 * Establece la vida del algoMon a crear.
	 * @param vida vida máxima del algoMon a crear.
	 * @return this.
	 */
	private AlgoMonBuilder setVida(int vida) {
		this.vida = vida;
		return this;
	}

	/* Devuelve una nueva instancia de AlgoMonFuego con
	 * los atributos actuales.
	 */
	private AlgoMon crearTipoFuego() {
		return new AlgoMonFuego(nombre, vida, ataques);
	}

	/* Devuelve una nueva instancia de AlgoMonAgua con
	 * los atributos actuales.
	 */
	private AlgoMon crearTipoAgua() {
		return new AlgoMonAgua(nombre, vida, ataques);

	}

	/* Devuelve una nueva instancia de AlgoMonPlanta con
	 * los atributos actuales.
	 */
	private AlgoMon crearTipoPlanta() {
		return new AlgoMonPlanta(nombre, vida, ataques);
	}

	/* Devuelve una nueva instancia de AlgoMonNormal con
	 * los atributos actuales.
	 */
	private AlgoMon crearTipoNormal() {
		return new AlgoMonNormal(nombre, vida, ataques);
	}

}
