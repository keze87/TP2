package src.fiuba.algo3.vista;

import javafx.geometry.HPos;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.RowConstraints;
import javafx.stage.Stage;
import src.fiuba.algo3.modelo.AlgoMon;
import src.fiuba.algo3.modelo.Juego;

public class EscenaBatalla extends EscenaJuegoAlgoMon {

	private GridPane layoutBatalla;
	private DisplayAlgoMon displayAlgoMonActivo;
	private DisplayAlgoMon displayAlgoMonContrincante;
	private HBox contenedorInferior;

	public EscenaBatalla(Stage stage, Juego juego) {
		super(stage, "FondoBatalla.png", juego);
	}

	@Override
	protected void agregarElementos() {
		super.agregarElementos();
		this.juego.inicializar();
		this.layoutBatalla = new GridPane();
		this.contenedorInferior = new HBox();

		this.actualizarImagenAlgoMon(this.juego.getJugadorActivo().getAlgoMonActivo(), 0, 1);
		this.actualizarImagenAlgoMon(this.juego.getContrincante().getAlgoMonActivo(), 1, 0);

		Consola.agregarAContendedor(this.contenedorInferior);
		Consola.limpiar();

		this.agregarDisplaysAlgoMon();
		this.agregarDisplayAcciones();

		ColumnConstraints columna = new ColumnConstraints(50f);
		columna.setPercentWidth(50f);

		RowConstraints fila = new RowConstraints();
		fila.setPercentHeight(50f);

		this.layoutBatalla.getColumnConstraints().add(columna);
		this.layoutBatalla.getColumnConstraints().add(columna);
		this.layoutBatalla.getRowConstraints().add(fila);
		this.layoutBatalla.getRowConstraints().add(fila);
		//this.layoutBatalla.setGridLinesVisible(true);

		this.layout.setCenter(this.layoutBatalla);
		this.layout.setBottom(this.contenedorInferior);
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

	private void agregarDisplaysAlgoMon() {
		this.displayAlgoMonActivo = new DisplayAlgoMon(juego.getJugadorActivo().getAlgoMonActivo());
		this.displayAlgoMonContrincante = new DisplayAlgoMon(juego.getJugadorActivo().getAlgoMonActivo());

		this.layoutBatalla.add(this.displayAlgoMonContrincante, 0, 0);
		this.layoutBatalla.add(this.displayAlgoMonActivo, 1, 1);

		GridPane.setHalignment(this.displayAlgoMonContrincante, HPos.RIGHT);
		GridPane.setHalignment(this.displayAlgoMonActivo, HPos.LEFT);
	}

	private void agregarDisplayAcciones() {
		GridPane botoneraAcciones = new GridPane();

		Button botonAtacar = new Button("Atacar");
		Button botonMochila = new Button("Mochila");
		Button botonCambiar = new Button("Cambiar");

		botoneraAcciones.getStyleClass().add("consola");
		botonAtacar.getStyleClass().add("boton-elegir-algoMon");
		botonMochila.getStyleClass().add("boton-elegir-algoMon");
		botonCambiar.getStyleClass().add("boton-elegir-algoMon");
		//botonAtacar.setPadding(new Insets(20f));

		botoneraAcciones.add(botonAtacar, 0, 0);
		botoneraAcciones.add(botonMochila, 1, 0);
		botoneraAcciones.add(botonCambiar, 0, 1);
		botoneraAcciones.setHgap(10f);
		botoneraAcciones.setVgap(10f);

		HBox.setHgrow(botoneraAcciones, Priority.ALWAYS);
		this.contenedorInferior.getChildren().add(botoneraAcciones);
	}

	private void actualizarDisplayParaAlgoMonNuevo(DisplayAlgoMon display, AlgoMon algoMon) {
		display.actualizar(algoMon);
	}

}