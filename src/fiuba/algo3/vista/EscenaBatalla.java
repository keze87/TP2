package src.fiuba.algo3.vista;

import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import src.fiuba.algo3.modelo.Juego;

public class EscenaBatalla extends EscenaJuegoAlgoMon {

	public EscenaBatalla(Stage stage, Juego juego) {
		super(stage, "", juego);
	}

	@Override
	protected void agregarElementos() {
		StackPane root = new StackPane();
		Label texto = new Label();

		texto.setText("BATALLA");
		root.getChildren().add(texto);
		this.setRoot(root);
	}

}
