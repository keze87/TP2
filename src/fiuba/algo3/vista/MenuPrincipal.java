package src.fiuba.algo3.vista;

import javafx.animation.FadeTransition;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.util.Duration;
import src.fiuba.algo3.modelo.Juego;

public class MenuPrincipal extends EscenaJuegoAlgoMon {

	public MenuPrincipal(Stage stage, Juego juego) {
		super(stage, juego);
	}

	@Override
	protected void agregarElementos() {
		super.agregarElementos();

		HBox botonera = new HBox(20);

		//Media sonido = new Media(new File("src/fiuba/algo3/vista/Sonidos/Pokemon_Opening.mp3").toURI().toString());
		//MediaPlayer mediaPlayer = new MediaPlayer(sonido);
		//mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
		//mediaPlayer.play();

		Image imagenLogo = new Image(ruta + "Logo.png");
		ImageView logoView = new ImageView(imagenLogo);
		HBox logo = new HBox(logoView);

		Button unJugador = new BotonMenuPrincipal("Un jugador");
		Button dosJugadores = new BotonMenuPrincipal("Dos jugadores");
		Button cheatCode = new BotonMenuPrincipal("Cheat code");
		Button salir = new BotonMenuPrincipal("Salir");

		salir.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				System.exit(0);

			}
		});

		unJugador.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				Sonido.click.play();
				Sonido.click.seek(Duration.ZERO);
				stage.setScene(new ElegirEquipoJugador1(stage, juego, 1));
			}

		});

		dosJugadores.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				Sonido.click.play();
				Sonido.click.seek(Duration.ZERO);
				stage.setScene(new ElegirEquipoJugador1(stage, juego, 2));
			}

		});

		FadeTransition transicion = Animaciones.animacionAparecer(logo);
		transicion.setOnFinished(
				new EventHandler<ActionEvent>() {

					@Override
					public void handle(ActionEvent event) {
						botonera.getChildren().addAll(unJugador, dosJugadores, cheatCode, salir);
					}
				}
				);

		transicion.play();

		botonera.setPadding(new Insets(50f));
		botonera.setAlignment(Pos.CENTER);

		logo.setPadding(new Insets(20));
		logo.setAlignment(Pos.TOP_CENTER);

		Timeline timeline = new Timeline(new KeyFrame(
				Duration.millis(250),
				ae -> layout.setCenter(logo)));

		timeline.play();

		layout.setBottom(botonera);
		this.agregarFondo("Fondo");
		this.setRoot(layout);
	}

}
