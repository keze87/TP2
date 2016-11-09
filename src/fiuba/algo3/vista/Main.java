package src.fiuba.algo3.vista;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

	@Override
	public void start(Stage primaryStage) {

		Scene menuPrincipal = Escenas.MenuPrincipal(primaryStage);

		primaryStage.setTitle("Algomon");
		primaryStage.setScene(menuPrincipal);
		primaryStage.show();

	}

	public static void main(String[] args) {

		launch(args);

	}

}