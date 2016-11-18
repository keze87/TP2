package src.fiuba.algo3.vista;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import src.fiuba.algo3.modelo.Juego;

public class Programa extends Application {

	@Override
	public void start(Stage primaryStage) {
		Scene introduccion = new Introduccion(primaryStage, new Juego());
		//Scene introduccion = new ElegirEquipoJugador1(primaryStage, new Juego());

		primaryStage.setFullScreen(false);
		primaryStage.setFullScreenExitKeyCombination(null);
		primaryStage.setFullScreenExitHint("");

		primaryStage.setTitle("AlgoMon");
		primaryStage.setScene(introduccion);
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}

}
