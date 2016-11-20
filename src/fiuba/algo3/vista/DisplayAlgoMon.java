package src.fiuba.algo3.vista;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import src.fiuba.algo3.modelo.AlgoMon;

public abstract class DisplayAlgoMon extends HBox {
	protected AlgoMon algoMon;
	private Label nombre;
	private Label vida;
	protected VBox contenedorInformacion;
	protected ImageView imagen;

	public DisplayAlgoMon(AlgoMon algoMon) {
		super(100f);
		this.algoMon = algoMon;
		this.nombre = new Label();
		this.vida = new Label();
		this.contenedorInformacion = new VBox();
		this.inicializar();
	}

	public void inicializar() {
		this.actualizarInformacion();
		this.actualizarImagen();

		this.nombre.setPadding(new Insets(0f, 0f, 0f, 10f));
		this.nombre.getStyleClass().add("texto-display-algoMon");

		this.vida.setPadding(new Insets(0f, 0f, 0f, 10f));
		this.vida.getStyleClass().add("texto-display-algoMon");

		this.contenedorInformacion.getStyleClass().add("display-algoMon");
		this.contenedorInformacion.getChildren().add(this.nombre);
		this.contenedorInformacion.getChildren().add(this.vida);
		this.contenedorInformacion.setMaxSize(120f, 80f);
	}

	public void actualizarInformacion() {
		this.nombre.setText(this.algoMon.getNombre());
		this.vida.setText((int) this.algoMon.getVida() + "/" + (int) this.algoMon.getVidaMaxima() + " HP");
	}

	public void actualizarParaAlgoMonNuevo(AlgoMon algoMon) {
		this.algoMon = algoMon;
		this.actualizarInformacion();
		this.actualizarImagen();
	}

	protected void actualizarImagen() {
		this.imagen.setScaleX(3f);
		this.imagen.setScaleY(3f);
	}

}
