package src.fiuba.algo3.vista;

import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
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

	/* Borra el contenido de la consola. */
	public static void limpiar() {
		consola.clear();
	}

	/* Agrega la consola a un contenedor. */
	public static void agregarAContenedor(BorderPane contenedor) {
		contenedor.setBottom(consola);
	}

	/* Agrega la consola a un contenedor. */
	public static void agregarAContenedor(StackPane contenedor) {
		contenedor.getChildren().add(consola);
	}

}
