package src.fiuba.algo3.vista;

import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {

	@Override
	public void start(Stage primaryStage) {

		primaryStage.setTitle("Algomon");
		primaryStage.setScene(Escenas.MenuPrincipal(primaryStage));
		primaryStage.show();

	}

	public static void main(String[] args) {

		launch(args);

	}

}
