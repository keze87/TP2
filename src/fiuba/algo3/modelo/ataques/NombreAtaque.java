package src.fiuba.algo3.modelo.ataques;

public enum NombreAtaque {
	ATAQUERAPIDO("Ataque rápido"),
	CANTO("Canto"),
	BURBUJA("Burbuja"),
	CAÑONDEAGUA("Cañón de agua"),
	CHUPAVIDAS("Chupavidas"),
	LATIGOCEPA("Látigo cepa"),
	BRASAS("Brasas"),
	FOGONAZO("Fogonazo"),
	MALDICION("Maldicion");

	private String nombre;

	NombreAtaque(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return this.nombre;
	}
}
