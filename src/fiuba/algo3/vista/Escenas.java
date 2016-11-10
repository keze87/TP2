package src.fiuba.algo3.vista;

import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Escenas {

	public static Scene MenuPrincipal(Stage primaryStage) {

		BorderPane layout = new BorderPane();
		BorderPane listaCentral = new BorderPane();
		BarraMenu barraMenu = new BarraMenu();

		// Imagen de fondo
		Image imagenFondo = new Image("file:src/fiuba/algo3/vista/Imagenes/Fondo.png");
		BackgroundImage fondo = new BackgroundImage(imagenFondo,
				BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.CENTER,
				BackgroundSize.DEFAULT);

		// Lista de botones
		HBox botones = new HBox(20);
		Button unJugador = new Boton("Un jugador");
		Button dosJugadores = new Boton("Dos jugadores");
		Button cheat = new Boton("Cheat Code");
		Button salir = new Boton("Salir");
		botones.setPadding(new Insets(40));
		botones.setAlignment(Pos.CENTER);

		//al pulsar en salir sale del juego
		salirDelJuego(salir);

		//Logo
		Image imagenLogo = new Image("file:src/fiuba/algo3/vista/Imagenes/Logo.png");
		ImageView logoView = new ImageView(imagenLogo);
		HBox logo = new HBox(logoView);
		logo.setPadding(new Insets(20));
		logo.setAlignment(Pos.CENTER);

		FadeTransition ft = new FadeTransition(Duration.millis(3000), logo);
		ft.setFromValue(0);
		ft.setToValue(1);
		ft.setCycleCount(1);
		ft.setAutoReverse(false);
		ft.play();
		ft.setOnFinished(
				new EventHandler<ActionEvent>() {

					@Override
					public void handle(ActionEvent event) {
						botones.getChildren().addAll(unJugador, dosJugadores, cheat, salir);
						primaryStage.show();
					}
				}
				);

		listaCentral.setTop(logo);
		listaCentral.setBottom(botones);
		layout.setCenter(listaCentral);
		layout.setTop(barraMenu);
		layout.setBackground(new Background(fondo));

		return new Scene(layout, 1024, 768);

	}

	private static void salirDelJuego(Button salir) {
		salir.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				System.exit(0);
			}

		});

	}

}
