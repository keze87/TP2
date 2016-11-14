package src.fiuba.algo3.vista;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import src.fiuba.algo3.modelo.Juego;

public class MenuPrincipal extends EscenaJuegoAlgoMon {

	public MenuPrincipal(Stage stage, Juego juego) {
		super(stage, "Fondo.png", juego);
	}

	@Override
	protected void agregarElementos() {
		super.agregarElementos();

		HBox botonera = new HBox(20);

		Image imagenLogo = new Image(ruta + "Logo.png");
		ImageView logoView = new ImageView(imagenLogo);
		HBox logo = new HBox(logoView);

		Button unJugador = new BotonMenuPrincipal("Un jugador");
		Button dosJugadores = new BotonMenuPrincipal("Dos jugadores");
		Button cheatCode = new BotonMenuPrincipal("Cheat code");
		Button salir = new BotonMenuPrincipal("Salir");

		dosJugadores.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				stage.setScene(new ElegirEquipoJugador1(stage, juego));
				stage.setFullScreen(true);
			}

		});

		botonera.getChildren().addAll(unJugador, dosJugadores, cheatCode, salir);
		botonera.setPadding(new Insets(50f));
		botonera.setAlignment(Pos.CENTER);

		logo.setPadding(new Insets(20));
		logo.setAlignment(Pos.TOP_CENTER);

		layout.setCenter(logo);
		layout.setBottom(botonera);
		layout.setBackground(this.fondo);
		this.setRoot(layout);
	}

}