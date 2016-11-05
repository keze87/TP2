package src.fiuba.algo3.modelo;
import src.fiuba.algo3.modelo.ataques.*;

public class AlgoMonBuilder {

	private String nombre = "";
	private int vida = 0;
	private Ataque ataque1;
	private Ataque ataque2;
	private Ataque ataque3;

	public static AlgoMon crearCharmander() {

		AlgoMonBuilder builder = new AlgoMonBuilder();

		builder.nombre("Charmander").vida(170).ataque1(new Brasas(10)).
		ataque2(new Fogonazo(4)).ataque3(new AtaqueRapido(16));

		return builder.crearTipoFuego();

	}

	private AlgoMonBuilder vida(int vida) {

		this.vida = vida;

		return this;

	}

	private AlgoMonBuilder nombre(String nombre) {

		this.nombre = nombre;

		return this;

	}

	private AlgoMonBuilder ataque1(Ataque ataque) {

		this.ataque1 = ataque;

		return this;

	}

	private AlgoMonBuilder ataque2(Ataque ataque) {

		this.ataque2 = ataque;

		return this;

	}

	private AlgoMonBuilder ataque3(Ataque ataque) {

		this.ataque3 = ataque;

		return this;

	}

	private AlgoMon crearTipoFuego() {

		return new AlgoMonFuego(nombre, vida, ataque1, ataque2, ataque3);

	}

	public static AlgoMon crearBulbasaur() {
		// TODO Auto-generated method stub
		return null;
	}

	public static AlgoMon crearSquirtle() {
		// TODO Auto-generated method stub
		return null;
	}

	public static AlgoMon crearChansey() {
		// TODO Auto-generated method stub
		return null;
	}

	public static AlgoMon crearJigglypuff() {
		// TODO Auto-generated method stub
		return null;
	}

	public static AlgoMon crearRattata() {
		// TODO Auto-generated method stub
		return null;
	}

}
