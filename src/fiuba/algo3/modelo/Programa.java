package src.fiuba.algo3.modelo;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import src.fiuba.algo3.vista.MenuPrincipal;

public class Programa extends Application {

	@Override
	public void start(Stage primaryStage) {
		primaryStage.setFullScreen(true);
		Scene menuPrincipal = new MenuPrincipal(primaryStage, new Juego());

		primaryStage.setTitle("AlgoMon");
		primaryStage.setScene(menuPrincipal);
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}

}
