package src.fiuba.algo3.vista;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Queue;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.RowConstraints;
import javafx.stage.Stage;
import src.fiuba.algo3.modelo.AlgoMon;
import src.fiuba.algo3.modelo.Juego;
import src.fiuba.algo3.modelo.Jugador;
import src.fiuba.algo3.modelo.ataques.NombreAtaque;
import src.fiuba.algo3.modelo.elementos.NombreElemento;
import src.fiuba.algo3.modelo.excepciones.AlgoMonDormidoNoPuedeAtacar;
import src.fiuba.algo3.modelo.excepciones.AlgoMonMurio;
import src.fiuba.algo3.modelo.excepciones.AlgoMonMurioPorQuemadura;
import src.fiuba.algo3.modelo.excepciones.AlgoMonRecibeDañoQuemadura;
import src.fiuba.algo3.modelo.excepciones.AlgoMonSeDurmio;
import src.fiuba.algo3.modelo.excepciones.AtaqueAgotado;
import src.fiuba.algo3.modelo.excepciones.StockAgotado;
import src.fiuba.algo3.modelo.excepciones.VidaCompleta;

public class EscenaBatalla extends EscenaJuegoAlgoMon {

	private GridPane layoutBatalla;
	private Map<Jugador, DisplayAlgoMon> displays;
	private HBox contenedorInferior;
	private BotoneraAcciones botoneraAcciones;
	private Button botonVolver;

	public EscenaBatalla(Stage stage, Juego juego) {
		super(stage, juego);
	}

