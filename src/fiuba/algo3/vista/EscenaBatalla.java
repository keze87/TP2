package src.fiuba.algo3.vista;

import java.util.Iterator;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.RowConstraints;
import javafx.stage.Stage;
import src.fiuba.algo3.modelo.AlgoMon;
import src.fiuba.algo3.modelo.Juego;
import src.fiuba.algo3.modelo.ataques.NombreAtaque;
import src.fiuba.algo3.modelo.elementos.NombreElemento;
import src.fiuba.algo3.modelo.excepciones.AlgoMonActivoMurio;
import src.fiuba.algo3.modelo.excepciones.AlgoMonDormidoNoPuedeAtacar;
import src.fiuba.algo3.modelo.excepciones.AlgoMonRecibeDañoQuemadura;
import src.fiuba.algo3.modelo.excepciones.AlgoMonSeDurmio;
import src.fiuba.algo3.modelo.excepciones.AtaqueAgotado;
import src.fiuba.algo3.modelo.excepciones.VidaCompleta;

public class EscenaBatalla extends EscenaJuegoAlgoMon {

	private GridPane layoutBatalla;
	private DisplayAlgoMon displayAlgoMonActivo;
	private DisplayAlgoMon displayAlgoMonContrincante;
	private HBox contenedorInferior;
	private BotoneraAcciones botoneraAcciones;
	private Button botonVolver;

	public EscenaBatalla(Stage stage, Juego juego) {
		super(stage, juego);
	}

	private enum PosAlgomon {
		FRENTE, ESPALDA;
	}

	@Override
	protected void agregarElementos() {
		super.agregarElementos();
		this.juego.inicializar();
		this.layoutBatalla = new GridPane();
		this.contenedorInferior = new HBox();
		this.botoneraAcciones = new BotoneraAcciones();
		this.crearBotonVolver();

		this.actualizarImagenAlgoMon(this.juego.getJugadorActivo().getAlgoMonActivo(), PosAlgomon.ESPALDA);
		this.actualizarImagenAlgoMon(this.juego.getContrincante().getAlgoMonActivo(), PosAlgomon.FRENTE);

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

	private void actualizarImagenAlgoMon(AlgoMon algoMon, PosAlgomon posAlgomon) {

		String nombreImagen;
		int size;
		int columna;
		int fila;

		if (posAlgomon == PosAlgomon.FRENTE) {

			nombreImagen = algoMon.getNombre();

			size = 2;

			columna = 1;
			fila = 0;

		} else {

			nombreImagen = algoMon.getNombre() + "_espalda";

			size = 3;

			columna = 0;
			fila = 1;

		}

		ImageView imagen = ContenedorImagenes.getImageView(nombreImagen);

		imagen.setScaleX(size);
		imagen.setScaleY(size);

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

		botonMochila.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				mostrarBotoneraMochila();
			}

		});

		Button botonCambiar = new Button("Cambiar");

		this.botoneraAcciones.borrarBotones();
		this.botoneraAcciones.add(botonAtacar);
		this.botoneraAcciones.add(botonMochila);
		this.botoneraAcciones.add(botonCambiar);

		if (this.juego.getJugadorActivo().esComputadora()) {

			Consola.mostrarMensaje("Turno Computadora");

			this.juego.getJugadorActivo().jugar(botonAtacar, botonMochila);

		} else {

			Consola.mostrarMensaje("¿Qué va a hacer " + juego.getJugadorActivo().getAlgoMonActivo().getNombre() + " ?");

		}
	}

	private void mostrarBotoneraAtaques() {
		Iterable<NombreAtaque> nombresAtaques = this.juego.getJugadorActivo().getAlgoMonActivo().getNombresAtaques();

		Iterator<NombreAtaque> it = nombresAtaques.iterator();

		this.botoneraAcciones.borrarBotones();

		while(it.hasNext()) {
			NombreAtaque nombreAtaqueActual = it.next();

			String textoBoton = nombreAtaqueActual.toString();

			textoBoton += " - ";
			textoBoton += this.juego.getJugadorActivo().getAlgoMonActivo().getUsosRestantesAtaque(nombreAtaqueActual);
			textoBoton += "/";
			textoBoton += this.juego.getJugadorActivo().getAlgoMonActivo().getUsosTotalesAtaque(nombreAtaqueActual);

			Button botonAtaque = new Button(textoBoton);

			botonAtaque.setOnAction(new EventHandler<ActionEvent>() {

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

			this.botoneraAcciones.add(botonAtaque);
		}

		this.botoneraAcciones.add(this.botonVolver);

		if (this.juego.getJugadorActivo().esComputadora()) {

			this.juego.getJugadorActivo().atacar(this.botoneraAcciones);

		}
	}

	private void mostrarBotoneraMochila() {
		NombreElemento[] nombresElementos = NombreElemento.values();

		this.botoneraAcciones.borrarBotones();

		for(NombreElemento nombreElemento : nombresElementos) {
			String textoBoton = nombreElemento.getNombre();

			textoBoton += " - ";
			textoBoton += this.juego.getJugadorActivo().getCantidadRestanteElemento(nombreElemento);
			textoBoton += "/";
			textoBoton += this.juego.getJugadorActivo().getCantidadTotalElemento(nombreElemento);

			Button botonElemento = new Button(textoBoton);

			botonElemento.setOnAction(new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent arg0) {
					try {
						juego.jugadorActivoUsaElemento(nombreElemento);
						Consola.mostrarMensaje("¡" + juego.getContrincante().getAlgoMonActivo().getNombre() + " recibió " + nombreElemento.getNombre() + "!");
					} catch(VidaCompleta e) {
						Consola.mostrarMensaje(e.getMessage());
					}

					displayAlgoMonActivo.actualizar();
					displayAlgoMonContrincante.actualizar();
					mostrarBotonOK();
				}

			});

			botonElemento.setGraphic(ContenedorImagenes.getImageView(nombreElemento.getNombre()));
			this.botoneraAcciones.add(botonElemento);
		}

		this.botoneraAcciones.add(botonVolver);
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

	private void crearBotonVolver() {
		this.botonVolver = new Button("<-");

		this.botonVolver.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				mostrarBotoneraAcciones();
			}

		});
	}

}
