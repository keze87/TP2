package src.fiuba.algo3.modelo.ataques;

import src.fiuba.algo3.modelo.efectos.Dormir;
import src.fiuba.algo3.modelo.efectos.Efecto;
import src.fiuba.algo3.modelo.efectos.Quemar;
import src.fiuba.algo3.modelo.efectos.SinEfecto;
import src.fiuba.algo3.modelo.efectos.Vampiro;

public class AtaqueBuilder {

	private NombreAtaque nombre;
	private int potencia;
	private int usosMaximos;
	private Efecto efectoBase;
	private Efecto efectoAtacante;

	private AtaqueBuilder(NombreAtaque nombre, int potencia, int usosMaximos, Efecto efectoBase, Efecto efectoAtacante) {

		this.nombre = nombre;
		this.potencia = potencia;
		this.usosMaximos = usosMaximos;
		this.efectoBase = efectoBase;
		this.efectoAtacante = efectoAtacante;

	}

	private AtaqueBuilder(NombreAtaque nombre, int potencia, int usosMaximos, Efecto efectoBase) {

		this.nombre = nombre;
		this.potencia = potencia;
		this.usosMaximos = usosMaximos;
		this.efectoBase = efectoBase;
		this.efectoAtacante = new SinEfecto();


	}

	/* Crea y devuelve una nueva instancia de Ataque correspondiente a Ataque Rápido. */
	public static Ataque crearAtaqueRapido() {
		AtaqueBuilder builder = new AtaqueBuilder(NombreAtaque.ATAQUERAPIDO, 10, 16, new SinEfecto());

		return builder.crearAtaqueNormal();
	}

	/* Crea y devuelve una nueva instancia de Ataque correspondiente a Canto. */
	public static Ataque crearCanto() {
		AtaqueBuilder builder = new AtaqueBuilder(NombreAtaque.CANTO, 0, 6, new Dormir());

		return builder.crearAtaqueNormal();
	}

	/* Crea y devuelve una nueva instancia de Ataque correspondiente a Burbuja. */
	public static Ataque crearBurbuja() {
		AtaqueBuilder builder = new AtaqueBuilder(NombreAtaque.BURBUJA, 10, 15, new SinEfecto());

		return builder.crearAtaqueAgua();
	}

	/* Crea y devuelve una nueva instancia de Ataque correspondiente a Cañón de agua. */
	public static Ataque crearCanionDeAgua() {
		AtaqueBuilder builder = new AtaqueBuilder(NombreAtaque.CAÑONDEAGUA, 20, 8, new SinEfecto());

		return builder.crearAtaqueAgua();
	}

	/* Crea y devuelve una nueva instancia de Ataque correspondiente a Chupavidas. */
	public static Ataque crearChupavidas() {
		AtaqueBuilder builder = new AtaqueBuilder(NombreAtaque.CHUPAVIDAS, 15, 8, new SinEfecto(), new Vampiro());

		return builder.crearAtaquePlanta();
	}

	/* Crea y devuelve una nueva instancia de Ataque correspondiente a Látigo cepa. */
	public static Ataque crearLatigoCepa() {
		AtaqueBuilder builder = new AtaqueBuilder(NombreAtaque.LATIGOCEPA, 15, 10, new SinEfecto());

		return builder.crearAtaquePlanta();
	}

	/* Crea y devuelve una nueva instancia de Ataque correspondiente a Brasas. */
	public static Ataque crearBrasas() {
		AtaqueBuilder builder = new AtaqueBuilder(NombreAtaque.BRASAS, 16, 10, new SinEfecto());

		return builder.crearAtaqueFuego();
	}

	/* Crea y devuelve una nueva instancia de Ataque correspondiente a Fogonazo. */
	public static Ataque crearFogonazo() {
		AtaqueBuilder builder = new AtaqueBuilder(NombreAtaque.FOGONAZO, 2, 4, new Quemar());

		return builder.crearAtaqueFuego();
	}

	/* Crea un ataque de tipo fuego con los valores actuales de los atributos. */
	private Ataque crearAtaqueFuego() {
		return new AtaqueFuego(this.nombre, this.potencia, this.usosMaximos, this.efectoBase, this.efectoAtacante);
	}

	/* Crea un ataque de tipo agua con los valores actuales de los atributos. */
	private Ataque crearAtaqueAgua() {
		return new AtaqueAgua(this.nombre, this.potencia, this.usosMaximos, this.efectoBase, this.efectoAtacante);
	}

	/* Crea un ataque de tipo planta con los valores actuales de los atributos. */
	private Ataque crearAtaquePlanta() {
		return new AtaquePlanta(this.nombre, this.potencia, this.usosMaximos, this.efectoBase, this.efectoAtacante);
	}

	/* Crea un ataque de tipo normal con los valores actuales de los atributos. */
	private Ataque crearAtaqueNormal() {
		return new AtaqueNormal(this.nombre, this.potencia, this.usosMaximos, this.efectoBase, this.efectoAtacante);
	}

	/* Crea y devuelve una nueva instancia de Ataque correspondiente a Maldicion. */
	public static Ataque crearMaldicion() {
		AtaqueBuilder builder = new AtaqueBuilder(NombreAtaque.MALDICION, 10, 8, new Quemar());

		return builder.crearAtaqueNormal();
	}

}
