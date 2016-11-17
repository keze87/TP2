package src.fiuba.algo3.vista;

import javafx.geometry.HPos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.stage.Stage;
import src.fiuba.algo3.modelo.AlgoMon;
import src.fiuba.algo3.modelo.Juego;

public class EscenaBatalla extends EscenaJuegoAlgoMon {

	private GridPane layoutBatalla;

	public EscenaBatalla(Stage stage, Juego juego) {
		super(stage, "FondoElegirEquipo.png", juego);
	}

	@Override
	protected void agregarElementos() {
		this.juego.inicializar();
		this.layoutBatalla = new GridPane();

		DisplayAlgoMon displayAlgoMonActivo = new DisplayAlgoMon(juego.getJugadorActivo().getAlgoMonActivo());
		DisplayAlgoMon displayAlgoMonContrincante = new DisplayAlgoMon(juego.getContrincante().getAlgoMonActivo());

		ColumnConstraints columna = new ColumnConstraints();
		columna.setPercentWidth(50f);

		RowConstraints fila = new RowConstraints();
		fila.setPercentHeight(50f);

		this.layoutBatalla.add(displayAlgoMonContrincante, 0, 0);
		this.layoutBatalla.add(displayAlgoMonActivo, 1, 1);

		this.actualizarImagenAlgoMon(this.juego.getJugadorActivo().getAlgoMonActivo(), 0, 1);
		this.actualizarImagenAlgoMon(this.juego.getContrincante().getAlgoMonActivo(), 1, 0);

		this.layoutBatalla.setGridLinesVisible(true);
		this.layoutBatalla.getColumnConstraints().add(columna);
		this.layoutBatalla.getColumnConstraints().add(columna);
		this.layoutBatalla.getRowConstraints().add(fila);
		this.layoutBatalla.getRowConstraints().add(fila);

		GridPane.setHalignment(displayAlgoMonContrincante, HPos.RIGHT);
		GridPane.setHalignment(displayAlgoMonActivo, HPos.LEFT);

		super.agregarElementos();
		this.layout.setCenter(this.layoutBatalla);
		this.layout.setBackground(this.fondo);
		this.setRoot(this.layout);
	}

	private void actualizarImagenAlgoMon(AlgoMon algoMon, int columna, int fila) {
		Image imagenAlgoMon = new Image(EscenaJuegoAlgoMon.ruta + algoMon.getNombre() + ".gif");
		ImageView imagen = new ImageView(imagenAlgoMon);

		imagen.setScaleX(5f);
		imagen.setScaleY(5f);
		this.layoutBatalla.add(imagen, columna, fila);
		GridPane.setHalignment(imagen, HPos.CENTER);
	}

}
