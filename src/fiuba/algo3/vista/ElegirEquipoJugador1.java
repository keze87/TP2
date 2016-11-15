package src.fiuba.algo3.vista;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import src.fiuba.algo3.modelo.Juego;

public class ElegirEquipoJugador1 extends ElegirEquipo {

	public ElegirEquipoJugador1(Stage stage, Juego juego) {
		super(stage, juego);
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
				stage.setScene(new ElegirEquipoJugador2(stage, juego));
			}

		});
	}

}
