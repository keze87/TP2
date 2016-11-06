package src.fiuba.algo3.modelo;
import src.fiuba.algo3.modelo.ataques.Ataque;

public class AlgoMonBuilder {

	private Ataque ataque1;
	private Ataque ataque2;
	private Ataque ataque3;
	private String nombre = "";
	private int vida = 0;

	public static AlgoMon crearBulbasaur() {

		AlgoMonBuilder builder = new AlgoMonBuilder();

		builder.nombre("Bulbasaur").vida(140).ataque1(AtaqueBuilder.crearChupavidas()).
		ataque2(AtaqueBuilder.crearLatigoCepa()).ataque3(AtaqueBuilder.crearAtaqueRapido());

		return builder.crearTipoPlanta();

	}

	public static AlgoMon crearChansey() {

		AlgoMonBuilder builder = new AlgoMonBuilder();

		builder.nombre("Chansey").vida(130);//.ataque1(new Canto()).
		//ataque2(new LatigoCepa()).ataque3(new AtaqueRapido());

		return builder.crearTipoNormal();

	}

	public static AlgoMon crearCharmander() {

		AlgoMonBuilder builder = new AlgoMonBuilder();

		builder.nombre("Charmander").vida(170);//.ataque1(new Brasas()).
		//ataque2(new Fogonazo()).ataque3(new AtaqueRapido());

		return builder.crearTipoFuego();

	}

	public static AlgoMon crearJigglypuff() {

		AlgoMonBuilder builder = new AlgoMonBuilder();

		builder.nombre("Jigglypuff").vida(130);//.ataque1(new Canto()).
		//ataque2(new Burbuja()).ataque3(new AtaqueRapido());

		return builder.crearTipoNormal();

	}

	// https://github.com/pret/pokered/blob/master/text/maps/viridian_forest_entrance.asm
	public static AlgoMon crearRattata() {

		AlgoMonBuilder builder = new AlgoMonBuilder();

		builder.nombre("Rattata").vida(170);//.ataque1(new Fogonazo()).
		//ataque2(new Burbuja()).ataque3(new AtaqueRapido());

		return builder.crearTipoNormal();

	}

	public static AlgoMon crearSquirtle() {

		AlgoMonBuilder builder = new AlgoMonBuilder();

		builder.nombre("Squirtle").vida(150);//.ataque1(new Burbuja()).
		//ataque2(new CañonAgua()).ataque3(new AtaqueRapido());

		return builder.crearTipoAgua();

	}

	public AlgoMonBuilder ataque1(Ataque ataque) {
		this.ataque1 = ataque;
		return this;
	}

	public AlgoMonBuilder ataque2(Ataque ataque) {
		this.ataque2 = ataque;
		return this;
	}

	public AlgoMonBuilder ataque3(Ataque ataque) {
		this.ataque3 = ataque;
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

	public AlgoMon crearTipoAgua() {
		return new AlgoMonAgua(nombre, vida, ataque1, ataque2, ataque3);
	}

	public AlgoMon crearTipoFuego() {
		return new AlgoMonFuego(nombre, vida, ataque1, ataque2, ataque3);
	}

	public AlgoMon crearTipoNormal() {
		return new AlgoMonNormal(nombre, vida, ataque1, ataque2, ataque3);
	}

	public AlgoMon crearTipoPlanta() {
		return new AlgoMonPlanta(nombre, vida, ataque1, ataque2, ataque3);
	}

}
