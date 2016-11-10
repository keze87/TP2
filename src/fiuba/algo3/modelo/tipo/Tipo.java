package src.fiuba.algo3.modelo.tipo;

public interface Tipo {
	/**
	 * Devuelve el multiplicador de daño que resulta de atacar a un AlgoMon de un tipo dado.
	 * @param tipo tipo del AlgoMon.
	 * @return el valor del multiplicador.
	 */
	public EfectividadTipo getMultiplicadorContra(Tipo tipo);
	public EfectividadTipo getMultiplicadorContra(Fuego tipo);
	public EfectividadTipo getMultiplicadorContra(Agua tipo);
	public EfectividadTipo getMultiplicadorContra(Planta tipo);
	public EfectividadTipo getMultiplicadorContra(Normal tipo);
}
