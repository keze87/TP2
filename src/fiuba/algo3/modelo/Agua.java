package src.fiuba.algo3.modelo;

public class Agua implements Tipo {

	@Override
	public float getMultiplicadorContra(Tipo tipo) {
		return tipo.getMultiplicadorContra(this);
	}

	@Override
	public float getMultiplicadorContra(Fuego tipo) {
		return 0.5f;
	}

	@Override
	public float getMultiplicadorContra(Agua tipo) {
		return 0.5f;
	}

	@Override
	public float getMultiplicadorContra(Planta tipo) {
		return 2f;
	}

	@Override
	public float getMultiplicadorContra(Normal tipo) {
		return 1f;
	}

}
