package src.fiuba.algo3.vista;

import java.util.LinkedList;
import java.util.Queue;

import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.text.Font;

public final class Consola {

	private static TextArea consola;
	private static Queue<String> colaMensajes;

	private Consola() {

	}

	static {
		consola = new TextArea();
		consola.setMaxHeight(100f);
		consola.setFont(new Font(24f));
		consola.setEditable(false);
		consola.getStyleClass().add("consola");

		colaMensajes = new LinkedList<String>();
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

	public static void agregarAContendedor(HBox contenedor) {
		contenedor.getChildren().add(consola);
		HBox.setHgrow(consola, Priority.ALWAYS);
	}

	/**
	 * Agrega un mensaje a la cola de mensajes.
	 * @param mensaje mensaje a encolar.
	 */
	public static void encolarMensaje(String mensaje) {
		colaMensajes.add(mensaje);
	}

	/* Determina si hay mensajes en la cola de mensajes. */
	public static boolean quedanMensajesEnLaCola() {
		return !colaMensajes.isEmpty();
	}

	/* Muestra el próximo mensaje de la cola. */
	public static void mostrarMensajeSiguiente() {
		mostrarMensaje(colaMensajes.remove());
	}

}
