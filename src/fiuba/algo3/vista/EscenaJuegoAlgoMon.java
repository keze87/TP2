package src.fiuba.algo3.vista;

import javafx.scene.Scene;
import javafx.scene.layout.Background;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import src.fiuba.algo3.modelo.Juego;

public abstract class EscenaJuegoAlgoMon extends Scene {

	protected Stage stage;
	protected BorderPane layout;
	protected Juego juego;
	protected static String ruta = "file:src/fiuba/algo3/vista/Imagenes/";

	public EscenaJuegoAlgoMon(Stage stage, Juego juego) {
		super(new Pane(), 1024, 768);
		this.getStylesheets().add(EscenaJuegoAlgoMon.ruta + "../estilos.css");
		this.stage = stage;
		this.stage.setFullScreen(true);
		this.stage.setMaximized(true);
		this.layout = new BorderPane();
		this.juego = juego;
		this.agregarElementos();
	}

	/* Agrega los elementos correspondientes a la escena. */
	protected void agregarElementos() {
		this.layout.setTop(new BarraMenu(stage));
	}

	/* Crea y establece la imagen de fondo para la escena. */
	protected void agregarFondo(String nombreImagenFondo) {
		Background fondo = ContenedorImagenes.getBackground(nombreImagenFondo);

		this.layout.setBackground(fondo);
	}

}
