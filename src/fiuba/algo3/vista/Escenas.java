package src.fiuba.algo3.vista;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Escenas {

	public static Scene MenuPrincipal(Stage primaryStage) {

		BorderPane layout = new BorderPane();

		BarraMenu barraMenu = new BarraMenu();

		Image imagenFondo = new Image("file:src/fiuba/algo3/vista/Imagenes/Grass.png");
		BackgroundImage fondo = new BackgroundImage(imagenFondo,
				BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.CENTER,
				BackgroundSize.DEFAULT);

		VBox botones = new VBox(20);
		botones.setAlignment(Pos.BOTTOM_CENTER);



		Button unJugador = new Boton("Un jugador");
		Button dosJugadores = new Boton("Dos jugadores");
		Button cheat = new Boton("Cheat Code");
		Button salir = new Boton("Salir");

		botones.getChildren().addAll(unJugador, dosJugadores, cheat, salir);

		layout.setLeft(botones);

		layout.setTop(barraMenu);
		layout.setBackground(new Background(fondo));

		return new Scene(layout, 1024, 768);

	}

}
