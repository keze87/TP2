package src.fiuba.algo3.vista;

import javafx.animation.FadeTransition;
import javafx.animation.Timeline;
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
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Escenas {

	public static Scene MenuPrincipal(Stage primaryStage) {

		BorderPane layout = new BorderPane();
		BorderPane listaLateral = new BorderPane();
		BarraMenu barraMenu = new BarraMenu();

		// Imagen de fondo
		Image imagenFondo = new Image("file:src/fiuba/algo3/vista/Imagenes/Grass.png");
		BackgroundImage fondo = new BackgroundImage(imagenFondo,
				BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.CENTER,
				BackgroundSize.DEFAULT);

		//Logo
		Image imagenLogo = new Image("file:src/fiuba/algo3/vista/Imagenes/Logo.png");
		ImageView logo = new ImageView(imagenLogo);

		FadeTransition ft = new FadeTransition(Duration.millis(3000), logo);
		ft.setFromValue(0);
		ft.setToValue(1);
		ft.setCycleCount(1);
		ft.setAutoReverse(false);
		ft.play();

		// Lista de botones
		VBox botones = new VBox(20);
		Button unJugador = new Boton("Un jugador");
		Button dosJugadores = new Boton("Dos jugadores");
		Button cheat = new Boton("Cheat Code");
		Button salir = new Boton("Salir");
		botones.getChildren().addAll(unJugador, dosJugadores, cheat, salir);

		listaLateral.setTop(logo);
		listaLateral.setBottom(botones);
		layout.setLeft(listaLateral);
		layout.setTop(barraMenu);
		layout.setBackground(new Background(fondo));

		return new Scene(layout, 1024, 768);

	}

}
