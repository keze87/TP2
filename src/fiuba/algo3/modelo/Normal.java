package src.fiuba.algo3.modelo;

public class Normal implements Tipo {

	@Override
	public float getMultiplicadorContra(Tipo tipo) {
		return 1f;
	}

	@Override
	public float getMultiplicadorContra(Fuego tipo) {
		return 1f;
	}

	@Override
	public float getMultiplicadorContra(Agua tipo) {
		return 1f;
	}

	@Override
	public float getMultiplicadorContra(Planta tipo) {
		return 1f;
	}

	@Override
	public float getMultiplicadorContra(Normal tipo) {
		return 1f;
	}

}
