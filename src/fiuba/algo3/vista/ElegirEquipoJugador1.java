package src.fiuba.algo3.vista;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import javafx.util.Duration;
import src.fiuba.algo3.modelo.Juego;

public class ElegirEquipoJugador1 extends ElegirEquipo {

	private int jugadores;

	public ElegirEquipoJugador1(Stage stage, Juego juego, int jugadores) {
		super(stage, juego);
		this.jugadores = jugadores;
		Consola.mostrarMensaje("Jugador 1: elije 3 algoMon.");
	}

	@Override
	protected void agregarElementos() {
		this.jugador = this.juego.getJugador1();
		super.agregarElementos();
	}

	@Override
	protected void setAccionFinalizarSeleccion() {
		this.finalizarSeleccion.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				Sonido.click.play();
				Sonido.click.seek(Duration.ZERO);
				if(!jugador.equipoEstaCompleto()) {
					Consola.mostrarMensaje("El equipo no está completo!");
				}

				if (jugadores == 2) {
					stage.setScene(new ElegirEquipoJugador2(stage, juego));
				} else {
					juego.crearComputadora();
					stage.setScene(new EscenaBatalla(stage, juego));
				}
			}

		});
	}

}
