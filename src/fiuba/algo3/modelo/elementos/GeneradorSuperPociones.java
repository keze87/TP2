package src.fiuba.algo3.modelo.elementos;

public class GeneradorSuperPociones implements GeneradorElemento {

	@Override
	public Elemento generarElemento() {
		return new SuperPocion();
	}

}
