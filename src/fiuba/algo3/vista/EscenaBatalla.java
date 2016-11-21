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
import src.fiuba.algo3.modelo.excepciones.AtaqueAgotado;
import src.fiuba.algo3.modelo.excepciones.JuegoTerminado;
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

		Sonido.stop("Pokemon_Opening.mp3");
		Sonido.play("Pokemon_Battle.mp3", 0.1f);

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

	/* Agrega una display a la escena para cada jugador. */
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

	/* Muestra la botonera de acciones. */
	private void mostrarBotoneraAcciones() {
		Button botonAtacar = new Button("Atacar");

		botonAtacar.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				Sonido.play("BotonPresionado.wav");
				mostrarBotoneraAtaques();
			}

		});

		Button botonMochila = new Button("Mochila");

		botonMochila.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				Sonido.play("BotonPresionado.wav");
				mostrarBotoneraMochila();
			}

		});

		Button botonCambiar = new Button("Cambiar");

		botonCambiar.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				Sonido.play("BotonPresionado.wav");
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

	/* Muestra la botonera de ataques. */
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
					Sonido.play("BotonPresionado.wav");

					try {
						Consola.mostrarMensaje("¡" + juego.getJugadorActivo().getAlgoMonActivo().getNombre() + " usó " + nombreAtaqueActual.toString() + "!");
						juego.jugadorActivoAtaca(nombreAtaqueActual);
						Sonido.play(nombreAtaqueActual.toString() + ".wav");

					} catch(AtaqueAgotado | AlgoMonDormidoNoPuedeAtacar e) {
						Consola.mostrarMensaje(e.getMessage());
					} catch(AlgoMonRecibeDañoQuemadura e) {
						Sonido.play(nombreAtaqueActual.toString() + ".wav");
						Consola.encolarMensaje(e.getMessage());
					} catch(AlgoMonMurio e) {
						Sonido.play(nombreAtaqueActual.toString() + ".wav");
						Consola.encolarMensaje(e.getMessage());
					} catch(AlgoMonMurioPorQuemadura e) {
						/* El algoMon atacado también murió. */
						if(!juego.getJugadorActivo().getAlgoMonActivo().estaVivo()) {
							Consola.encolarMensaje("¡" + juego.getJugadorActivo().getAlgoMonActivo().getNombre() + " murió!");
						}

						Consola.encolarMensaje("¡" + juego.getContrincante().getAlgoMonActivo().getNombre() + " murió a causa de la quemadura!");
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

	/* Muestra la botonera para elegir un elemento. */
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
					Sonido.play("BotonPresionado.wav");

					try {
						Consola.mostrarMensaje("¡" + juego.getJugadorActivo().getAlgoMonActivo().getNombre() + " recibió " + nombreElemento.getNombre() + "!");
						juego.jugadorActivoUsaElemento(nombreElemento);
						Sonido.play("RecibirElemento.wav");
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

	/**
	 * Muestra la botonera para cambiar el algoMon activo.
	 * @param jugador jugador que desea hacer el cambio.
	 */
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
					Sonido.play("BotonPresionado.wav");

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

	/* Determina qué jugadores tienen su algoMon activo muerto, y para cada uno
	 * muestra la botonera para que puedan reemplazarlo.
	 */
	private void reemplazarAlgoMonMuertos() {
		Queue<Jugador> jugadoresConAlgoMonActivoMuerto = this.juego.getJugadoresConAlgoMonActivoMuerto();

		if(!jugadoresConAlgoMonActivoMuerto.isEmpty()) {
			Jugador jugador = jugadoresConAlgoMonActivoMuerto.remove();

			this.displays.get(jugador).esconder();
			this.mostrarBotoneraReemplazar(jugador);
		}

		else {
			this.mostrarBotoneraAcciones();
		}
	}

	/**
	 * Muestra la botonera para reemplazar a un algoMon muerto.
	 * @param jugador jugador que necesita hacer el cambio.
	 */
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
					Sonido.play("BotonPresionado.wav");

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

	/* Muestra el botón que muestra los mensajes encolados en
	 * la consola. */
	private void mostrarBotonOK() {
		Button botonOK = new Button("OK");

		botonOK.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				Sonido.play("BotonPresionado.wav");

				if(Consola.quedanMensajesEnLaCola()) {
					Consola.mostrarMensajeSiguiente();
				}

				else {
					try {
						buscarGanador();
						reemplazarAlgoMonMuertos();
					} catch(JuegoTerminado e) {
						finJuego();
					}
				}
			}

		});

		this.botoneraAcciones.borrarBotones();
		this.botoneraAcciones.add(botonOK);
	}

	/* Determina si alguno de los jugadores ganó. En caso afirmativo
	 * lanza una excepción.
	 */
	private void buscarGanador() {
		if(this.juego.hayGanador()) {
			throw new JuegoTerminado("¡El juego terminó!");
		}
	}

	/* Realiza las acciones correspondientes al finalizar
	 * el juego.
	 */
	private void finJuego() {
		this.ocultarAlgoMonMuertos();
		botoneraAcciones.setVisible(false);
		Sonido.stop("Pokemon_Battle.mp3");
		Sonido.play("Victoria.mp3");
		Consola.mostrarMensaje("¡Fin del juego!");
	}

	/* Oculta los display de cada algoMon activo que está muerto. */
	private void ocultarAlgoMonMuertos() {
		Queue<Jugador> jugadoresConAlgoMonActivoMuerto = juego.getJugadoresConAlgoMonActivoMuerto();

		while(!jugadoresConAlgoMonActivoMuerto.isEmpty()) {
			Jugador jugadorActual = jugadoresConAlgoMonActivoMuerto.remove();

			this.displays.get(jugadorActual).esconder();
		}

	}

	/* Actualiza la información de los displays. */
	private void actualizarDisplays() {
		for(DisplayAlgoMon display : this.displays.values()) {
			display.actualizarInformacion();
		}
	}

	/* Crea el botón que se utiliza para volver a la botonera de acciones desde
	 * otra botonera.
	 */
	private void crearBotonVolver() {
		this.botonVolver = new Button("<-");

		this.botonVolver.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				Sonido.play("BotonPresionado.wav");
				mostrarBotoneraAcciones();
			}

		});
	}

}
