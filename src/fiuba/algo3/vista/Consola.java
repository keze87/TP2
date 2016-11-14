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

	public static void mostrarConsola() {
		consola.setVisible(true);
	}

	public static void esconderConsola() {
		consola.setVisible(false);
	}

	public static void mostrarMensaje(String mensaje) {
		consola.setText(mensaje);
	}

	public static TextArea getConsola() {
		return consola;
	}
}
