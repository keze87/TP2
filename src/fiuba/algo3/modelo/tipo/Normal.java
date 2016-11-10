package src.fiuba.algo3.modelo.tipo;

public class Normal implements Tipo {

	@Override
	public EfectividadTipo getMultiplicadorContra(Tipo tipo) {
		return EfectividadTipo.NORMAL;
	}

	@Override
	public EfectividadTipo getMultiplicadorContra(Fuego tipo) {
		return EfectividadTipo.NORMAL;
	}

	@Override
	public EfectividadTipo getMultiplicadorContra(Agua tipo) {
		return EfectividadTipo.NORMAL;
	}

	@Override
	public EfectividadTipo getMultiplicadorContra(Planta tipo) {
		return EfectividadTipo.NORMAL;
	}

	@Override
	public EfectividadTipo getMultiplicadorContra(Normal tipo) {
		return EfectividadTipo.NORMAL;
	}

}
