package src.fiuba.algo3.vista;

import javafx.scene.Node;
import javafx.scene.control.Button;

public class BotonJuego extends Button {

	public BotonJuego(String text) {
		super(text);
	}

	protected BotonJuego() {
		super();
	}

	private BotonJuego(String text, Node graphic) {
		super(text, graphic);
	}

	/* Agrega el contenido del botón. */
	protected void agregarContenido() {
		this.getStyleClass().add("boton-juego");
	}

}
