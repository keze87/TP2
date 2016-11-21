package src.fiuba.algo3.vista;

import src.fiuba.algo3.modelo.AlgoMon;

public class BotonAlgoMon extends BotonJuego {

	protected AlgoMon algoMon;

	public BotonAlgoMon(AlgoMon algoMon) {
		super();
		this.algoMon = algoMon;
		this.agregarContenido();
	}

	protected BotonAlgoMon(String text) {
		super(text);
	}

	@Override
	protected void agregarContenido() {
		super.agregarContenido();
		this.agregarTexto();
		this.agregarImagen();
	}

	/* Agrega el texto del botón a partir de la información del algoMon. */
	protected void agregarTexto() {
		this.setText(this.algoMon.getNombre());
	}

	/* Agrega una imagen que representa al algoMon. */
	protected void agregarImagen() {
		this.setGraphic(ContenedorImagenes.getImageView(this.algoMon.getNombre()));
	}

}
