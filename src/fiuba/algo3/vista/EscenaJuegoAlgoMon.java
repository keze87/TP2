package src.fiuba.algo3.vista;

import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import src.fiuba.algo3.modelo.Juego;

public abstract class EscenaJuegoAlgoMon extends Scene {

	protected Stage stage;
	protected BorderPane layout;
	protected Background fondo;
	protected Juego juego;
	protected static String ruta = "file:src/fiuba/algo3/vista/imagenes/";

	public EscenaJuegoAlgoMon(Stage stage, String nombreImagenFondo, Juego juego) {
		super(new Pane(), 500, 400);
		this.getStylesheets().add(EscenaJuegoAlgoMon.ruta + "../estilos.css");
		this.stage = stage;
		this.layout = new BorderPane();
		this.juego = juego;
		this.crearFondo(nombreImagenFondo);
		this.agregarElementos();
	}

	/* Agrega los elementos correspondientes a la escena. */
	protected void agregarElementos() {
		this.layout.setTop(new BarraMenu(stage));
		this.layout.setBottom(Consola.getConsola());
	}

	/* Crea y establece la imagen de fondo para la escena. */
	private void crearFondo(String nombreImagenFondo) {
		Image imagenFondo = new Image(EscenaJuegoAlgoMon.ruta + nombreImagenFondo);

		BackgroundImage fondo = new BackgroundImage(imagenFondo, BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT,
				BackgroundPosition.CENTER, BackgroundSize.DEFAULT);

		this.fondo = new Background(fondo);
	}

}
