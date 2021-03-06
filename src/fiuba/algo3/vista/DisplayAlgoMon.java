package src.fiuba.algo3.vista;

import javafx.animation.RotateTransition;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.util.Duration;
import src.fiuba.algo3.modelo.AlgoMon;

public abstract class DisplayAlgoMon extends HBox {
	protected AlgoMon algoMon;
	private Label nombre;
	private Label vida;
	protected VBox contenedorInformacion;
	protected ImageView imagen;
	protected int size;
	protected Text activo = new Text("Activo");

	public DisplayAlgoMon(AlgoMon algoMon, int size) {
		super(100f);
		this.algoMon = algoMon;
		this.nombre = new Label();
		this.vida = new Label();
		this.contenedorInformacion = new VBox();
		this.imagen = new ImageView();
		this.size = size;
		this.inicializar();
	}

	/* Inicializa el contenido del display. */
	public void inicializar() {
		this.actualizarInformacion();
		this.actualizarImagen();

		this.nombre.setAlignment(Pos.CENTER);
		this.nombre.getStyleClass().add("texto-display-algoMon");

		this.nombre.setAlignment(Pos.CENTER);
		this.vida.getStyleClass().add("texto-display-algoMon");

		this.contenedorInformacion.getStyleClass().add("display-algoMon");
		this.contenedorInformacion.getChildren().add(this.nombre);
		this.contenedorInformacion.getChildren().add(this.vida);
		this.contenedorInformacion.setMaxSize(200f, 80f);
	}

	/* Actualiza el display a partir del estado del algoMon. */
	public void actualizarInformacion() {
		this.nombre.setText(this.algoMon.getNombre());
		this.vida.setText((int) this.algoMon.getVida() + "/" + (int) this.algoMon.getVidaMaxima() + " HP");
	}

	/* Actualiza el display para mostrar la información y la imagen de un
	 * algoMon nuevo.
	 */
	public void actualizarParaAlgoMonNuevo(AlgoMon algoMon) {
		this.algoMon = algoMon;
		this.actualizarInformacion();
		this.actualizarImagen();
		this.mostrar();
	}

	/* Esconde el display. */
	public void esconder() {
		this.setVisible(false);
	}

	/* Muestra el display. */
	protected void mostrar() {
		this.setVisible(true);
	}

	/* Actualiza la imagen del algoMon. */
	protected void actualizarImagen() {
		this.imagen.setScaleX(size);
		this.imagen.setScaleY(size);
	}

	public void atacar(){

		RotateTransition rotacion = new RotateTransition(Duration.seconds(1));

		rotacion.setNode(imagen);
		rotacion.setByAngle(360);
		rotacion.setCycleCount(1);

		rotacion.play();

	}

	public void esconderActivo() {
		this.contenedorInformacion.getChildren().remove(activo);
	}

	public void mostrarActivo() {
		this.contenedorInformacion.getChildren().add(activo);
	}

}
