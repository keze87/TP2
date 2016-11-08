package src.fiuba.algo3.modelo.ataques;

import src.fiuba.algo3.modelo.efectos.Dormir;
import src.fiuba.algo3.modelo.efectos.Efecto;
import src.fiuba.algo3.modelo.efectos.Quemar;
import src.fiuba.algo3.modelo.efectos.SinEfecto;
import src.fiuba.algo3.modelo.efectos.Vampiro;

public class AtaqueBuilder {

	private String nombre;
	private int potencia;
	private int usosMaximos;
	private Efecto efectoBase;

	private AtaqueBuilder(String nombre, int potencia, int usosMaximos, Efecto efectoBase) {

		this.nombre = nombre;
		this.potencia = potencia;
		this.usosMaximos = usosMaximos;
		this.efectoBase = efectoBase;

	}

	/* Crea un ataque de tipo fuego con los valores actuales de los atributos. */
	private Ataque crearAtaqueFuego() {
		return new AtaqueFuego(this.nombre, this.potencia, this.usosMaximos, this.efectoBase);
	}

	/* Crea un ataque de tipo agua con los valores actuales de los atributos. */
	private Ataque crearAtaqueAgua() {
		return new AtaqueAgua(this.nombre, this.potencia, this.usosMaximos, this.efectoBase);
	}

	/* Crea un ataque de tipo planta con los valores actuales de los atributos. */
	private Ataque crearAtaquePlanta() {
		return new AtaquePlanta(this.nombre, this.potencia, this.usosMaximos, this.efectoBase);
	}

	/* Crea un ataque de tipo normal con los valores actuales de los atributos. */
	private Ataque crearAtaqueNormal() {
		return new AtaqueNormal(this.nombre, this.potencia, this.usosMaximos, this.efectoBase);
	}

	/* Crea y devuelve una nueva instancia de Ataque correspondiente a Ataque Rápido. */
	public static Ataque crearAtaqueRapido() {
		AtaqueBuilder builder = new AtaqueBuilder("Ataque rápido", 10, 16, new SinEfecto());

		return builder.crearAtaqueNormal();
	}

	/* Crea y devuelve una nueva instancia de Ataque correspondiente a Canto. */
	public static Ataque crearCanto() {
		AtaqueBuilder builder = new AtaqueBuilder("Canto", 0, 6, new Dormir());

		return builder.crearAtaqueNormal();
	}

	/* Crea y devuelve una nueva instancia de Ataque correspondiente a Burbuja. */
	public static Ataque crearBurbuja() {
		AtaqueBuilder builder = new AtaqueBuilder("Burbuja", 10, 15, new SinEfecto());

		return builder.crearAtaqueAgua();
	}

	/* Crea y devuelve una nueva instancia de Ataque correspondiente a Cañón de agua. */
	public static Ataque crearCanionDeAgua() {
		AtaqueBuilder builder = new AtaqueBuilder("Cañón de agua", 20, 8, new SinEfecto());

		return builder.crearAtaqueAgua();
	}

	/* Crea y devuelve una nueva instancia de Ataque correspondiente a Chupavidas. */
	public static Ataque crearChupavidas() {
		AtaqueBuilder builder = new AtaqueBuilder("Chupavidas", 15, 8, new Vampiro());

		return builder.crearAtaquePlanta();
	}

	/* Crea y devuelve una nueva instancia de Ataque correspondiente a Látigo cepa. */
	public static Ataque crearLatigoCepa() {
		AtaqueBuilder builder = new AtaqueBuilder("Látigo cepa", 15, 10, new SinEfecto());

		return builder.crearAtaquePlanta();
	}

	/* Crea y devuelve una nueva instancia de Ataque correspondiente a Brasas. */
	public static Ataque crearBrasas() {
		AtaqueBuilder builder = new AtaqueBuilder("Brasas", 16, 10, new SinEfecto());

		return builder.crearAtaqueFuego();
	}

	/* Crea y devuelve una nueva instancia de Ataque correspondiente a Fogonazo. */
	public static Ataque crearFogonazo() {
		AtaqueBuilder builder = new AtaqueBuilder("Fogonazo", 2, 4, new Quemar());

		return builder.crearAtaqueFuego();
	}

}
