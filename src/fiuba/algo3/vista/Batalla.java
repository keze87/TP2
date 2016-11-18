package src.fiuba.algo3.vista;

import javafx.geometry.HPos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import src.fiuba.algo3.modelo.AlgoMon;
import src.fiuba.algo3.modelo.Juego;

public class Batalla extends GridPane {

	Juego juego;

	public Batalla(Juego juego) {

		super();

		this.juego = juego;

		DisplayAlgoMon displayAlgoMonActivo = new DisplayAlgoMon(juego.getJugadorActivo().getAlgoMonActivo());
		DisplayAlgoMon displayAlgoMonContrincante = new DisplayAlgoMon(juego.getContrincante().getAlgoMonActivo());

		ColumnConstraints columna = new ColumnConstraints();
		columna.setPercentWidth(50f);

		RowConstraints fila = new RowConstraints();
		fila.setPercentHeight(50f);

		this.add(displayAlgoMonContrincante, 1, 0);
		this.add(displayAlgoMonActivo, 0, 0);

		this.actualizarImagenAlgoMon(this.juego.getJugadorActivo().getAlgoMonActivo(), 0, 1);
		this.actualizarImagenAlgoMon(this.juego.getContrincante().getAlgoMonActivo(), 1, 1);

		this.setGridLinesVisible(true);
		this.getColumnConstraints().add(columna);
		this.getColumnConstraints().add(columna);
		this.getRowConstraints().add(fila);
		this.getRowConstraints().add(fila);

		GridPane.setHalignment(displayAlgoMonContrincante, HPos.RIGHT);
		GridPane.setHalignment(displayAlgoMonActivo, HPos.LEFT);

		this.getStyleClass().add("batalla");

	}

	private void actualizarImagenAlgoMon(AlgoMon algoMon, int columna, int fila) {
		Image imagenAlgoMon = new Image(EscenaJuegoAlgoMon.ruta + algoMon.getNombre() + ".gif");
		ImageView imagen = new ImageView(imagenAlgoMon);

		imagen.setScaleX(1.5);
		imagen.setScaleY(1.5);
		this.add(imagen, columna, fila);
		GridPane.setHalignment(imagen, HPos.CENTER);
	}

}
