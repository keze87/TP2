package src.fiuba.algo3.vista;

import javafx.geometry.HPos;
import javafx.geometry.VPos;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.stage.Stage;
import src.fiuba.algo3.modelo.Juego;

public class EscenaBatalla extends EscenaJuegoAlgoMon {

	public EscenaBatalla(Stage stage, Juego juego) {

		super(stage, "", juego);

	}

	@Override
	protected void agregarElementos() {

		super.agregarElementos();

		GridPane batallaYBotones = new GridPane();
		BotonesBatalla filaBoton = new BotonesBatalla(); //Necesita a juego y a batalla

		Batalla batalla = new Batalla(juego);

		RowConstraints rc = new RowConstraints();
		rc.setPercentHeight(70);
		rc.setValignment(VPos.BOTTOM);
		batallaYBotones.getRowConstraints().add(rc);

		RowConstraints rc2 = new RowConstraints();
		rc2.setPercentHeight(30);
		rc2.setValignment(VPos.BOTTOM);
		batallaYBotones.getRowConstraints().add(rc2);

		ColumnConstraints cc = new ColumnConstraints();
		cc.setHalignment(HPos.CENTER);
		cc.setPercentWidth(100);
		batallaYBotones.getColumnConstraints().add(cc);

		batallaYBotones.add(batalla, 0, 0);
		batallaYBotones.add(filaBoton, 0, 1);

		this.layout.setCenter(batallaYBotones);

		this.setRoot(this.layout);

	}

}
