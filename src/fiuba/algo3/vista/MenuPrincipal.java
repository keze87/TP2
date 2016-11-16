package src.fiuba.algo3.vista;

import java.io.File;

import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import javafx.util.Duration;
import src.fiuba.algo3.modelo.Juego;

public class MenuPrincipal extends EscenaJuegoAlgoMon {

	public MenuPrincipal(Stage stage, Juego juego) {
		super(stage, "Fondo.png", juego);
	}

	@Override
	protected void agregarElementos() {
		super.agregarElementos();

		HBox botonera = new HBox(20);

		Media sonido = new Media(new File("src/fiuba/algo3/vista/Sonidos/Pokemon_Opening.mp3").toURI().toString());
		MediaPlayer mediaPlayer = new MediaPlayer(sonido);
		mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);

		Image imagenLogo = new Image(ruta + "Logo.png");
		ImageView logoView = new ImageView(imagenLogo);
		HBox logo = new HBox(logoView);

		Button unJugador = new BotonMenuPrincipal("Un jugador");
		Button dosJugadores = new BotonMenuPrincipal("Dos jugadores");
		Button cheatCode = new BotonMenuPrincipal("Cheat code");
		Button salir = new BotonMenuPrincipal("Salir");

		mediaPlayer.play();

		salir.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				System.exit(0);

			}
		});

		dosJugadores.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				stage.setScene(new ElegirEquipoJugador1(stage, juego));
			}

		});

		FadeTransition transicion = new FadeTransition(Duration.millis(3000), logo);
		transicion.setFromValue(0);
		transicion.setToValue(1);
		transicion.setCycleCount(1);
		transicion.setAutoReverse(false);
		transicion.play();
		transicion.setOnFinished(
				new EventHandler<ActionEvent>() {

					@Override
					public void handle(ActionEvent event) {
						botonera.getChildren().addAll(unJugador, dosJugadores, cheatCode, salir);
					}
				}
				);

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
