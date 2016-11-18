package src.fiuba.algo3.vista;

import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;

public class BotonesBatalla extends VBox {

	Button boton1;
	Button boton2;
	Button boton3;
	Button boton4;

	public BotonesBatalla() {

		super();

		HBox colBoton1 = new HBox();
		HBox colBoton2 = new HBox();

		boton1 = new Button();
		boton2 = new Button();
		boton3 = new Button();
		boton4 = new Button();

		colBoton1.getChildren().addAll(boton1, boton2);
		colBoton2.getChildren().addAll(boton3, boton4);

		HBox.setHgrow(boton1, Priority.ALWAYS);
		HBox.setHgrow(boton2, Priority.ALWAYS);
		HBox.setHgrow(boton3, Priority.ALWAYS);
		HBox.setHgrow(boton4, Priority.ALWAYS);

		int btnCount = colBoton1.getChildren().size();
		boton1.prefWidthProperty().bind(colBoton1.widthProperty().divide(btnCount));
		boton2.prefWidthProperty().bind(colBoton1.widthProperty().divide(btnCount));
		boton3.prefWidthProperty().bind(colBoton1.widthProperty().divide(btnCount));
		boton4.prefWidthProperty().bind(colBoton1.widthProperty().divide(btnCount));

		boton1.prefHeightProperty().bind(this.heightProperty().divide(2));
		boton2.prefHeightProperty().bind(this.heightProperty().divide(2));
		boton3.prefHeightProperty().bind(this.heightProperty().divide(2));
		boton4.prefHeightProperty().bind(this.heightProperty().divide(2));

		this.getChildren().addAll(colBoton1, colBoton2);

		this.botonesPrincipales();

	}

	public void botonesPrincipales() {

		boton1.setText("Atacar");
		//boton1.setOnAction(value);
		boton1.getStyleClass().add("boton-elegir-algoMon");

		boton2.setText("Mochila");
		//boton1.setOnAction(value);
		boton2.getStyleClass().add("boton-elegir-algoMon");

		boton3.setText("Cambiar Algomon");
		//boton1.setOnAction(value);
		boton3.getStyleClass().add("boton-elegir-algoMon");

		boton4.setText("Huir");
		//boton1.setOnAction(value);
		boton4.getStyleClass().add("boton-elegir-algoMon");

	}

}
