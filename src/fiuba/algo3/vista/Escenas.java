package src.fiuba.algo3.vista;

import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Escenas {

	public static Scene MenuPrincipal(Stage primaryStage) {

		BorderPane layout = new BorderPane();

		BarraMenu barraMenu = new BarraMenu();
		Image imagenFondo = new Image("file:src/fiuba/algo3/vista/Imagenes/Grass.png");
		BackgroundImage fondo = new BackgroundImage(imagenFondo,
				BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT);

		layout.setTop(barraMenu);
		layout.setBackground(new Background(fondo));

		return new Scene(layout, 1024, 768);

	}

}
