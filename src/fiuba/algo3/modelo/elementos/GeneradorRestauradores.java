package src.fiuba.algo3.modelo.elementos;

public class GeneradorRestauradores implements GeneradorElemento {

	@Override
	public Elemento generarElemento() {
		return new Restaurador();
	}

}
