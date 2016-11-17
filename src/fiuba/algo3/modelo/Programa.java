package src.fiuba.algo3.modelo;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.KeyCombination;
import javafx.stage.Stage;
import src.fiuba.algo3.vista.ElegirEquipoJugador1;

public class Programa extends Application {

	@Override
	public void start(Stage primaryStage) {
		primaryStage.setFullScreen(false);
		//Scene menuPrincipal = new MenuPrincipal(primaryStage, new Juego());
		//Scene introduccion = new Introduccion(primaryStage, new Juego());
		Scene elegirAlgoMonJugador1 = new ElegirEquipoJugador1(primaryStage, new Juego());

		primaryStage.setTitle("AlgoMon");
		//primaryStage.setScene(introduccion);
		primaryStage.setScene(elegirAlgoMonJugador1);
		primaryStage.setFullScreenExitKeyCombination(KeyCombination.NO_MATCH);
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}

}
