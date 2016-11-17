package src.fiuba.algo3.vista;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import src.fiuba.algo3.modelo.AlgoMon;

public class DisplayAlgoMon extends VBox {

	private AlgoMon algoMon;
	private Label nombre;
	private Label vida;
	private HBox botonera;

	public DisplayAlgoMon(AlgoMon algoMon) {
		this.algoMon = algoMon;
		this.inicializarDisplay();
	}

	private void inicializarDisplay() {
		this.agregarInformacionAlgoMon();
		this.agregarBotoneraAccion();
		this.getStyleClass().add("display-algoMon");
		this.setMaxSize(250f, 100f);
	}

	private void agregarInformacionAlgoMon() {
		this.nombre = new Label(this.algoMon.getNombre());
		this.nombre.setPadding(new Insets(0f, 0f, 0f, 10f));

		this.vida = new Label((int)algoMon.getVida() + "/" + (int)algoMon.getVidaMaxima() + " HP");
		this.vida.setPadding(new Insets(0f, 0f, 0f, 10f));

		this.getChildren().add(nombre);
		this.getChildren().add(vida);
	}

	private void agregarBotoneraAccion() {
		HBox botoneraAccion = new HBox(5f);

		Button botonAtacar = new Button("Atacar");
		Button botonMochila = new Button("Mochila");
		Button botonCambiarAlgoMon = new Button("Cambiar");

		botonAtacar.getStyleClass().add("boton-display-algoMon");
		botonMochila.getStyleClass().add("boton-display-algoMon");
		botonCambiarAlgoMon.getStyleClass().add("boton-display-algoMon");

		botoneraAccion.getChildren().add(botonAtacar);
		botoneraAccion.getChildren().add(botonMochila);
		botoneraAccion.getChildren().add(botonCambiarAlgoMon);
		botoneraAccion.setPadding(new Insets(10f));
		//this.getChildren().add(botoneraAccion);
		this.botonera = botoneraAccion;
		this.getChildren().add(this.botonera);
		this.esconderBotonera();
	}

	public void esconderBotonera() {
		this.getChildren().remove(this.botonera);
		//this.botonera.setVisible(false);
		this.setMaxSize(250f, 30f);
	}

}
