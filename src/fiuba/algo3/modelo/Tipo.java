package src.fiuba.algo3.modelo;

public interface Tipo {
	/**
	 * Devuelve el multiplicador de daño que resulta de atacar a un AlgoMon de un tipo dado.
	 * @param tipo tipo del AlgoMon.
	 * @return el valor del multiplicador.
	 */
	public float getMultiplicadorContra(Tipo tipo);
	public float getMultiplicadorContra(Fuego tipo);
	public float getMultiplicadorContra(Agua tipo);
	public float getMultiplicadorContra(Planta tipo);
	public float getMultiplicadorContra(Normal tipo);
}
