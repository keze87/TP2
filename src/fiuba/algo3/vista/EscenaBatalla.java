package src.fiuba.algo3.vista;

import java.util.Iterator;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.RowConstraints;
import javafx.stage.Stage;
import src.fiuba.algo3.modelo.AlgoMon;
import src.fiuba.algo3.modelo.Juego;
import src.fiuba.algo3.modelo.ataques.NombreAtaque;
import src.fiuba.algo3.modelo.excepciones.AlgoMonActivoMurio;
import src.fiuba.algo3.modelo.excepciones.AlgoMonDormidoNoPuedeAtacar;
import src.fiuba.algo3.modelo.excepciones.AlgoMonRecibeDañoQuemadura;
import src.fiuba.algo3.modelo.excepciones.AlgoMonSeDurmio;
import src.fiuba.algo3.modelo.excepciones.AtaqueAgotado;

public class EscenaBatalla extends EscenaJuegoAlgoMon {

	private GridPane layoutBatalla;
	private DisplayAlgoMon displayAlgoMonActivo;
	private DisplayAlgoMon displayAlgoMonContrincante;
	private HBox contenedorInferior;
	private BotoneraAcciones botoneraAcciones;

	public EscenaBatalla(Stage stage, Juego juego) {
		super(stage, "", juego);
	}

	@Override
	protected void agregarElementos() {
		super.agregarElementos();
		this.juego.inicializar();
		this.layoutBatalla = new GridPane();
		this.contenedorInferior = new HBox();
		this.botoneraAcciones = new BotoneraAcciones();

		this.actualizarImagenAlgoMon(this.juego.getJugadorActivo().getAlgoMonActivo(), 0, 1);
		this.actualizarImagenAlgoMon(this.juego.getContrincante().getAlgoMonActivo(), 1, 0);

		Consola.agregarAContendedor(this.contenedorInferior);

		this.agregarDisplaysAlgoMon();
		this.mostrarBotoneraAcciones();

		ColumnConstraints columna = new ColumnConstraints(50f);
		columna.setPercentWidth(50f);

		RowConstraints fila = new RowConstraints();
		fila.setPercentHeight(50f);

		this.layoutBatalla.getColumnConstraints().add(columna);
		this.layoutBatalla.getColumnConstraints().add(columna);
		this.layoutBatalla.getRowConstraints().add(fila);
		this.layoutBatalla.getRowConstraints().add(fila);

		this.layout.setCenter(this.layoutBatalla);
		this.layout.setBottom(this.contenedorInferior);
		this.layout.getCenter().getStyleClass().add("contenedor-central-batalla");
		this.layout.getBottom().getStyleClass().add("contenedor-inferior-batalla");

		this.contenedorInferior.getChildren().add(this.botoneraAcciones);
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
		this.displayAlgoMonContrincante = new DisplayAlgoMon(juego.getContrincante().getAlgoMonActivo());

		this.layoutBatalla.add(this.displayAlgoMonContrincante, 0, 0);
		this.layoutBatalla.add(this.displayAlgoMonActivo, 1, 1);

		GridPane.setHalignment(this.displayAlgoMonContrincante, HPos.RIGHT);
		GridPane.setHalignment(this.displayAlgoMonActivo, HPos.LEFT);
	}

	private void mostrarBotoneraAcciones() {
		Button botonAtacar = new Button("Atacar");

		botonAtacar.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				mostrarBotoneraAtaques();
			}

		});

		Button botonMochila = new Button("Mochila");
		Button botonCambiar = new Button("Cambiar");

		this.botoneraAcciones.borrarBotones();
		this.botoneraAcciones.add(botonAtacar);
		this.botoneraAcciones.add(botonMochila);
		this.botoneraAcciones.add(botonCambiar);

		Consola.mostrarMensaje("¿Qué va a hacer " + juego.getJugadorActivo().getAlgoMonActivo().getNombre() + " ?");
	}

	private void mostrarBotoneraAtaques() {
		Iterable<NombreAtaque> nombresAtaques = this.juego.getJugadorActivo().getAlgoMonActivo().getNombresAtaques();

		Iterator<NombreAtaque> it = nombresAtaques.iterator();

		this.botoneraAcciones.borrarBotones();

		while(it.hasNext()) {
			NombreAtaque nombreAtaqueActual = it.next();

			String textoBoton = nombreAtaqueActual.toString();

			textoBoton += " - ";
			textoBoton += this.juego.getJugadorActivo().getAlgoMonActivo().getAtaque(nombreAtaqueActual).getUsosRestantes();
			textoBoton += "/";
			textoBoton += this.juego.getJugadorActivo().getAlgoMonActivo().getAtaque(nombreAtaqueActual).getUsosTotales();

			Button boton = new Button(textoBoton);

			boton.setOnAction(new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent arg0) {

					try {
						Consola.mostrarMensaje("¡" + juego.getJugadorActivo().getAlgoMonActivo().getNombre() + " usó " + nombreAtaqueActual.toString() + "!");
						juego.jugadorActivoAtaca(nombreAtaqueActual);

					} catch(AtaqueAgotado | AlgoMonDormidoNoPuedeAtacar e) {
						Consola.mostrarMensaje(e.getMessage());
					} catch(AlgoMonSeDurmio | AlgoMonRecibeDañoQuemadura e) {
						Consola.encolarMensaje(e.getMessage());
					} catch(AlgoMonActivoMurio e) {
						Consola.encolarMensaje(e.getMessage());

						if(juego.getJugadorActivo().puedeSeguirJugando()) {
							Consola.encolarMensaje("Elije a otro algoMon:");
						}
					}

					displayAlgoMonActivo.actualizar();
					displayAlgoMonContrincante.actualizar();
					mostrarBotonOK();
				}

			});

			this.botoneraAcciones.add(boton);
		}
	}

	private void mostrarBotonOK() {
		Button botonOK = new Button("OK");

		botonOK.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				if(Consola.quedanMensajesEnLaCola()) {
					Consola.mostrarMensajeSiguiente();
				}

				else {
					mostrarBotoneraAcciones();
				}
			}

		});

		this.botoneraAcciones.borrarBotones();
		this.botoneraAcciones.add(botonOK);
	}

	private void actualizarDisplayParaAlgoMonNuevo(DisplayAlgoMon display, AlgoMon algoMon) {
		display.actualizar(algoMon);
	}

}