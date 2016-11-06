package src.fiuba.algo3.modelo.ataques;

public class AtaqueBuilder {

	private String nombre;
	private int potencia;
	private int usosMaximos;

	private AtaqueBuilder(String nombre, int potencia, int usosMaximos) {
		this.nombre = nombre;
		this.potencia = potencia;
		this.usosMaximos = usosMaximos;
	}

	/* Crea un ataque de tipo fuego con los valores actuales de los atributos. */
	private Ataque crearAtaqueFuego() {
		return new AtaqueFuego(this.nombre, this.potencia, this.usosMaximos);
	}

	/* Crea un ataque de tipo agua con los valores actuales de los atributos. */
	private Ataque crearAtaqueAgua() {
		return new AtaqueAgua(this.nombre, this.potencia, this.usosMaximos);
	}

	/* Crea un ataque de tipo planta con los valores actuales de los atributos. */
	private Ataque crearAtaquePlanta() {
		return new AtaquePlanta(this.nombre, this.potencia, this.usosMaximos);

	}

	/* Crea un ataque de tipo normal con los valores actuales de los atributos. */
	private Ataque crearAtaqueNormal() {
		return new AtaqueNormal(this.nombre, this.potencia, this.usosMaximos);
	}

	/* Crea y devuelve una nueva instancia de Ataque correspondiente a Ataque Rápido. */
	public static Ataque crearAtaqueRapido() {
		AtaqueBuilder builder = new AtaqueBuilder("Ataque Rápido", 10, 16);

		return builder.crearAtaqueNormal();
	}

	/* Crea y devuelve una nueva instancia de Ataque correspondiente a Canto. */
	public static Ataque crearCanto() {
		AtaqueBuilder builder = new AtaqueBuilder("Canto", 0, 6);

		return builder.crearAtaqueNormal();
	}

	/* Crea y devuelve una nueva instancia de Ataque correspondiente a Burbuja. */
	public static Ataque crearBurbuja() {
		AtaqueBuilder builder = new AtaqueBuilder("Burbuja", 10, 15);

		return builder.crearAtaqueAgua();
	}

	/* Crea y devuelve una nueva instancia de Ataque correspondiente a Cañón de agua. */
	public static Ataque crearCanionDeAgua() {
		AtaqueBuilder builder = new AtaqueBuilder("Cañón de agua", 20, 8);

		return builder.crearAtaqueAgua();
	}

	/* Crea y devuelve una nueva instancia de Ataque correspondiente a Chupavidas. */
	public static Ataque crearChupavidas() {
		AtaqueBuilder builder = new AtaqueBuilder("Chupavidas", 15, 8);

		return builder.crearAtaquePlanta();
	}

	/* Crea y devuelve una nueva instancia de Ataque correspondiente a Látigo cepa. */
	public static Ataque crearLatigoCepa() {
		AtaqueBuilder builder = new AtaqueBuilder("Látigo cepa", 15, 10);

		return builder.crearAtaquePlanta();
	}

	/* Crea y devuelve una nueva instancia de Ataque correspondiente a Brasas. */
	public static Ataque crearBrasas() {
		AtaqueBuilder builder = new AtaqueBuilder("Brasas", 16, 10);

		return builder.crearAtaqueFuego();
	}

	/* Crea y devuelve una nueva instancia de Ataque correspondiente a Fogonazo. */
	public static Ataque crearFogonazo() {
		AtaqueBuilder builder = new AtaqueBuilder("Fogonazo", 2, 4);

		return builder.crearAtaqueFuego();
	}

}
