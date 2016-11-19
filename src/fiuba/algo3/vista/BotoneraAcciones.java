package src.fiuba.algo3.vista;

import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import src.fiuba.algo3.modelo.excepciones.BotoneraLlena;

public class BotoneraAcciones extends GridPane {

	private static int cantidadMaximaFilas = 2;
	private static int cantidadMaximaColumnas = 2;
	private int filaActual;
	private int columnaActual;

	public BotoneraAcciones() {
		super();
		this.setPrefWidth(500f);
		this.filaActual = 0;
		this.columnaActual = 0;
	}

	public void add(Button child) {

		if(this.filaActual == BotoneraAcciones.cantidadMaximaFilas) {
			throw new BotoneraLlena("La botonera está llena. No se pueden agregar más elementos.");
		}

		super.add(child, this.columnaActual, this.filaActual);

		this.calcularColumnaYFilaSiguientes();

		child.setMaxWidth(Double.MAX_VALUE);
		child.setMaxHeight(Double.MAX_VALUE);
		child.getStyleClass().add("boton-elegir-algoMon");

		GridPane.setHgrow(child, Priority.ALWAYS);
		GridPane.setVgrow(child, Priority.ALWAYS);
	}

	public void borrarBotones() {
		this.getChildren().clear();
		this.columnaActual = 0;
		this.filaActual = 0;
	}

	private void calcularColumnaYFilaSiguientes() {
		this.columnaActual++;

		if(this.columnaActual == BotoneraAcciones.cantidadMaximaColumnas) {
			this.columnaActual = 0;
			this.filaActual++;
		}
	}

}
