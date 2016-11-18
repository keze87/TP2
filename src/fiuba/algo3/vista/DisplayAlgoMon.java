package src.fiuba.algo3.vista;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import src.fiuba.algo3.modelo.AlgoMon;

public class DisplayAlgoMon extends VBox {

	private AlgoMon algoMon;
	private Label nombre;
	private Label vida;

	public DisplayAlgoMon(AlgoMon algoMon) {
		this.algoMon = algoMon;
		this.nombre = new Label();
		this.vida = new Label();
		this.inicializarDisplay();
		this.actualizar();
	}

	public void actualizar() {
		this.nombre.setText(this.algoMon.getNombre());
		this.vida.setText((int)this.algoMon.getVida() + "/" + (int)this.algoMon.getVidaMaxima() + " HP");
	}

	public void actualizar(AlgoMon algoMon) {
		this.algoMon = algoMon;
		this.actualizar();
	}

	private void inicializarDisplay() {
		this.getStyleClass().add("display-algoMon");
		this.setMaxSize(120f, 80f);

		this.nombre.setPadding(new Insets(0f, 0f, 0f, 10f));
		this.nombre.getStyleClass().add("texto-display-algoMon");

		this.vida.setPadding(new Insets(0f, 0f, 0f, 10f));
		this.vida.getStyleClass().add("texto-display-algoMon");

		this.getChildren().add(nombre);
		this.getChildren().add(vida);
	}

}
