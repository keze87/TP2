package src.fiuba.algo3.vista;

import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import src.fiuba.algo3.modelo.Juego;

public class EscenaBatalla extends EscenaJuegoAlgoMon {

	public EscenaBatalla(Stage stage, Juego juego) {
		super(stage, "", juego);
		this.juego.inicializar();
	}

	@Override
	protected void agregarElementos() {
		GridPane layoutBatalla = new GridPane();

		layoutBatalla.setGridLinesVisible(true);
		layoutBatalla.setMinSize(500, 500);

		super.agregarElementos();
		this.layout.setCenter(layoutBatalla);
		this.setRoot(this.layout);
	}

}
