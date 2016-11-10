package src.fiuba.algo3.modelo.tipo;

public enum EfectividadTipo {
	SUPEREFECTIVO(2.0f),
	NORMAL(1.0f),
	POCOEFECTIVO(0.5f);

	private float efectividad;

	EfectividadTipo(float efectividad) {
		this.efectividad = efectividad;
	}

	/* Devuelve el valor de la efectividad. */
	public float getValor() {
		return this.efectividad;
	}
}
