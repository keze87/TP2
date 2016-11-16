package src.fiuba.algo3.modelo.elementos;

public class GeneradorPociones implements GeneradorElemento {

	@Override
	public Elemento generarElemento() {
		return new Pocion();
	}

}