	@Override
	protected void agregarElementos() {
		super.agregarElementos();

		Sonido.get("Pokemon_Opening.mp3").stop();

		this.juego.inicializar();
		this.layoutBatalla = new GridPane();
		this.contenedorInferior = new HBox();
		this.botoneraAcciones = new BotoneraAcciones();
		this.crearBotonVolver();

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

	private void agregarDisplaysAlgoMon() {
		DisplayAlgoMon displayAlgoMonPrimerPlano = new DisplayAlgoMonPrimerPlano(juego.getJugador1().getAlgoMonActivo());
		DisplayAlgoMon displayAlgoMonSegundoPlano = new DisplayAlgoMonSegundoPlano(juego.getJugador2().getAlgoMonActivo());

		this.displays = new HashMap<Jugador, DisplayAlgoMon>();
		this.displays.put(this.juego.getJugador1(), displayAlgoMonPrimerPlano);
		this.displays.put(this.juego.getJugador2(), displayAlgoMonSegundoPlano);

		this.layoutBatalla.add(displayAlgoMonSegundoPlano, 1, 0);
		this.layoutBatalla.add(displayAlgoMonPrimerPlano, 0, 1);

		displayAlgoMonPrimerPlano.setAlignment(Pos.CENTER_RIGHT);
		displayAlgoMonSegundoPlano.setAlignment(Pos.BOTTOM_LEFT);
	}

	private void mostrarBotoneraAcciones() {
		Button botonAtacar = new Button("Atacar");

		botonAtacar.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				Sonido.getSeek("BotonPresionado.wav").play();
				mostrarBotoneraAtaques();
			}

		});

		Button botonMochila = new Button("Mochila");

		botonMochila.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				Sonido.getSeek("BotonPresionado.wav").play();
				mostrarBotoneraMochila();
			}

		});

		Button botonCambiar = new Button("Cambiar");

		botonCambiar.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				Sonido.getSeek("BotonPresionado.wav").play();
				mostrarBotoneraCambiar(juego.getJugadorActivo());
			}

		});

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

			textoBoton += "  ";
			textoBoton += this.juego.getJugadorActivo().getAlgoMonActivo().getUsosRestantesAtaque(nombreAtaqueActual);
			textoBoton += "/";
			textoBoton += this.juego.getJugadorActivo().getAlgoMonActivo().getUsosTotalesAtaque(nombreAtaqueActual);

			Button botonAtaque = new Button(textoBoton);

			botonAtaque.setOnAction(new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent arg0) {
					Sonido.getSeek("BotonPresionado.wav").play();

					try {

						Consola.mostrarMensaje("¡" + juego.getJugadorActivo().getAlgoMonActivo().getNombre() + " usó " + nombreAtaqueActual.toString() + "!");
						juego.jugadorActivoAtaca(nombreAtaqueActual);
						Sonido.getSeek(nombreAtaqueActual.toString() + ".wav").play();

					} catch(AtaqueAgotado | AlgoMonDormidoNoPuedeAtacar e) {
						Consola.mostrarMensaje(e.getMessage());
					} catch(AlgoMonSeDurmio e){
						Consola.encolarMensaje(e.getMessage());
					}
					catch(AlgoMonRecibeDañoQuemadura e) {
						Sonido.getSeek(nombreAtaqueActual.toString() + ".wav").play();
						Consola.encolarMensaje(e.getMessage());
					} catch(AlgoMonMurio | AlgoMonMurioPorQuemadura e) {
						Consola.encolarMensaje(e.getMessage());
					}

					actualizarDisplays();
					mostrarBotonOK();
				}

			});

			this.botoneraAcciones.add(botonAtaque);
		}

		this.botoneraAcciones.add(this.botonVolver);

		if (this.juego.getJugadorActivo().esComputadora()) {

			this.juego.getJugadorActivo().elegirAtaque(this.botoneraAcciones);

		}
	}

	private void mostrarBotoneraMochila() {
		NombreElemento[] nombresElementos = NombreElemento.values();

		this.botoneraAcciones.borrarBotones();

		for(NombreElemento nombreElemento : nombresElementos) {
			String textoBoton = nombreElemento.getNombre();

			textoBoton += "  ";
			textoBoton += this.juego.getJugadorActivo().getCantidadRestanteElemento(nombreElemento);
			textoBoton += "/";
			textoBoton += this.juego.getJugadorActivo().getCantidadTotalElemento(nombreElemento);

			Button botonElemento = new Button(textoBoton);

			botonElemento.setOnAction(new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent arg0) {
					Sonido.getSeek("BotonPresionado.wav").play();

					try {
						Consola.mostrarMensaje("¡" + juego.getJugadorActivo().getAlgoMonActivo().getNombre() + " recibió " + nombreElemento.getNombre() + "!");
						juego.jugadorActivoUsaElemento(nombreElemento);
					} catch(VidaCompleta e) {
						Consola.mostrarMensaje(e.getMessage());
					} catch(AlgoMonRecibeDañoQuemadura e) {
						Consola.encolarMensaje(e.getMessage());
					} catch(AlgoMonMurioPorQuemadura e) {
						Consola.encolarMensaje(e.getMessage());
					} catch(StockAgotado e) {
						Consola.mostrarMensaje(e.getMessage());
					}

					actualizarDisplays();
					mostrarBotonOK();
				}

			});

			botonElemento.setGraphic(ContenedorImagenes.getImageView(nombreElemento.getNombre()));
			this.botoneraAcciones.add(botonElemento);
		}

		this.botoneraAcciones.add(botonVolver);

		if (this.juego.getJugadorActivo().esComputadora()) {

			this.juego.getJugadorActivo().elegirElemento(this.botoneraAcciones);

		}
	}

	private void mostrarBotoneraCambiar(Jugador jugador) {
		Iterable<AlgoMon> algoMonInactivos = jugador.getAlgoMonInactivos();

		Iterator<AlgoMon> it = algoMonInactivos.iterator();

		Consola.mostrarMensaje("Elije un algoMon para reemplazar a " + jugador.getAlgoMonActivo().getNombre() + ":");
		this.botoneraAcciones.borrarBotones();

		while(it.hasNext()) {
			AlgoMon algoMonActual = it.next();

			Button boton = new BotonCambiarAlgoMon(algoMonActual);

			boton.setOnAction(new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent arg0) {
					Sonido.getSeek("BotonPresionado.wav").play();

					try {
						juego.cambiarAlgoMonActivoJugadorActivo(algoMonActual);
						displays.get(jugador).actualizarParaAlgoMonNuevo(algoMonActual);
						reemplazarAlgoMonMuertos();
					} catch(Exception e) {
						Consola.mostrarMensaje(e.getMessage());
					}
				}

			});

			this.botoneraAcciones.add(boton);
		}

		this.botoneraAcciones.add(this.botonVolver);
	}

	private void reemplazarAlgoMonMuertos() {
		Queue<Jugador> jugadoresConAlgoMonActivoMuerto = this.juego.getJugadoresConAlgoMonActivoMuerto();

		if(!jugadoresConAlgoMonActivoMuerto.isEmpty()) {
			this.mostrarBotoneraReemplazar(jugadoresConAlgoMonActivoMuerto.remove());
		}

		else {
			this.mostrarBotoneraAcciones();
		}
	}

	private void mostrarBotoneraReemplazar(Jugador jugador) {
		Iterable<AlgoMon> algoMonInactivos = jugador.getAlgoMonInactivos();

		Iterator<AlgoMon> it = algoMonInactivos.iterator();

		Consola.mostrarMensaje("Elije un algoMon para reemplazar a " + jugador.getAlgoMonActivo().getNombre() + ":");
		this.botoneraAcciones.borrarBotones();

		while(it.hasNext()) {
			AlgoMon algoMonActual = it.next();

			Button boton = new BotonCambiarAlgoMon(algoMonActual);

			boton.setOnAction(new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent arg0) {
					Sonido.getSeek("BotonPresionado.wav").play();

					try {
						jugador.cambiarAlgoMonActivo(algoMonActual);
						displays.get(jugador).actualizarParaAlgoMonNuevo(algoMonActual);
						reemplazarAlgoMonMuertos();
					} catch(Exception e) {
						Consola.mostrarMensaje(e.getMessage());
					}
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
				Sonido.getSeek("BotonPresionado.wav").play();

				if(Consola.quedanMensajesEnLaCola()) {
					Consola.mostrarMensajeSiguiente();
				}

				else {
					//mostrarBotoneraAcciones();
					reemplazarAlgoMonMuertos();
				}
			}

		});

		this.botoneraAcciones.borrarBotones();
		this.botoneraAcciones.add(botonOK);
	}

	private void actualizarDisplays() {
		for(DisplayAlgoMon display : this.displays.values()) {
			display.actualizarInformacion();
		}
	}

	private void crearBotonVolver() {
		this.botonVolver = new Button("<-");

		this.botonVolver.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				Sonido.getSeek("BotonPresionado.wav").play();
				mostrarBotoneraAcciones();
			}

		});
	}

}
