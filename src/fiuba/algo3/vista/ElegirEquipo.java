package src.fiuba.algo3.vista;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import src.fiuba.algo3.modelo.Juego;
import src.fiuba.algo3.modelo.Jugador;

public abstract class ElegirEquipo extends EscenaJuegoAlgoMon {

	protected Button finalizarSeleccion;
	protected Jugador jugador;

	public ElegirEquipo(Stage stage, Juego juego) {
		super(stage, "Fondo.png", juego);
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

		filaSuperior.getChildren().add(new BotonElegirAlgoMon("Charmander", this.jugador, display));
		filaSuperior.getChildren().add(new BotonElegirAlgoMon("Squirtle", this.jugador, display));
		filaSuperior.getChildren().add(new BotonElegirAlgoMon("Bulbasaur", this.jugador, display));
		filaSuperior.setAlignment(Pos.CENTER);

		filaInferior.getChildren().add(new BotonElegirAlgoMon("Jigglypuff", this.jugador, display));
		filaInferior.getChildren().add(new BotonElegirAlgoMon("Chansey", this.jugador, display));
		filaInferior.getChildren().add(new BotonElegirAlgoMon("Rattata", this.jugador, display));
		filaInferior.setAlignment(Pos.CENTER);

		filaEquipo.getChildren().add(display);
		filaEquipo.getChildren().add(this.finalizarSeleccion);
		filaEquipo.setAlignment(Pos.CENTER);

		botonera.getChildren().add(filaSuperior);
		botonera.getChildren().add(filaInferior);
		botonera.getChildren().add(filaEquipo);
		botonera.setAlignment(Pos.CENTER);

		layout.setCenter(botonera);
		layout.setBackground(this.fondo);
		this.setRoot(layout);
	}

	protected abstract void setAccionFinalizarSeleccion();

}
