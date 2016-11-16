package src.fiuba.algo3.vista;

import javafx.scene.canvas.Canvas;
import javafx.stage.Stage;
import src.fiuba.algo3.modelo.Juego;

public class EscenaBatalla extends EscenaJuegoAlgoMon {

	public EscenaBatalla(Stage stage, Juego juego) {
		super(stage, "", juego);
	}

	@Override
	protected void agregarElementos() {
		Canvas canvas = new Canvas();

		this.layout.setCenter(canvas);

		super.agregarElementos();
		this.setRoot(layout);
	}



}
