package src.fiuba.algo3.modelo.elementos;

public class GeneradorVitaminas implements GeneradorElemento {

	@Override
	public Elemento generarElemento() {
		return new Vitamina();
	}

}
