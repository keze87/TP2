package src.fiuba.algo3.vista;

import javafx.geometry.HPos;
import javafx.scene.control.Label;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import src.fiuba.algo3.modelo.AlgoMon;
import src.fiuba.algo3.modelo.Juego;

public class EscenaBatalla extends EscenaJuegoAlgoMon {

	public EscenaBatalla(Stage stage, Juego juego) {
		super(stage, "FondoElegirEquipo.png", juego);
	}

	@Override
	protected void agregarElementos() {
		this.juego.inicializar();

		VBox displayAlgoMonActivo = this.crearDisplayAlgoMon(juego.getJugadorActivo().getAlgoMonActivo());
		VBox displayAlgoMonContrincante = this.crearDisplayAlgoMon(juego.getContrincante().getAlgoMonActivo());
		GridPane layoutBatalla = new GridPane();

		ColumnConstraints columna = new ColumnConstraints();
		columna.setPercentWidth(50f);

		RowConstraints fila = new RowConstraints();
		fila.setPercentHeight(50f);

		layoutBatalla.add(displayAlgoMonContrincante, 0, 0);
		layoutBatalla.add(displayAlgoMonActivo, 1, 1);

		layoutBatalla.setGridLinesVisible(true);
		layoutBatalla.getColumnConstraints().add(columna);
		layoutBatalla.getColumnConstraints().add(columna);
		layoutBatalla.getRowConstraints().add(fila);
		layoutBatalla.getRowConstraints().add(fila);

		GridPane.setHalignment(displayAlgoMonContrincante, HPos.RIGHT);
		GridPane.setHalignment(displayAlgoMonActivo, HPos.LEFT);

		super.agregarElementos();
		this.layout.setCenter(layoutBatalla);
		this.layout.setBackground(this.fondo);
		this.setRoot(this.layout);
	}

	private VBox crearDisplayAlgoMon(AlgoMon algoMon) {
		VBox display = new VBox();
		Label nombre = new Label(algoMon.getNombre());
		Label vida = new Label((int)algoMon.getVida() + "/" + (int)algoMon.getVidaMaxima() + " HP");

		display.getChildren().add(nombre);
		display.getChildren().add(vida);
		display.getStyleClass().add("display-algoMon");
		display.setMaxSize(100f, 80f);
		return display;
	}

}
