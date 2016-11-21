package src.fiuba.algo3.modelo.elementos;

public enum NombreElemento {
	POCION("Poción"),
	SUPERPOCION("Superpoción"),
	RESTAURADOR("Restaurador"),
	VITAMINA("Vitamina");

	private String nombre;

	NombreElemento(String nombre) {
		this.nombre = nombre;
	}

	/* Devuelve el nombre como cadena. */
	public String getNombre() {
		return this.nombre;
	}
}
