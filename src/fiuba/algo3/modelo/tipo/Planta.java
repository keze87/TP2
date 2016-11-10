package src.fiuba.algo3.modelo.tipo;

public class Planta implements Tipo {

	@Override
	public EfectividadTipo getMultiplicadorContra(Tipo tipo) {
		return tipo.getMultiplicadorContra(this);
	}

	@Override
	public EfectividadTipo getMultiplicadorContra(Fuego tipo) {
		return EfectividadTipo.SUPEREFECTIVO;
	}

	@Override
	public EfectividadTipo getMultiplicadorContra(Agua tipo) {
		return EfectividadTipo.POCOEFECTIVO;
	}

	@Override
	public EfectividadTipo getMultiplicadorContra(Planta tipo) {
		return EfectividadTipo.POCOEFECTIVO;
	}

	@Override
	public EfectividadTipo getMultiplicadorContra(Normal tipo) {
		return EfectividadTipo.NORMAL;
	}

}
