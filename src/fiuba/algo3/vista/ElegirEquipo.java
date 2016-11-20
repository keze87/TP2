package src.fiuba.algo3.vista;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import src.fiuba.algo3.modelo.AlgoMon;
import src.fiuba.algo3.modelo.AlgoMonBuilder;
import src.fiuba.algo3.modelo.Juego;
import src.fiuba.algo3.modelo.Jugador;

public abstract class ElegirEquipo extends EscenaJuegoAlgoMon {

	protected Button finalizarSeleccion;
	protected Jugador jugador;

	public ElegirEquipo(Stage stage, Juego juego) {
		super(stage, juego);
	}

	@Override
	protected void agregarElementos() {
		super.agregarElementos();

		VBox botonera = new VBox(20);
		HBox filaSuperior = new HBox(20);
		HBox filaInferior = new HBox(20);
		HBox filaEquipo = new HBox(20);
		DisplayEquipo display = new DisplayEquipo(this.jugador);

		this.finalizarSeleccion = new Button("Listo");
		this.finalizarSeleccion.getStyleClass().add("boton-listo");
		this.setAccionFinalizarSeleccion();

		agregarBotonAContenedor(this.crearBotonSeleccionAlgoMon(AlgoMonBuilder.crearCharmander(), display), filaSuperior);
		agregarBotonAContenedor(this.crearBotonSeleccionAlgoMon(AlgoMonBuilder.crearSquirtle(), display), filaSuperior);
		agregarBotonAContenedor(this.crearBotonSeleccionAlgoMon(AlgoMonBuilder.crearBulbasaur(), display), filaSuperior);

		filaSuperior.setAlignment(Pos.CENTER);

		agregarBotonAContenedor(this.crearBotonSeleccionAlgoMon(AlgoMonBuilder.crearJigglypuff(), display), filaInferior);
		agregarBotonAContenedor(this.crearBotonSeleccionAlgoMon(AlgoMonBuilder.crearChansey(), display), filaInferior);
		agregarBotonAContenedor(this.crearBotonSeleccionAlgoMon(AlgoMonBuilder.crearRattata(), display), filaInferior);

		filaInferior.setAlignment(Pos.CENTER);

		filaEquipo.getChildren().add(display);
		filaEquipo.getChildren().add(this.finalizarSeleccion);
		filaEquipo.setAlignment(Pos.CENTER);

		botonera.getChildren().add(filaSuperior);
		botonera.getChildren().add(filaInferior);
		botonera.getChildren().add(filaEquipo);
		botonera.setAlignment(Pos.CENTER);

		layout.setCenter(botonera);
		this.agregarFondo("FondoElegirEquipo");
		Consola.agregarAContenedor(this.layout);
		Consola.limpiar();
		this.setRoot(layout);
	}

	/* Crea y devuelve un botón para elegir un algoMon dado. */
	private Button crearBotonSeleccionAlgoMon(AlgoMon algoMon, DisplayEquipo display) {
		//return new BotonElegirAlgoMon(nombreAlgoMon, this.jugador, display);
		return new BotonElegirAlgoMon(algoMon, this.jugador, display);
	}

	/* Agrega un botón a un contenedor. */
	private void agregarBotonAContenedor(Button boton, Pane contenedor) {
		contenedor.getChildren().add(boton);
	}

	/* Establece la acción a realizar cuando se termina de armar el equipo. */
	protected abstract void setAccionFinalizarSeleccion();

}
