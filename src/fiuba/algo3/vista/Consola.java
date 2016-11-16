package src.fiuba.algo3.vista;

import javafx.scene.control.TextArea;
import javafx.scene.text.Font;

public final class Consola {

	private static TextArea consola = new TextArea();

	private Consola() {

	}

	static {
		consola = new TextArea();
		consola.setMaxHeight(100f);
		consola.setFont(new Font(24f));
		consola.setEditable(false);
		consola.getStyleClass().add("consola");
	}

	/* Muestra la consola y su contenido en la pantalla. */
	public static void mostrarConsola() {
		consola.setVisible(true);
	}

	/* Oculta la consola. */
	public static void esconderConsola() {
		consola.setVisible(false);
	}

	/* Muestra un mensaje por la consola. */
	public static void mostrarMensaje(String mensaje) {
		consola.setText(mensaje);
	}

	/* Devuelve la consola. */
	public static TextArea getConsola() {
		return consola;
	}
}
